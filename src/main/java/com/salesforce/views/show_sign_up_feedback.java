//Author: Timothy van der Graaff
package sign_up;

public class Show_Sign_Up_Feedback {
	
	public String show_sign_up_feedback(String[] sign_up) {
		
		config.Config use_config = new config.Config();
		
		String output = "";
		
		if (sign_up[0] != "database error") {
			
			if (sign_up[0] == "no user action") {
	
				output = "";
			} else if (sign_up[0] == "successful database update") {
				
				output += "<label>Thank you for signing up!  You should receive an email with furthur instructions. <a href='" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/admin.php'>Click here</a> to log in.</label>\n";
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
