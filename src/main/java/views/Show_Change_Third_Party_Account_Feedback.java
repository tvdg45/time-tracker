//Author: Timothy van der Graaff

package views;

public class Show_Change_Third_Party_Account_Feedback {
	
	public String show_change_third_party_account_feedback(String[] change_third_party_account) {
		
		String output = "";
		
		if (change_third_party_account[0] == "successful database update" || change_third_party_account[0] == "not logged in") {
			
			output += "<script type='text/javascript'>\n";
			output += "window.location = document.location.href.replace('#', '');\n";
			output += "</script>\n";
		} else if (change_third_party_account[0] == "database error" || change_third_party_account[0] == "no user action" || change_third_party_account[0] == "") {
			
			output = "";
		} else {
			
			output += "<div style=\"text-align: left; width: 100%\">\n";
			output += "<label>Please correct the following errors:</label>\n";
			output += "</div>\n";
			output += "<div style=\"text-align: left; width: 100%\">\n";
			output += "<ul>\n";
	
			for (int row = 0; row < change_third_party_account.length; row++) {

				if (change_third_party_account[row] != null) {
					
					output += "<li><label>" + change_third_party_account[row] + "</label></li>\n";
				}
			}
	
			output += "</ul>\n";
			output += "</div>\n";
		}
		
		return output;
	}
}
