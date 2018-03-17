package cps406_iteration_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Daniel, Dylan, Issam, Oliver
 *Sends notifcations to user by adding it to notification list
 */
public class Notification {
private static final String FILENAME4 = "C:\\Users\\Daniel\\Desktop\\notificationList.txt";	

/**
 * @param users	- list of users to message
 * 
 * Adds username to list of people to notify
 * 
 * @return true or false if notification added to list
 */
public static boolean messageUser(ArrayList<String> users){
	String content;
	//open file for writing
	 File log = new File(FILENAME4);
			    try{
			    	//if no file exists make one
			    if(log.exists()==false){
			            log.createNewFile();
			    }
			    //write to file a string with user info
			    PrintWriter out = new PrintWriter(new FileWriter(log, true));
				for(int i =0; i<users.size(); i++){
				out.append(users.get(i));}
			    out.close();
			    return true;
			    }catch(IOException e){
			    	//Error caught
			        System.out.println("ERROR");
			        return false;
			    }
}
}
