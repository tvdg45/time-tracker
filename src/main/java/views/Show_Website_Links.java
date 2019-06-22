//Author: Timothy van der Graaff
package views;

import java.util.ArrayList;
import utilities.Form_Validation;

public class Show_Website_Links {
    
    public static ArrayList<ArrayList<String>> website_links;
    public static String url;
    public static String page;
    
    private static String url_constructor() {
      
        String output;
        
        if (page.equals("null") || Form_Validation.is_string_null_or_white_space(page)) {
            
            output = url;
        } else {
            
            output = configuration.Config.domain() + "/" + page;
        }
        
        return output;
    }
    
    //Unfocused menu label for horizonal link format
    private static String unfocused_menu_label_horizonal_format(String link_name, String url, String new_window) {
        
        String output = "";
        
        //Open link in new tab
        if (new_window.equals("yes")) {
                
            if (link_name.length() <= 60) {

                output += "<span class=\"menu_label\" style=\"line-height: 40px; font-size: 12pt\">" +
                        "<a target=\'_blank\' style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                        "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                        "white-space: nowrap\" href=\"" + url + "\">" + 
                        link_name + "</a></span>\n";
            } else {
                
                output += "<span class=\"menu_label\" style=\"line-height: 40px; font-size: 12pt\">" +
                        "<a target=\'_blank\' style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                        "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                        "white-space: normal\" href=\"" + url + "\">" + 
                        link_name + "</a></span>\n";
            }
        } else {
            
            if (link_name.length() <= 60) {
                
                output += "<span class=\"menu_label\" style=\"line-height: 40px; font-size: 12pt\">" +
                        "<a style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                        "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                        "white-space: nowrap\" href=\"" + url + "\">" + 
                        link_name + "</a></span>\n";
            } else {
                
                output += "<span class=\"menu_label\" style=\"line-height: 40px; font-size: 12pt\">" +
                        "<a style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                        "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                        "white-space: normal\" href=\"" + url + "\">" + 
                        link_name + "</a></span>\n";
            }
        }
        
        return output;
    }
    
    //If a link is focused on this means that a loaded web page
    //url matches a page link url.
    public static String show_website_links_horizontal_format() {
        
        String output = "";
        
        for (int i = 0; i < website_links.get(0).size(); i++) {
            
            if (url_constructor().equals(configuration.Config.domain())
                    || url_constructor().equals(configuration.Config.domain() + "/")) {
                
                //Any link that is not focused on
                output += unfocused_menu_label_horizonal_format(website_links.get(0).get(i),
                        website_links.get(1).get(i), website_links.get(2).get(i));
                
            } else if (website_links.get(1).get(i).contains(url_constructor()) &&
                    !(url_constructor().equals(configuration.Config.domain())
                    || url_constructor().equals(configuration.Config.domain() + "/"))) {
                
                //Open link in new tab
                if (website_links.get(2).get(i).equals("yes")) {
                
                    if (website_links.get(0).get(i).length() <= 60) {

                        output += "<span class=\"focused_menu_label\" style=\"line-height: 40px; font-size: 12pt\">"
                            + "<a target=\'_blank\' style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                            "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                            "white-space: nowrap\" href=\"" + website_links.get(1).get(i) + "\">" + 
                            website_links.get(0).get(i) + "</a></span>\n";
                    } else {

                        output += "<span class=\"focused_menu_label\" style=\"line-height: 40px; font-size: 12pt\">"
                            + "<a target=\'_blank\' style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                            "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                            "white-space: normal\" href=\"" + website_links.get(1).get(i) + "\">" + 
                            website_links.get(0).get(i) + "</a></span>\n";
                    }
                } else {
                
                    if (website_links.get(0).get(i).length() <= 60) {

                        output += "<span class=\"focused_menu_label\" style=\"line-height: 40px; font-size: 12pt\">"
                            + "<a style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                            "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                            "white-space: nowrap\" href=\"" + website_links.get(1).get(i) + "\">" + 
                            website_links.get(0).get(i) + "</a></span>\n";
                    } else {

                        output += "<span class=\"focused_menu_label\" style=\"line-height: 40px; font-size: 12pt\">"
                            + "<a style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                            "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                            "white-space: normal\" href=\"" + website_links.get(1).get(i) + "\">" + 
                            website_links.get(0).get(i) + "</a></span>\n";
                    }
                }                
            } else {

                //Any link that is not focused on
                output += unfocused_menu_label_horizonal_format(website_links.get(0).get(i),
                        website_links.get(1).get(i), website_links.get(2).get(i));
            }
        }
        
        return output;
    }
    
    //Unfocused menu label for horizonal link format
    private static String unfocused_menu_label_vertical_format(String link_name, String url, String new_window) {
        
        String output = "";
        
        //Open link in new tab
        if (new_window.equals("yes")) {
                
            output += "<div class=\"show_vertical_menu\" style=\"text-align: left; display: none\">" +
                    "<span class=\"menu_label\" style=\"line-height: 40px; font-size: 12pt\">" +
                    "<a target=\"_blank\" style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                    "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                    "white-space: normal\" href=\"" + url + "\">" + link_name + "</a></span>\n" +
                    "</div>\n";
        } else {
            
            output += "<div class=\"show_vertical_menu\" style=\"text-align: left; display: none\">" +
                    "<span class=\"menu_label\" style=\"line-height: 40px; font-size: 12pt\">" +
                    "<a style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                    "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                    "white-space: normal\" href=\"" + url + "\">" + link_name + "</a></span>\n" +
                    "</div>\n";
        }
        
        return output;
    }
    
    //If a link is focused on this means that a loaded web page
    //url matches a page link url.
    public static String show_website_links_vertical_format() {
        
        String output = "";
        
        for (int i = 0; i < website_links.get(0).size(); i++) {
            
            if (url_constructor().equals(configuration.Config.domain())
                    || url_constructor().equals(configuration.Config.domain() + "/")) {
                
                //Any link that is not focused on
                output += unfocused_menu_label_vertical_format(website_links.get(0).get(i),
                        website_links.get(1).get(i), website_links.get(2).get(i));
                
            } else if (website_links.get(1).get(i).contains(url_constructor()) &&
                    !(url_constructor().equals(configuration.Config.domain())
                    || url_constructor().equals(configuration.Config.domain() + "/"))) {
                
                //Open link in new tab
                if (website_links.get(2).get(i).equals("yes")) {
                
                    output += "<div class=\"show_vertical_menu\" style=\"text-align: left; display: none\">" +
                        "<span class=\"focused_menu_label\" style=\"line-height: 40px; font-size: 12pt\">" +
                        "<a target=\"_blank\" style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                        "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                        "white-space: normal\" href=\"" + website_links.get(1).get(i) + "\">" +
                            website_links.get(0).get(i) + "</a></span>\n" +
                        "</div>\n";
                } else {
                
                    output += "<div class=\"show_vertical_menu\" style=\"text-align: left; display: none\">" +
                        "<span class=\"focused_menu_label\" style=\"line-height: 40px; font-size: 12pt\">" +
                        "<a style=\"padding-left: 15px; padding-right: 15px; margin-top: 12px; " +
                        "margin-bottom: 12px; font-weight: bold; text-transform: uppercase; " +
                        "white-space: normal\" href=\"" + website_links.get(1).get(i) + "\">" +
                            website_links.get(0).get(i) + "</a></span>\n" +
                        "</div>\n";
                }                
            } else {

                //Any link that is not focused on
                output += unfocused_menu_label_vertical_format(website_links.get(0).get(i),
                        website_links.get(1).get(i), website_links.get(2).get(i));
            }
        }
        
        return output;
    }
}
