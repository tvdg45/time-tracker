//Author: Timothy van der Graaff
package controllers;

import views.Show_Tasks;
import utilities.Form_Validation;
import java.util.ArrayList;
import java.sql.Connection;

public class Control_Search_Tasks extends models.Search_Tasks {
    
    //global variables
    public static Connection use_connection;
    public static String task_owner;
    public static ArrayList<ArrayList<String>> search_tasks;
    
    public static String request_tasks() {
        
        String output;
        
        if (!(Form_Validation.is_string_null_or_white_space(task_owner))) {
            
            try {
                
                connection = use_connection;
                
                set_task_owner(task_owner);
                
                search_tasks = search_tasks();
                
                if (String.valueOf(search_tasks.get(1).get(0)).equals("no task")
                    || String.valueOf(search_tasks.get(1).get(0)).equals("fail")) {
                    
                    output = "no tasks";
                } else {
                    
                    Show_Tasks.tasks = search_tasks;
                    
                    output = Show_Tasks.show_tasks();
                }
            } catch (Exception e) {
                
                output = "[{\"row_id\": \"\", \"user_id\": \"\", \"task_name\": \"\", " +
                        "\"description\": \"\", \"time_started\": \"\", \"time_stopped\": " +
                        "\"\", \"date_received\": \"\", \"time_received\": \"\", \"total_time\": \"\"}]";
            }
        } else {
            
            output = "no tasks";
        }
        
        return output;
    }    
}
