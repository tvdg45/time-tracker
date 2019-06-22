//Author Timothy van der Graaff
package controllers;

import views.Show_Website_Links;
import java.util.ArrayList;

public class Request_Website_Links extends models.Website_Links_Processor {
    
    public static String show_website;
    public static String url;
    public static String page;
    
    //Global variable for total number of web pages
    public static int number_of_website_links;
    
    //Global variable for all website link fields
    public static ArrayList<ArrayList<String>> website_links;
    
    //This method packages web page search results into
    //global variables.
    public static void search_website_link() {
        
        if (show_website.equals("yes")) {
        
            number_of_website_links = search_row_count();
            website_links = search_website_links();
        }
    }
    
    //The web page links are composed.
    public static String request_website_links_horizontal_format() {
        
        String output = "";
        
        if (show_website.equals("yes")) {
            
            if (number_of_website_links > 0) {
                
                if (!(website_links.get(0).get(0).equals("links not found"))
                        && !(website_links.get(0).get(0).equals("page error"))) {
                    
                    Show_Website_Links.url = url;
                    Show_Website_Links.page = page;
                    Show_Website_Links.website_links = website_links;
                    
                    output += Show_Website_Links.show_website_links_horizontal_format();
                }
            }
        }
        
        return output;
    }
    
    //The web page links are composed.
    public static String request_website_links_vertical_format() {
        
        String output = "";
        
        if (show_website.equals("yes")) {
            
            if (number_of_website_links > 0) {
                
                if (!(website_links.get(0).get(0).equals("links not found"))
                        && !(website_links.get(0).get(0).equals("page error"))) {
                    
                    Show_Website_Links.url = url;
                    Show_Website_Links.page = page;
                    Show_Website_Links.website_links = website_links;
                    
                    output += Show_Website_Links.show_website_links_vertical_format();
                }
            }
        }
        
        return output;
    }
}
