package Abhinandan_Project.UI.Listeners;

import Abhinandan_Project.Constants.Env;
import Abhinandan_Project.Utility.JSONUtility;
import Abhinandan_Project.Utility.PropertiesUTIL;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_NUMBER_OF_ATTEMPTS= Integer.parseInt(PropertiesUTIL.readProperties(Env.DEV,"MAX_NUMBER_OF_ATTEMPTS"));

    //private static final int MAX_NUMBER_OF_ATTEMPTS= JSONUtility.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
    private static int currentAttempt =1;


    @Override
    public boolean retry(ITestResult result) {

        if(currentAttempt<=MAX_NUMBER_OF_ATTEMPTS){
            currentAttempt++;
            return true;
        }
        return false;
    }
}
