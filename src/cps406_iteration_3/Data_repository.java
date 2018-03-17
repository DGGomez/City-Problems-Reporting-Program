package cps406_iteration_3;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Daniel, Dylan, Issam, Oliver
 *Data Repository for controlling, deleting and editing memory
 */
public class Data_repository {
	//files to be opened
	private static final String FILENAME = "C:\\Users\\Daniel\\Desktop\\userList.txt";	
	private static final String FILENAME2 = "C:\\Users\\Daniel\\Desktop\\reportList.txt";	
	private static final String FILENAME3 = "C:\\Users\\Daniel\\Desktop\\rankingList.txt";	
	private static final String FILENAME4 = "C:\\Users\\Daniel\\Desktop\\notificationList.txt";	
	
	//currently logged in user
	private static String username=""; 
	private static boolean loggedIn=false;
/**
 * @param address	- Address of problem
 * @param number	- Report problem number
 * @param username	- User that has requested the report
 * 
 * Save report on a list for Ranking
 * 
 * @return true or false if report was saved successfully
 */
public boolean writeReport(String address, String number){
	
	String content;
	//Open a file to write to
	 File log = new File(FILENAME2);
			    try{
			    	//if no file exists create one
			    if(log.exists()==false){
			            log.createNewFile();
			    }
			    //write out line of text that describes report to file
			    PrintWriter out = new PrintWriter(new FileWriter(log, true));
					content = "Username: "+username+" ,Address: "+address.toUpperCase().replaceAll("\\s", "")+" ,Report_number: "+number+"\n";
				out.append(content);
			    out.close();
			    return true;
			    }catch(IOException e){
			    	//error occured report couldn't be saved
			        System.out.println("ERROR");
			        return false;
			    }
}

/**
 * @param username	- User requesting to delete one of his reports
 * @param address	- Address of report
 * @param number	- Report problem number
 * 
 * Go through report list and copy all reports that don't 
 * have the same info as the requested report. The file is
 * deleted and replaced with the list without the requested
 * report.
 * 
 * @return true or false if report was deleted successfully
 */
public boolean deleteReport(String username, String address, String number){

	String sCurrentLine;
	String report = "Username: "+username+" ,Address: "+address.toUpperCase().replaceAll("\\s", "")+" ,Report_number: "+number;
//arraylist for reports that won't be deleted	
	ArrayList<String> nonDeletedReports=new ArrayList<String>();
	
	//read file
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME2))) {

		while ((sCurrentLine = br.readLine()) != null) {
			if(report.substring(0).equals(sCurrentLine)){
			}
			else
			nonDeletedReports.add(sCurrentLine);
		}
	} catch (IOException e) {
		//exception caught while reading
	}
	//Overwrite the file with arraylist
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME2))) {
		for(int i =0; i<nonDeletedReports.size();i++){
			bw.write(nonDeletedReports.get(i));
		}
		return true;
	} catch (IOException e) {
		//exception caught while writing
		return false;
	}
}

/**
 * @param rAddress	- address for report to be removed
 * @param rnumber	- number for report to be removed
 * @param user		- Username for request
 * @param address	- address for edit report
 * @param number	- number for edit report
 * 
 * Swap old report for new report
 * 
 * @return
 */
public boolean editReport(String rAddress, String rnumber, String address, String number){
	String sCurrentLine;
	String report = "Username: "+username+" ,Address: "+rAddress.toUpperCase().replaceAll("\\s", "")+" ,Report_number: "+rnumber;
	String newreport = "Username: "+username+" ,Address: "+address.toUpperCase().replaceAll("\\s", "")+" ,Report_number: "+number;

	//arraylist for reports that won't be deleted	
	ArrayList<String> nonDeletedReports=new ArrayList<String>();
	
	//read file
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME2))) {

		while ((sCurrentLine = br.readLine()) != null) {
			if(report.substring(0).equals(sCurrentLine)){
			nonDeletedReports.add(newreport);
			}
			else
			nonDeletedReports.add(sCurrentLine);
		}
	} catch (IOException e) {
		//exception caught while reading
	}
	//Overwrite the file with arraylist
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME2))) {
		for(int i =0; i<nonDeletedReports.size();i++){
			bw.write(nonDeletedReports.get(i));
		}
		return true;
	} catch (IOException e) {
		//exception caught while writing
		return false;
	}
}

/**
 * Takes the ranking list and puts it in order while
 * removing all other reports of the same rank
 * except one until after they are chosen to give
 * order. After the priority report is chosen the one
 * that was removed will take its place
 * 
 * @return
 */
public boolean listOfTopReports(){
	//Organize reports by rank
	SortedMap<Integer,String> tr=new TreeMap<Integer, String>();
	String sCurrentLine;
	String []pieces;
	//read reports
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME3))) {

		while ((sCurrentLine = br.readLine()) != null) {
			pieces=sCurrentLine.split(" ");
			tr.put(Integer.parseInt(pieces[1]),sCurrentLine);
		}
	} catch (IOException e) {
	}
	ArrayList<String>contents = new ArrayList<String>();
	int count=0;
	//put organized reports into an array 
	for(int key:tr.keySet()){
		contents.add(tr.get(key));
	}
	//write reports to file backwards to get them printed in order
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME3))) {
		for(int i =contents.size()-1; i>=0; i--){
			bw.write(contents.get(i));
		}
		return true;
	} catch (IOException e) {
		return false;
	}
}

