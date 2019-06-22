//Author: Timothy van der Graaff
package views;

import utilities.Find_and_replace;
import java.util.ArrayList;

public class Show_Web_Page_Heading {
    
    public static String website_name;
    public static String page_description;
    public static String page_keywords;
    public static String page_name;
    
    public static String show_description() {
        
        String output;
        
        if (page_description.equals("no description")) {
            
            output = "";
        } else {
           
            output = "<script>$('head').append('<meta name=\"description\" content=\"" +
                    page_description + "\" />');</script>\n";
        }
        
        return output;
    }
    
    public static String show_keywords() {
        
        String output;
        
        if (page_keywords.equals("no keywords")) {
            
            output = "";
        } else {
            
            output = "<script>$('head').append('<meta name=\"keywords\" content=\"" + 
                    page_keywords + "\" />');</script>\n";
        }
        
        return output;
    }
    
    public static String show_title() {
        
        String output;
        
        ArrayList<String> find = new ArrayList<>();
        ArrayList<String> replace = new ArrayList<>();
        
        find.add("'");
        replace.add("\\'");
        
        switch (page_name) {
            case "no web pages":
                output = "<script>$('title').append('There are no web pages.  Come back later. | " + 
                        Find_and_replace.find_and_replace(find, replace, website_name) + "');</script>\n";
                break;
            case "page not found":
                output = "<script>$('title').append('Shoot!  That page does not exist! | " + 
                        Find_and_replace.find_and_replace(find, replace, website_name) + "');</script>\n";
                break;
            default:
                if (page_name.equals("Home") || page_name.equals("page error") || page_name.equals("no page title")) {
                    
                    output = "<script>$('title').append('" + 
                            Find_and_replace.find_and_replace(find, replace, website_name) + "');</script>\n";
                } else {
                   
                    output = "<script>$('title').append('" + 
                            Find_and_replace.find_and_replace(find, replace, page_name) + 
                            " | " + Find_and_replace.find_and_replace(find, replace, website_name) + 
                            "');</script>\n";
                }
                break;
        }
        
        return output;
    }
}
