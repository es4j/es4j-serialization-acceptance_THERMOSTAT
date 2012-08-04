package org.es4j.eventstore.serlization.acceptance;

//using System.Configuration;

import java.util.Map;

//using System.Linq;

//internal static
public class ConfigurationExtensions {

    public static String getSetting(/*this*/ String settingName) {
        //return getCommandLineArgument("/" + settingName + ":")
	//			?? Environment.GetEnvironmentVariable(settingName)
	//			?? ConfigurationManager.AppSettings[settingName];
        String setting;
        setting = getCommandLineArgument("/" + settingName + ":");
        setting = (setting != null)? setting : System.getenv(settingName);
        setting = (setting != null)? setting : (String)ConfigurationManager.getAppSettings().get(settingName);
        return setting;
    }

    private static String getCommandLineArgument(String settingName) {
        String setting;

        //return Environment.getCommandLineArgs()
	//			.Where(arg => arg.StartsWith(settingName))
	//			.Select(arg => arg.Replace(settingName, string.Empty))
	//			.FirstOrDefault();

        Map<String, String> variables = System.getenv();
        if(variables.containsKey(settingName)) {
            setting = variables.get(settingName);
        }
        else {
            setting = "";
        }

        return setting;
    }

}