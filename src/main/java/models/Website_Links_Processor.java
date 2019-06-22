//Author: Timothy van der Graaff
package models;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Website_Links_Processor extends configuration.Config {
    
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    public static Connection connection;
    
    private static void create_new_table() {
        
        try {
            
            PreparedStatement create_statement = connection.prepareStatement(
                    
                    "CREATE TABLE company_hyperlinks (row_id INT NOT NULL, link_name TEXT NOT NULL, " +
                            "page_url TEXT NOT NULL, open_new_window TEXT NOT NULL, date_received TEXT NOT NULL, " +
                            "time_received TEXT NOT NULL, PRIMARY KEY (row_id)) ENGINE = MYISAM;");
            
            create_statement.execute();
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_hyperlinks' " +
                    "table was not created because it already exists.  " +
                    "This is not necessarily an error.");
        }
    }
    
    protected static int search_row_count() {
        
        int output;
        
        try {
            
            PreparedStatement prepared_statement = connection.prepareStatement("SELECT row_id FROM company_hyperlinks " +
                    "ORDER BY row_id ASC");
            
            ResultSet result_set = prepared_statement.executeQuery();
            
            result_set.last();
            
            if (result_set.getRow() > 0) {
               
                output = result_set.getRow();
            } else {
                
                output = 0;
            }
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "{0}", e);
            
            output = 0;
        }
        
        return output;
    }
    
    protected static ArrayList<ArrayList<String>> search_website_links() {
        
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> url = new ArrayList<>();
        ArrayList<String> new_window = new ArrayList<>();
        int link_count = 0;
        
        try {
            
            PreparedStatement select_statement = connection.prepareStatement("SELECT link_name, page_url, " +
                    "open_new_window FROM company_hyperlinks ORDER BY row_id ASC");
            
            ResultSet select_results = select_statement.executeQuery();
            
            while (select_results.next()) {

                name.add(select_results.getString(1));
                url.add(select_results.getString(2));
                new_window.add(select_results.getString(3));
                
                link_count++;
            }
            
            if (link_count < 1) {
                
                name.add("links not found");
                url.add("");
                new_window.add("");
            }
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_hyperlinks' " +
                    "table is corrupt or does not exist");
            
            create_new_table();
            
            name.add("page error");
            url.add("");
            new_window.add("");
        }
        
        output.add(name);
        output.add(url);
        output.add(new_window);
        
        return output;
    }
}
