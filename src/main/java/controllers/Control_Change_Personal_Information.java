//Author: Timothy van der Graaff
package controllers;

public class Control_Change_Personal_Information extends models.Change_Personal_Information {
	
	public String control_basic_information_changer(String first_name, String last_name, String save_basic_information, String cancel_changes, String admin_session) {
		
		views.Show_Personal_Information_Changer_Feedback control_change_personal_information = new views.Show_Personal_Information_Changer_Feedback();
		
		String output = "";
		
		this.set_first_name(first_name);
		this.set_last_name(last_name);
		this.set_save_basic_information(save_basic_information);
		this.set_cancel_changes(cancel_changes);
		this.set_admin_session(admin_session);
		
		output += control_change_personal_information.show_fetch_lost_personal_information_feedback(this.change_basic_information());
		
		return output;
	}
	
	public String control_email_changer(String email, String save_email, String cancel_changes, String admin_session) {
		
		views.Show_Personal_Information_Changer_Feedback control_change_personal_information = new views.Show_Personal_Information_Changer_Feedback();
		
		String output = "";
		
		this.set_email(email);
		this.set_save_email(save_email);
		this.set_cancel_changes(cancel_changes);
		this.set_admin_session(admin_session);
		
		output += control_change_personal_information.show_fetch_lost_personal_information_feedback(this.change_email());
		
		return output;
	}
	
	public String control_username_changer(String username, String save_username, String cancel_changes, String admin_session) {
		
		views.Show_Personal_Information_Changer_Feedback control_change_personal_information = new views.Show_Personal_Information_Changer_Feedback();
		
		String output = "";
		
		this.set_username(username);
		this.set_save_username(save_username);
		this.set_cancel_changes(cancel_changes);
		this.set_admin_session(admin_session);
		
		output += control_change_personal_information.show_fetch_lost_personal_information_feedback(this.change_username());
		
		return output;
	}
	
	public String control_password_changer(String current_password, String new_password, String confirm_new_password, String save_password, String cancel_changes, String admin_session) {
		
		views.Show_Personal_Information_Changer_Feedback control_change_personal_information = new views.Show_Personal_Information_Changer_Feedback();
		
		String output = "";
		
		this.set_current_password(current_password);
		this.set_new_password(new_password);
		this.set_confirm_new_password(confirm_new_password);
		this.set_save_password(save_password);
		this.set_cancel_changes(cancel_changes);
		this.set_admin_session(admin_session);
		
		output += control_change_personal_information.show_fetch_lost_personal_information_feedback(this.change_password());
		
		return output;
	}
}
