//Author: Timothy van der Graaff
package controllers;

public class Request_Third_Party_Accounts extends models.Third_Party_Accounts_Processor {
	
	public String request_websites(String admin_session) {
		
		views.Show_Third_Party_Accounts request_third_party_accounts = new views.Show_Third_Party_Accounts();
		
		String output = "";
		
		this.set_admin_session(admin_session);
		
		output += request_third_party_accounts.show_websites(this.search_websites());
		
		return output;
	}
}
