//Author Timothy van der Graaff
package controllers;

import java.sql.Connection;

import views.Show_CSS_Responsive_Design_Screens;

public class Request_CSS_Responsive_Design_Screens extends models.CSS_Responsive_Design_Screens_Processor {
    
    public static String show_website;
    public static Connection use_connection;
    
    public static String request_css_responsive_design_screens() {
        
        String output = "";
        
        if (show_website.equals("yes")) {

            connection = use_connection;
        
            if (!(search_css_responsive_design_screens().get(0).get(0).equals("responsive design screens not found"))
                && !(search_css_responsive_design_screens().get(0).get(0).equals("page error"))) {
            
                Show_CSS_Responsive_Design_Screens.responsive_design_screens = search_css_responsive_design_screens();
            
                output = Show_CSS_Responsive_Design_Screens.show_responsive_design_screens();
            }
        }
        
        return output;
    }
}
