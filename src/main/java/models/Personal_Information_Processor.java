//Author: Timothy van der Graaff
package models;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

public abstract class Personal_Information_Processor extends configuration.Config {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	//This overloaded method gets the number of records returned in a search.
	protected int search_personal_information(String table_name, String field_name, String admin_session) {
		
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
	protected int search_personal_information(String table_name, String admin_session) {
		
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
			
			PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM " + table_name + " WHERE row_id = ? ORDER BY row_id ASC");
			
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
	protected String[][] search_personal_information(String admin_session) {
		
		String[][] output = new String[1][6];
		int int_admin_session = 0;
		int row = 0;
		
		try {
			
			int_admin_session = Integer.valueOf(admin_session);
		} catch (Exception e) {
			
			int_admin_session = 0;
		}
		
		try {
			
			if (this.search_personal_information("third_party_account_info_per_traffic_monitor_app", "row_id", admin_session) == 1) {
				
				output[0][0] = "valid user found";
			
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
				
				PreparedStatement select_statement = connection.prepareStatement("SELECT row_id, first_name, last_name, email, username FROM third_party_account_info_per_traffic_monitor_app WHERE row_id = ? ORDER BY row_id ASC");
			
				select_statement.setInt(1, int_admin_session);
			
				ResultSet select_results = select_statement.executeQuery();
			
				while (select_results.next()) {
				
					output[0][1] = String.valueOf(select_results.getInt(1));
					output[0][2] = select_results.getString(2);
					output[0][3] = select_results.getString(3);
					output[0][4] = select_results.getString(4);
					output[0][5] = select_results.getString(5);
				
					row++;
				}
			} else {
				
				output[0][0] = "no valid user";
			}
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
			
			output[0][0] = "database error";
		}

		return output[0][0];
	}
}
