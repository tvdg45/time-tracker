//Author: Timothy van der Graaff
package models;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Footer_Content_Processor extends configuration.Config {
   
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    private static void create_new_table() {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(database_url(), database_username(),
                    database_password());
            
            PreparedStatement create_statement = connection.prepareStatement(
                    
                    "CREATE TABLE company_footer_content (row_id INT NOT NULL, footer_content TEXT NOT NULL, " +
                            "date_received TEXT NOT NULL, time_received TEXT NOT NULL, PRIMARY KEY (row_id)) " +
                            "ENGINE = MYISAM;");
            
            create_statement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_footer_content' " +
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
            
            PreparedStatement prepared_statement = connection.prepareStatement("SELECT row_id FROM " +
                    "company_footer_content ORDER BY row_id DESC");
            
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
    
    protected static ArrayList<String> search_footer_content() {
        
        ArrayList<String> output = new ArrayList<>();
        int footer_section_count = 0;
        
        try {
           
           Class.forName("com.mysql.jdbc.Driver");
            
           Connection connection = DriverManager.getConnection(database_url(), database_username(), 
                   database_password());
           
           PreparedStatement select_statement = connection.prepareStatement("SELECT footer_content FROM " +
                   "company_footer_content ORDER BY row_id ASC");
           
           ResultSet select_results = select_statement.executeQuery();
           
           while (select_results.next()) {
               
               output.add("footer content found");
               output.add(select_results.getString(1));
               
               footer_section_count++;
           }
           
           if (footer_section_count == 0) {
               
               output.add("footer content not found");
           }
        } catch (ClassNotFoundException | SQLException e) {

            LOGGER.log(Level.INFO, "The 'company_footer_content' " +
                    "table is corrupt or does not exist");
            
            create_new_table();
            
            output.add("page error");
        }
        
        return output;
    }
}