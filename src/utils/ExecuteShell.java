package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuteShell {
	public String ExecuteShellCommand(String...parameters){
		String command= "";

		for(int counter=0; counter < parameters.length ; counter++){
			command = command + parameters[counter] + " ";
		}		
		System.out.println("COMMAND "+ command);
		return executeCommand(command);
	}
	
	
	public String executeCommand(String command) {

		StringBuffer output = new StringBuffer();
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = input.readLine())!= null) {
//				if(line.contains("Event received: serverReceivedMsg") )break;
//				if(line.contains("TimeCheck: Exiting  time ") )break;
				output.append(line + "\n");
//				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println("Unable to Execute Command "+ command);
			e.printStackTrace();
		}
		return output.toString();
	}
}