/**
 * @param firstN	- User's first name
 * @param lastN		- User's last name
 * @param address	- User's address
 * @param phone		- User's phone number
 * @param email		- User's email
 * @param user		- User's username
 * @param pass		- User's password
 * 
 * Get user info and save their user information for
 * login and reporting.
 * 
 * @return true or false if the User is saved
 */
public boolean saveUser(String firstN, String lastN,
String address, String phone, String email, String user, 
String pass){

	String content;
	//open file for writing
	 File log = new File(FILENAME);
			    try{
			    	//if no file exists make one
			    if(log.exists()==false){
			            log.createNewFile();
			    }
			    //write to file a string with user info
			    PrintWriter out = new PrintWriter(new FileWriter(log, true));
	
				content = "First: "+firstN.toUpperCase()+" ,Last: "+lastN.toUpperCase()+" ,Address: "+address.toUpperCase()+" ,Phone_number: "+phone+" ,Email: "+email.toUpperCase()+" ,Username: "+user.toUpperCase()+" ,Password: "+pass.toUpperCase()+"\n";
			
				out.append(content);
			    out.close();
			    return true;
			    }catch(IOException e){
			    	//Error caught
			        System.out.println("ERROR");
			        return false;
			    }
	
}

/**
 * @param username	- User to be deleted
 * 
 * Usernames should already be checked for uniqueness 
 * the users that don't have this name will be copied on
 * to an arraylist and copied on to an overwrited user
 * list.
 * 
 * @return true or false if user is deleted successful
 */
public boolean deleteUser(String username){
	String sCurrentLine;
	username = username.toUpperCase();
	String []pieces; //the split of sCurrentLine to extract username
	
	//list of users that won't be deleted
	ArrayList<String> nonDeletedUsers=new ArrayList<String>();
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

		while ((sCurrentLine = br.readLine()) != null) {
		
			pieces= sCurrentLine.split(" ");
			//pieces[11] will always be username
			if(username.substring(0).equals(pieces[11])){	
			}
			else{
			nonDeletedUsers.add(sCurrentLine);}
		}

	} catch (IOException e) {
		//reading exception caught
	}
	//write to file all non-deleted Users
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
		for(int i =0; i<nonDeletedUsers.size();i++){
			bw.write(nonDeletedUsers.get(i));
		}
		return true;
	} catch (IOException e) {
		//writing exception caught
		return false;
	}
}


public boolean changeUserInfo(String firstN, String lastN,
		String address, String phone, String email){
	String sCurrentLine;
	String content = "First: "+firstN.toUpperCase()+" ,Last: "+lastN.toUpperCase()+" ,Address: "+address.toUpperCase()+" ,Phone_number: "+phone+" ,Email: "+email.toUpperCase()+" ,Username: "+username.toUpperCase()+" ,Password: ";

	//arraylist for reports that won't be deleted	
	ArrayList<String> nonDeletedUsers=new ArrayList<String>();
	
	//read file
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

		while ((sCurrentLine = br.readLine()) != null) {
			String [] pieces = sCurrentLine.split(" ");
			if(username.substring(0).equals(pieces[11])){
				content=content+pieces[13]+"\n";
				nonDeletedUsers.add(content);
			}
			else
				nonDeletedUsers.add(sCurrentLine);
		}
	} catch (IOException e) {
		//exception caught while reading
	}
	//Overwrite the file with arraylist
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
		for(int i =0; i<nonDeletedUsers.size();i++){
			bw.write(nonDeletedUsers.get(i));
		}
		return true;
	} catch (IOException e) {
		//exception caught while writing
		return false;
	}
}

/**
 * @param user	- Requester's username
 * @param pass	- Requester's password
 * 
 * User attempts to login in order to use CYPRESS
 * The username and password will be checked to 
 * user list.
 * 
 * @return string with user info
 */
public String getAuthentication(String user, String pass){
	//read userlist file
	user = user.toUpperCase();
	pass = pass.toUpperCase();
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
		String sCurrentLine;
		
		while ((sCurrentLine = br.readLine()) != null) {
			//splits sCurrentLine to find user and password
			String [] parts = sCurrentLine.split(" ");
					if(pass.substring(0).equals(parts[13])&&parts[11].substring(0).equals(user)){
						username=user;
						loggedIn=true;
						return sCurrentLine;
					}
			
		}
		return "";
	} catch (IOException e) {
		return "";
	
	}
}

//TO-DO but not priority
public boolean deleteNotification(){
	return true;
}

//TO-DO but not priority
public boolean getVote(){
	return true;
}

//TO-DO but not priority
public boolean writeSurvey(){
	return true;
}

//TO-DO but not priority
public boolean saveSurvey(){
	return true;
}

}
