//Author: Timothy van der Graaff
package models;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.Form_Validation;

public abstract class Website_Name_Processor extends configuration.Config {
    
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    private static void create_new_table() {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(database_url(), database_username(),
                    database_password());
            
            PreparedStatement create_statement = connection.prepareStatement(
                    
                    "CREATE TABLE company_website_name (row_id INT NOT NULL, name TEXT NOT NULL, date_received " +
                            "TEXT NOT NULL, time_received TEXT NOT NULL, PRIMARY KEY (row_id)) ENGINE = MYISAM;");
            
            create_statement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_website_name' " +
                    "table was not created because it already exists.  " +
                    "This is not necessarily an error.");
        }
    }
    
    protected static String search_website_name() {
        
        String output = "";
        int website_name_count = 0;
        
        try {
           Class.forName("com.mysql.jdbc.Driver");
           
           Connection connection = DriverManager.getConnection(database_url(), database_username(), 
                   database_password());
           
           PreparedStatement select_statement = connection.prepareStatement("SELECT name FROM company_website_name " +
                   "ORDER BY row_id DESC LIMIT 1");
           
           ResultSet select_results = select_statement.executeQuery();
           
           while (select_results.next()) {
               
               output = String.valueOf(select_results.getString(1));
               
               website_name_count++;
           }
           
           if (Form_Validation.is_string_null_or_white_space(output)) {
               
               output = "Timothy\'s Digital Solutions Framework";
           }
           
           if (website_name_count == 0) {
               
               output = "Timothy\'s Digital Solutions Framework";
           }
        } catch (ClassNotFoundException | SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_website_name' " +
                    "table is corrupt or does not exist");
            
            create_new_table();
            
            output = "Timothy\'s Digital Solutions Framework";
        }
        
        return output;
    }
}
