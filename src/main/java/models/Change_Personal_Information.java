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

public abstract class Change_Personal_Information extends configuration.Config {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	//gets and sets variables
	private String first_name;
	private String last_name;
	private String email;
	private String username;
	private String current_password;
	private String new_password;
	private String confirm_new_password;
	private String save_basic_information;
	private String save_email;
	private String save_username;
	private String save_password;
	private String cancel_changes;
	private String admin_session;
	
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
	
	protected void set_current_password(String current_password) {
		
		this.current_password = current_password;
	}
	
	protected void set_new_password(String new_password) {
		
		this.new_password = new_password;
	}
	
	protected void set_confirm_new_password(String confirm_new_password) {
		
		this.confirm_new_password = confirm_new_password;
	}
	
	protected void set_save_basic_information(String save_basic_information) {
		
		this.save_basic_information = save_basic_information;
	}
	
	protected void set_save_email(String save_email) {
		
		this.save_email = save_email;
	}
	
	protected void set_save_username(String save_username) {
		
		this.save_username = save_username;
	}
	
	protected void set_save_password(String save_password) {
		
		this.save_password = save_password;
	}
	
	protected void set_cancel_changes(String cancel_changes) {

		this.cancel_changes = cancel_changes;
	}
	
	protected void set_admin_session(String admin_session) {

		this.admin_session = admin_session;
	}
	
	//gets
	private String get_first_name() {

		return this.first_name;
	}
	
	private String get_last_name() {

		return this.last_name;
	}
	
	private	String get_email() {
		
		return this.email;
	}
	
	private String get_username() {
		
		return this.username;
	}
	
	private String get_current_password() {
		
		return this.current_password;
	}
	
	private String get_new_password() {
		
		return this.new_password;
	}
	
	private String get_confirm_new_password() {
		
		return this.confirm_new_password;
	}
	
	private String get_save_basic_information() {
		
		return this.save_basic_information;
	}
	
	private	String get_save_email() {
		
		return this.save_email;
	}
	
	private String get_save_username() {
		
		return this.save_username;
	}
	
	private String get_save_password() {
		
		return this.save_password;
	}
	
	private String get_cancel_changes() {

		return this.cancel_changes;
	}
	
	private String get_admin_session() {

		return this.admin_session;
	}
	
	
	
	
	
	
	
	private String repeat_found_in_email(String input_value, String admin_session) {
		
		String output = "";
		int int_admin_session = 0;
		
		try {
			
			int_admin_session = Integer.valueOf(admin_session);
		} catch (Exception e) {
			
			int_admin_session = 0;
		}
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
			
			PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM third_party_account_info_per_traffic_monitor_app WHERE email = BINARY ? AND NOT row_id = ? ORDER BY row_id DESC");
			
			select_statement.setString(1, input_value);
			select_statement.setInt(2, int_admin_session);
			
			ResultSet select_results = select_statement.executeQuery();
			
			select_results.last();
			
			if (select_results.getRow() > 0) {
				
				output = "yes";
			} else {
				
				output = "no";
			}
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
		}
		
