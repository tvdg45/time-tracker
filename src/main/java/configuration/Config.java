//Author: Timothy van der Graaff
package configuration;

public class Config {

 public String database_server() {

  String output = "";

  //You can use a name like "localhost", a URL, or an IP address.
  String database_server = "82.163.176.10";

  output += database_server;

  return output;
 }

 public String database_port() {

  String output = "";

  //This method is used for remote database server connections.  Only number values are allowed.
  String database_port = "3306";

  output += database_port;

  return output;
 }

 public String database_name() {

  String output = "";

  //Choose your database by defining the following constant.
  String database_name = "timothys_digital_solutions_third_party_apps";

  output += database_name;

  return output;
 }

 public String database_username() {

  String output = "";

  //Choose your username by defining the following constant.
  String database_username = "timothys_tim";

  output += database_username;

  return output;
 }

 public String database_password() {

  String output = "";

  //Choose your password by defining the following constant.
  String database_password = "ranger12";

  output += database_password;

  return output;
 }

 public String database_url() {

  String output = "";

  //You can define the following constant as a database connection parameter.  Database username and database password are the two other parameters.  That makes a total of three parameters in your database connection.

  //Example: Connection connection = DriverManager.getConnection(this.database_url(), this.database_username(), this.database_password());
  String database_url = "jdbc:mysql://" + this.database_server() + ":" + this.database_port() + "/" + this.database_name();

  output += database_url;

  return output;
 }

 public String domain() {

  String output = "";

  //Define any domain name below.  Your domain name can also have a directory included.

  //Example: Directory not included - https://www.timothysdigitalsolutions.com or directory included - https://www.timothysdigitalsolutions.com/contact-me
  String domain = "https://www.timothysdigitalsolutions.com";

  output += domain;

  return output;
 }

 public String third_party_domain() {

  String output = "";

  //Define any domain name below.  Your domain name can also have a directory included.

  //Example: Directory not included - https://www.timothysdigitalsolutions.com or directory included - https://www.timothysdigitalsolutions.com/contact-me
  String third_party_domain = "https://user-account-management-1.herokuapp.com";

  output += third_party_domain;

  return output;
 }
}
