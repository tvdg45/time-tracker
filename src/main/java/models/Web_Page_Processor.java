//Author: Timothy van der Graaff
package models;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.Find_and_replace;
import utilities.Form_Validation;

public abstract class Web_Page_Processor extends configuration.Config {
    
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    public static Connection connection;
    
    //global variables
    private static String url;
    private static String page;
    
    //mutators
    protected static void set_url(String this_url) {
        
        url = this_url;
    }
    
    protected static void set_page(String this_page) {
        
        page = this_page;
    }
    
    //accessors
    private static String get_url() {
        
        return url;
    }
    
    private static String get_page() {
        
        return page;
    }
    
    private static void create_new_table() {
        
        try {
            
            PreparedStatement create_statement = connection.prepareStatement(
                    
                    "CREATE TABLE company_web_pages (row_id INT NOT NULL, page_content_draft TEXT NOT NULL, " +
                    "page_name TEXT NOT NULL, page_description TEXT NOT NULL, " +
                    "page_keywords TEXT NOT NULL, page_content TEXT NOT NULL, " +
                    "page_directory TEXT NOT NULL, page_status TEXT NOT NULL, " +
                    "date_received TEXT NOT NULL, time_received TEXT NOT NULL, PRIMARY KEY (row_id)) ENGINE = MYISAM;");
            
            create_statement.execute();
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_web_pages' " +
                    "table was not created because it already exists.  " +
                    "This is not necessarily an error.");
        }
    }
    
    protected static int search_row_count() {
        
        int output;
        
        try {
            
            PreparedStatement prepared_statement = connection.prepareStatement("SELECT row_id FROM company_web_pages " +
                    "ORDER BY row_id DESC");
            
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
    
    //Search web page details based on URL or page query.
    protected static ArrayList<String> search_web_pages() {
        
        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> find = new ArrayList<>();
        ArrayList<String> replace = new ArrayList<>();
        String page_directory;
        int page_count = 0;
        
        String get_url = get_url();
        String get_page = get_page();
        
        get_url = utilities.Url_Cleaner.after_domain_and_before_directory(get_url);
        get_url = utilities.Url_Cleaner.erase_last_slash_in_url(get_url);
        page_directory = utilities.Url_Cleaner.ignore_remaining_url_after_question_mark(get_url);
        
        //find values
        find.add(domain().replace("https://", ""));
        
        //replace values
        replace.add("");
        
        page_directory = Find_and_replace.find_and_replace(find, replace, page_directory);
        
        if (page_directory.equals("")) {
            
            page_directory = "home";
        }
        
        try {
            
           PreparedStatement select_statement = connection.prepareStatement("SELECT row_id, page_content_draft, " +
                   "page_name, page_description, page_keywords, page_content, page_directory, page_status " +
                   "date_received, time_received FROM company_web_pages WHERE page_directory = ? " +
                   "ORDER BY row_id DESC LIMIT 1");
           
           if (!(Form_Validation.is_string_null_or_white_space(get_page))
                   && !(get_page.equals("null"))) {
              
               select_statement.setString(1, get_page);
           } else {
               
               select_statement.setString(1, page_directory);
           }
           
           ResultSet select_results = select_statement.executeQuery();
           
           while (select_results.next()) {
               
               output.add("page found");
               output.add(String.valueOf(select_results.getInt(1)));
               output.add(select_results.getString(2));
               output.add(select_results.getString(3));
               output.add(select_results.getString(4));
               output.add(select_results.getString(5));
               output.add(select_results.getString(6));
               output.add(select_results.getString(7));
               output.add(select_results.getString(8));
               output.add(select_results.getString(9));
               output.add(select_results.getString(10));
               
               page_count++;
           }
           
           if (page_count == 0) {
               
               output.add("page not found");
           }
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_web_pages' " +
                    "table is corrupt or does not exist");
            
            create_new_table();
            
            output.add("page error");
        }
        
        return output;
    }
}
