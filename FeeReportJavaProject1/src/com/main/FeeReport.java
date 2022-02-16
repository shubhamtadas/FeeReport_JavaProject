package com.main;

import java.util.*;
import com.student.*;

public class FeeReport {
	
Scanner sc = new Scanner(System.in);

public static void main(String[] agrs) {
		
	Admin adminLogin = new Admin();		
	AccountantSection acc_section = new AccountantSection();
		
	while(true){
		System.out.println("\n1. Admin Login \n2. Accountant Login \n3. Exit code");
		int n;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter '1' for Admin Login ; '2' for Accountant Login ; '3' for exit code ->> ");
		n = sc.nextInt();
			
		switch(n) {

/* ------------------------------- Admin Login & Section ------------------------------------*/

		case 1:
			System.out.print("\nName: ");
			String name = sc.next();
		
			System.out.print("\nPassword: ");
			String pass = sc.next();
				
			boolean login = adminLogin.adminLogin(name, pass);
			
			if(login) {
				System.out.println("\nLogin Successfully");
				boolean flag = false;
				do {
					System.out.println("\n1. Add Accountant \n2. View Accountant \n3. Logout");
					int k = sc.nextInt();
					
					switch(k) {
					case 1:
						System.out.println("Accountant Id: ");
						int accId = sc.nextInt();
						System.out.println("Accountant Name: ");
						String accName = sc.next();
						System.out.println("Password: ");
						String accPass = sc.next();
						System.out.println("Email: ");
						String accEmail = sc.next();
						System.out.println("Contact No: ");
						String accContact = sc.next();
						
						Accountant accLogin = new Accountant(accId,accName,accPass,accEmail,accContact);
						acc_section.addAccountant(accLogin);
						break;
							
					case 2:
						acc_section.viewAccountant();
						break;
							
					case 3:
						flag=true;
					}
				}while(flag==false);
					
			}
			else {
				System.out.println("\nIncoreect Name or Password");
			}
			break;
			
/* ----------------------------- Accountant Login & Section ----------------------------------*/

		case 2: 
			System.out.print("\nEnter the Accountant name : ");
			String accountant_name = sc.next();
				
			System.out.print("\nEnter the Password : ");
			String accountant_password = sc.next();
			
			boolean check = acc_section.accountantLogin(accountant_name,accountant_password);
			if(check) {
				StudentDao stObj = new StudentDaoImpl();
				System.out.println("\nLogin Successfully");
				boolean flag = false;
				do 
				{
					System.out.println("\n1. Add Student \n2. View Student \n3. Edit Student \n4. Due Fee \n5. Logout");
					int k = sc.nextInt();
						
					switch(k) 
					{
						case 1:
							System.out.println("Roll No: ");
							String stRoll = sc.next();
							
							System.out.println("Student Name: ");
							String stName = sc.next();
							
							System.out.println("Email: ");
							String stEmail = sc.next();
							
							System.out.println("Course: ");
							String stCourse = sc.next();
							
							System.out.println("Fee: ");
							int stFee = sc.nextInt();
							
							System.out.println("Paid: ");
							int stPaid = sc.nextInt();
							
							int stDue = stFee-stPaid;
							
							System.out.println("Address: ");
							String stAddress = sc.next();
							
							System.out.println("City: ");
							String stCity = sc.next();
							
							System.out.println("State: ");
							String stState = sc.next();
							
							System.out.println("Country: ");
							String stCountry = sc.next();
							
							System.out.println("Contact No: ");
							String stContact = sc.next();
							
							Student student = new Student(stRoll, stName, stEmail, stCourse, stFee, stPaid, stDue, stAddress, stCity, stState, stCountry, stContact);
							
							stObj.addStudent(student);
							System.out.println("\nStudent added successfully !!");
							
							break;
							
							case 2:
								System.out.println("Enter Roll no: ");
								String viewStud = sc.next();
								String s = stObj.loadStudent(viewStud);
								System.out.println(s);
								break;
							case 3:
								System.out.println("Enter Roll no: ");
								String updateRoll=sc.next();
								String oldStr = stObj.loadStudent(updateRoll);
								
//								System.out.println("Roll No: ");
//								String stuRoll = sc.next();
								
								System.out.println("Student Name: ");
								String stuName = sc.next();
								
								System.out.println("Email: ");
								String stuEmail = sc.next();
								
								System.out.println("Course: ");
								String stuCourse = sc.next();
								
								System.out.println("Fee: ");
								int stuFee = sc.nextInt();
								
								System.out.println("Paid: ");
								int stuPaid = sc.nextInt();
								
								int stuDue = stuFee-stuPaid;
								
								System.out.println("Address: ");
								String stuAddress = sc.next();
								
								System.out.println("City: ");
								String stuCity = sc.next();
								
								System.out.println("State: ");
								String stuState = sc.next();
								
								System.out.println("Country: ");
								String stuCountry = sc.next();
								
								System.out.println("Contact No: ");
								String stuContact = sc.next();
								String newStr = stuName + "\t" + stuEmail +"\t" + stuCourse +"\t" + stuFee +"\t" + stuPaid +"\t" + stuDue +"\t" + stuAddress +"\t" + stuCity +"\t" + stuState +"\t" + stuCountry +"\t" + stuContact;    
								stObj.updateStudent(updateRoll,oldStr,newStr);
								break;
							case 4:
								System.out.println("Enter Roll no: ");
								String searchRoll=sc.next();
								String due_detail = stObj.deuFee(searchRoll);
								System.out.println(due_detail);
								break;
							case 5:
								flag=true;
						}
					}while(flag==false);
				}
				else 
				{
					System.out.println("\nIncorrect Name or Password");
				}
				break;
/*------------------------------------ Exit Code --------------------------------------------*/		
			case 3:
				System.out.println("\nExit Code, Good Bye !!");
				System.exit(0);
				break;
			}
		}
	}
}