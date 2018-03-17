package cps406_iteration_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Daniel, Dylan, Issam, Oliver
 * check top ranked report and remove it from reportList
 * Then send list of people to notify.
 */
public class Resolution {
	private static final String FILENAME2 = "C:\\Users\\Daniel\\Desktop\\reportList.txt";	
	private static final String FILENAME3 = "C:\\Users\\Daniel\\Desktop\\rankingList.txt";	

/**
 * @param memory	- shared memory space
 * 
 * Reads rankingList and takes first one to send off.
 * Report is deleted off the report list and usernames
 * are put on a list to notify users.
 * 
 * @return true or false if successful
 */
public boolean sendReport(Data_repository memory){
	Notification notif = new Notification();
	String sCurrentLine;
	String [] pieces;
	String address="";
	String number="";
	ArrayList<String> usersToNotify= new ArrayList<String>();
	//read rankings and take address and number
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME3))) {
		sCurrentLine = br.readLine();
		pieces = sCurrentLine.split(" ");
		address=pieces[3];
		number = pieces[5];
	} catch (IOException e) {
	}
	//read reportList take username and delete report
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME2))) {

		while ((sCurrentLine = br.readLine()) != null) {
			pieces = sCurrentLine.split(" ");
			if(address.substring(0).equals(pieces[3])&&number.substring(0).equals(pieces[5])){
				usersToNotify.add(pieces[1]);
				memory.deleteReport(pieces[1], address, number);
			}
		}
		//send to notification
		notif.messageUser(usersToNotify);
	} catch (IOException e) {
	}
	return true;
}

//TO-DO
public boolean editReportResolution(){
	return true;
}

//TO-DO
public String showReportResolution(){
	return "";
}
}
