//Author: Timothy van der Graaff
public class Control_Fetch_Lost_Personal_Information extends Fetch_Lost_Personal_Information {
	
	public String control_fetch_username(String email, String fetch_username) {
		
		Show_Fetch_Lost_Personal_Information_Feedback control_fetch_lost_personal_information = new Show_Fetch_Lost_Personal_Information_Feedback();
		
		String output = "";
		
		this.set_email(email);
		this.set_fetch_username(fetch_username);
		
		output += control_fetch_lost_personal_information.show_fetch_lost_personal_information_feedback(this.fetch_username(), this.search_first_name(), this.search_username(), email);
		
		return output;
	}
	
	public String control_fetch_password(String username, String fetch_password) {
		
		Show_Fetch_Lost_Personal_Information_Feedback control_fetch_lost_personal_information = new Show_Fetch_Lost_Personal_Information_Feedback();
		
		String output = "";
		
		this.set_username(username);
		this.set_fetch_password(fetch_password);
		
		output += control_fetch_lost_personal_information.show_fetch_lost_personal_information_feedback(this.fetch_password(), this.search_first_name(), username, this.search_email(), this.search_password());
		
		return output;
	}
}