		return output;
	}
	
	private String repeat_found_in_username(String input_value, String admin_session) {
		
		String output = "";
		int int_admin_session = 0;
		
		try {
			
			int_admin_session = Integer.valueOf(admin_session);
		} catch (Exception e) {
			
			int_admin_session = 0;
		}
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
			
			PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM third_party_account_info_per_traffic_monitor_app WHERE username = BINARY ? AND NOT row_id = ? ORDER BY row_id DESC");
			
			select_statement.setString(1, input_value);
			select_statement.setInt(2, int_admin_session);
			
			ResultSet select_results = select_statement.executeQuery();
			
			select_results.last();
			
			if (select_results.getRow() > 0) {
				
				output = "yes";
			} else {
				
				output = "no";
			}
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
		}
		
		return output;
	}
	
	private String validate_password(String input_value, String admin_session) {
		
		String output = "";
		int int_admin_session = 0;
		
		try {
			
			int_admin_session = Integer.valueOf(admin_session);
		} catch (Exception e) {
			
			int_admin_session = 0;
		}
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
			
			PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM third_party_account_info_per_traffic_monitor_app WHERE password = BINARY ? AND row_id = ? ORDER BY row_id DESC");
			
			select_statement.setString(1, input_value);
			select_statement.setInt(2, int_admin_session);
			
			ResultSet select_results = select_statement.executeQuery();
			
			select_results.last();
			
			if (select_results.getRow() > 0) {
				
				output = "yes";
			} else {
				
				output = "no";
			}
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
		}
		
		return output;
	}

	private String validate_username(String input_value, String admin_session) {
		
		String output = "";
		int int_admin_session = 0;
		
		try {
			
			int_admin_session = Integer.valueOf(admin_session);
		} catch (Exception e) {
			
			int_admin_session = 0;
		}
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
			
			PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM third_party_account_info_per_traffic_monitor_app WHERE username = BINARY ? AND row_id = ? ORDER BY row_id DESC");
			
			select_statement.setString(1, input_value);
			select_statement.setInt(2, int_admin_session);
			
			ResultSet select_results = select_statement.executeQuery();
			
			select_results.last();
			
			if (select_results.getRow() > 0) {
				
				output = "yes";
			} else {
				
				output = "no";
			}
		} catch (Exception e) {
			
			LOGGER.log(Level.INFO, "" + e + "");
		}
		
		return output;
	}

	protected String[] change_basic_information() {
		
		utilities.Form_Validation form_validation = new utilities.Form_Validation();
		
		String[] output = new String[2];
		int int_admin_session = 0;
		
		String get_first_name = this.get_first_name();
		String get_last_name = this.get_last_name();
		String get_save_basic_information = this.get_save_basic_information();
		String get_cancel_changes = this.get_cancel_changes();
		String get_admin_session = this.get_admin_session();
		
		if (!(get_admin_session.equals("null")) && !(form_validation.is_string_null_or_white_space(get_admin_session))) {
			
			if (!(get_save_basic_information.equals("null")) || !(get_cancel_changes.equals("null"))) {
				
				if (!(get_admin_session.equals("null")) && !(form_validation.is_string_null_or_white_space(get_admin_session))) {
					
					if (!(get_save_basic_information.equals("null"))) {
						
						if (form_validation.is_string_null_or_white_space(get_first_name) || form_validation.is_string_null_or_white_space(get_last_name)) {
							
							if (form_validation.is_string_null_or_white_space(get_first_name)) {
								
								output[0] = "You must provide your first name.";
							}
							
							if (form_validation.is_string_null_or_white_space(get_last_name)) {
								
								output[1] = "You must provide your last name.";
							}
						} else {
							
							try {
								
								int_admin_session = Integer.valueOf(get_save_basic_information);
							} catch (Exception e) {
								
								int_admin_session = 0;
							}
							
							try {
								
								Class.forName("com.mysql.jdbc.Driver");
								
								Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
								
								PreparedStatement update_statement = connection.prepareStatement("UPDATE third_party_account_info_per_traffic_monitor_app SET first_name = ?, last_name = ? WHERE row_id = ?");
								
								update_statement.setString(1, get_first_name);
								update_statement.setString(2, get_last_name);
								update_statement.setInt(3, int_admin_session);
								
								update_statement.execute();
								
								output[0] = "successful database update";
							} catch (Exception e) {
								
								LOGGER.log(Level.INFO, "" + e + "");
								
								output[0] = "database error";
							}
						}
					} else if (!(get_cancel_changes.equals("null"))) {
						
						output[0] = "voided changes";
					}
				} else {
					
					output[0] = "not logged in";
				}
			} else {
				
				output[0] = "no user action";
			}
		} else {
			
			output[0] = "not logged in";
		}
		
		return output;
	}
	
	protected String[] change_email() {
		
		utilities.Form_Validation form_validation = new utilities.Form_Validation();
		
		String[] output = new String[2];
		int int_admin_session = 0;
		String redundancy_found_in_email = "";
		
		String get_email = this.get_email();
		String get_save_email = this.get_save_email();
		String get_cancel_changes = this.get_cancel_changes();
		String get_admin_session = this.get_admin_session();
		
		if (!(get_admin_session.equals("null")) && !(form_validation.is_string_null_or_white_space(get_admin_session))) {
			
			if (!(get_save_email.equals("null")) || !(get_cancel_changes.equals("null"))) {
				
				if (!(get_admin_session.equals("null")) && !(form_validation.is_string_null_or_white_space(get_admin_session))) {
					
					if (!(get_save_email.equals("null"))) {
						
						redundancy_found_in_email = this.repeat_found_in_email(get_email, get_save_email);
						
						if (form_validation.is_string_null_or_white_space(get_email) || !(form_validation.is_email_valid(get_email)) || redundancy_found_in_email.equals("yes")) {
							
							if (form_validation.is_string_null_or_white_space(get_email) || !(form_validation.is_email_valid(get_email))) {
								
								output[0] = "You must provide a valid email.";
							}
							
							if (redundancy_found_in_email.equals("yes")) {
								
								output[1] = "That email is already taken.  Please choose a different one.";
							}
						} else {
							
							try {
								
								int_admin_session = Integer.valueOf(get_save_email);
							} catch (Exception e) {
								
								int_admin_session = 0;
							}

							try {
								
								Class.forName("com.mysql.jdbc.Driver");
								
								Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
								
								PreparedStatement update_statement = connection.prepareStatement("UPDATE third_party_account_info_per_traffic_monitor_app SET email = ? WHERE row_id = ?");
								
								update_statement.setString(1, get_email);
								update_statement.setInt(2, int_admin_session);
								
								update_statement.execute();
								
								output[0] = "successful database update";
							} catch (Exception e) {
								
								LOGGER.log(Level.INFO, "" + e + "");
								
								output[0] = "database error";
							}							
						}
					} else if (!(get_cancel_changes.equals("null"))) {
						
						output[0] = "voided changes";
					}
				} else {
					
					output[0] = "not logged in";
				}
			} else {
				
				output[0] = "no user action";
			}
		} else {
			
			output[0] = "not logged in";
		}
		
		return output;
	}
	
	protected String[] change_username() {
		
		utilities.Form_Validation form_validation = new utilities.Form_Validation();
		
		String[] output = new String[2];
		int int_admin_session = 0;
		String redundancy_found_in_username = "";
		String is_username_your_password = "";
		
		String get_username = this.get_username();
		String get_save_username = this.get_save_username();
		String get_cancel_changes = this.get_cancel_changes();
		String get_admin_session = this.get_admin_session();
		
		if (!(get_admin_session.equals("null")) && !(form_validation.is_string_null_or_white_space(get_admin_session))) {
			
			if (!(get_save_username.equals("null")) || !(get_cancel_changes.equals("null"))) {
				
				if (!(get_admin_session.equals("null")) && !(form_validation.is_string_null_or_white_space(get_admin_session))) {
					
					if (!(get_save_username.equals("null"))) {
						
						redundancy_found_in_username = this.repeat_found_in_username(get_username, get_save_username);
						is_username_your_password = this.validate_password(get_username, get_save_username);
						
						if (form_validation.is_string_null_or_white_space(get_username) || get_username.length() < 3 || form_validation.number_of_white_spaces(get_username) > 0 || redundancy_found_in_username.equals("yes") || is_username_your_password.equals("yes")) {
							
							if (form_validation.is_string_null_or_white_space(get_username) || get_username.length() < 3 || form_validation.number_of_white_spaces(get_username) > 0 || is_username_your_password.equals("yes")) {
								
								output[0] = "Your username must contain at least three characters. Your username is allowed to contain letters, numbers, and symbols. Symbols include !, $, #, etc. Your username must not contain any spaces. Your username must not be the same as your password.";
							}
							
							if (redundancy_found_in_username.equals("yes")) {
								
								output[1] = "That username is already taken.  Please choose a different one.";
							}
						} else {
							
							try {
								
								int_admin_session = Integer.valueOf(get_save_username);
							} catch (Exception e) {
								
								int_admin_session = 0;
							}

							try {
								
								Class.forName("com.mysql.jdbc.Driver");
								
								Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
								
								PreparedStatement update_statement = connection.prepareStatement("UPDATE third_party_account_info_per_traffic_monitor_app SET username = ? WHERE row_id = ?");
								
								update_statement.setString(1, get_username);
								update_statement.setInt(2, int_admin_session);
								
								update_statement.execute();
								
								output[0] = "successful database update";
							} catch (Exception e) {
								
								LOGGER.log(Level.INFO, "" + e + "");
								
								output[0] = "database error";
							}							
						}
					} else if (!(get_cancel_changes.equals("null"))) {
						
						output[0] = "voided changes";
					}
				} else {
					
					output[0] = "not logged in";
				}
			} else {
				
				output[0] = "no user action";
			}
		} else {
			
			output[0] = "not logged in";
		}
		
		return output;
	}
	
	protected String[] change_password() {
		
		utilities.Form_Validation form_validation = new utilities.Form_Validation();
		
		String[] output = new String[4];
		int int_admin_session = 0;
		String is_password_valid = "";
		String is_new_password_your_username = "";
		String is_new_password_your_current_one = "";
		
		String get_current_password = this.get_current_password();
		String get_new_password = this.get_new_password();
		String get_confirm_new_password = this.get_confirm_new_password();
		String get_save_password = this.get_save_password();
		String get_cancel_changes = this.get_cancel_changes();
		String get_admin_session = this.get_admin_session();
		
		if (!(get_admin_session.equals("null")) && !(form_validation.is_string_null_or_white_space(get_admin_session))) {
			
			if (!(get_save_password.equals("null")) || !(get_cancel_changes.equals("null"))) {
				
				if (!(get_admin_session.equals("null")) && !(form_validation.is_string_null_or_white_space(get_admin_session))) {
					
					if (!(get_save_password.equals("null"))) {
						
						is_password_valid = this.validate_password(get_current_password, get_save_password);
						is_new_password_your_username = this.validate_username(get_new_password, get_save_password);
						is_new_password_your_current_one = this.validate_password(get_new_password, get_save_password);
						
						output[0] = is_password_valid;
						if (form_validation.is_string_null_or_white_space(get_current_password) || !(is_password_valid.equals("yes")) || form_validation.is_string_null_or_white_space(get_new_password) || get_new_password.length() < 8 || form_validation.number_of_uppercase_characters(get_new_password) < 1 || get_new_password.replaceAll("\\D", "").length() < 2 || is_new_password_your_username.equals("yes") || is_new_password_your_current_one.equals("yes") || form_validation.is_string_null_or_white_space(get_confirm_new_password) || !(get_new_password.equals(get_confirm_new_password))) {
							
							if (form_validation.is_string_null_or_white_space(get_current_password) || !(is_password_valid.equals("yes"))) {
								
								output[0] += "You must correctly provide your current password.  Check for misspellings.";
							}
							
							if ((form_validation.is_string_null_or_white_space(get_new_password) || get_new_password.length() < 8 || form_validation.number_of_uppercase_characters(get_new_password) < 1 || get_new_password.replaceAll("\\D", "").length() < 2 || is_new_password_your_username.equals("yes") || is_new_password_your_current_one.equals("yes")) && !(form_validation.is_string_null_or_white_space(get_current_password) || !(is_password_valid.equals("yes")))) {
								
								output[1] = "Your password must contain at least eight characters, including at least one uppercase letter, and two numeric characters. Your password is allowed to contain symbols, such as !, $, #, etc. Your new password must not be the same as your username or current password.";
							}
							
							if (form_validation.is_string_null_or_white_space(get_confirm_new_password) && !(form_validation.is_string_null_or_white_space(get_current_password) || !(is_password_valid.equals("yes")))) {
								
								output[2] = "You must confirm your password.";
							}
							
							if ((!(form_validation.is_string_null_or_white_space(get_new_password)) && !(form_validation.is_string_null_or_white_space(get_confirm_new_password)) && !(get_new_password.equals(get_confirm_new_password))) && !(form_validation.is_string_null_or_white_space(get_current_password) || !(is_password_valid.equals("yes")))) {
								
								output[3] = "Passwords must match.";
							}
						} else {
							
							try {
								
								int_admin_session = Integer.valueOf(get_save_password);
							} catch (Exception e) {
								
								int_admin_session = 0;
							}

							try {
								
								Class.forName("com.mysql.jdbc.Driver");
								
								Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
								
								PreparedStatement update_statement = connection.prepareStatement("UPDATE third_party_account_info_per_traffic_monitor_app SET password = ? WHERE row_id = ?");
								
								update_statement.setString(1, get_confirm_new_password);
								update_statement.setInt(2, int_admin_session);
								
								update_statement.execute();
								
								output[0] = "successful database update";
							} catch (Exception e) {
								
								LOGGER.log(Level.INFO, "" + e + "");
								
								output[0] = "database error";
							}							
						}
					} else if (!(get_cancel_changes.equals("null"))) {
						
						output[0] = "voided changes";
					}
				} else {
					
					output[0] = "not logged in";
				}
			} else {
				
				output[0] = "no user action";
			}
		} else {
			
			output[0] = "not logged in";
		}
		
		return output;
	}
}
