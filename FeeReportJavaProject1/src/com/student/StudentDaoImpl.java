package com.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {

   @Override
   public void addStudent(Student st) {
	   try
		{
 	      File myObj = new File("StudentData.txt");
 	      if (myObj.createNewFile()) {
 	        System.out.println("\nFile created: " + myObj.getName());
 	      }
 	      else
 	      {
 	        System.out.println("\nFile already exists.");
 	      }
 	      FileWriter fw = new FileWriter(myObj, true); 
 	      BufferedWriter bw = new BufferedWriter(fw);
 	      String lineToAppend=("\n"+st.getRollNo()+"\t"+st.getName()+"\t"+st.getEmail()+"\t"+st.getCourse()+"\t"+st.getFee()+"\t"+st.getPaid()+"\t"+st.getDue()+"\t"+st.getAddress()+"\t"+st.getCity()+"\t"+st.getState()+"\t"+st.getCountry()+"\t"+st.getContact());    
 	      bw.write(lineToAppend);
 	      bw.close();
         
 	    } catch (IOException e) {
 	      System.out.println("An error occurred.");
 	      e.printStackTrace();
 	    }
   }

   @SuppressWarnings("finally")
@Override
   public String deuFee(String rollNo) {
	   // TODO Auto-generated method stub
	   File input = new File("StudentData.txt");
	   FileReader fr=null;
	
	   String str,dueDetail="";
	   try {
		   fr = new FileReader(input);
		   @SuppressWarnings("resource")
		   BufferedReader br = new BufferedReader(fr);
		
		   while((str=br.readLine()) != null) {
			   if(str.contains(rollNo)) {
				dueDetail = dueDetail + str;
			   }
		   }
	   }
	   catch(IOException e){
		   System.out.println("An error Occurred!\n");
	   }
	   finally {
		   return(dueDetail);
	   }
}
   
@SuppressWarnings("finally")
@Override
public String loadStudent(String roll) {
	 File input = new File("StudentData.txt");
	   FileReader fr=null;
	
	   String str,loadData="";
	   try {
		   fr = new FileReader(input);
		   @SuppressWarnings("resource")
		   BufferedReader br = new BufferedReader(fr);
		
		   while((str=br.readLine()) != null) {
			   if(str.contains(roll)) {
				loadData = loadData + str;
			   }
		   }
	   }
	   catch(IOException e){
		   System.out.println("An error Occurred!\n");
	   }
	   finally {
		   return(loadData);
	   }
}
	@Override
	public void updateStudent(String roll, String oldData, String newData)
	{
		try {
			
		String filePath = "StudentData.txt";
	    //Instantiating the Scanner class to read the file
	    Scanner sc = new Scanner(new File(filePath));
	    //instantiating the StringBuffer class
	    StringBuffer buffer = new StringBuffer();
	    //Reading lines of the file and appending them to StringBuffer
	    while (sc.hasNextLine()) {
	       buffer.append(sc.nextLine()+System.lineSeparator());
	    }
	    String fileContents = buffer.toString();
	    sc.close();
	   String newLine = roll + "\t" + newData;
	    fileContents = fileContents.replaceAll(oldData, newLine);
	   
	    @SuppressWarnings("resource")
		FileWriter writer = new FileWriter(filePath);
	
	    writer.append(fileContents);
	    writer.flush();
		}
		catch(IOException e){
			   System.out.println("An error Occurred!\n");
		}
	}

}