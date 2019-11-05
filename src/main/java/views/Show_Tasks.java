//Author: Timothy van der Graaff
package views;

import java.util.ArrayList;
import utilities.Find_and_replace;

public class Show_Tasks {
    
    //global variables
    public static ArrayList<ArrayList<String>> tasks = new ArrayList<>();
    
    public static String show_tasks() {
        
        String output = "";
        
        ArrayList<String> find = new ArrayList<>();
        ArrayList<String> replace = new ArrayList<>();
        
        find.add("<script");
        find.add("<style");
        find.add("\"");
        find.add("'");
        find.add("<br />");
        find.add("<br>");
        find.add("<div>");
        find.add("</div>");
        
        replace.add("&lt;script");
        replace.add("&lt;style");
        replace.add("&quot;");
        replace.add("&apos;");
        replace.add(" ");
        replace.add("");
        replace.add("");
        replace.add("");
        
        output += "[";
        
        for (int i = 0; i < tasks.get(0).size(); i++) {
            
            output += "{\"row_id\": \"" +
                    Find_and_replace.find_and_replace(find, replace, String.valueOf(tasks.get(0).get(i)).replace("<", "&lt;").replace(">", "&gt;")) +
                    "\", \"user_id\": \"" +
                    Find_and_replace.find_and_replace(find, replace, String.valueOf(tasks.get(1).get(i)).replace("<", "&lt;").replace(">", "&gt;")) +
                    "\", \"task_name\": \"" +
                    Find_and_replace.find_and_replace(find, replace, String.valueOf(tasks.get(2).get(i)).replace("<", "&lt;").replace(">", "&gt;")) +
                    "\", \"description\": \"" +
                    Find_and_replace.find_and_replace(find, replace, String.valueOf(tasks.get(3).get(i)).replace("<", "&lt;").replace(">", "&gt;")) +
                    "\", \"time_started\": \"" +
                    Find_and_replace.find_and_replace(find, replace, String.valueOf(tasks.get(4).get(i)).replace("<", "&lt;").replace(">", "&gt;")) +
                    "\", \"time_stopped\": \"" +
                    Find_and_replace.find_and_replace(find, replace, String.valueOf(tasks.get(5).get(i)).replace("<", "&lt;").replace(">", "&gt;")) +
                    "\", \"date_received\": \"" +
                    Find_and_replace.find_and_replace(find, replace, String.valueOf(tasks.get(6).get(i)).replace("<", "&lt;").replace(">", "&gt;")) +
                    "\", \"time_received\": \"" +
                    Find_and_replace.find_and_replace(find, replace, String.valueOf(tasks.get(7).get(i)).replace("<", "&lt;").replace(">", "&gt;")) +
                    "\", \"total_time\": \"" +
                    Find_and_replace.find_and_replace(find, replace, String.valueOf(tasks.get(8).get(i)).replace("<", "&lt;").replace(">", "&gt;")) +
                    "\"}, ";
        }
        
        output += "{}]";
        
        output = output.replace(", {}", "");
        
        return output;
    }
}