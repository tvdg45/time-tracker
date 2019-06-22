//Author: Timothy van der Graaff
package utilities;

import java.util.ArrayList;

public class Url_Cleaner extends configuration.Config {
    
    public static String after_domain_and_before_directory(String url) {
        
        String output = "";
        String[] parts = url.split("/", 2);
        
        if (!(parts[1].equals(""))) {
            
            output += parts[1];
        }
        
        return output;
    }
    
    public static String erase_last_slash_in_url(String url) {
        
        String output = "";
        String[] parts = url.split("/", 1);
        ArrayList<String> find = new ArrayList<>();
        ArrayList<String> replace = new ArrayList<>();
        
        //find substrings
        find.add("/");
        
        //replacement substrings
        replace.add("");
        
        if (!(parts[0].equals(""))) {
            
            output += Find_and_replace.find_and_replace(find, replace, parts[0]);
        }
        
        return output;
    }
    
    public static String ignore_remaining_url_after_question_mark(String url) {
        
        String output = "";
        String[] parts = url.split("\\?", 2);
        
        if (!(parts[0].equals(""))) {
            
            output += parts[0];
        }
        
        return output;
    }
    
    public static String check_for_www(String url, String page) {
        
        String output = "";
        String page_query;
        String bad_query;
        String bad_domain_found = "";
        
        if (page.equals("null") || Form_Validation.is_string_null_or_white_space(page)) {
            
            ArrayList<String> each_bad_domain_home_page = bad_domain();
            
            for (int row = 0; row < each_bad_domain_home_page.size(); row++) {
                
                if (url.equals(each_bad_domain_home_page.get(row))) {
                    
                    bad_domain_found = "yes";
                }
            }
            
            //Website redirects to home page.
            if (bad_domain_found.equals("yes")) {
                
                output = "redirect to root directory";
            }
        } else {
            
            ArrayList<String> each_bad_domain_other_page = bad_domain();
            
            page_query = url + "/index.php?page=" + page;
            
            for (int row = 0; row < each_bad_domain_other_page.size(); row++) {
                
                bad_query = each_bad_domain_other_page.get(row) + "/index.php?page=" + page;
                
                if (page_query.equals(bad_query)) {
                    
                    bad_domain_found = "yes";
                }
            }
            
            //Website redirects to page query.
            if (bad_domain_found.equals("yes")) {
                
                output = "redirect to page query";
            }         
        }
        
        return output;
    }
}
