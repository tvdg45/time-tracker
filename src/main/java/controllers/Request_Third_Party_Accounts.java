//Author: Timothy van der Graaff
package controllers;

public class Request_Third_Party_Accounts extends models.Third_Party_Accounts_Processor {

 protected views.Show_Third_Party_Accounts request_third_party_accounts;

 public Request_Third_Party_Accounts() {

  request_third_party_accounts = new views.Show_Third_Party_Accounts();
 }

 public String request_websites(String admin_session) {

  String output = "";

  this.set_admin_session(admin_session);

  output += this.request_third_party_accounts.show_websites(this.search_websites());

  return output;
 }
}
