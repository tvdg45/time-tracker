//Author: Timothy van der Graaff
package views;

import java.util.ArrayList;

public class Show_Footer_Content {
    
    public static ArrayList<String> footer_sections;
    
    public static String show_footer_content() {
        
        String output;
        
        switch (footer_sections.get(0)) {
            case "footer content not found":
                output = "";
            break;
            case "page error":
                output = "";
            break;
            default:
                output = "";
                
                for (int i = 0; i < footer_sections.size(); i++) {
                    
                    if (!(footer_sections.get(i).equals("footer content found"))) {
                        
                        output += "<div class=\"footer\" style=\"text-align: left; word-wrap: break-word\">\n";
                        output += "<div class=\"content_within_apps\">" + footer_sections.get(i) + "</div>";
                        output += "</div>\n";
                    }
                }
            break;
        }
        
        return output;
    }
}
