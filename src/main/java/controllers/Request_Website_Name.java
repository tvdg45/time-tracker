//Author: Timothy van der Graaff
package controllers;

import java.sql.Connection;

public class Request_Website_Name extends models.Website_Name_Processor {
    
    public static Connection use_connection;
    
    public static String request_website_name() {
        
        connection = use_connection;
        
        return search_website_name();
    }
}
