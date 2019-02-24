= //Author: Timothy van der Graaff
package models;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Change_Third_Party_Account extends configuration.Config {

 protected utilities.Form_Validation form_validation;

 public Change_Third_Party_Account() {

  form_validation = new utilities.Form_Validation();
 }

 private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

 //gets and sets variables
 private String id;
 private String url;
 private String token;
 private String memory_plan;
 private String memory;
 private String date_received;
 private String time_received;
 private String add_website;
 private String change_url;
 private String change_token;
 private String delete_website;
 private String downgrade_plan;
 private String upgrade_plan;
 private String admin_session;

 //sets
 protected void set_id(String id) {

  this.id = id;
 }

 protected void set_url(String url) {

  this.url = url;
 }

 protected void set_token(String token) {

  this.token = token;
 }

 protected void set_memory_plan(String memory_plan) {

  this.memory_plan = memory_plan;
 }

 protected void set_memory(String memory) {

  this.memory = memory;
 }

 protected void set_date_received(String date_received) {

  this.date_received = date_received;
 }

 protected void set_time_received(String time_received) {

  this.time_received = time_received;
 }

 protected void set_add_website(String add_website) {

  this.add_website = add_website;
 }

 protected void set_change_url(String change_url) {

  this.change_url = change_url;
 }

 protected void set_change_token(String change_token) {

  this.change_token = change_token;
 }

 protected void set_delete_website(String delete_website) {

  this.delete_website = delete_website;
 }

 protected void set_downgrade_plan(String downgrade_plan) {

  this.downgrade_plan = downgrade_plan;
 }

 protected void set_upgrade_plan(String upgrade_plan) {

  this.upgrade_plan = upgrade_plan;
 }

 protected void set_admin_session(String admin_session) {

  this.admin_session = admin_session;
 }

 //gets
 private String get_id() {

  return this.id;
 }

 private String get_url() {

  return this.url;
 }

 private String get_token() {

  return this.token;
 }

 private String get_memory_plan() {

  return this.memory_plan;
 }

 private String get_memory() {

  return this.memory;
 }

 private String get_date_received() {

  return this.date_received;
 }

 private String get_time_received() {

  return this.time_received;
 }

 private String get_add_website() {

  return this.add_website;
 }

 private String get_change_url() {

  return this.change_url;
 }

 private String get_change_token() {

  return this.change_token;
 }

 private String get_delete_website() {

  return this.delete_website;
 }

 private String get_downgrade_plan() {

  return this.downgrade_plan;
 }

 private String get_upgrade_plan() {

  return this.upgrade_plan;
 }

 private String get_admin_session() {

  return this.admin_session;
 }




 private int generate_row_id(String database_table) {

  int output = 0;

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement prepared_statement = connection.prepareStatement("SELECT row_id FROM " + database_table + " ORDER BY row_id DESC LIMIT 1");

   ResultSet result_set = prepared_statement.executeQuery();

   while (result_set.next()) {

    output = result_set.getInt(1);
   }
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);
  }

  return output + 1;
 }

 private void create_new_shopping_cart_table() {

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement create_statement = connection.prepareStatement("CREATE TABLE third_party_traffic_monitor_app_shopping_cart (row_id INT NOT NULL, item TEXT NOT NULL, description TEXT NOT NULL, price DECIMAL(10,2) NOT NULL, quantity INT NOT NULL, date_received TEXT NOT NULL, time_received TEXT NOT NULL, website_id INT NOT NULL, PRIMARY KEY (row_id)) ENGINE = MYISAM;");

   create_statement.execute();
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "The 'third_party_traffic_monitor_app_shopping_cart' table was not created because it already exists.  This is not necessarily an error.");
  }
 }

 private void create_new_third_party_website_info_per_traffic_monitor_app_table() {

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement create_statement = connection.prepareStatement("CREATE TABLE third_party_website_info_per_traffic_monitor_app (row_id INT NOT NULL, url TEXT NOT NULL, token TEXT NOT NULL, memory_plan TEXT NOT NULL, memory_limit TEXT NOT NULL, date_received TEXT NOT NULL, time_received TEXT NOT NULL, account_id INT NOT NULL, PRIMARY KEY (row_id)) ENGINE = MYISAM;");

   create_statement.execute();
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "The 'third_party_website_info_per_traffic_monitor_app' table was not created because it already exists.  This is not necessarily an error.");
  }
 }

 private void create_new_purchase_receipt_table() {

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement create_statement = connection.prepareStatement("CREATE TABLE third_party_traffic_monitor_app_receipts (row_id INT NOT NULL, date_received TEXT NOT NULL, time_received TEXT NOT NULL, website_id INT NOT NULL, PRIMARY KEY (row_id)) ENGINE = MYISAM;");

   create_statement.execute();
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "The 'third_party_traffic_monitor_app_receipts' table was not created because it already exists.  This is not necessarily an error.");
  }
 }

 private void create_new_items_sold_table() {

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement create_statement = connection.prepareStatement("CREATE TABLE third_party_traffic_monitor_app_items_sold (row_id INT NOT NULL, item TEXT NOT NULL, description TEXT NOT NULL, price DECIMAL(10,2) NOT NULL, quantity INT NOT NULL, date_received TEXT NOT NULL, time_received TEXT NOT NULL, receipt_id INT NOT NULL, website_id INT NOT NULL, PRIMARY KEY (row_id)) ENGINE = MYISAM;");

   create_statement.execute();
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "The 'third_party_traffic_monitor_app_items_sold' table was not created because it already exists.  This is not necessarily an error.");
  }
 }

 private double convert_to_bytes_from_gigabytes(String input_value) {

  DecimalFormat decimal_format = new DecimalFormat("#,##0.00");
  double output;
  double int_input_value;
  double megabytes;
  double kilobytes;
  double bytes;

  try {

   int_input_value = Double.parseDouble(input_value);
  } catch (Exception e) {

   int_input_value = 0;
  }

  megabytes = int_input_value * 1000;
  kilobytes = megabytes * 1000;
  bytes = kilobytes * 1024;

  output = Double.parseDouble(decimal_format.format(Math.round(bytes * 100.0) / 100.0));

  return output;
 }

 //This overloaded method gets the number of records returned in a search.
 protected int search_number_of_bytes(String table_name, String field_name, String input_value) {

  int output;
  int int_input_value;

  try {

   int_input_value = Integer.valueOf(input_value);
  } catch (Exception e) {

   int_input_value = 0;
  }

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM " + table_name + " WHERE " + field_name + " = ? ORDER BY row_id ASC");

   select_statement.setInt(1, int_input_value);

   ResultSet select_results = select_statement.executeQuery();

   select_results.last();

   output = select_results.getRow();
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);

   output = 0;
  }

  return output;
 }

 //This overloaded method gathers search results.
 private int search_number_of_bytes(String input_value) {

  int output = 0;
  int int_input_value;

  try {

   int_input_value = Integer.valueOf(input_value);
  } catch (Exception e) {

   int_input_value = 0;
  }

  try {

   if (this.search_number_of_bytes("third_party_website_info_per_traffic_monitor_app", "row_id", input_value) == 1) {

    Class.forName("com.mysql.jdbc.Driver");

    Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

    PreparedStatement select_statement = connection.prepareStatement("SELECT memory_limit FROM third_party_website_info_per_traffic_monitor_app WHERE row_id = ?");

    select_statement.setInt(1, int_input_value);

    ResultSet select_results = select_statement.executeQuery();

    while (select_results.next()) {

     try {

      output = Integer.valueOf(select_results.getString(1));
     } catch (SQLException | NumberFormatException e) {

      output = 0;
     }
    }
   } else {

    output = 0;
   }
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);

   this.create_new_third_party_website_info_per_traffic_monitor_app_table();

   output = 0;
  }

  return output;
 }

 private String check_for_existing_website(String input_value) {

  String output = "";

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM third_party_website_info_per_traffic_monitor_app WHERE url = ? ORDER BY row_id DESC");

   select_statement.setString(1, input_value);

   ResultSet select_results = select_statement.executeQuery();

   select_results.last();

   if (select_results.getRow() > 0) {

    output = "website already exists";
   }
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);

   this.create_new_third_party_website_info_per_traffic_monitor_app_table();

   output = "database error";
  }

  return output;
 }

 protected String[] add_website() {

  String[] output = new String[3];
  int int_admin_session;
  String check_for_existing_website;

  String get_url = this.get_url();
  String get_token = this.get_token();
  String get_date_received = this.get_date_received();
  String get_time_received = this.get_time_received();
  String get_add_website = this.get_add_website();
  String get_admin_session = this.get_admin_session();

  if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

   if (!(get_add_website.equals("null"))) {

    if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

     check_for_existing_website = this.check_for_existing_website(get_url.toLowerCase());

     if (this.form_validation.is_string_null_or_white_space(get_url) || (!(get_url.contains("http://")) && !(get_url.contains("https://"))) || this.form_validation.is_string_null_or_white_space(get_token) || check_for_existing_website.equals("website already exists")) {

      if (this.form_validation.is_string_null_or_white_space(get_url) || (!(get_url.contains("http://")) && !(get_url.contains("https://")))) {

       output[0] = "You must provide a website URL, starting with http:// or https://.";
      }

      if (this.form_validation.is_string_null_or_white_space(get_token)) {

       output[1] = "You do not have a valid token.  Try adding the website again.";
      }

      if (check_for_existing_website.equals("website already exists")) {

       output[2] = "You or someone else already has that website.  Try a different spelling.";
      }
     } else {

      try {

       int_admin_session = Integer.valueOf(get_admin_session);
      } catch (Exception e) {

       int_admin_session = 0;
      }

      try {

       Class.forName("com.mysql.jdbc.Driver");

       Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

       PreparedStatement select_statement = connection.prepareStatement("SELECT row_id FROM third_party_website_info_per_traffic_monitor_app WHERE url = ? AND token = ? AND memory_plan = ? AND memory_limit = ? AND date_received = ? AND time_received = ? AND account_id = ? ORDER BY row_id DESC");

       select_statement.setString(1, get_url.toLowerCase());
       select_statement.setString(2, get_token);
       select_statement.setString(3, "pay as you go");
       select_statement.setString(4, "0");
       select_statement.setString(5, get_date_received);
       select_statement.setString(6, get_time_received);
       select_statement.setInt(7, int_admin_session);

       ResultSet select_results = select_statement.executeQuery();

       select_results.last();

       if (select_results.getRow() < 1) {

        PreparedStatement insert_statement = connection.prepareStatement("INSERT INTO third_party_website_info_per_traffic_monitor_app (row_id, url, token, memory_plan, memory_limit, date_received, time_received, account_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

        insert_statement.setInt(1, this.generate_row_id("third_party_website_info_per_traffic_monitor_app"));
        insert_statement.setString(2, get_url.toLowerCase());
        insert_statement.setString(3, get_token);
        insert_statement.setString(4, "pay as you go");
        insert_statement.setString(5, "0");
        insert_statement.setString(6, get_date_received);
        insert_statement.setString(7, get_time_received);
        insert_statement.setInt(8, int_admin_session);

        insert_statement.execute();

        output[0] = "successful database update";
       } else {

        output[0] = "successful database update";
       }
      } catch (ClassNotFoundException | SQLException e) {

       LOGGER.log(Level.INFO, "{0}", e);

       this.create_new_third_party_website_info_per_traffic_monitor_app_table();

       output[0] = "database error";
      }
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

 protected String[] change_url() {

  String[] output = new String[2];
  int int_id;
  String check_for_existing_website;

  String get_id = this.get_id();
  String get_url = this.get_url();
  String get_change_url = this.get_change_url();
  String get_admin_session = this.get_admin_session();

  if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

   if (!(get_change_url.equals("null"))) {

    if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

     check_for_existing_website = this.check_for_existing_website(get_url.toLowerCase());

     if (this.form_validation.is_string_null_or_white_space(get_url) || (!(get_url.contains("http://")) && !(get_url.contains("https://"))) || check_for_existing_website.equals("website already exists")) {

      if (this.form_validation.is_string_null_or_white_space(get_url) || (!(get_url.contains("http://")) && !(get_url.contains("https://")))) {

       output[0] = "You must provide a website URL, starting with http:// or https://.";
      }

      if (check_for_existing_website.equals("website already exists")) {

       output[0] = "You or someone else already has that website.  Try a different spelling.";
      }
     } else {

      try {

       int_id = Integer.valueOf(get_id);
      } catch (Exception e) {

       int_id = 0;
      }

      try {

       Class.forName("com.mysql.jdbc.Driver");

       Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

       PreparedStatement update_statement = connection.prepareStatement("UPDATE third_party_website_info_per_traffic_monitor_app SET url = ? WHERE row_id = ?");

       update_statement.setString(1, get_url.toLowerCase());
       update_statement.setInt(2, int_id);

       update_statement.execute();

       output[0] = "successful database update";
      } catch (ClassNotFoundException | SQLException e) {

       LOGGER.log(Level.INFO, "{0}", e);

       this.create_new_third_party_website_info_per_traffic_monitor_app_table();

       output[0] = "database error";
      }
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

 protected String[] change_token() {

  String[] output = new String[1];
  int int_id;

  String get_id = this.get_id();
  String get_token = this.get_token();
  String get_change_token = this.get_change_token();
  String get_admin_session = this.get_admin_session();

  if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

   if (!(get_change_token.equals("null"))) {

    if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

     if (this.form_validation.is_string_null_or_white_space(get_token)) {

      output[0] = "You do not have a valid token.  Try adding the website again.";
     } else {

      try {

       int_id = Integer.valueOf(get_id);
      } catch (Exception e) {

       int_id = 0;
      }

      try {

       Class.forName("com.mysql.jdbc.Driver");

       Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

       PreparedStatement update_statement = connection.prepareStatement("UPDATE third_party_website_info_per_traffic_monitor_app SET token = ? WHERE row_id = ?");

       update_statement.setString(1, get_token);
       update_statement.setInt(2, int_id);

       update_statement.execute();

       output[0] = "successful database update";
      } catch (ClassNotFoundException | SQLException e) {

       LOGGER.log(Level.INFO, "{0}", e);

       this.create_new_third_party_website_info_per_traffic_monitor_app_table();

       output[0] = "database error";
      }
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

 private String delete_from_shopping_cart(String input_value) {

  String output;
  int int_input_value;

  try {

   int_input_value = Integer.valueOf(input_value);
  } catch (Exception e) {

   int_input_value = 0;
  }

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement delete_statement = connection.prepareStatement("DELETE FROM third_party_traffic_monitor_app_shopping_cart WHERE website_id = ?");

   delete_statement.setInt(1, int_input_value);

   delete_statement.execute();

   output = "successful database update";
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);

   this.create_new_shopping_cart_table();

   output = "database error";
  }

  return output;
 }

 private String delete_items_sold(String input_value) {

  String output;
  int int_input_value;

  try {

   int_input_value = Integer.valueOf(input_value);
  } catch (Exception e) {

   int_input_value = 0;
  }

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement delete_statement = connection.prepareStatement("DELETE FROM third_party_traffic_monitor_app_items_sold WHERE website_id = ?");

   delete_statement.setInt(1, int_input_value);

   delete_statement.execute();

   output = "successful database update";
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);

   this.create_new_items_sold_table();

   output = "database error";
  }

  return output;
 }

 private String delete_receipt(String input_value) {

  String output;

  int int_input_value;

  try {

   int_input_value = Integer.valueOf(input_value);
  } catch (Exception e) {

   int_input_value = 0;
  }

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement delete_statement = connection.prepareStatement("DELETE FROM third_party_traffic_monitor_app_receipts WHERE website_id = ?");

   delete_statement.setInt(1, int_input_value);

   delete_statement.execute();

   output = "successful database update";
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);

   this.create_new_purchase_receipt_table();

   output = "database error";
  }

  return output;
 }

 private String delete_traffic_by_today_date(String input_value) {

  String output;
  int int_input_value;

  try {

   int_input_value = Integer.valueOf(input_value);
  } catch (Exception e) {

   int_input_value = 0;
  }

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement delete_statement = connection.prepareStatement("DELETE FROM third_party_traffic_monitor_app_by_today_date WHERE website_id = ?");

   delete_statement.setInt(1, int_input_value);

   delete_statement.execute();

   output = "successful database update";
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);

   this.create_new_purchase_receipt_table();

   output = "database error";
  }

  return output;
 }

 private String delete_traffic_by_date(String input_value) {

  String output;
  int int_input_value;

  try {

   int_input_value = Integer.valueOf(input_value);
  } catch (Exception e) {

   int_input_value = 0;
  }

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement delete_statement = connection.prepareStatement("DELETE FROM third_party_traffic_monitor_app_by_date WHERE website_id = ?");

   delete_statement.setInt(1, int_input_value);

   delete_statement.execute();

   output = "successful database update";
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);

   this.create_new_purchase_receipt_table();

   output = "database error";
  }

  return output;
 }

 private String delete_traffic_by_month_of_year(String input_value) {

  String output;
  int int_input_value;

  try {

   int_input_value = Integer.valueOf(input_value);
  } catch (Exception e) {

   int_input_value = 0;
  }

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement delete_statement = connection.prepareStatement("DELETE FROM third_party_traffic_monitor_app_by_month_of_year WHERE website_id = ?");

   delete_statement.setInt(1, int_input_value);

   delete_statement.execute();

   output = "successful database update";
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);

   this.create_new_purchase_receipt_table();

   output = "database error";
  }

  return output;
 }

 private String delete_traffic_by_year(String input_value) {

  String output;
  int int_input_value;

  try {

   int_input_value = Integer.valueOf(input_value);
  } catch (Exception e) {

   int_input_value = 0;
  }

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement delete_statement = connection.prepareStatement("DELETE FROM third_party_traffic_monitor_app_by_year WHERE website_id = ?");

   delete_statement.setInt(1, int_input_value);

   delete_statement.execute();

   output = "successful database update";
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);

   this.create_new_purchase_receipt_table();

   output = "database error";
  }

  return output;
 }

 private String delete_all_traffic_records(String input_value) {

  String output;

  int int_input_value;

  try {

   int_input_value = Integer.valueOf(input_value);
  } catch (Exception e) {

   int_input_value = 0;
  }

  try {

   Class.forName("com.mysql.jdbc.Driver");

   Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

   PreparedStatement delete_statement = connection.prepareStatement("DELETE FROM third_party_traffic_log WHERE website_id = ?");

   delete_statement.setInt(1, int_input_value);

   delete_statement.execute();

   output = "successful database update";
  } catch (ClassNotFoundException | SQLException e) {

   LOGGER.log(Level.INFO, "{0}", e);

   this.create_new_purchase_receipt_table();

   output = "database error";
  }

  return output;
 }

 protected String[] delete_website() {

  String[] output = new String[1];
  int int_id;
  String delete_from_shopping_cart;
  String delete_items_sold;
  String delete_receipt = "";
  String delete_traffic_by_today_date;
  String delete_traffic_by_date;
  String delete_traffic_by_month_of_year;
  String delete_traffic_by_year;
  String delete_all_traffic_records;

  String get_id = this.get_id();
  String get_delete_website = this.get_delete_website();
  String get_admin_session = this.get_admin_session();

  if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

   if (!(get_delete_website.equals("null"))) {

    if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

     try {

      int_id = Integer.valueOf(get_id);
     } catch (Exception e) {

      int_id = 0;
     }

     delete_from_shopping_cart = this.delete_from_shopping_cart(get_id);
     delete_items_sold = this.delete_items_sold(get_id);

     if (delete_items_sold.equals("successful database update")) {

      delete_receipt = this.delete_receipt(get_id);
     }

     delete_traffic_by_today_date = this.delete_traffic_by_today_date(get_id);
     delete_traffic_by_date = this.delete_traffic_by_date(get_id);
     delete_traffic_by_month_of_year = this.delete_traffic_by_month_of_year(get_id);
     delete_traffic_by_year = this.delete_traffic_by_year(get_id);
     delete_all_traffic_records = this.delete_all_traffic_records(get_id);

     if (delete_from_shopping_cart.equals("successful database update") && delete_receipt.equals("successful database update") && delete_traffic_by_today_date.equals("successful database update") && delete_traffic_by_date.equals("successful database update") && delete_traffic_by_month_of_year.equals("successful database update") && delete_traffic_by_year.equals("successful database update") && delete_all_traffic_records.equals("successful database update")) {

      try {

       Class.forName("com.mysql.jdbc.Driver");

       Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

       PreparedStatement delete_statement = connection.prepareStatement("DELETE FROM third_party_website_info_per_traffic_monitor_app WHERE row_id = ?");

       delete_statement.setInt(1, int_id);

       delete_statement.execute();

       output[0] = "successful database update";
      } catch (ClassNotFoundException | SQLException e) {

       LOGGER.log(Level.INFO, "{0}", e);

       this.create_new_third_party_website_info_per_traffic_monitor_app_table();

       output[0] = "database error";
      }
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

 protected String[] downgrade_plan() {

  String[] output = new String[1];
  int int_id;
  double dec_memory;

  String get_id = this.get_id();
  String get_memory_plan = this.get_memory_plan();
  String get_memory = this.get_memory();
  String get_downgrade_plan = this.get_downgrade_plan();
  String get_admin_session = this.get_admin_session();

  if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

   if (!(get_downgrade_plan.equals("null"))) {

    if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

     dec_memory = this.convert_to_bytes_from_gigabytes(get_memory) + this.search_number_of_bytes(get_id);

     try {

      int_id = Integer.valueOf(get_id);
     } catch (Exception e) {

      int_id = 0;
     }

     try {

      Class.forName("com.mysql.jdbc.Driver");

      Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

      PreparedStatement update_statement = connection.prepareStatement("UPDATE third_party_website_info_per_traffic_monitor_app SET memory_plan = ?, memory_limit = ? WHERE row_id = ?");

      update_statement.setString(1, get_memory_plan);
      update_statement.setString(2, String.valueOf(dec_memory).replace("-", ""));
      update_statement.setInt(3, int_id);

      update_statement.execute();
     } catch (ClassNotFoundException | SQLException e) {

      LOGGER.log(Level.INFO, "{0}", e);

      this.create_new_third_party_website_info_per_traffic_monitor_app_table();

      output[0] = "database error";
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

 protected String[] upgrade_plan() {

  String[] output = new String[1];
  int int_id;

  String get_id = this.get_id();
  String get_memory_plan = this.get_memory_plan();
  String get_memory = this.get_memory();
  String get_upgrade_plan = this.get_upgrade_plan();
  String get_admin_session = this.get_admin_session();

  if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

   if (!(get_upgrade_plan.equals("null"))) {

    if (!(get_admin_session.equals("null")) && !(this.form_validation.is_string_null_or_white_space(get_admin_session))) {

     try {

      int_id = Integer.valueOf(get_id);
     } catch (Exception e) {

      int_id = 0;
     }

     try {

      Class.forName("com.mysql.jdbc.Driver");

      Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());

      PreparedStatement update_statement = connection.prepareStatement("UPDATE third_party_website_info_per_traffic_monitor_app SET memory_plan = ?, memory_limit = ? WHERE row_id = ?");

      update_statement.setString(1, get_memory_plan);
      update_statement.setString(2, get_memory);
      update_statement.setInt(3, int_id);

      update_statement.execute();
     } catch (ClassNotFoundException | SQLException e) {

      LOGGER.log(Level.INFO, "{0}", e);

      this.create_new_third_party_website_info_per_traffic_monitor_app_table();

      output[0] = "database error";
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
