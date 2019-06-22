//Author: Timothy van der Graaff
package views;

public class Show_Web_Page_Content {
    
    public static String page_content;
    
    public static String show_content() {
        
        String output;
        
        switch (page_content) {
            case "no web pages":
                output = "<label style=\"font-size: 12pt\"><b>There are " +
                        "no web pages.  Come back later.</b></label>\n";
                break;
            case "page not found":
                output = "<label style=\"font-size: 12pt\"><b>Shoot!  That page does not exist!</b></label>\n";
                break;
            case "no content":
                output = "<label style=\"font-size: 12pt\"><b>There is " +
                        "no content.  Come back later.</b></label>\n";
                break;
            case "page error":
                output = "<label style=\"font-size: 12pt\"><b>There is " +
                        "no content.  Come back later.</b></label>\n";
                break;
            default:
                output = page_content;
                break;
        }
        
        return output;
    }
}
