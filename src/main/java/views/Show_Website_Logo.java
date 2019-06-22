//Author: Timothy van der Graaff
package views;

public class Show_Website_Logo {
    
    public static String file_path;
    
    public static String no_logo_found() {
      
        String output;
        
        output = "<a href=\"" + configuration.Config.domain() + "\">" +
                "<img alt=\"no-file.png\" " +
                "src=\"" + configuration.Config.domain() + "/images/no-file.png\" " +
                "style=\"width: 50%\" /></a>";        
        
        return output;
    }
    
    public static String logo_found() {
        
        String output;

        output = "<a href=\"https://www.timothysdigitalsolutions.com/\">" +
                "<img alt=\"" + file_path + "\" " +
                "src=\"" + configuration.Config.domain() + "/media/" + file_path + "\" " +
                "style=\"width: 50%\" /></a>";
        
        return output;
    }
}
