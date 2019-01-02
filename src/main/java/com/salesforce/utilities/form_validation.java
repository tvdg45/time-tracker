//Author: Timothy van der Graaff
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import java.util.regex.Matcher; 
import java.util.regex.Pattern;

import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.util.logging.*;  

package utilities;

public class Form_Validation {
	
	public static boolean is_string_null_or_white_space(String input_string) {
    
		if (input_string == null) {
			
			return true;
		}

		for (int i = 0; i < input_string.length(); i++) {
			
			if (!Character.isWhitespace(input_string.charAt(i))) {
				
				return false;
			}
		}

		return true;
	}
	
    public static boolean is_email_valid(String input_string) { 
        
		String email_regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		
        Pattern pattern = Pattern.compile(email_regex);
		
        if (input_string == null) {
            
			return false;
		} else {
			
			return pattern.matcher(input_string).matches();
		}
    }
	
	public static int number_of_white_spaces(String input_string) {
		
		int output = 0;
		
		output = input_string.length() - input_string.replaceAll(" ", "").length();
		
		return output;
	}
	
	public static int number_of_uppercase_characters(String input_string) {
		
		int output;
		
        char character;
        int uppercase = 0;
		int asciivalue = 0;
		
        for (int i = 0; i < input_string.length(); i++) {
			
            character = input_string.charAt(i);
			
            asciivalue = (int)character;
			
            if (asciivalue >= 65 && asciivalue <= 90) {
				
                uppercase++;
            }
        }
		
		output = uppercase;
		
		return output;
	}
}
