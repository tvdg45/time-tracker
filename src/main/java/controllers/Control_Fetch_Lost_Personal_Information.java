//Author: Timothy van der Graaff
package controllers;

public class Control_Fetch_Lost_Personal_Information extends models.Fetch_Lost_Personal_Information {
	
	private views.Show_Fetch_Lost_Personal_Information_Feedback control_fetch_lost_personal_information;
	
	public Control_Fetch_Lost_Personal_Information() {
		
		this.control_fetch_lost_personal_information = control_fetch_lost_personal_information;
	}
	
	public String control_fetch_username(String email, String fetch_username) {
		
		String output = "";
		
		this.set_email(email);
		this.set_fetch_username(fetch_username);
		
		output += control_fetch_lost_personal_information.show_fetch_lost_personal_information_feedback(this.fetch_username());
		
		return output;
	}
	
	public String control_fetch_password(String username, String fetch_password) {
		
		String output = "";
		
		this.set_username(username);
		this.set_fetch_password(fetch_password);
		
		output += control_fetch_lost_personal_information.show_fetch_lost_personal_information_feedback(this.fetch_password());
		
		return output;
	}
}
