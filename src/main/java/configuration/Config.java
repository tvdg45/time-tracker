//Author: Timothy van der Graaff
package configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;

public class Config {
    
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    private static String database_server;
    private static String database_username;
    private static String database_password;
    private static String database_port;
    private static String database_name;
    private static String database_url;
    
    public static void call_database_information() throws IOException {
        
        URL url_for_get_request = new URL("https://tds-webhook.herokuapp.com/tds-webhook-company-website");
        
        String read_line;
        
        HttpURLConnection conection = (HttpURLConnection)url_for_get_request.openConnection();
        conection.setRequestMethod("POST");
        
        int response_code = conection.getResponseCode();
        
        if (response_code == HttpURLConnection.HTTP_OK) {
            
            StringBuilder response;
            
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()))) {
                
                response = new StringBuilder();
                
                while ((read_line = in.readLine()) != null) {
                    
                    response.append(read_line);
                }
            }
            
            String[] credentials = response.toString().split("\\s*,\\s*");
            
            if (credentials.length == 5) {
                
                try {

                    database_server = credentials[0];
                    database_username = credentials[1];
                    database_password = credentials[2];
                    database_port = credentials[3];
                    database_name = credentials[4];
                    
                    database_url = "jdbc:mysql://" + database_server + ":" + database_port + "/" + database_name;
                } catch (Exception e) {
                }
            }
        }
    }
    
    public static Connection openConnection() throws IOException {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            call_database_information();
            
            Connection connection = DriverManager.getConnection(database_url, database_username, database_password);
            
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            
            LOGGER.log(Level.INFO, "Unable to connect to the database");
            
            return null;
        }
    }
    
    public static ArrayList<String> bad_domain() {
        
        ArrayList<String> output = new ArrayList<> ();
        
        output.add("timothysdigitalsolutions.com");
        output.add("http://timothysdigitalsolutions.com");
        output.add("http://www.timothysdigitalsolutions.com");
        output.add("https://timothysdigitalsolutions.com");
        
        return output;
    }
    
    public static String domain() {
        
        String output = "";
        
        //Define any domain name below.  Your domain name can also have a directory included.
        //Example: Directory not included - https://www.timothysdigitalsolutions.com or directory included - https://www.timothysdigitalsolutions.com/contact-me
        String domain = "https://www.timothysdigitalsolutions.com";
        
        output += domain;
        
        return output;
    }
    
    public static String third_party_domain() {
        
        String output = "";
        
        //Define any domain name below.  Your domain name can also have a directory included.
        
        //Example: Directory not included - https://www.timothysdigitalsolutions.com or directory included - https://www.timothysdigitalsolutions.com/contact-me
        //String third_party_domain = "https://user-account-management-1.herokuapp.com";
        String third_party_domain = "https://timothys-digital-solutions-web.herokuapp.com";
        
        output += third_party_domain;
        
        return output;
    }
}
