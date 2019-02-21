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

public abstract class Fetch_Lost_Personal_Information extends configuration.Config {
	
	private utilities.Form_Validation form_validation;
	
	public Fetch_Lost_Personal_Information() {
		
		form_validation = new utilities.Form_Validation();
	}
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	//gets and sets variables
	private String email;
	private String username;
	private String fetch_username;
	private String fetch_password;
	
	//sets
	protected void set_email(String email) {
		
		this.email = email;
	}
	
	protected void set_username(String username) {
		
		this.username = username;
	}
	
	protected void set_fetch_username(String fetch_username) {
		
		this.fetch_username = fetch_username;
	}
	
	protected void set_fetch_password(String fetch_password) {
		
		this.fetch_password = fetch_password;
	}
	
	//gets
	private String get_email() {
		
		return this.email;
	}
	
	private String get_username() {
		
		return this.username;
	}
	
	private String get_fetch_username() {
		
		return this.fetch_username;
	}
	
	private String get_fetch_password() {
		
		return this.fetch_password;
	}
	
	
	
	
	
	
	private String random_keys() {
		
		String output = "";
		
		int left_limit = 97; // letter 'a'
		int right_limit = 122; // letter 'z'
		int target_string_length = 10;
		int random_limited_int = 0;
		
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(target_string_length);
		
		for (int i = 0; i < target_string_length; i++) {
			
			random_limited_int = left_limit + (int)(random.nextFloat() * (right_limit - left_limit + 1));
			
			buffer.append((char) random_limited_int);
		}
		
		output = buffer.toString();
		
		return output;
	}
	
	private void change_password(String username) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
			
			PreparedStatement update_statement = connection.prepareStatement("UPDATE third_party_account_info_per_traffic_monitor_app SET password = ? WHERE username = BINARY ?");
			
			update_statement.setString(1, this.random_keys());
			update_statement.setString(2, username);
			
			update_statement.execute();
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
		}
	}
	
	private int check_number_of_rows(String table_name, String field_name, String input_value) {
		
		int output = 0;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
			
			PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM " + table_name + " WHERE " + field_name + " = BINARY ? ORDER BY row_id DESC");
			
			select_statement.setString(1, input_value);
			
			ResultSet select_results = select_statement.executeQuery();
			
			select_results.last();
			
			output = select_results.getRow();
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
		}
		
		return output;
	}
	
	protected String[][] fetch_username() {
		
		String[][] output = new String[1][4];
		
		String get_email = this.get_email();
		String get_fetch_username = this.get_fetch_username();
		
		if (!(get_fetch_username.equals("null"))) {
			
			if (this.form_validation.is_string_null_or_white_space(get_email) || !(this.form_validation.is_email_valid(get_email))) {
				
				output[0][0] = "You must provide a valid email.";
			} else {
				
				try {
					
					if (this.check_number_of_rows("third_party_account_info_per_traffic_monitor_app", "email", get_email) != 1) {
						
						output[0][0] = "That email does not match our records.  Please try again.";
					} else {
						
						output[0][0] = "successful username authentication";
						
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
					
						PreparedStatement select_statement = connection.prepareStatement("SELECT first_name, username, email FROM third_party_account_info_per_traffic_monitor_app WHERE email = BINARY ? ORDER BY row_id DESC");
				
						select_statement.setString(1, get_email);
					
						ResultSet select_results = select_statement.executeQuery();
					
						while (select_results.next()) {
							
							output[0][1] = select_results.getString(1);
							output[0][2] = select_results.getString(2);
							output[0][3] = select_results.getString(3);
						}
					}
				} catch (Exception e) {
					
					LOGGER.log(Level.INFO, "" + e + "");
					
					output[0][0] = "database error";
				}
			}
		} else {
			
			output[0][0] = "no user action";
		}
		
		return output;
	}
	
	protected String[][] fetch_password() {
		
		String[][] output = new String[1][5];
		
		String get_username = this.get_username();
		String get_fetch_password = this.get_fetch_password();
		
		if (!(get_fetch_password.equals("null"))) {
			
			if (this.form_validation.is_string_null_or_white_space(get_username)) {
				
				output[0][0] = "You must provide your username.";
			} else {
				
				try {
					
					if (this.check_number_of_rows("third_party_account_info_per_traffic_monitor_app", "username", get_username) != 1) {
						
						output[0][0] = "That username does not match our records.  Please try again.";
					} else {
						
						output[0][0] = "successful password authentication";
						
						this.change_password(get_username);
						
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
						
						PreparedStatement select_statement = connection.prepareStatement("SELECT first_name, username, email, password FROM third_party_account_info_per_traffic_monitor_app WHERE username = BINARY ? ORDER BY row_id DESC");
						
						select_statement.setString(1, get_username);
						
						ResultSet select_results = select_statement.executeQuery();
						
						while (select_results.next()) {
							
							output[0][1] = select_results.getString(1);
							output[0][2] = select_results.getString(2);
							output[0][3] = select_results.getString(3);
							output[0][4] = select_results.getString(4);
						}						
					}
				} catch (Exception e) {
					
					LOGGER.log(Level.INFO, "" + e + "");
					
					output[0][0] = "database error";
				}
			}
		} else {
			
			output[0][0] = "no user action";
		}
		
		return output;
	}
}
