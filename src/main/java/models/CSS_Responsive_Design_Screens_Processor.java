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

public abstract class CSS_Responsive_Design_Screens_Processor extends configuration.Config {
    
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    private static void create_new_table() {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(database_url(), database_username(),
                    database_password());
            
            PreparedStatement create_statement = connection.prepareStatement(
                    
                    "CREATE TABLE company_css_responsive_design_screens (row_id INT NOT NULL, " +
                            "screen_ratio TEXT NOT NULL, css_code_for_screen_ratio TEXT NOT NULL, " +
                            "PRIMARY KEY (row_id)) ENGINE = MYISAM;");
            
            create_statement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_css_responsive_design_screens' " +
                    "table was not created because it already exists.  " +
                    "This is not necessarily an error.");
        }
    }
    
    private static void add_new_records() {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(database_url(), database_username(),
                    database_password());
            
            PreparedStatement create_statement = connection.prepareStatement(
                    
                    "INSERT INTO company_css_responsive_design_screens (row_id, screen_ratio, " +
                            "css_code_for_screen_ratio) VALUES\n" +
                            "(1, '@media only screen and (min-width: 2001px)', " +
                            "'.embeded_media { width: 45%; height: 600px; border: 0px solid transparent; " +
                            "margin-left: 2%; margin-right: 2%; margin-top: 5px; margin-bottom: 5px; padding: 0px; " +
                            "background-color: transparent; }\r\n#logo_traditional_and_links_traditional_format { " +
                            "text-align: left; width: 100%; }\r\n#logo_traditional_and_links_responsive_format { " +
                            "display: none; }\r\n#page_name_traditional_or_responsive_format { text-align: center; " +
                            "width: 100%; }\r\n.content_within_apps { vertical-align: top; text-align: left; " +
                            "width: 79%; padding-top: 1%; padding-bottom: 1%; margin-left: 10.5%; margin-right: 10.5%; " +
                            "}\r\n.content { vertical-align: top; text-align: left; width: 80%; padding-top: 1%; " +
                            "padding-bottom: 1%; margin-left: 10%; margin-right: 10%; }\r\n#footer_traditional_format " +
                            "{ text-align: left; width: 100%; }\r\n#footer_responsive_format { display: none; }'),\n" +
                            "(2, '@media only screen and (min-width: 1001px) and (max-width: 2000px)', '.embeded_media " +
                            "{ width: 45%; height: 400px; border: 0px solid transparent; margin-left: 2%; " +
                            "margin-right: 2%; margin-top: 5px; margin-bottom: 5px; padding: 0px; background-color: " +
                            "transparent; }\r\n#logo_traditional_and_links_traditional_format { text-align: left; " +
                            "width: 100%; }\r\n#logo_traditional_and_links_responsive_format { display: none; " +
                            "}\r\n#page_name_traditional_or_responsive_format { text-align: center; width: 100%; " +
                            "}\r\n.content_within_apps { vertical-align: top; text-align: left; width: 79%; " +
                            "padding-top: 1%; padding-bottom: 1%; margin-left: 10.5%; margin-right: 10.5%; " +
                            "}\r\n.content { vertical-align: top; text-align: left; width: 80%; padding-top: 1%; " +
                            "padding-bottom: 1%; margin-left: 10%; margin-right: 10%; }\r\n#footer_traditional_format { " +
                            "text-align: left; width: 100%; }\r\n#footer_responsive_format { display: none; }'),\n" +
                            "(3, '@media only screen and (min-width: 501px) and (max-width: 1000px)', '.embeded_media " +
                            "{ width: 98%; height: 600px; border: 0px solid transparent; margin-left: 2%; " +
                            "margin-right: 2%; margin-top: 5px; margin-bottom: 5px; padding: 0px; background-color: " +
                            "transparent; }\r\n#logo_traditional_and_links_traditional_format { display: none; " +
                            "}\r\n#logo_traditional_and_links_responsive_format { text-align: left; width: 100%; " +
                            "}\r\n#page_name_traditional_or_responsive_format { text-align: center; width: 100%; " +
                            "}\r\n.content_within_apps { vertical-align: top; text-align: left; width: 95%; padding-top: " +
                            "1%; padding-bottom: 1%; margin-left: 2.25%; margin-right: 2.25%; }\r\n.content { " +
                            "vertical-align: top; text-align: left; width: 95%; padding-top: 1%; padding-bottom: 1%; " +
                            "margin-left: 2.25%; margin-right: 2.25%; }\r\n#footer_traditional_format { display: none; " +
                            "}\r\n#footer_responsive_format { text-align: left; width: 100%; }'),\n" +
                            "(4, '@media only screen and (max-width: 500px)', '.embeded_media { width: 98%; height: " +
                            "300px; border: 0px solid transparent; margin-left: 2%; margin-right: 2%; margin-top: 5px; " +
                            "margin-bottom: 5px; padding: 0px; background-color: transparent; " +
                            "}\r\n#logo_traditional_and_links_traditional_format { display: none; " +
                            "}\r\n#logo_traditional_and_links_responsive_format { text-align: left; width: 100%; " +
                            "}\r\n#page_name_traditional_or_responsive_format { text-align: center; width: 100%; " +
                            "}\r\n.content_within_apps { vertical-align: top; text-align: left; width: 95%; " +
                            "padding-top: 1%; padding-bottom: 1%; margin-left: 2.25%; margin-right: 2.25%; " +
                            "}\r\n.content { vertical-align: top; text-align: left; width: 95%; padding-top: 1%; " +
                            "padding-bottom: 1%; margin-left: 2.25%; margin-right: 2.25%; " +
                            "}\r\n#footer_traditional_format { display: none; }\r\n#footer_responsive_format { " +
                            "text-align: left; width: 100%; }');");
            
            create_statement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            
            LOGGER.log(Level.INFO, "");
        }
    }
    
    protected static ArrayList<ArrayList<String>> search_css_responsive_design_screens() {
        
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        ArrayList<String> element = new ArrayList<>();
        ArrayList<String> attribute = new ArrayList<>();
        int responsive_design_screen_count = 0;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(database_url(), database_username(), 
                   database_password());
            
            PreparedStatement select_statement = connection.prepareStatement("SELECT screen_ratio, " +
                    "css_code_for_screen_ratio FROM company_css_responsive_design_screens ORDER BY row_id DESC");
            
            ResultSet select_results = select_statement.executeQuery();
            
            while (select_results.next()) {

                element.add(select_results.getString(1));
                attribute.add(select_results.getString(2));
                
                responsive_design_screen_count++;
            }
            
            if (responsive_design_screen_count < 1) {
                
                element.add("responsive design screens not found");
                attribute.add("");
            }            
        } catch (ClassNotFoundException | SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_css_responsive_design_screens' " +
                    "table is corrupt or does not exist");
            
            create_new_table();
            add_new_records();
            
            element.add("page error");
            attribute.add("");
        }
        
        output.add(element);
        output.add(attribute);
        
        return output;
    }
}
