//Author Timothy van der Graaff
package controllers;

import views.Show_CSS_Responsive_Design_Screens;

public class Request_CSS_Responsive_Design_Screens extends models.CSS_Responsive_Design_Screens_Processor {
    
    public static String request_css_responsive_design_screens() {
        
        String output = "";
        
        if (!(search_css_responsive_design_screens().get(0).get(0).equals("responsive design screens not found"))
                && !(search_css_responsive_design_screens().get(0).get(0).equals("page error"))) {
            
            Show_CSS_Responsive_Design_Screens.responsive_design_screens = search_css_responsive_design_screens();
            
            output = Show_CSS_Responsive_Design_Screens.show_responsive_design_screens();
        }
        
        return output;
    }
}
