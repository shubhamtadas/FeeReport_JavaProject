package com.main;

public class Admin {
	boolean adminLogin(String name, String pass)	// for Admin Login
	{

		String givenName = "admin", givenPassword = "admin123";
		boolean nameCheck = name.equals(givenName);
		boolean passCheck = pass.endsWith(givenPassword);
		if(nameCheck && passCheck) {
			return true;	// for successful admin login
		}
		else
			return false;	// for incorrect credentials
	}
}