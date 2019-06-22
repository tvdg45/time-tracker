//Author Timothy van der Graaff
package controllers;

import views.Show_Website_Icon;

import java.sql.Connection;

public class Request_Website_Icon extends models.Website_Icon_Processor {
    
    public static Connection use_connection;
    
    public static String request_website_icon() {
        
        String output;
        
        connection = use_connection;
        
        if (search_row_count() == 1 && !(search_website_icon().equals(""))
                && !(search_website_icon().equals("page error"))) {
            
            Show_Website_Icon.file_path = search_website_icon();
            
            output = Show_Website_Icon.icon_found();
        } else {
            
            output = Show_Website_Icon.no_icon_found();
        }
        
        return output;
    }
}
