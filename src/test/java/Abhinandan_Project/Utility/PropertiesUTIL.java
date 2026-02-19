package Abhinandan_Project.Utility;

import Abhinandan_Project.Constants.Env;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUTIL {

    public static String readProperties(Env env, String propertyName) {

        File  file = new File(System.getProperty("user.dir")+"/Config/"+env+".properties");
        FileReader fileReader = null;
        Properties properties = new Properties();
        try {
            fileReader = new FileReader(file);
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
        String value= properties.getProperty(propertyName.toUpperCase());
        return value;
    }

}
