<?php
	$first_name = $_GET['first_name'];
	$last_name = $_GET['last_name'];
	$email = $_GET['email'];
	$username = $_GET['username'];
	$password = $_GET['password'];
	
	//This constant is for media, javascript, and HTML files.
	define('TIMOTHYS_DIGITAL_SOLUTIONS_ADDRESS_FILE_PATH', 'https://' . $_SERVER['SERVER_NAME']);
	
	define('TIMOTHYS_DIGITAL_SOLUTIONS_WEBSITE_NAME', 'TDS Cloud');
	define('TIMOTHYS_DIGITAL_SOLUTIONS_EMAIL_ADDRESS', 'timothys@timothysdigitalsolutions.com');
	
	function send_email($first_name, $last_name, $username, $password, $email) {
		
		//Multiple recipients
		$to = $email; // note the comma
		
		//Subject
		$subject = 'Traffic Monitor - Registration info for ' . $first_name;
		
		//Message
		$message = "<!DOCTYPE html>\r\n";
		$message .= "<html xmlns=\"https://www.w3.org/1999/xhtml\">\r\n";
		$message .= "<head>\r\n";
		$message .= "<title>Traffic Monitor - Registration info for " . $first_name . "</title>\r\n";
		$message .= "</head>\r\n";
		$message .= "<body>\r\n";
		$message .= "<style>\r\n";
		$message .= "p { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #000000; cursor: text; }\r\n";
		$message .= "a { text-decoration: none; font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #e20000; cursor: pointer; }\r\n";
		$message .= "a:hover, a:focus, a:visited { text-decoration: underline; font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #e20000; cursor: pointer; }\r\n";
		$message .= "</style>\r\n";
		$message .= "<div style=\"text-align: center\">\n";
		$message .= "<a href=\"" . TIMOTHYS_DIGITAL_SOLUTIONS_ADDRESS_FILE_PATH . "/third-party-web-apps/apps/traffic-monitor/admin.php\"><img alt='receipt-logo.jpg' src='" . TIMOTHYS_DIGITAL_SOLUTIONS_ADDRESS_FILE_PATH . "/third-party-web-apps/images/receipt-logo.jpg' style='width: 25%' /></a>\n";
		$message .= "</div>\r\n";
		$message .= "<div style=\"text-align: center\">\n";
		$message .= "<label>Traffic Monitor</label>\n";
		$message .= "</div><br /><br />\r\n";
		
		if ($password == 'Password12') {
			
			$message .= "<div style=\"text-align: left\"><p>Hi " . $first_name . ", your new account is ready to use.  You might want to keep this message for your records.  Changing your password is strongly recommended.</p></div>\r\n";
		} else {
			
			$message .= "<div style=\"text-align: left\"><p>Hi " . $first_name . ", your new account is ready to use.  You might want to keep this message for your records.</p></div>\r\n";
		}
		
		$message .= "<div style=\"text-align: left\">\r\n";
		$message .= "<p>\r\n";
		$message .= "<b>First name:</b> " . $first_name . "<br />\r\n";
		$message .= "<b>Last name:</b> " . $last_name . "<br />\r\n";
		$message .= "<b>Username:</b> " . $username . "<br />\r\n";
		$message .= "<b>Password:</b> " . $password . "<br />\r\n";
		$message .= "</p>\r\n";
		$message .= "</div>\r\n";
		$message .= "<div style=\"text-align: left\">\r\n";
		$message .= "<p>\r\n";
		$message .= "<b><a href=\"" . TIMOTHYS_DIGITAL_SOLUTIONS_ADDRESS_FILE_PATH . "/third-party-web-apps/apps/traffic-monitor/admin.php\">Log in</a></b><br />\r\n";
		$message .= "</p>\r\n";
		$message .= "</div>\r\n";
		$message .= "<div style=\"text-align: left\"><p>Do not reply to this message.</p></div>\r\n";
		$message .= "</body>\r\n";
		$message .= "</html>\r\n";
		
		// To send HTML mail, the Content-type header must be set
		$headers[] = 'MIME-Version: 1.0';
		$headers[] = 'Content-type: text/html; charset=iso-8859-1';
		
		// Additional headers
		$headers[] = 'From: ' . TIMOTHYS_DIGITAL_SOLUTIONS_WEBSITE_NAME . ' <' . TIMOTHYS_DIGITAL_SOLUTIONS_EMAIL_ADDRESS . '>';
		$headers[] = 'Reply-To: ' . TIMOTHYS_DIGITAL_SOLUTIONS_EMAIL_ADDRESS;
		$headers[] = 'X-Mailer: PHP/' . phpversion();
		
		// Mail it
		mail($to, $subject, $message, implode("\r\n", $headers));
	}
	
	send_email($first_name, $last_name, $username, $password, $email);
