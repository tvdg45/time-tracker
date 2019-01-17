//Author: Timothy van der Graaff
package models;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

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

public abstract class Sign_Up extends configuration.Config {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	//gets and sets variables
	private String first_name;
	private String last_name;
	private String email;
	private String username;
	private String password;
	private String confirm_password;
	private String date_received;
	private String time_received;
	private String sign_up;

	//sets
	protected void set_first_name(String first_name) {
		
		this.first_name = first_name;
	}
	
	protected void set_last_name(String last_name) {

		this.last_name = last_name;
	}
	
	protected void set_email(String email) {

		this.email = email;
	}
	
	protected void set_username(String username) {
		
		this.username = username;
	}
	
	protected void set_password(String password) {
		
		this.password = password;
	}
	
	protected void set_confirm_password(String confirm_password) {
		
		this.confirm_password = confirm_password;
	}
	
	protected void set_date_received(String date_received) {

		this.date_received = date_received;
	}
	
	protected void set_time_received(String time_received) {

		this.time_received = time_received;
	}
	
	protected void set_sign_up(String sign_up) {

		this.sign_up = sign_up;
	}
	
	//gets
	private String get_first_name() {

		return this.first_name;
	}
	
	private String get_last_name() {

		return this.last_name;
	}
	
	private String get_email() {

		return this.email;
	}
	
	private String get_username() {
		
		return this.username;
	}
	
	private String get_password() {
		
		return this.password;
	}
	
	private String get_confirm_password() {
		
		return this.confirm_password;
	}
	
	private String get_date_received() {

		return this.date_received;
	}
	
	private String get_time_received() {

		return this.time_received;
	}
	
	private String get_sign_up() {

		return this.sign_up;
	}
	
	
	
	
	
	private int generate_row_id() {

		int output = 0;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
			
			PreparedStatement prepared_statement = connection.prepareStatement("SELECT row_id FROM third_party_account_info_per_traffic_monitor_app ORDER BY row_id DESC LIMIT 1");
			
			ResultSet result_set = prepared_statement.executeQuery();
			
			while (result_set.next()) {
				
				output = result_set.getInt(1);
			}
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
		}

