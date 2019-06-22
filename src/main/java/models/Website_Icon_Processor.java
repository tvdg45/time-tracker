//Author: Timothy van der Graaff
package models;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Website_Icon_Processor extends configuration.Config {
    
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    private static void create_new_table() {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(database_url(), database_username(),
                    database_password());
            
            PreparedStatement create_statement = connection.prepareStatement(
                    
                    "CREATE TABLE company_website_icon (row_id INT NOT NULL, file_path TEXT NOT NULL, date_received " +
                            "TEXT NOT NULL, time_received TEXT NOT NULL, PRIMARY KEY (row_id)) ENGINE = MYISAM;");
            
            create_statement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_website_icon' " +
                    "table was not created because it already exists.  " +
                    "This is not necessarily an error.");
        }
        
    }
    
    protected static int search_row_count() {
        
        int output;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(database_url(), database_username(),
                    database_password());
            
            PreparedStatement prepared_statement = connection.prepareStatement("SELECT row_id FROM company_website_icon " +
                    "ORDER BY row_id ASC");
            
            ResultSet result_set = prepared_statement.executeQuery();
            
            result_set.last();
            
            if (result_set.getRow() > 0) {
               
                output = result_set.getRow();
            } else {
                
                output = 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            
            LOGGER.log(Level.INFO, "{0}", e);
            
            output = 0;
        }
        
        return output;
    }
    
    protected static String search_website_icon() {
        
        String output = "";
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(database_url(), database_username(), 
                   database_password());
            
            PreparedStatement select_statement = connection.prepareStatement("SELECT file_path FROM " +
                    "company_website_icon ORDER BY row_id ASC LIMIT 1");
            
            ResultSet select_results = select_statement.executeQuery();
            
            while (select_results.next()) {
                
                output = select_results.getString(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_website_icon' " +
                    "table is corrupt or does not exist");
            
            create_new_table();
            
            output = "page error";
        }
        
        return output;
    }
}
