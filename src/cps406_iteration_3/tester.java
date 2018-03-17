package cps406_iteration_3;

import java.util.Scanner;

public class tester {
	private static boolean loggedIn= false;
	private static String user="";
	private static Ranking rank = new Ranking();
	
	public static void main(String[] args) {
		Data_repository memory = new Data_repository();
		login(memory);

	}
	public static void deleteReport(Data_repository memory,String user){
		Scanner scan = new Scanner(System.in);
		System.out.println("address");
		String address = scan.nextLine();
		System.out.println("1-8");
		String number = scan.nextLine();
		memory.deleteReport(user, address, number);
	}
	public static void deleteUser(Data_repository memory){
		Scanner scan = new Scanner(System.in);
		System.out.println("Username:");
		String user1 = scan.nextLine();
		memory.deleteUser(user1);
	}
	public static void register(Data_repository memory){
	Register reg = new Register(memory);
		reg.makeLoginName();
		reg.makeLoginPassword();
		reg.enterInformation();
	
	}
	public static void report(Data_repository memory, String username){
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Address");
	String address = scan.nextLine();
	System.out.println("1-8");
	String number = scan.nextLine();
	memory.writeReport(address,number, username);
	rank.addReportRank(memory);
	}
	
	public static void login(Data_repository memory){
		Scanner scan = new Scanner(System.in);
		System.out.println("username");
		String username= scan.next();
		System.out.println("password");
		String password = scan.next();
		String state = memory.getAuthentication(username,password);
		System.out.println(state);
		loggedIn=true;
		user= username;
	}

}