		return output + 1;
	}
	
	private String repeat_found_in_email(String input_string) {
		
		String output = "";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
			
			PreparedStatement prepared_statement = connection.prepareStatement("SELECT row_id FROM third_party_account_info_per_traffic_monitor_app WHERE email = BINARY ? ORDER BY row_id DESC");
			
			prepared_statement.setString(1, input_string);
			
			ResultSet result_set = prepared_statement.executeQuery();
			
			result_set.last();
			
			if (result_set.getRow() > 0) {
				
				output += "yes";
			} else {
				
				output += "no";
			}
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
		}
		
		return output;
	}
	
	private String repeat_found_in_username(String input_string) {
		
		String output = "";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
			
			PreparedStatement prepared_statement = connection.prepareStatement("SELECT row_id FROM third_party_account_info_per_traffic_monitor_app WHERE username = BINARY ? ORDER BY row_id DESC");
			
			prepared_statement.setString(1, input_string);
			
			ResultSet result_set = prepared_statement.executeQuery();
			
			result_set.last();
			
			if (result_set.getRow() > 0) {
				
				output += "yes";
			} else {
				
				output += "no";
			}
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
		}
		
		return output;
	}
	
	protected String[] sign_up() {
		
		utilities.Form_Validation form_validation = new utilities.Form_Validation();
		
		String[] output = new String[8];
		String redundancy_found_in_email = "";
		String redundancy_found_in_username = "";
		
		String get_first_name = this.get_first_name();
		String get_last_name = this.get_last_name();
		String get_email = this.get_email();
		String get_username = this.get_username();
		String get_password = this.get_password();
		String get_confirm_password = this.get_confirm_password();
		String get_date_received = this.get_date_received();
		String get_time_received = this.get_time_received();
		String get_sign_up = this.get_sign_up();
		
		if (get_sign_up.equals("Sign up")) {
			
			redundancy_found_in_email = this.repeat_found_in_email(get_email);
			redundancy_found_in_username = this.repeat_found_in_username(get_username);
			
			if (form_validation.is_string_null_or_white_space(get_first_name) || form_validation.is_string_null_or_white_space(get_last_name) || form_validation.is_string_null_or_white_space(get_email) || !(form_validation.is_email_valid(get_email)) || redundancy_found_in_email.equals("yes") || form_validation.is_string_null_or_white_space(get_username) || get_username.length() < 3 || form_validation.number_of_white_spaces(get_username) > 0 || redundancy_found_in_username.equals("yes") || form_validation.is_string_null_or_white_space(get_password) || get_password.length() < 8 || form_validation.number_of_uppercase_characters(get_password) < 1 || get_password.replaceAll("\\D", "").length() < 2 || get_username.equals(get_password) || form_validation.is_string_null_or_white_space(get_confirm_password) || !(get_confirm_password.equals(get_password))) {
				
				if (form_validation.is_string_null_or_white_space(get_first_name)) {
					
					output[0] = "You must provide your first name.";
				}
				
				if (form_validation.is_string_null_or_white_space(get_last_name)) {
					
					output[1] = "You must provide your last name.";
				}
				
				if (form_validation.is_string_null_or_white_space(get_email) || !(form_validation.is_email_valid(get_email))) {
					
					output[2] = "You must provide a valid email.";
				}
				
				if (redundancy_found_in_email.equals("yes")) {
					
					output[3] = "That email is already taken.  Please choose a different one.";
				}
				
				if (form_validation.is_string_null_or_white_space(get_username) || get_username.length() < 3 || form_validation.number_of_white_spaces(get_username) > 0) {
					
					output[4] = "Your username must contain at least three characters. Your username is allowed to contain letters, numbers, and symbols. Symbols include !, $, #, etc. Your username must not contain any spaces.";
				}
				
				if (redundancy_found_in_username.equals("yes")) {
					
					output[5] = "That username is already taken.  Please choose a different one.";
				}
				
				if (form_validation.is_string_null_or_white_space(get_password) || get_password.length() < 8 || form_validation.number_of_uppercase_characters(get_password) < 1 || get_password.replaceAll("\\D", "").length() < 2 || get_username.equals(get_password)) {
					
					output[6] = "Your password must contain at least eight characters, including at least one uppercase letter, and two numeric characters. Your password is allowed to contain symbols, such as !, $, #, etc. Your password must not be the same as your username.";
				}
				
				if (form_validation.is_string_null_or_white_space(get_confirm_password)) {
					
					output[7] = "You must confirm your password.";
				} else if (!(get_confirm_password.equals(get_password))) {
					
					output[7] = "Passwords must match.";
				}
			} else {
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
					
					PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM third_party_account_info_per_traffic_monitor_app WHERE first_name = ? AND last_name = ? AND email = BINARY ? AND username = BINARY ? AND password = BINARY ? AND authority_level = ? AND date_received = ? AND time_received = ? ORDER BY row_id DESC");
				
					select_statement.setString(1, get_first_name);
					select_statement.setString(2, get_last_name);
					select_statement.setString(3, get_email);
					select_statement.setString(4, get_username);
					select_statement.setString(5, get_password);
					select_statement.setString(6, "general user");
					select_statement.setString(7, get_date_received);
					select_statement.setString(8, get_time_received);
					
					ResultSet select_results = select_statement.executeQuery();
					
					select_results.last();
					
					if (select_results.getRow() < 1) {
						
						PreparedStatement insert_statement = connection.prepareStatement("INSERT INTO third_party_account_info_per_traffic_monitor_app (row_id, first_name, last_name, email, username, password, authority_level, date_received, time_received) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
						
						insert_statement.setInt(1, this.generate_row_id());
						insert_statement.setString(2, get_first_name);
						insert_statement.setString(3, get_last_name);
						insert_statement.setString(4, get_email);
						insert_statement.setString(5, get_username);
						insert_statement.setString(6, get_password);
						insert_statement.setString(7, "general user");
						insert_statement.setString(8, get_date_received);
						insert_statement.setString(9, get_time_received);
						
						insert_statement.execute();
						
						output[0] = "successful database update";
					} else {
						
						output[0] = "successful database update";
					}
				} catch (Exception e) {
					
					LOGGER.log(Level.INFO, "" + e + "");
					
					output[0] = "database error";
				}
			}
		} else {
			
			output[0] = "no user action";
		}
		
		return output;
	}
}
