/**
 * 
 */
package cps406_iteration_3;

/**
 * @author Daniel
 * Adds reports if logged in
 */
public class Report {


/**
 * @param memory
 * @param address
 * @param number
 * @return if report was written to memory
 */
public static boolean addReport(Data_repository memory, String address, String number){
return memory.writeReport(address, number);

}


/**
 * @param memory
 * @param username
 * @param address
 * @param number
 * @return if report was deleted
 */
public static boolean deleteReport(Data_repository memory, String username, String address, String number){
	return memory.deleteReport(username, address, number);
	
}
/**
 * @param memory
 * @param rAddress
 * @param rnumber
 * @param address
 * @param number
 * @return if report was editted correctly
 */
public static boolean editReport(Data_repository memory, String rAddress, String rnumber, String address, String number){
	return memory.editReport(rAddress, rnumber, address, number);
}
}
