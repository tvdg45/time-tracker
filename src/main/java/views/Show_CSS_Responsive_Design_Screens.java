//Author: Timothy van der Graaff
package views;

import java.util.ArrayList;

public class Show_CSS_Responsive_Design_Screens {
    
    public static ArrayList<ArrayList<String>> responsive_design_screens;
    
    public static String show_responsive_design_screens() {
        
        String output = "";
        
        output += "<style type=\"text/css\">\n";
        
        for (int i = 0; i < responsive_design_screens.get(0).size(); i++) {
            
            output += responsive_design_screens.get(0).get(i) + " {\n\n";
            output += responsive_design_screens.get(1).get(i) + "\n\n";
            output += "\n}\n\n";
        }
        
        output += "</style>";
        
        return output;
    }
}
