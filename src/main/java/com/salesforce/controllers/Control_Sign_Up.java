//Author: Timothy van der Graaff
public class Control_Sign_Up extends Sign_Up {
	
	public String control_sign_up(String first_name, String last_name, String email, String username, String password, String confirm_password, String date_received, String time_received, String sign_up) {
		
		Show_Sign_Up_Feedback control_sign_up = new Show_Sign_Up_Feedback();
		
		String output = sign_up;
		
		/*this.set_first_name(first_name);
		this.set_last_name(last_name);
		this.set_email(email);
		this.set_username(username);
		this.set_password(password);
		this.set_confirm_password(confirm_password);
		this.set_date_received(date_received);
		this.set_time_received(time_received);
		this.set_sign_up(sign_up);
		
		output += control_sign_up.show_sign_up_feedback(this.sign_up());*/
		
		if (sign_up.equals("null")) {
			
			output += "no";
		}
		
		return output;
	}
}
