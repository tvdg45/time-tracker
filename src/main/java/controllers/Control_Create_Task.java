//Author: Timothy van der Graaff
package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import views.Show_Change_Tasks;

public class Control_Create_Task extends models.Change_Tasks {
    
    public static Connection use_connection;
    public static String admin_session;
    public static String task_name;
    public static String task_description;
    public static String time_started;
    public static String date_received;
    public static String time_received;
    public static String create_task;
    
    public static String control_create_task() {
        
        String output = "";
        
        if (create_task.equals("Create task")) {
            
            connection = use_connection;
            
            set_admin_session(admin_session);
            set_task_name(task_name);
            set_task_description(task_description);
            set_time_started(time_started);
            set_date_received(date_received);
            set_time_received(time_received);
            
            if (create_task().equals("success")) {
                
                output = Show_Change_Tasks.refresh_page();
            } else {
                
                output = "";
            }
            
            try {
                
                use_connection.close();
            } catch (SQLException e) {
            }
        }
        
        return output;
    }
}
