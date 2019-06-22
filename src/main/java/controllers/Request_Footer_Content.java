//Author Timothy van der Graaff
package controllers;

import views.Show_Footer_Content;
import java.util.ArrayList;

import java.sql.Connection;

public class Request_Footer_Content extends models.Footer_Content_Processor {
    
    public static String show_website;
    public static Connection use_connection;
    
    //Global variable for total number of footer sections
    public static int number_of_footer_sections;
    
    //Global variable for all footer sections
    public static ArrayList<String> footer_sections;
    
    //This method packages web page search results into
    //global variables.
    public static void search_footer_content_section() {
        
        if (show_website.equals("yes")) {
            
            connection = use_connection;
            
            number_of_footer_sections = search_row_count();
            footer_sections = search_footer_content();
        }
    }
    
    //The footer content is composed.
    public static String request_footer_content() {
        
        String footer_content = "";
        
        if (show_website.equals("yes")) {

            if (number_of_footer_sections > 0) {
            
                Show_Footer_Content.footer_sections = footer_sections;
                
                footer_content = Show_Footer_Content.show_footer_content();
            }
        }
        
        return footer_content;
    }
}
