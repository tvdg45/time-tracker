//Author: Timothy van der Graaff
package views;

public class Show_Sign_Up_Feedback {

 protected configuration.Config use_config;

 public Show_Sign_Up_Feedback() {

  use_config = new configuration.Config();
 }

 public String show_sign_up_feedback(String[] sign_up, String first_name, String last_name, String username, String password, String email) {

  String output = "";

  if (!(sign_up[0].equals("database error"))) {

   switch (sign_up[0]) {
       
    case "no user action":
    
     output = "";
     
     break;
        
    case "successful database update":
        
     output += "<script type=\"text/javascript\">\n";
     output += "$(document).ready(function() {\n\n";
     output += "$(\"#new_first_name\").val(\"\");\n";
     output += "$(\"#new_last_name\").val(\"\");\n";
     output += "$(\"#new_email\").val(\"\");\n";
     output += "$(\"#new_username\").val(\"\");\n";
     output += "$(\"#new_password\").val(\"\");\n";
     output += "$(\"#confirm_new_password\").val(\"\");\n\n";
     output += "var xhttp = new XMLHttpRequest();\n\n";
     output += "xhttp.onreadystatechange = function() {\n\n";
     output += "if (this.readyState == 4 && this.status == 200) {\n\n";
     output += "$(\".create_new_account\").html(this.responseText);\n";
     output += "}\n";
     output += "};\n\n";
     output += "xhttp.open(\"POST\", \"" + this.use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/sign-up-email.php\");\n";
     output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
     output += "xhttp.send(\"first_name=" + first_name + "&last_name=" + last_name + "&username=" + username + "&password=" + password + "&email=" + email + "\");\n";
     output += "});\n";
     output += "</script>\n";
     output += "<div class=\"create_new_account\" style=\"text-align: left; width: 100%\"></div>\n\n";
     
     break;
        
    default:
        
     output += "<div style=\"text-align: left; width: 100%\">\n";
     output += "<label>Please correct the following errors:</label>\n";
     output += "</div>\n";
     output += "<div style=\"text-align: left; width: 100%\">\n";
     output += "<ul>\n";
     
     for (int row = 0; row < sign_up.length; row++) {

      if (sign_up[row] != null) {

       output += "<li><label>" + sign_up[row] + "</label></li>\n";
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
