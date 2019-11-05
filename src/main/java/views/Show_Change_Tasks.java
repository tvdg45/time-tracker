//Author: Timothy van der Graaff
package views;

public class Show_Change_Tasks {
    
    public static String refresh_page() {
        
        String output = "";
        
        output += "<script type=\"text/javascript\">\n";
        output += "window.location = document.location.href.replace(\"#\", \"\");\n";
        output += "</script>\n";
        
        return output;
    }
    
    public static String delete_tasks_error_message() {
        
        String output = "";
        
        output += "<br /><label><span style=\"color: red\">You must select a task before deleting any.</span></label>\n";
        
        return output;
    }
}
