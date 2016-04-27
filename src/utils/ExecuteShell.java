package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import readProperties.LoadAndroidPropertiesFile;

public class ExecuteShell {


	public void ExecuteShellCommand(String ... parameters){

		String command= "";

		for(int counter=0; counter < parameters.length ; counter++){
			command = command + parameters[counter] + " ";
		}
		LogUtil.info("COMMAND: "+ command);
		executeCommand(command);

	}

	public String executeCommand(String command) {

		StringBuffer output = new StringBuffer();
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = input.readLine())!= null) {

				output.append(line + "\n");
				LogUtil.info(line);

			}
		} catch (Exception e) {
			LogUtil.info("Unable to Execute Command "+ command);
			e.printStackTrace();
		}

		return output.toString();
	}

	public String getAppPid()
	{
		LogUtil.info("Getting device id: ");

		Process p;
		String line = "";
		String id = "";
		try {

			String command = "ps | grep "+ LoadAndroidPropertiesFile.APP_PACKAGE_NAME;
			p = Runtime.getRuntime().exec(command);
			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			line = input.readLine();

			id = line.substring(10, 15);



		} catch (IOException e) {

			e.printStackTrace();

		}
		return id;
	}

}
