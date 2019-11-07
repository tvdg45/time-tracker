//Author: Timothy van der Graaff
package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import views.Show_Change_Tasks;

public class Control_Finish_Selected_Task extends models.Change_Tasks {
    
	//global variables
    public static Connection use_connection;
    public static String admin_session;
    public static String task_id;
    public static String time_stopped;
    public static String finish_task;
    
    public static String control_finish_selected_task() {
        
        String output = "";
        
        if (finish_task.equals("Finish task")) {
            
            connection = use_connection;
            
            set_admin_session(admin_session);
            set_task_id(task_id);
            set_time_stopped(time_stopped);
            
            if (finish_selected_task().equals("success")) {
                
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
