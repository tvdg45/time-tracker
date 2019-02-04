//Author: Timothy van der Graaff
package views;

public class Show_Third_Party_Accounts extends models.Third_Party_Accounts_Processor {
	
	public String show_websites(String[][] search_websites) {
		
		configuration.Config use_config = new configuration.Config();
		
		String output = "";
		
		if (search_websites[0][0] != "database error" && search_websites[0][0] != "no websites" && search_websites[0][0] != "not logged in") {
			
			output += "<script type='text/javascript'>\n";
			output += "var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz';\n";
			output += "var string_length = 15;\n";
			output += "var random_string = '';\n";
			output += "var r_num = 0;\n\n";
			output += "function add_website() {\n\n";
			output += "random_string = '';\n\n";
			output += "for (var i = 0; i < string_length; i++) {\n\n";
			output += "r_num = Math.floor(Math.random() * chars.length);\n";
			output += "random_string += chars.substring(r_num, r_num + 1);\n";
			output += "}\n\n";
			output += "var xhttp = new XMLHttpRequest();\n\n";
			output += "xhttp.onreadystatechange = function() {\n\n";
			output += "if (this.readyState == 0 || this.readyState == 1 || this.readyState == 2 || this.readyState == 3) {\n\n";
			output += "$(\".add_website\").html(\"<label>Saving website...  Please wait.</label>\");\n";
			output += "}\n";
			output += "if (this.readyState == 4 && this.status == 0) {\n\n";
			output += "$(\".add_website\").html(\"<label>Sorry, your website was not saved.  Check your internet connection.</label>\");\n";
			output += "}\n";
			output += "if (this.readyState == 4 && this.status == 200) {\n\n";
			output += "$(\".add_website\").html(this.responseText);\n";
			output += "}\n";
			output += "};\n\n";
			output += "xhttp.open(\"POST\", \"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/change-third-party-account.php\");\n";
			output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
			output += "xhttp.send(\"url=\" + $(\"#url\").val() + \"&token=\" + random_string + \"&add_website=Add website\");\n";
			output += "}\n";
			output += "</script>\n";
			output += "<div style='text-align: left; width: 100%'>\n";
			output += "<label>Choose a URL:</label>\n";
			output += "</div>\n";
			output += "<div style='text-align: left; width: 100%'>\n";
			output += "<input type='text' id='url' style='width: 97.5%' />\n";
			output += "</div>\n";
			output += "<div style='text-align: left; width: 100%'>\n";
			output += "<br /><input type='button' id='adding_website' onclick='add_website()' value='Add website' /><br /><br />\n";
			output += "</div>\n";
			output += "<div style='text-align: left; width: 100%'>\n";
			output += "<div class='add_website'></div>\n";
			output += "</div>\n";
			output += "<br /><br />\n";
			
			for (int row = 0; row < search_websites.length; row++) {
				
				output += "<script type=\"text/javascript\">\n";
				output += "var chars_" + search_websites[row][1] + " = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz';\n";
				output += "var string_length_" + search_websites[row][1] + " = 15;\n";
				output += "var random_string_" + search_websites[row][1] + " = '';\n";
				output += "var r_num_" + search_websites[row][1] + " = 0;\n\n";				
				output += "function confirm_change_url_" + search_websites[row][1] + "() {\n\n";
				output += "var xhttp = new XMLHttpRequest();\n\n";
				output += "xhttp.onreadystatechange = function() {\n\n";
				output += "if (this.readyState == 0 || this.readyState == 1 || this.readyState == 2 || this.readyState == 3) {\n\n";
				output += "$(\"#confirm_change_url_" + search_websites[row][1] + "\").html(\"<label>Saving website...  Please wait.</label>\");\n";
				output += "}\n";
				output += "if (this.readyState == 4 && this.status == 0) {\n\n";
				output += "$(\"#confirm_change_url_" + search_websites[row][1] + "\").html(\"<label>Sorry, your website was not saved.  Check your internet connection.</label>\");\n";
				output += "}\n";
				output += "if (this.readyState == 4 && this.status == 200) {\n\n";
				output += "$(\"#confirm_change_url_" + search_websites[row][1] + "\").html(this.responseText);\n";
				output += "}\n";
				output += "};\n\n";
				output += "xhttp.open(\"POST\", \"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/change-third-party-account.php\");\n";
				output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
				output += "xhttp.send(\"id=" + search_websites[row][1] + "&url=\" + $(\"#confirm_url_" + search_websites[row][1] + "\").val() + \"&change_url=Change URL\");\n";
				output += "}\n\n";
				output += "function change_token_" + search_websites[row][1] + "() {\n\n";
				output += "random_string_" + search_websites[row][1] + " = '';\n\n";
				output += "for (var i_" + search_websites[row][1] + " = 0; i_" + search_websites[row][1] + " < string_length; i_" + search_websites[row][1] + "++) {\n\n";
				output += "r_num_" + search_websites[row][1] + " = Math.floor(Math.random() * chars_" + search_websites[row][1] + ".length);\n";
				output += "random_string_" + search_websites[row][1] + " += chars_" + search_websites[row][1] + ".substring(r_num_" + search_websites[row][1] + ", r_num_" + search_websites[row][1] + " + 1);\n";
				output += "}\n\n";
				output += "var xhttp = new XMLHttpRequest();\n\n";
				output += "xhttp.onreadystatechange = function() {\n\n";
				output += "if (this.readyState == 0 || this.readyState == 1 || this.readyState == 2 || this.readyState == 3) {\n\n";
				output += "$(\"#change_token_" + search_websites[row][1] + "\").html(\"<label>Saving website...  Please wait.</label>\");\n";
				output += "}\n";
				output += "if (this.readyState == 4 && this.status == 0) {\n\n";
				output += "$(\"#change_token_" + search_websites[row][1] + "\").html(\"<label>Sorry, your website was not saved.  Check your internet connection.</label>\");\n";
				output += "}\n";
				output += "if (this.readyState == 4 && this.status == 200) {\n\n";
				output += "$(\"#change_token_" + search_websites[row][1] + "\").html(this.responseText);\n";
				output += "}\n";
				output += "};\n\n";
				output += "xhttp.open(\"POST\", \"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/change-third-party-account.php\");\n";
				output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
				output += "xhttp.send(\"id=" + search_websites[row][1] + "&token=\" + random_string_" + search_websites[row][1] + " + \"&change_token=Change token\");\n";
				output += "}\n\n";
				output += "function confirm_delete_website_" + search_websites[row][1] + "() {\n\n";
				output += "var xhttp = new XMLHttpRequest();\n\n";
				output += "xhttp.onreadystatechange = function() {\n\n";
				output += "if (this.readyState == 0 || this.readyState == 1 || this.readyState == 2 || this.readyState == 3) {\n\n";
				output += "$(\"#confirm_delete_website_" + search_websites[row][1] + "\").html(\"<label>Deleting website...  Please wait.</label>\");\n";
				output += "}\n";
				output += "if (this.readyState == 4 && this.status == 0) {\n\n";
				output += "$(\"#confirm_delete_website_" + search_websites[row][1] + "\").html(\"<label>Sorry, your website was not deleted.  Check your internet connection.</label>\");\n";
				output += "}\n";
				output += "if (this.readyState == 4 && this.status == 200) {\n\n";
				output += "$(\"#confirm_delete_website_" + search_websites[row][1] + "\").html(this.responseText);\n";
				output += "}\n";
				output += "};\n\n";
				output += "xhttp.open(\"POST\", \"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/change-third-party-account.php\");\n";
				output += "xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n";
				output += "xhttp.send(\"id=" + search_websites[row][1] + "&delete_website=Delete website\");\n";
				output += "}\n\n";
				output += "function show_source_code_" + search_websites[row][1] + "() {\n\n";
				output += "$('.source_code').slideUp();\n";
				output += "$('.change_url_confirmation').slideUp();\n";
				output += "$('.delete_website_confirmation').slideUp();\n";
				output += "$('#source_code_" + search_websites[row][1] + "').slideDown();\n";
				output += "}\n\n";
				output += "function hide_source_code_" + search_websites[row][1] + "() {\n\n";
				output += "$('.source_code').slideUp();\n";
				output += "$('.change_url_confirmation').slideUp();\n";
				output += "$('.delete_website_confirmation').slideUp();\n";
				output += "}\n\n";				
				output += "function change_url_" + search_websites[row][1] + "() {\n\n";
				output += "$('.source_code').slideUp();\n";
				output += "$('.change_url_confirmation').slideUp();\n";
				output += "$('.delete_website_confirmation').slideUp();\n";
				output += "$('#change_url_confirmation_" + search_websites[row][1] + "').slideDown();\n";
				output += "}\n\n";
				output += "function cancel_change_url_" + search_websites[row][1] + "() {\n\n";
				output += "$('.source_code').slideUp();\n";
				output += "$('.change_url_confirmation').slideUp();\n";
				output += "$('.delete_website_confirmation').slideUp();\n";
				output += "}\n\n";
				output += "function delete_website_" + search_websites[row][1] + "() {\n\n";
				output += "$('.source_code').slideUp();\n";
				output += "$('.change_url_confirmation').slideUp();\n";
				output += "$('.delete_website_confirmation').slideUp();\n";
				output += "$('#delete_website_confirmation_" + search_websites[row][1] + "').slideDown();\n";
				output += "}\n\n";
				output += "function cancel_delete_website_" + search_websites[row][1] + "() {\n\n";
				output += "$('.source_code').slideUp();\n";
				output += "$('.change_url_confirmation').slideUp();\n";
				output += "$('.delete_website_confirmation').slideUp();\n";
				output += "}\n\n";
				output += "</script>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<label><b>Authorized URL: </b> " + search_websites[row][2] + "</label>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<label><b>Token: </b> " + search_websites[row][3] + "</label>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<label><b>Memory plan: </b> " + search_websites[row][4] + "</label>\n";
				output += "</div>\n";
				
				if (search_websites[row][4].toLowerCase().contains("pay as you go".toLowerCase())) {
					
					output += "<div style='text-align: left; width: 100%'>\n";
					output += "<label><b>Memory limit: </b> " + this.convert_to_memory_unit(search_websites[row][5]) + "</label>\n";
					output += "</div>\n";					
				}
				
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<label><a href=\"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/admin.php?id=" + search_websites[row][1] + "\">View traffic</a> | <a href=\"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/admin.php?id=" + search_websites[row][1] + "&page=buy-memory\">Buy memory</a> | <a href=\"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/admin.php?id=" + search_websites[row][1] + "&page=submit-payment\">View cart</a> | <a href=\"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/admin.php?id=" + search_websites[row][1] + "&page=view-receipts\">View receipts</a> | <a href=\"#\" id=\"showing_source_code_" + search_websites[row][1] + "\" onclick=\"show_source_code_" + search_websites[row][1] + "()\">Show source code</a> | <a href=\"#\" id=\"changing_url_" + search_websites[row][1] + "\" onclick=\"change_url_" + search_websites[row][1] + "()\">Change URL</a> | <a href=\"#\" id=\"changing_token_" + search_websites[row][1] + "\" onclick=\"change_token_" + search_websites[row][1] + "()\">Change token</a> | <a href=\"#\" id=\"changing_token_" + search_websites[row][1] + "\" onclick=\"delete_website_" + search_websites[row][1] + "()\">Delete website</a></label>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<div id='change_token_" + search_websites[row][1] + "'></div>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%; display: none' class=\"source_code\" id=\"source_code_" + search_websites[row][1] + "\">\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<br /><label><a href=\"#\" class=\"hiding_source_code_" + search_websites[row][1] + "\" onclick=\"hide_source_code_" + search_websites[row][1] + "()\">Hide source code</a></label><br />\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<br /><label><b>Copy and paste the following source code to your website: </b></label>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%; border: 1px solid; padding-top: 5px; padding-bottom: 5px'>\n";
				output += "<div style='text-align: left; width: 98%; margin-left: 1%; margin-right: 1%'>\n";
				output += "<label>&lt;script src=\"https://socket-io-2.herokuapp.com/socket.io/socket.io.js\"&gt;&lt;/script&gt;</label><br />\n";
				output += "<label>&lt;script&gt;</label><br />\n";
				output += "<label>$(document).ready(function() {</label><br /><br />\n";
				output += "<label>$.ajax({</label><br /><br />\n";
				output += "<label>url: \"" + use_config.domain() + "/third-party-web-apps/apps/traffic-monitor/index.php?id=" + search_websites[row][1] + "&token=" + search_websites[row][3] + "&url=\" + document.location.href</label><br />\n";
				output += "<label>}).then(function(data) {</label><br /><br />\n";
				output += "<label>$(\".greeting_content\").html(data);</label><br />\n";
				output += "<label>});</label><br />\n";
				output += "<label>});</label><br />\n";
				output += "<label>&lt;/script&gt;</label><br />\n";
				output += "<label>&lt;div class=\"greeting_content\"&gt;&lt;/div&gt;</label>\n";
				output += "</div>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<br /><label><a href=\"#\" class=\"hiding_source_code_" + search_websites[row][1] + "\" onclick=\"hide_source_code_" + search_websites[row][1] + "()\">Hide source code</a></label>\n";
				output += "</div>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%; display: none' class='change_url_confirmation' id=\"change_url_confirmation_" + search_websites[row][1] + "\">\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<br /><label>Change URL:</label>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<input type='text' id='confirm_url_" + search_websites[row][1] + "' style='width: 97.5%' />\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<br /><input type='button' id='confirming_change_url_" + search_websites[row][1] + "' onclick='confirm_change_url_" + search_websites[row][1] + "()' value='Change URL' /><br /><br />\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<label><a href=\"#\" id=\"canceling_change_url_" + search_websites[row][1] + "\" onclick=\"cancel_change_url_" + search_websites[row][1] + "()\">Cancel</a></label>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<div id='confirm_change_url_" + search_websites[row][1] + "'></div>\n";
				output += "</div>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%; display: none' class='delete_website_confirmation' id=\"delete_website_confirmation_" + search_websites[row][1] + "\">\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<br /><label><b>Do you really want to delete this website?</b></label>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<label>Deleting this website means that you will lose all traffic logs associated with the given website.  In addition to this your receipts and settings for this corresponding website will also be destroyed!</label>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<label><a href=\"#\" id=\"confirming_delete_website_" + search_websites[row][1] + "\" onclick=\"confirm_delete_website_" + search_websites[row][1] + "()\">Delete anyway</a> | <a href=\"#\" id=\"canceling_delete_website_" + search_websites[row][1] + "\" onclick=\"cancel_delete_website_" + search_websites[row][1] + "()\">Cancel</a></label>\n";
				output += "</div>\n";
				output += "<div style='text-align: left; width: 100%'>\n";
				output += "<div id='confirm_delete_website_" + search_websites[row][1] + "'></div>\n";
				output += "</div>\n";
				output += "</div>\n";
				output += "<br /><br />\n";
			}
		} else {
			
			output += "<div style='text-align: left; width: 100%'>\n";
			output += "<label><b>You are not currently managing any websites.</b></label>\n";
			output += "</div>\n";
		}
		
		return output;
	}
}
