//Author Timothy van der Graaff
package controllers;

import views.Show_Web_Page_Heading;
import views.Show_Web_Page_Content;
import java.util.ArrayList;

import java.sql.Connection;

public class Request_Web_Page extends models.Web_Page_Processor {
    
    public static String website_name;
    public static String url;
    public static String page;
    public static String page_preview;
    public static String show_website;
    public static Connection use_connection;
    
    //Global variable for total number of web pages
    public static int number_of_web_pages;
    
    //Global variable for all web page fields
    public static ArrayList<String> web_page;
    
    //This method packages web page search results into
    //global variables.
    public static void search_web_page() {
        
        if (show_website.equals("yes")) {
            
            connection = use_connection;
            
            if (url.equals("null")) {
                
                url = configuration.Config.domain();
            }
            
            set_url(url);
            set_page(page);
        
            number_of_web_pages = search_row_count();
            web_page = search_web_pages();
        }
    }
    
    //The web page description is composed.
    public static String request_page_description() {
        
        String output = "";
        
        if (show_website.equals("yes")) {
            
            Show_Web_Page_Heading.page_description = "no description";
            
            if (number_of_web_pages > 0) {
            
                try {
                
                    if (!(web_page.get(0).equals("page error"))
                        && !(web_page.get(0).equals("page not found"))
                        && (web_page.get(0).equals("page found")
                        && !(web_page.get(4).equals("")))) {
                    
                        Show_Web_Page_Heading.page_description = web_page.get(4);
                    }
                } catch (Exception e) {
                
                    Show_Web_Page_Heading.page_description = "no description";
                }
            }
            
            output = Show_Web_Page_Heading.show_description();
        }
        
        return output;
    }
    
    //The web page keywords are composed.
    public static String request_page_keywords() {
        
        String output = "";
        
        if (show_website.equals("yes")) {

            Show_Web_Page_Heading.page_keywords = "no keywords";
            
            if (number_of_web_pages > 0) {
            
                try {
                
                    if (!(web_page.get(0).equals("page error"))
                        && !(web_page.get(0).equals("page not found"))
                        && (web_page.get(0).equals("page found")
                        && !(web_page.get(5).equals("")))) {
                    
                        Show_Web_Page_Heading.page_keywords = web_page.get(5);
                    }
                } catch (Exception e) {
                
                    Show_Web_Page_Heading.page_keywords = "no keywords";
                }
            }
            
            output = Show_Web_Page_Heading.show_keywords();
        }
        
        return output;
    }
    
    //The web page title is composed.
    public static String request_title() {
        
        String output = "";
        
        if (show_website.equals("yes")) {
            
            Show_Web_Page_Heading.website_name = website_name;
        
            if (number_of_web_pages < 1) {
            
                Show_Web_Page_Heading.page_name = "no web pages";
            } else {
            
                try {
                
                    switch (web_page.get(0)) {
                        case "page error":
                            Show_Web_Page_Heading.page_name = web_page.get(0);
                            break;
                        case "page not found":
                            Show_Web_Page_Heading.page_name = web_page.get(0);
                            break;
                        default:
                            Show_Web_Page_Heading.page_name = web_page.get(3);
                            break;
                    }
                } catch (Exception e) {
                
                    Show_Web_Page_Heading.page_name = "no page title";
                }
            }
            
            output = Show_Web_Page_Heading.show_title();
        }
        
        return output;
    }
    
    //The web page body is composed.
    public static String request_content() {
        
        String output = "";
        
        if (show_website.equals("yes")) {
            
            if (number_of_web_pages < 1) {
            
                Show_Web_Page_Content.page_content = "no web pages";
            } else {
            
                try {
                
                    if (web_page.get(0).equals("page error")) {
                        
                        Show_Web_Page_Content.page_content = web_page.get(0);                        
                    } else if (web_page.get(0).equals("page not found")) {

                        Show_Web_Page_Content.page_content = web_page.get(0);
                    } else if (web_page.get(0).equals("page found")
                        && web_page.get(6).equals("")) {
                    
                        Show_Web_Page_Content.page_content = "no content";
                    } else {
                    
                        Show_Web_Page_Content.page_content = web_page.get(6);
                    }
                } catch (Exception e) {
                
                    Show_Web_Page_Content.page_content = "no content";
                }
            }
            
            output = Show_Web_Page_Content.show_content();
        }
        
        return output;
    }    
}
