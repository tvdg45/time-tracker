//Author Timothy van der Graaff
package controllers;

import views.Show_Website_Logo;

public class Request_Website_Logo extends models.Website_Logo_Processor {
    
    public static String request_website_logo() {
        
        String output;
        
        if (search_row_count() == 1 && !(search_website_logo().equals(""))
                && !(search_website_logo().equals("page error"))) {
            
            Show_Website_Logo.file_path = search_website_logo();
            
            output = Show_Website_Logo.logo_found();
        } else {
            
            output = Show_Website_Logo.no_logo_found();
        }
        
        return output;
    }
}
