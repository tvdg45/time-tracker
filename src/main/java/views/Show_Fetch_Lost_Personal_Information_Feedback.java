//Author: Timothy van der Graaff
package views;

public class Show_Fetch_Lost_Personal_Information_Feedback {

 protected configuration.Config use_config;

 public Show_Fetch_Lost_Personal_Information_Feedback() {

  use_config = new configuration.Config();
 }

 public String show_fetch_lost_personal_information_feedback(String[][] fetch_lost_personal_information) {

  String output = "";

  if (!(fetch_lost_personal_information[0][0].equals("database error"))) {

   switch (fetch_lost_personal_information[0][0]) {
       
    case "no user action":
        
     output = "";
     
     break;
        
    case "successful username authentication":
        
     output += "<script type=\"text/javascript\">\n";
     output += "$(document).ready(function() {\n\n";
     output += "$(\"#email\").val(\"\");\n\n";
     output += "var xhttp = new XMLHttpRequest();\n\n";
     output += "xhttp.onreadystatechange = function() {\n\n";
     output += "if (this.readyState == 4 && this.status == 200) {\n\n";
     output += "$(\".fetch_username_email\").html(this.responseText);\n";
     output += "}\n";
     output += "};\n\n";
     output += "xhttp.open(\"POST\", \"" + this.use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/fetch-username-email.php\");\n";
     output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
     output += "xhttp.send(\"first_name=" + fetch_lost_personal_information[0][1] + "&username=" + fetch_lost_personal_information[0][2] + "&email=" + fetch_lost_personal_information[0][3] + "\");\n";
     output += "});\n";
     output += "</script>\n";
     output += "<div class=\"fetch_username_email\" style=\"text-align: left; width: 100%\"></div>\n\n";
     
     break;
        
    case "successful password authentication":
        
     output += "<script type=\"text/javascript\">\n";
     output += "$(document).ready(function() {\n\n";
     output += "$(\"#find_password_username\").val(\"\");\n\n";
     output += "var xhttp = new XMLHttpRequest();\n\n";
     output += "xhttp.onreadystatechange = function() {\n\n";
     output += "if (this.readyState == 4 && this.status == 200) {\n\n";
     output += "$(\".fetch_password_email\").html(this.responseText);\n";
     output += "}\n";
     output += "};\n\n";
     output += "xhttp.open(\"POST\", \"" + this.use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/fetch-password-email.php\");\n";
     output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
     output += "xhttp.send(\"first_name=" + fetch_lost_personal_information[0][1] + "&username=" + fetch_lost_personal_information[0][2] + "&email=" + fetch_lost_personal_information[0][3] + "&password=" + fetch_lost_personal_information[0][4] + "\");\n";
     output += "});\n";
     output += "</script>\n";
     output += "<div class=\"fetch_password_email\" style=\"text-align: left; width: 100%\"></div>\n\n";
     
     break;
        
    default:
        
     output += "<div style=\"text-align: left; width: 100%\">\n";
     output += "<label>Please correct the following errors:</label>\n";
     output += "</div>\n";
     output += "<div style=\"text-align: left; width: 100%\">\n";
     output += "<ul>\n";
     
     for (int row = 0; row < fetch_lost_personal_information.length; row++) {

      if (fetch_lost_personal_information[row][0] != null) {

       output += "<li><label>" + fetch_lost_personal_information[row][0] + "</label></li>\n";
      }
     }
     
     output += "</ul>\n";
     output += "</div>\n";
     
     break;
   }
  }

  return output;
 }
}
