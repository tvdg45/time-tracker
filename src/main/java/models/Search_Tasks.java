//Author: Timothy van der Graaff
package models;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Search_Tasks {
    
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    public static Connection connection;
    
    //global variables
    private static String task_owner;
    
    //mutators
    protected static void set_task_owner(String this_task_owner) {
        
        task_owner = this_task_owner;
    }
    
    //accessors
    private static String get_task_owner() {
        
        return task_owner;
    }
    
    
    
    
    
    private static void create_new_table() {
        
        try {
            
            PreparedStatement create_statement = connection.prepareStatement(
                    
                    "CREATE TABLE company_time_tracker_tasks " +
                    "(row_id INT NOT NULL, user_id TEXT NOT NULL, " + 
                    "task_name TEXT NOT NULL, description TEXT NOT NULL, " +
                    "time_started TEXT NOT NULL, time_stopped TEXT NOT NULL, " +
                    "date_received TEXT NOT NULL, time_received TEXT NOT NULL, " +
                    "total_time TEXT NOT NULL, " +
                    "PRIMARY KEY (row_id)) ENGINE = MYISAM;");
            
            create_statement.execute();
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_time_tracker_tasks' " +
                    "table was not created because it already exists.  " +
                    "This is not necessarily an error.");
        }
    }
    
    protected static ArrayList<ArrayList<String>> search_tasks() {
        
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        
        ArrayList<String> row_id = new ArrayList<>();
        ArrayList<String> user_id = new ArrayList<>();
        ArrayList<String> task_name = new ArrayList<>();
        ArrayList<String> description = new ArrayList<>();
        ArrayList<String> time_started = new ArrayList<>();
        ArrayList<String> time_stopped = new ArrayList<>();
        ArrayList<String> date_received = new ArrayList<>();
        ArrayList<String> time_received = new ArrayList<>();
        ArrayList<String> total_time = new ArrayList<>();
        
        int task_count = 0;
        
        PreparedStatement select_statement;
        ResultSet select_results;
        
        try {
            
            select_statement = connection.prepareStatement("SELECT row_id, user_id, task_name, description, " +
                    "time_started, time_stopped, date_received, time_received, total_time FROM " +
                    "company_time_tracker_tasks WHERE user_id = ? " +
                    "ORDER BY row_id DESC");
            
            select_statement.setString(1, get_task_owner());
            
            select_results = select_statement.executeQuery();
            
            while (select_results.next()) {
                
                row_id.add(String.valueOf(select_results.getInt(1)));
                user_id.add(select_results.getString(2));
                task_name.add(select_results.getString(3));
                description.add(select_results.getString(4));
                time_started.add(select_results.getString(5));
                time_stopped.add(select_results.getString(6));
                date_received.add(select_results.getString(7));
                time_received.add(select_results.getString(8));
                total_time.add(select_results.getString(9));
                
                task_count++;
            }
            
            if (task_count == 0) {
                
                row_id.add("0");
                user_id.add("no task");
                task_name.add("no task");
                description.add("no task");
                time_started.add("no task");
                time_stopped.add("no task");
                date_received.add("no task");
                time_received.add("no task");
                total_time.add("0");
            }
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_time_tracker_tasks' " +
                    "table is corrupt or does not exist");
            
            create_new_table();
            
            row_id.add("0");
            user_id.add("fail");
            task_name.add("fail");
            description.add("fail");
            time_started.add("fail");
            time_stopped.add("fail");
            date_received.add("fail");
            time_received.add("fail");
            total_time.add("0");
        }
        
        output.add(row_id);
        output.add(user_id);
        output.add(task_name);
        output.add(description);
        output.add(time_started);
        output.add(time_stopped);
        output.add(date_received);
        output.add(time_received);
        output.add(total_time);
        
        return output;
    }
}
