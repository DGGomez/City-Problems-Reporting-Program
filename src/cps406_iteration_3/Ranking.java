package cps406_iteration_3;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Daniel
 * Ranks report by comparing same address and numbers
 */
public class Ranking {
private static final String FILENAME = "C:\\Users\\Daniel\\Desktop\\reportList.txt";	
private static final String FILENAME2 = "C:\\Users\\Daniel\\Desktop\\rankingList.txt";	

//add to file
/**
 * @param memory	- shared memory to read reportList
 * 
 * Reads reportList and puts comparing part in an ArrayList
 * This arrayList will be needed later for counting rank
 * 
 * @return true or false if successful ranking
 */
public boolean addReportRank(Data_repository memory){
	try {
		//read reportList file
		FileReader fr = new FileReader(FILENAME);
		BufferedReader br = new BufferedReader(fr);

		String sCurrentLine;
		String check;
		ArrayList<String> parts= new ArrayList<String>();
		
		/** read line by line and put the address and number
		*	into arrayList for easier counting
		*/
		while ((sCurrentLine = br.readLine()) != null) {	
			String[] pieces =sCurrentLine.split(" ");	
			check = pieces[2]+" "+pieces[3]+" "+pieces[4]+" "+pieces[5];
			parts.add(check);
		}
		//send report list to edit for ranking
		editReportRank(memory,parts);
		return true;

	} catch (IOException e) {
		
		return false;}
	
}

/**
 * @param memory	- shared memory to write to report
 * @param parts		- Arraylist that holds all reports address and number
 * 
 * Adds ranking to list from a list of report info. Overwrites
 * last list since reports will constantly be changed.
 * 
 * @return true or false if ranking is successful
 */
public boolean editReportRank(Data_repository memory, ArrayList<String>parts){
	
	String content;
	String check;

	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME2))) {
		
		//counts same strings and removes them from list
		for(int j =0; j<parts.size(); j++){
			int count=1;
			check = parts.get(j);
				for(int k=j+1; k<parts.size(); k++){
				if(check.substring(0).equals(parts.get(k))){
					count++;
					parts.remove(k);
				}
			}
			content = "Rank: "+count+" "+check+"\n";
			bw.write(content);
			}
		//orders ranking
		memory.listOfTopReports();
		
		return true;
	} catch (IOException e) {
		return false;
	}
}

//To-DO
public String showReportRank(){
	return "";
}

}
