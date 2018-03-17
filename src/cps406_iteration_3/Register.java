package cps406_iteration_3;

import java.io.*;
import java.util.Scanner;

/**
 * @author Daniel, Dyaln, Issam, Oliver
 * Register gets external info about user to create user
 * in database
 */
public class Register {
	private static final String FILENAME = "C:\\Users\\Daniel\\Desktop\\userList.txt";	
	private static String pass, user;
	private static Scanner scan = new Scanner(System.in);
	private static Data_repository memory;
	
/**
 * @param m 
 * gets shared memory space
 */
public Register(Data_repository m){
	memory=m;
}


/**
 * @param user	- Username to be checked for availability
 * 
 * Reads through userlist and checks if user name is taken
 * 
 * @return true if username is free, false if taken and must be repeated until true
 */
public static boolean makeLoginName(String user){
	
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

		String sCurrentLine;
		String [] pieces;
		while ((sCurrentLine = br.readLine()) != null) {
			pieces = sCurrentLine.split(" ");
			if(user.substring(0).equals(pieces[11])){
				System.out.println("Username taken");
				return false;
			}
		}
		return true;
	} catch (IOException e) {
		return false;
	}
}

/**
 * adds password to information to be put on userList
 * @return true since password doesn't need to be checked
 */
public static boolean makeLoginPassword(){
	System.out.println("Password:");
	pass = scan.nextLine();
	return true;
}


/**
 * Enter user information and send to memory to add to userList
 * @return
 */
public static boolean enterInformation(){
	System.out.println("First Name:");
	String firstN= scan.nextLine();
	System.out.println("Last Name:");
	String lastN = scan.nextLine();
	System.out.println("address");
	String address = scan.nextLine();
	System.out.println("Phone Number:");
	String phone = scan.nextLine();
	System.out.println("Email Address");
	String email = scan.nextLine();
	memory.saveUser(firstN, lastN, address, phone, email, user, pass);
	return true;
}

/**
 * Check strength of password based on length of string
 * @return true
 */
public static boolean isPasswordSecure(){
	if(pass.length()>15)System.out.println("Strong");
	else if(pass.length()>7 && pass.length()<15)System.out.println("Medium");
	else System.out.println("weak");
	return true;
}
}
