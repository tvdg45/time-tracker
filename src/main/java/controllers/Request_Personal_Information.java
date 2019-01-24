//Author: Timothy van der Graaff
package controllers;

public class Request_Personal_Information {
	
	public String admin_request_personal_information(String admin_session) {
		
		views.Show_Personal_Information request_personal_information = new views.Show_Personal_Information();
		
		String output = "";

		output += request_personal_information.admin_show_personal_information(admin_session);
		
		return output;
	}
}