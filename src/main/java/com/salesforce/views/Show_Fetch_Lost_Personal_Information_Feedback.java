//Author: Timothy van der Graaff
public class Show_Fetch_Lost_Personal_Information_Feedback {
	
	public String show_fetch_lost_personal_information_feedback(String[] fetch_username, String search_first_name, String search_username, String email) {
		
		Config use_config = new Config();
		
		String output = "";
		
		if (fetch_username[0] != "database error") {
			
			if (fetch_username[0] == "no user action") {
				
				output = "";
			} else if (fetch_username[0] == "successful username authentication") {
				
				output += "<script type=\"text/javascript\">\n";
				output += "$(document).ready(function() {\n\n";
				output += "var xhttp = new XMLHttpRequest();\n\n";
				output += "xhttp.onreadystatechange = function() {\n\n";
				output += "if (this.readyState == 4 && this.status == 200) {\n\n";
				output += "$(\".fetch_username_email\").html(this.responseText);\n";
				output += "}\n";
				output += "};\n\n";
				output += "xhttp.open(\"POST\", \"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/fetch-username-email.php\");\n";
				output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
				output += "xhttp.send(\"first_name=" + search_first_name + "&username=" + search_username + "&email=" + email + "\");\n";
				output += "});\n";
				output += "</script>\n";
				output += "<div class=\"fetch_username_email\" style=\"text-align: left; width: 100%\"></div>\n\n";
			} else {
				
				output += "<div style=\"text-align: left; width: 100%\">\n";
				output += "<label>Please correct the following errors:</label>\n";
				output += "</div>\n";
				output += "<div style=\"text-align: left; width: 100%\">\n";
				output += "<ul>\n";
	
				for (int row = 0; row < fetch_username.length; row++) {

					if (fetch_username[row] != null) {
						
						output += "<li><label>" + fetch_username[row] + "</label></li>\n";
					}
				}
	
				output += "</ul>\n";
				output += "</div>\n";
			}
		}
		
		output = fetch_username[0];
		
		return output;
	}
	
	public String show_fetch_lost_personal_information_feedback(String[] fetch_password, String search_first_name, String username, String search_email, String search_password) {
		
		Config use_config = new Config();
		
		String output = "";
		
		if (fetch_password[0] != "database error") {
			
			if (fetch_password[0] == "no user action") {
				
				output = "";
			} else if (fetch_password[0] == "successful password authentication") {
				
				output += "<script type=\"text/javascript\">\n";
				output += "$(document).ready(function() {\n\n";
				output += "var xhttp = new XMLHttpRequest();\n\n";
				output += "xhttp.onreadystatechange = function() {\n\n";
				output += "if (this.readyState == 4 && this.status == 200) {\n\n";
				output += "$(\".fetch_password_email\").html(this.responseText);\n";
				output += "}\n";
				output += "};\n\n";
				output += "xhttp.open(\"POST\", \"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/fetch-password-email.php\");\n";
				output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
				output += "xhttp.send(\"first_name=" + search_first_name + "&username=" + username + "&email=" + search_email + "&password=" + search_password + "\");\n";
				output += "});\n";
				output += "</script>\n";
				output += "<div class=\"fetch_password_email\" style=\"text-align: left; width: 100%\"></div>\n\n";
			} else {
				
				output += "<div style=\"text-align: left; width: 100%\">\n";
				output += "<label>Please correct the following errors:</label>\n";
				output += "</div>\n";
				output += "<div style=\"text-align: left; width: 100%\">\n";
				output += "<ul>\n";
	
				for (int row = 0; row < fetch_password.length; row++) {

					if (fetch_password[row] != null) {
						
						output += "<li><label>" + fetch_password[row] + "</label></li>\n";
					}
				}
	
				output += "</ul>\n";
				output += "</div>\n";
			}
		}		
		
		return output;
	}
}
