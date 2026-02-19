package Abhinandan_Project.Utility;

import Abhinandan_Project.Constants.Env;
import Abhinandan_Project.UI.POJOS.Config;
import Abhinandan_Project.UI.POJOS.Environment;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtility {

    public static Environment readJSON(Env env) {

        Gson gson = new Gson();
        File jsonFile = new File(System.getProperty("user.dir")+"/Config/config.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Config config = gson.fromJson(fileReader, Config.class);
        Environment environment = config.getEnvironment().get("QA");
        return environment;

    }
}
