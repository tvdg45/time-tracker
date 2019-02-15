//Author: Timothy van der Graaff
package controllers;

public class Control_Change_Third_Party_Account extends models.Change_Third_Party_Account {
	
	public String control_add_website(String url, String token, String date_received, String time_received, String add_website, String admin_session) {
		
		views.Show_Change_Third_Party_Account_Feedback control_change_third_party_account = new views.Show_Change_Third_Party_Account_Feedback();
		
		String output = "";
		
		this.set_url(url);
		this.set_token(token);
		this.set_date_received(date_received);
		this.set_time_received(time_received);
		this.set_add_website(add_website);
		this.set_admin_session(admin_session);
		
		output += control_change_third_party_account.show_change_third_party_account_feedback(this.add_website());
		
		return output;
	}
	
	public String control_change_url(String id, String url, String change_url, String admin_session) {
		
		views.Show_Change_Third_Party_Account_Feedback control_change_third_party_account = new views.Show_Change_Third_Party_Account_Feedback();
		
		String output = "";
		
		this.set_id(id);
		this.set_url(url);
		this.set_change_url(change_url);
		this.set_admin_session(admin_session);
		
		output += control_change_third_party_account.show_change_third_party_account_feedback(this.change_url());
		
		return output;
	}
	
	public String control_change_token(String id, String token, String change_token, String admin_session) {
		
		views.Show_Change_Third_Party_Account_Feedback control_change_third_party_account = new views.Show_Change_Third_Party_Account_Feedback();
		
		String output = "";
		
		this.set_id(id);
		this.set_token(token);
		this.set_change_token(change_token);
		this.set_admin_session(admin_session);
		
		output += control_change_third_party_account.show_change_third_party_account_feedback(this.change_token());
		
		return output;
	}
	
	public String control_delete_website(String id, String delete_website, String admin_session) {
		
		views.Show_Change_Third_Party_Account_Feedback control_change_third_party_account = new views.Show_Change_Third_Party_Account_Feedback();
		
		String output = "";
		
		this.set_id(id);
		this.set_delete_website(delete_website);
		this.set_admin_session(admin_session);
		
		output += control_change_third_party_account.show_change_third_party_account_feedback(this.delete_website());
		
		return output;
	}
	
	public String control_downgrade_plan(String id, String memory_plan, String memory, String downgrade_plan, String admin_session) {
		
		views.Show_Change_Third_Party_Account_Feedback control_change_third_party_account = new views.Show_Change_Third_Party_Account_Feedback();
		
		String output = "";
		
		this.set_id(id);
		this.set_memory_plan(memory_plan);
		this.set_memory(memory);
		this.set_downgrade_plan(downgrade_plan);
		this.set_admin_session(admin_session);

		output += control_change_third_party_account.show_change_third_party_account_feedback(this.downgrade_plan());
		
		return output;
	}
	
	public function control_upgrade_plan(String id, String memory_plan, String memory, String upgrade_plan, String admin_session) {
		
		views.Show_Change_Third_Party_Account_Feedback control_change_third_party_account = new views.Show_Change_Third_Party_Account_Feedback();
		
		String output = "";
		
		this.set_id(id);
		this.set_memory_plan(memory_plan);
		this.set_memory(memory);
		this.set_upgrade_plan(upgrade_plan);
		this.set_admin_session(admin_session);

		output += control_change_third_party_account.show_change_third_party_account_feedback(this.upgrade_plan());
		
		return output;
	}
}
