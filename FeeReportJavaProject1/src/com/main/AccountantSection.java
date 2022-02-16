package com.main;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccountantSection {
	
	boolean accountantLogin(String acc_name, String acc_password)	// for Accountant Login
	{
		boolean flag = false;
		try {
			String line = "";
			FileReader F1 = new FileReader("AccountantData.txt");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(F1);
			while((line =br.readLine())!=null){
				
				if(line.indexOf(acc_name)!=-1 && line.indexOf(acc_password)!=-1) {
					flag = true;
				}
			}
		}
		catch(IOException e){
			System.out.println("An error Occurred!\n");
		}
		if(flag){
			return true;	// for successful login
		}
		else{
			return false;	// for invalid credentials
		}
	}
	
	void addAccountant(Accountant acct) {
		try
		{
  	      File myObj = new File("AccountantData.txt");
  	      if (myObj.createNewFile()) {
  	        System.out.println("File created: " + myObj.getName());
  	      }
  	      else
  	      {
  	        System.out.println("File already exists.");
  	      }
  	      FileWriter fw = new FileWriter(myObj, true); 
  	      BufferedWriter bw = new BufferedWriter(fw);
  	      String lineToAppend=("\n"+acct.getId()+"\t\t"+acct.getName()+"\t\t"+acct.getPassword()+"\t\t"+acct.getEmail()+"\t\t"+acct.getContactno());    
  	      bw.write(lineToAppend);
  	      bw.close();
          
  	    } catch (IOException e) {
  	      System.out.println("An error occurred.");
  	      e.printStackTrace();
  	    }
	}
	void viewAccountant() {
		try 
		{  
			File file = new File("AccountantData.txt");   
			if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
			{  
			System.out.println("Not supported");  
			return;  
			}  
			Desktop desktop = Desktop.getDesktop();  
			if(file.exists())         //checks file exists or not  
			desktop.open(file);              //opens the specified file  
		}  
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}  
	}

}