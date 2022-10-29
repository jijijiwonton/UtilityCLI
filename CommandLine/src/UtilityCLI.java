/**
 * Program Description: CLI Utility Development Task1
 * Author name: Jiwon Hwang
 */

import java.util.Scanner;

/**
 * Import Library for more functions
 */
import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class UtilityCLI {
	
	static Scanner input = new Scanner(System.in);
	static LocalDate date = LocalDate.now();
	static LocalTime time = LocalTime.now();
	
	/**
	 * For code-reuse and readability, setting constant variables
	 */
	static final String GO_TO_ADAPTER_SEETTINGS = "0";			// done
	static final String GET_MY_LOCAL_LIST_OF_ADAPTERS = "1";    // variable 1
	static final String GET_MY_LOCAL_WIFI_IP_AND_MAC = "2";		// variable 2 only IP address and MAC address
	/*
	 * citation : https://imaitman.tistory.com/205
	 */
	static final String PING_GOOGLE = "3";						// done
	static final String PING_WITH_PARAMETERS = "4"; 			// done
	/*
	 * citation: https://bluemint.tistory.com/31
	 */
	static final String IPCONFIG_WITH_PARAMETERS = "5";			// done
	static String LIST_OF_COMMANDS = "L";
	static String EXIT = "E";
	
	static String choice ="";

	public static void main(String[] args) {
	
		/**
		 * Declaring a variable for a user-input
		 */
	
		System.out.println("CLI Utility Development for Prof. Risvan Coskun");
		System.out.println("<Jiwon Hwang>");
		// I will fix it with decimal formats for Time
		System.out.println("Date: " + date + " Time: " + time);
		System.out.println("Bonus Activity 1: Creation/Completion of this code template");
		
		menu();
	}
	
	/**
	 * Displaying options available
	 */
	private static void menu() {
		
		System.out.println("***********************************************************");
		System.out.println("List of available commands <case sensitive>");
		System.out.println("***********************************************************");
		System.out.println("GoToAdapterSettings <0>");
		System.out.println("GetMyLocalListOfAdapters <1>");
		System.out.println("GetMyLocalWiFiIpAndMAC <2>");
		System.out.println("ping google.ca <3>");
		System.out.println("ping -parameters- <4>");
		System.out.println("ipconfig -parameters- <5>");
		System.out.println("***********************************************************");
		System.out.println("L or l for list of commands " + LIST_OF_COMMANDS);
		System.out.println("E or e for exit: " + EXIT);
		System.out.println("***********************************************************");
		
		if(!choice.equalsIgnoreCase(EXIT)) {
			runProgram();
		}
	}
	
	private static void cmdInJava(String command, String parameter) {
		// Declare a variable for a command line Interface
		String cmd = command + " " + parameter;
		String cmdResult = "";
		
		try {
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(cmd);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String inputLine;
			
			while((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
				cmd += cmdResult;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	/**
	 * A method that executes a program runnable
	 */
	private static void runProgram() {
		
		while(!choice.equalsIgnoreCase(EXIT)) {
			System.out.println();
			System.out.print("Ready for a command:");
			choice = input.nextLine();
			
			boolean isCommands = choice.equalsIgnoreCase("l");
			boolean isExit = choice.equalsIgnoreCase("e");
			
			if(choice.equals(GO_TO_ADAPTER_SEETTINGS)) {
				System.out.println("GoToAdapterSettings: invoking the adapter settings....");
				System.out.println("Please wait....");
				String path = "C:\\\\windows\\\\system32\\\\control.exe ncpa.cpl";
				cmdInJava(path, null);
			} else if(choice.equals(GET_MY_LOCAL_LIST_OF_ADAPTERS)) {
				System.out.println("GetMyLocalListOfAdapters: invoking the local list of adapter settings....");
				System.out.println("Please wait....");
				cmdInJava("ipconfig", "");
			} else if(choice.equals(GET_MY_LOCAL_WIFI_IP_AND_MAC)) {
				System.out.println("GetMyLocalWiFiIpAndMAC: invoking the local WiFi IP and MAC settings....");
				System.out.println("Please wait....");
				// need to fix it
				cmdInJava("arp -a", "");
			} else if(choice.equals(PING_GOOGLE)) {
				System.out.println("ping google.com");
				System.out.println("Please wait....");
				cmdInJava("ping", "google.com");
			} else if(choice.equals(PING_WITH_PARAMETERS)) {
				System.out.print("Enter an IP address you want to test: ");
				String pingTestIP = input.nextLine();
				System.out.println("ping " + pingTestIP);
				System.out.println("Please wait....");
				cmdInJava("ping", pingTestIP);
			} else if(choice.equals(IPCONFIG_WITH_PARAMETERS)) {
				System.out.print("Enter a parameter you want to put with ipconfig: ");
				String ipconfigTest = input.nextLine();
				System.out.println("You entered: ipconfig " + ipconfigTest);
				System.out.println("Please wait....");
				cmdInJava("ipconfig", ipconfigTest);
			} else if(isCommands && LIST_OF_COMMANDS.equalsIgnoreCase("L")) {
				menu();
				// exit AND EXIT modification
			} else if(isExit && EXIT.equalsIgnoreCase("E")) {
				System.out.println("Thanks for using the program");
				break;
			} else {
				System.out.println("Invalid Input");
			}
		}
	}
}