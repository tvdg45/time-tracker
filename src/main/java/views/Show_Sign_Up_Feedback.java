//Author: Timothy van der Graaff
package views;

public class Show_Sign_Up_Feedback {
	
	public String show_sign_up_feedback(String[] sign_up, String first_name, String last_name, String username, String password, String email) {
		
		configuration.Config use_config = new configuration.Config();
		
		String output = "";
		
		if (sign_up[0] != "database error") {
			
			if (sign_up[0] == "no user action") {
	
				output = "";
			} else if (sign_up[0] == "successful database update") {
				
				output += "<script type=\"text/javascript\">\n";
				output += "$(document).ready(function() {\n\n";
				output += "var xhttp = new XMLHttpRequest();\n\n";
				output += "xhttp.onreadystatechange = function() {\n\n";
				output += "if (this.readyState == 4 && this.status == 200) {\n\n";
				output += "$(\".create_new_account\").html(this.responseText);\n";
				output += "}\n";
				output += "};\n\n";
				output += "xhttp.open(\"POST\", \"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/sign-up-email.php\");\n";
				output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
				output += "xhttp.send(\"first_name=" + first_name + "&last_name=" + last_name + "&username=" + username + "&password=" + password + "&email=" + email + "\");\n";
				output += "});\n";
				output += "</script>\n";
				output += "<div class=\"create_new_account\" style=\"text-align: left; width: 100%\"></div>\n\n";
			} else {
				
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
			}
		}
		
		return output;
	}
}
