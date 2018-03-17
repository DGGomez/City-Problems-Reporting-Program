package cps406_iteration_3;

/**
 * @author Daniel,Dylan, Oliver, Issam
 *Controls login, logout and user changes
 */
public class SecurityManager {
	private static String state; //all user info
	/**
	 * @param memory	- shared memory space
	 * @param user		- Username for accessing account
	 * @param pass		- Password for accessing acount
	 * 
	 * Takes given username and password and sends it to 
	 * Data repository to check if it is in the database
	 * if it is the it will return a string of user info
	 * 
	 * @return true or false whether login successful
	 */
	public static boolean validateUser(Data_repository memory, String user, String pass){
	 state = memory.getAuthentication(user,pass);
		return !state.isEmpty();
	}
	public static boolean changeInfo(Data_repository memory,String firstN, String lastN,
			String address, String phone, String email){
		
		return memory.changeUserInfo(firstN, lastN, address, phone, email);
	}
	
	public static void cancelLogin(){
		//logic to go back to gui
	}
	public static boolean logout(Data_repository memory){
	//to-do
		return true;
	}
	public static boolean validateSecurityInfo(){
		//to-do
		return true;
	}
}
