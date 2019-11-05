//Author: Timothy van der Graaff
package models;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.Form_Validation;

public abstract class Change_Tasks {
    
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    public static Connection connection;
    
    //global variables
    private static String admin_session;
    private static String task_id;
    private static String[] each_selected_task;
    private static String task_name;
    private static String task_description;
    private static String time_started;
    private static String time_stopped;
    private static String date_received;
    private static String time_received;
    
    //mutators
    protected static void set_admin_session(String this_admin_session) {
        
        admin_session = this_admin_session;
    }
    
    protected static void set_task_id(String this_task_id) {
        
        task_id = this_task_id;
    }
    
    protected static void set_each_selected_task(String[] this_each_selected_task) {
        
        each_selected_task = this_each_selected_task;
    }
    
    protected static void set_task_name(String this_task_name) {
        
        task_name = this_task_name;
    }
    
    protected static void set_task_description(String this_task_description) {
        
        task_description = this_task_description;
    }
    
    protected static void set_time_started(String this_time_started) {
        
        time_started = this_time_started;
    }
    
    protected static void set_time_stopped(String this_time_stopped) {
        
        time_stopped = this_time_stopped;
    }
    
    protected static void set_date_received(String this_date_received) {
        
        date_received = this_date_received;
    }
    
    protected static void set_time_received(String this_time_received) {
        
        time_received = this_time_received;
    }
    
    //accessors
    private static String get_admin_session() {
        
        return admin_session;
    }
    
    private static String get_task_id() {
        
        return task_id;
    }
    
    private static String[] get_each_selected_task() {
        
        return each_selected_task;
    }
    
    private static String get_task_name() {
        
        return task_name;
    }
    
    private static String get_task_description() {
        
        return task_description;
    }
    
    private static String get_time_started() {
        
        return time_started;
    }
    
    private static String get_time_stopped() {
        
        return time_stopped;
    }
    
    private static String get_date_received() {
        
        return date_received;
    }
    
    private static String get_time_received() {
        
        return time_received;
    }
    
    
    
    
    
    
    private static int generate_row_id() {
        
        int output;
        
        try {
            
            PreparedStatement prepared_statement = connection.prepareStatement("SELECT row_id FROM " +
                    "company_time_tracker_tasks ORDER BY row_id DESC");
            
            ResultSet result_set = prepared_statement.executeQuery();
            
            result_set.last();
            
            if (result_set.getRow() > 0) {
               
                output = result_set.getRow();
            } else {
                
                output = 0;
            }
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "{0}", e);
            
            output = 0;
        }
        
        return output + 1;
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
    
    private static int calculate_total_minutes(int start_time, int finish_time) {
        
        int output;
        
        try {
            
            output = finish_time - start_time;
        } catch (Exception e) {
            
            output = 0;
        }
        
        return output;
    }
    
    private static int search_start_time(int row_id) {
        
        int output = 0;
        int task_count = 0;
        
        PreparedStatement select_statement;
        ResultSet select_results;
        
        try {
            
            select_statement = connection.prepareStatement("SELECT time_started FROM company_time_tracker_tasks " +
                    "WHERE row_id = ?");
            
            select_statement.setInt(1, row_id);
            
            select_results = select_statement.executeQuery();
            
            while (select_results.next()) {
                
                output = Integer.parseInt(select_results.getString(1));
                
                task_count++;
            }
            
            if (task_count != 1) {
                
                output = 0;
            }
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_time_tracker_tasks' " +
                    "table is corrupt or does not exist");
            
            create_new_table();
            
            output = 0; 
        }
        
        return output;
    }
    
    protected static String create_task() {
        
        String output;
        
        try {
            
            PreparedStatement insert_statement = connection.prepareStatement("INSERT INTO " +
                    "company_time_tracker_tasks (row_id, user_id, task_name, description, time_started, " +
                    "time_stopped, date_received, time_received, total_time) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            insert_statement.setInt(1, generate_row_id());
            insert_statement.setString(2, get_admin_session());
            
            if (Form_Validation.is_string_null_or_white_space(get_task_name())) {
                
                insert_statement.setString(3, "Unspecified task");
            } else {
            
                insert_statement.setString(3, get_task_name());
            }
            
            if (Form_Validation.is_string_null_or_white_space(get_task_description())) {
                
                insert_statement.setString(4, "None");
            } else {
            
                insert_statement.setString(4, get_task_description());
            }
            
            insert_statement.setString(5, get_time_started());
            insert_statement.setString(6, "");
            insert_statement.setString(7, get_date_received());
            insert_statement.setString(8, get_time_received());
            insert_statement.setString(9, "0");
            
            insert_statement.addBatch();
            
            insert_statement.executeBatch();
            
            output = "success";
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_time_tracker_tasks' " +
                    "table is corrupt or does not exist");
            
            create_new_table();
            
            output = "fail";
        }
        
        return output;
    }
    
    protected static String finish_selected_task() {
        
        String output;
        
        PreparedStatement update_statement;
        
        try {
            
            update_statement = connection.prepareStatement("UPDATE company_time_tracker_tasks " +
                    "SET time_stopped = ?, total_time = ? WHERE user_id = ? AND row_id = ?");
            
            update_statement.setString(1, get_time_stopped());
            update_statement.setString(2, String.valueOf(calculate_total_minutes(search_start_time(
                    Integer.parseInt(get_task_id())),
                    Integer.valueOf(get_time_stopped()))
            ));
            update_statement.setString(3, get_admin_session());
            update_statement.setInt(4, Integer.parseInt(get_task_id()));
            
            update_statement.addBatch();
            
            update_statement.executeBatch();
            
            output = "success";
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_time_tracker_tasks' " +
                    "table is corrupt or does not exist");
            
            create_new_table();
            
            output = "fail";
        }
        
        return output;
    }
    
    protected static String delete_selected_tasks() {
        
        String output;
        int records_to_delete = 0;
        
        PreparedStatement delete_statement;
        
        try {
            
            delete_statement = connection.prepareStatement("DELETE FROM company_time_tracker_tasks " +
                    "WHERE user_id = ? AND row_id = ?");
            
            for (int i = 0; i < get_each_selected_task().length; i++) {
                
                delete_statement.setString(1, get_admin_session());
                delete_statement.setInt(2, Integer.parseInt(get_each_selected_task()[i]));
                
                delete_statement.addBatch();
                
                records_to_delete++;
            }
            
            if (records_to_delete > 0) {
                
                delete_statement.executeBatch();
            }
            
            output = "success";
        } catch (SQLException e) {
            
            LOGGER.log(Level.INFO, "The 'company_time_tracker_tasks' " +
                    "table is corrupt or does not exist");
            
            create_new_table();
            
            output = "fail";
        }
        
        return output;
    }
}