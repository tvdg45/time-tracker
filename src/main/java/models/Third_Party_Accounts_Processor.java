//Author: Timothy van der Graaff
package models;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.text.DecimalFormat;

import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.util.logging.*; 

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public abstract class Third_Party_Accounts_Processor extends configuration.Config {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	//gets and sets variables
	private String admin_session;
	
	//sets
	protected void set_admin_session(String admin_session) {
		
		this.admin_session = admin_session;
	}
	
	//gets
	private String get_admin_session() {
		
		return this.admin_session;
	}
	
	
	
	
	
	
	protected String convert_to_memory_unit(String input_value) {
		
		DecimalFormat decimal_format = new DecimalFormat("#,###.00");
		
		String output = "";
		double dec_input_value = 0;
		double kilobyte = 0;
		double megabyte = 0;
		double gigabyte = 0;
		double terabyte = 0;
		double petabyte = 0;
		double exabyte = 0;
		double zettabyte = 0;
		double yottabyte = 0;
		
		try {
			
			dec_input_value = Double.parseDouble(input_value);
		} catch (Exception e) {
			
			dec_input_value = 0;
		}
		
		kilobyte = dec_input_value / 1024;
		megabyte = kilobyte / 1000;
		gigabyte = megabyte / 1000;
		terabyte = gigabyte / 1000;
		petabyte = terabyte / 1000;
		exabyte = petabyte / 1000;
		zettabyte = exabyte / 1000;
		yottabyte = zettabyte / 1000;
		
		if (kilobyte < 251) {
			
			output += String.valueOf(decimal_format.format(Math.round(kilobyte * 100.0) / 100.0)) + " KB.";
		} else if (megabyte < 501) {
		
			output += String.valueOf(decimal_format.format(Math.round(megabyte * 100.0) / 100.0)) + " MB.";
		} else if (gigabyte < 501) {
		
			output += String.valueOf(decimal_format.format(Math.round(gigabyte * 100.0) / 100.0)) + " GB.";
		} else if (terabyte < 501) {
		
			output += String.valueOf(decimal_format.format(Math.round(terabyte * 100.0) / 100.0)) + " TB.";
		} else if (petabyte < 501) {
		
			output += String.valueOf(decimal_format.format(Math.round(petabyte * 100.0) / 100.0)) + " PB.";
		} else if (exabyte < 501) {
		
			output += String.valueOf(decimal_format.format(Math.round(exabyte * 100.0) / 100.0)) + " EB.";
		} else if (zettabyte < 501) {
		
			output += String.valueOf(decimal_format.format(Math.round(zettabyte * 100.0) / 100.0)) + " ZB.";
		} else {
		
			output += String.valueOf(decimal_format.format(Math.round(yottabyte * 100.0) / 100.0)) + " YB.";
		}
		
		return output;
	}
	
	//This overloaded method gets the number of records returned in a search.
	protected int search_websites(String table_name, String field_name, String admin_session) {
		
		int output = 0;
		int int_admin_session = 0;
		
		try {
			
			int_admin_session = Integer.valueOf(admin_session);
		} catch (Exception e) {
			
			int_admin_session = 0;
		}
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
			
			PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM " + table_name + " WHERE " + field_name + " = ? ORDER BY row_id ASC");
			
			select_statement.setInt(1, int_admin_session);
			
			ResultSet select_results = select_statement.executeQuery();
			
			select_results.last();
			
			output = select_results.getRow();
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
			
			output = 0;
		}

		return output;
	}
	
	//This overloaded method helps to define an array length.
	protected int search_websites(String table_name, String admin_session) {
		
		int output = 0;
		int int_admin_session = 0;
		
		try {
			
			int_admin_session = Integer.valueOf(admin_session);
		} catch (Exception e) {
			
			int_admin_session = 0;
		}
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
			
			PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM " + table_name + " WHERE account_id = ? ORDER BY row_id ASC");
			
			select_statement.setInt(1, int_admin_session);
			
			ResultSet select_results = select_statement.executeQuery();
			
			select_results.last();
			
			if (select_results.getRow() == 0) {
				
				output = 1;
			} else {
				
				output = select_results.getRow();
			}
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
			
			output = 1;
		}

		return output;
	}
	
	//This overloaded method gathers search results.
	protected String[][] search_websites() {
		
		utilities.Form_Validation form_validation = new utilities.Form_Validation();
		
		String[][] output = new String[this.search_websites("third_party_website_info_per_traffic_monitor_app", get_admin_session)][6];
		int int_admin_session = 0;
		int row = 0;
		
		String get_admin_session = this.get_admin_session();
		
		try {
			
			int_admin_session = Integer.valueOf(get_admin_session);
		} catch (Exception e) {
			
			int_admin_session = 0;
		}
		
		if (get_admin_session.equals("null") || form_validation.is_string_null_or_white_space(get_admin_session)) {
			
			output[0][0] = "not logged in";
		} else {
			
			try {
				
				if (this.search_websites("third_party_website_info_per_traffic_monitor_app", "account_id", admin_session) > 0) {
					
					output[0][0] = "websites found";
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
					
					PreparedStatement select_statement = connection.prepareStatement("SELECT row_id, url, token, memory_plan, memory_limit FROM third_party_website_info_per_traffic_monitor_app WHERE account_id = ? ORDER BY row_id DESC");
					
					select_statement.setInt(1, int_admin_session);
					
					ResultSet select_results = select_statement.executeQuery();
					
					while (select_results.next()) {
						
						output[row][1] = String.valueOf(select_results.getInt(1));
						output[row][2] = select_results.getString(2);
						output[row][3] = select_results.getString(3);
						output[row][4] = select_results.getString(4);
						output[row][5] = select_results.getString(5);
						
						row++;
					}
				} else {
					
					output[0][0] = "no websites";
				}
			} catch (Exception e) {
				
				LOGGER.log(Level.INFO, "" + e + "");
				
				output[0][0] = "database error";
			}
		}
		
		return output;
	}
}
