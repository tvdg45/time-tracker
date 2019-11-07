//Author: Timothy van der Graaff
package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import views.Show_Change_Tasks;

public class Control_Delete_Tasks extends models.Change_Tasks {
    
	//global variables
    public static Connection use_connection;
    public static String admin_session;
    public static String[] each_selected_task;
    public static String delete_tasks;
    
    public static String control_delete_tasks() {
        
        String output = "";
        
        if (delete_tasks.equals("Delete tasks")) {
            
            if (each_selected_task.length > 0 && !(each_selected_task[0].equals(""))) {
                
                connection = use_connection;
                
                set_admin_session(admin_session);
                set_each_selected_task(each_selected_task);
                
                if (delete_selected_tasks().equals("success")) {
                    
                    output = Show_Change_Tasks.refresh_page();
                } else {
                    
                    output = "";
                }
                
                try {
                    
                    use_connection.close();
                } catch (SQLException e) {
                }
            } else {
                
                output = Show_Change_Tasks.delete_tasks_error_message();
            }
        }
        
        return output;
    }
}
