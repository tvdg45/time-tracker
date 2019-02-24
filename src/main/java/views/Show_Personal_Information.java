//Author: Timothy van der Graaff
package views;

public class Show_Personal_Information extends models.Personal_Information_Processor {

 protected configuration.Config use_config;

 public Show_Personal_Information() {

  use_config = new configuration.Config();
 }

 private String find_and_replace(String input_value) {

  String output = "";

  int find_and_replace_quantity = 2;
  String[] find = new String[find_and_replace_quantity];
  String[] replace = new String[find_and_replace_quantity];

  find[0] = "<";
  find[1] = ">";

  replace[0] = "&lt;";
  replace[1] = "&gt;";

  for (int i = 0; i < find.length; i++) {

   output = input_value.replace(find[i], replace[i]);
  }

  return output;
 }

 public String admin_show_personal_information(String admin_session) {

  String output = "";
  String[][] personal_information;

  personal_information = this.search_personal_information(admin_session);

  if (!(personal_information[0][0].equals("database error")) && !(personal_information[0][0].equals("no valid user"))) {

   output += "<div style='text-align: left; word-wrap: break-word; width: 100%'>\n";
   output += "<script type='text/javascript'>\n";
   output += "$(document).ready(function() {\n\n";
   output += "$(\".update_personal_information_button_section\").fadeIn();\n";
   output += "});\n\n";
   output += "</script>\n";

   for (int row = 0; row < personal_information.length; row++) {

    output += "<div style='text-align: left; width: 100%'>\n";
    output += "<div style='text-align: left; width: 100%'>\n";
    output += "<script type='text/javascript'>\n";
    output += "function access_basic_information_prompt() {\n\n";
    output += "$(\"#update_basic_information_button_section\").slideUp(1200);\n";
    output += "$(\"#update_email_prompt\").slideUp(1200);\n";
    output += "$(\"#update_username_prompt\").slideUp(1200);\n";
    output += "$(\"#update_password_prompt\").slideUp(1200);\n";
    output += "$(\"#update_basic_information_prompt\").slideDown(1200);\n";
    output += "$(\"#update_email_button_section\").slideDown(1200);\n";
    output += "$(\"#update_username_button_section\").slideDown(1200);\n";
    output += "$(\"#update_password_button_section\").slideDown(1200);\n";
    output += "}\n\n";
    output += "function update_basic_information() {\n\n";
    output += "var xhttp = new XMLHttpRequest();\n\n";
    output += "xhttp.onreadystatechange = function() {\n\n";
    output += "if (this.readyState == 0 || this.readyState == 1 || this.readyState == 2 || this.readyState == 3) {\n\n";
    output += "$(\".change_basic_information\").html(\"<label>Saving basic information...  Please wait.</label>\");\n";
    output += "}\n";
    output += "if (this.readyState == 4 && this.status == 0) {\n\n";
    output += "$(\".change_basic_information\").html(\"<label>Sorry, your basic information was not saved.  Check your internet connection.</label>\");\n";
    output += "}\n";
    output += "if (this.readyState == 4 && this.status == 200) {\n\n";
    output += "$(\".change_basic_information\").html(this.responseText);\n";
    output += "}\n";
    output += "};\n\n";
    output += "xhttp.open(\"POST\", \"" + this.use_config.third_party_domain() + "/change-personal-information\");\n";
    output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
    output += "xhttp.send(\"first_name=\" + $(\"#first_name\").val() + \"&last_name=\" + $(\"#last_name\").val() + \"&save_basic_information=" + personal_information[row][1] + "&admin_session=" + personal_information[row][1] + "\");\n";
    output += "}\n\n";
    output += "function undo_basic_information_changes() {\n\n";
    output += "var xhttp = new XMLHttpRequest();\n\n";
    output += "xhttp.onreadystatechange = function() {\n\n";
    output += "if (this.readyState == 4 && this.status == 200) {\n\n";
    output += "$(\".change_basic_information\").html(this.responseText);\n";
    output += "}\n";
    output += "};\n\n";
    output += "xhttp.open(\"POST\", \"" + this.use_config.third_party_domain() + "/change-personal-information\");\n";
    output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
    output += "xhttp.send(\"cancel_changes=" + personal_information[row][1] + "&admin_session=" + personal_information[row][1] + "\");\n";
    output += "}\n\n";
    output += "</script>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label><b>Edit basic information</b></label><br /><br />\n";
    output += "</div>\n";
    output += "<div id='update_basic_information_prompt' style='text-align: left; display: none'>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label>* indicates required field</label><br /><br />\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label>First name:*</label>\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<input type='text' id='first_name' value='" + this.find_and_replace(personal_information[row][2]) + "' style='width: 97.5%' />\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label>Last name:*</label>\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<input type='text' id='last_name' value='" + this.find_and_replace(personal_information[row][3]) + "' style='width: 97.5%' />\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<br /><input type='button' id='change_basic_information' onclick='update_basic_information()' value='Save changes' /><br /><br />\n";
    output += "<input type='button' id='cancel_basic_information_changes' onclick='undo_basic_information_changes()' value='Cancel' /><br /><br />\n";
    output += "<div class=\"change_basic_information\"></div><br />\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "<div class='update_personal_information_button_section' id='update_basic_information_button_section' style='text-align: left; display: none'>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label><b>First name:</b> " + this.find_and_replace(personal_information[row][2]) + "</label>\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label><b>Last name:</b> " + this.find_and_replace(personal_information[row][3]) + "</label>\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<br /><input type='button' id='open_basic_information_prompt' onclick='access_basic_information_prompt()' value='Change' /><br /><br /><br />\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "<div style='text-align: left; width: 100%'>\n";
    output += "<div style='text-align: left; width: 100%'>\n";
    output += "<script type='text/javascript'>\n";
    output += "function access_email_prompt() {\n\n";
    output += "$(\"#update_basic_information_prompt\").slideUp(1200);\n";
    output += "$(\"#update_email_button_section\").slideUp(1200);\n";
    output += "$(\"#update_username_prompt\").slideUp(1200);\n";
    output += "$(\"#update_password_prompt\").slideUp(1200);\n";
    output += "$(\"#update_basic_information_button_section\").slideDown(1200);\n";
    output += "$(\"#update_email_prompt\").slideDown(1200);\n";
    output += "$(\"#update_username_button_section\").slideDown(1200);\n";
    output += "$(\"#update_password_button_section\").slideDown(1200);\n";
    output += "}\n\n";
    output += "function update_email() {\n\n";
    output += "var xhttp = new XMLHttpRequest();\n\n";
    output += "xhttp.onreadystatechange = function() {\n\n";
    output += "if (this.readyState == 0 || this.readyState == 1 || this.readyState == 2 || this.readyState == 3) {\n\n";
    output += "$(\".change_email\").html(\"<label>Saving email...  Please wait.</label>\");\n";
    output += "}\n";
    output += "if (this.readyState == 4 && this.status == 0) {\n\n";
    output += "$(\".change_email\").html(\"<label>Sorry, your email was not saved.  Check your internet connection.</label>\");\n";
    output += "}\n";
    output += "if (this.readyState == 4 && this.status == 200) {\n\n";
    output += "$(\".change_email\").html(this.responseText);\n";
    output += "}\n";
    output += "};\n\n";
    output += "xhttp.open(\"POST\", \"" + this.use_config.third_party_domain() + "/change-personal-information\");\n";
    output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
    output += "xhttp.send(\"email=\" + $(\"#email\").val() + \"&save_email=" + personal_information[row][1] + "&admin_session=" + personal_information[row][1] + "\");\n";
    output += "}\n\n";
    output += "function undo_email_changes() {\n\n";
    output += "var xhttp = new XMLHttpRequest();\n\n";
    output += "xhttp.onreadystatechange = function() {\n\n";
    output += "if (this.readyState == 4 && this.status == 200) {\n\n";
    output += "$(\".change_email\").html(this.responseText);\n";
    output += "}\n";
    output += "};\n\n";
    output += "xhttp.open(\"POST\", \"" + this.use_config.third_party_domain() + "/change-personal-information\");\n";
    output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
    output += "xhttp.send(\"cancel_changes=" + personal_information[row][1] + "&admin_session=" + personal_information[row][1] + "\");\n";
    output += "}\n\n";
    output += "</script>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label><b>Edit email</b></label><br /><br />\n";
    output += "</div>\n";
    output += "<div id='update_email_prompt' style='text-align: left; display: none'>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label>* indicates required field</label><br /><br />\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label>Email:* Example: <b>johndoe@hotmail.com</b></label>\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<input type='text' id='email' value='" + this.find_and_replace(personal_information[row][4]) + "' style='width: 97.5%' />\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<br /><input type='button' id='change_email' onclick='update_email()' value='Save changes' /><br /><br />\n";
    output += "<input type='button' id='cancel_email_changes' onclick='undo_email_changes()' value='Cancel' /><br /><br />\n";
    output += "<div class=\"change_email\"></div><br />\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "<div class='update_personal_information_button_section' id='update_email_button_section' style='text-align: left; display: none'>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label><b>Email:</b> " + this.find_and_replace(personal_information[row][4]) + "</label>\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<br /><input type='button' id='open_email_prompt' onclick='access_email_prompt()' value='Change' /><br /><br /><br />\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "<div style='text-align: left; width: 100%'>\n";
    output += "<div style='text-align: left; width: 100%'>\n";
    output += "<script type='text/javascript'>\n";
    output += "function access_username_prompt() {\n\n";
    output += "$(\"#update_basic_information_prompt\").slideUp(1200);\n";
    output += "$(\"#update_email_prompt\").slideUp(1200);\n";
    output += "$(\"#update_username_button_section\").slideUp(1200);\n";
    output += "$(\"#update_password_prompt\").slideUp(1200);\n";
    output += "$(\"#update_basic_information_button_section\").slideDown(1200);\n";
    output += "$(\"#update_email_button_section\").slideDown(1200);\n";
    output += "$(\"#update_username_prompt\").slideDown(1200);\n";
    output += "$(\"#update_password_button_section\").slideDown(1200);\n";
    output += "}\n\n";
    output += "function update_username() {\n\n";
    output += "var xhttp = new XMLHttpRequest();\n\n";
    output += "xhttp.onreadystatechange = function() {\n\n";
    output += "if (this.readyState == 0 || this.readyState == 1 || this.readyState == 2 || this.readyState == 3) {\n\n";
    output += "$(\".change_username\").html(\"<label>Saving username...  Please wait.</label>\");\n";
    output += "}\n";
    output += "if (this.readyState == 4 && this.status == 0) {\n\n";
    output += "$(\".change_username\").html(\"<label>Sorry, your username was not saved.  Check your internet connection.</label>\");\n";
    output += "}\n";
    output += "if (this.readyState == 4 && this.status == 200) {\n\n";
    output += "$(\".change_username\").html(this.responseText);\n";
    output += "}\n";
    output += "};\n\n";
    output += "xhttp.open(\"POST\", \"" + this.use_config.third_party_domain() + "/change-personal-information\");\n";
    output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
    output += "xhttp.send(\"username=\" + $(\"#username\").val() + \"&save_username=" + personal_information[row][1] + "&admin_session=" + personal_information[row][1] + "\");\n";
    output += "}\n\n";
    output += "function undo_username_changes() {\n\n";
    output += "var xhttp = new XMLHttpRequest();\n\n";
    output += "xhttp.onreadystatechange = function() {\n\n";
    output += "if (this.readyState == 4 && this.status == 200) {\n\n";
    output += "$(\".change_username\").html(this.responseText);\n";
    output += "}\n";
    output += "};\n\n";
    output += "xhttp.open(\"POST\", \"" + this.use_config.third_party_domain() + "/change-personal-information\");\n";
    output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
    output += "xhttp.send(\"cancel_changes=" + personal_information[row][1] + "&admin_session=" + personal_information[row][1] + "\");\n";
    output += "}\n\n";
    output += "</script>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label><b>Edit username</b></label><br /><br />\n";
    output += "</div>\n";
    output += "<div id='update_username_prompt' style='text-align: left; display: none'>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label>* indicates required field</label><br /><br />\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label>Username:* (Username must contain at least three characters.  Username is allowed to contain letters, numbers, and symbols.  Symbols include !, $, #, etc.  Username must not contain any spaces. Username must not be the same as your password.)</b></label>\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<input type='text' id='username' value='" + this.find_and_replace(personal_information[row][5]) + "' style='width: 97.5%' />\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<br /><input type='button' id='change_username' onclick='update_username()' value='Save changes' /><br /><br />\n";
    output += "<input type='button' id='cancel_username_changes' onclick='undo_username_changes()' value='Cancel' /><br /><br />\n";
    output += "<div class=\"change_username\"></div><br />\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "<div class='update_personal_information_button_section' id='update_username_button_section' style='text-align: left; display: none'>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label><b>Username:</b> " + this.find_and_replace(personal_information[row][5]) + "</label>\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<br /><input type='button' id='open_username_prompt' onclick='access_username_prompt()' value='Change' /><br /><br /><br />\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "<div style='text-align: left; width: 100%'>\n";
    output += "<div style='text-align: left; width: 100%'>\n";
    output += "<script type='text/javascript'>\n";
    output += "function access_password_prompt() {\n\n";
    output += "$(\"#update_basic_information_prompt\").slideUp(1200);\n";
    output += "$(\"#update_email_prompt\").slideUp(1200);\n";
    output += "$(\"#update_username_prompt\").slideUp(1200);\n";
    output += "$(\"#update_password_button_section\").slideUp(1200);\n";
    output += "$(\"#update_basic_information_button_section\").slideDown(1200);\n";
    output += "$(\"#update_email_button_section\").slideDown(1200);\n";
    output += "$(\"#update_username_button_section\").slideDown(1200);\n";
    output += "$(\"#update_password_prompt\").slideDown(1200);\n";
    output += "}\n\n";
    output += "function update_password() {\n\n";
    output += "var xhttp = new XMLHttpRequest();\n\n";
    output += "xhttp.onreadystatechange = function() {\n\n";
    output += "if (this.readyState == 0 || this.readyState == 1 || this.readyState == 2 || this.readyState == 3) {\n\n";
    output += "$(\".change_password\").html(\"<label>Saving password...  Please wait.</label>\");\n";
    output += "}\n";
    output += "if (this.readyState == 4 && this.status == 0) {\n\n";
    output += "$(\".change_password\").html(\"<label>Sorry, your password was not saved.  Check your internet connection.</label>\");\n";
    output += "}\n";
    output += "if (this.readyState == 4 && this.status == 200) {\n\n";
    output += "$(\".change_password\").html(this.responseText);\n";
    output += "}\n";
    output += "};\n\n";
    output += "xhttp.open(\"POST\", \"" + this.use_config.third_party_domain() + "/change-personal-information\");\n";
    output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
    output += "xhttp.send(\"current_password=\" + $(\"#current_password\").val() + \"&new_password=\" + $(\"#new_password\").val() + \"&confirm_new_password=\" + $(\"#confirm_new_password\").val() + \"&save_password=" + personal_information[row][1] + "&admin_session=" + personal_information[row][1] + "\");\n";
    output += "}\n\n";
    output += "function undo_password_changes() {\n\n";
    output += "var xhttp = new XMLHttpRequest();\n\n";
    output += "xhttp.onreadystatechange = function() {\n\n";
    output += "if (this.readyState == 4 && this.status == 200) {\n\n";
    output += "$(\".change_password\").html(this.responseText);\n";
    output += "}\n";
    output += "};\n\n";
    output += "xhttp.open(\"POST\", \"" + this.use_config.third_party_domain() + "/change-personal-information\");\n";
    output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
    output += "xhttp.send(\"cancel_changes=" + personal_information[row][1] + "&admin_session=" + personal_information[row][1] + "\");\n";
    output += "}\n\n";
    output += "</script>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label><b>Edit password</b></label><br /><br />\n";
    output += "</div>\n";
    output += "<div id='update_password_prompt' style='text-align: left; display: none'>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label>* indicates required field</label><br /><br />\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label>Current password:*</b></label>\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<input type='password' id='current_password' style='width: 97.5%' />\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label>New password:* (Password must contain at least eight characters, including at least one uppercase letter, and two numeric characters.  Password is allowed to contain symbols, such as !, $, #, etc.  Password must not be the same as your username.)</b></label>\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<input type='password' id='new_password' style='width: 97.5%' />\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<label>Confirm new password:*</b></label>\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<input type='password' id='confirm_new_password' style='width: 97.5%' />\n";
    output += "</div>\n";
    output += "<div style='text-align: left'>\n";
    output += "<br /><input type='button' id='change_password' onclick='update_password()' value='Save changes' /><br /><br />\n";
    output += "<input type='button' id='cancel_password_changes' onclick='undo_password_changes()' value='Cancel' /><br /><br />\n";
    output += "<div class=\"change_password\"></div><br />\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "<div class='update_personal_information_button_section' id='update_password_button_section' style='text-align: left; display: none'>\n";
    output += "<br /><input type='button' id='open_password_prompt' onclick='access_password_prompt()' value='Change' /><br /><br /><br />\n";
    output += "</div>\n";
    output += "</div>\n";
    output += "</div>\n";
   }

   output += "</div>\n";
  }

  return output;
 }
}
