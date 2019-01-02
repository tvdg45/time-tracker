//Author: Timothy van der Graaff
package sign_up;

public class Control_Sign_Up extends sign_up.Sign_Up {
	
	public String control_sign_up(first_name, last_name, email, username, password, confirm_password, date_received, time_received, sign_up) {
		
		sign_up.Show_Sign_Up_Feedback control_sign_up = new sign_up.Show_Sign_Up_Feedback();
		
		this.set_first_name(first_name);
		this.set_last_name(last_name);
		this.set_email(email);
		this.set_username(username);
		this.set_password(password);
		this.set_confirm_password(confirm_password);
		this.set_date_received(date_received);
		this.set_time_received(time_received);
		this.set_sign_up(sign_up);
		
		return control_sign_up.show_sign_up_feedback(this.sign_up());	
	}
}
