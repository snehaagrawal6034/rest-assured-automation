package stepDefinition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private static ConfigFileReader configFileReader = new ConfigFileReader();
    Properties properties;

    private ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/Configuration.properties"));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at ");
        }
    }
    public String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public static void main(String[] args) {
        System.out.println(new ConfigFileReader().getReportConfigPath());
    }

    public static ConfigFileReader getInstance() {
        return configFileReader;
    }
}
