//Author: Timothy van der Graaff
package views;

public class Show_Personal_Information_Changer_Feedback {
	
	public String show_personal_information_changer_feedback(String[] change_personal_information) {
		
		String output = "";
		
		if (change_personal_information[0] != "database error") {
			
			if (change_personal_information[0] == "no user action") {
				
				output = "";
			} else if (change_personal_information[0] == "successful database update" || change_personal_information[0] == "voided changes" || change_personal_information[0] == "not logged in") {
				
				output += "<script type='text/javascript'>\n";
				output += "window.location = document.location.href.replace('#', '');\n";
				output += "</script>\n";
			} else {
				
				output += "<div style=\"text-align: left; width: 100%\">\n";
				output += "<label>Please correct the following errors:</label>\n";
				output += "</div>\n";
				output += "<div style=\"text-align: left; width: 100%\">\n";
				output += "<ul>\n";
	
				for (int row = 0; row < change_personal_information.length; row++) {

					if (change_personal_information[row] != null) {
						
						output += "<li><label>" + change_personal_information[row] + "</label></li>\n";
					}
				}
	
				output += "</ul>\n";
				output += "</div>\n";
			}
		}
		
		return output;
	}
}
