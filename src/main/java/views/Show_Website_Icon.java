//Author: Timothy van der Graaff
package views;

public class Show_Website_Icon {
    
    public static String file_path;
    
    public static String no_icon_found() {
      
        String output;
        
        output = "<script>$('head').append('<link rel=\"icon\" href=\"" + configuration.Config.domain() +
                "/images/no-file.png\" sizes=\"32x32\" />');</script>\n";        
        
        return output;
    }
    
    public static String icon_found() {
        
        String output;

        output = "<script>$('head').append('<link rel=\"icon\" href=\"" + configuration.Config.domain() +
                "/media/" + file_path + "\" sizes=\"32x32\" />');</script>\n";
        
        return output;
    }
}
