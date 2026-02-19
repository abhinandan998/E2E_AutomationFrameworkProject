package Abhinandan_Project.UI.DataProviders;

import Abhinandan_Project.UI.POJOS.TestData;
import Abhinandan_Project.UI.POJOS.user;
import Abhinandan_Project.Utility.ExcelReaderUtility;
import Abhinandan_Project.Utility.csvReaderUtility;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {


    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> LoginDataProvider(){
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir")+"/TestData/LoginData.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(testDataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TestData testData= gson.fromJson(fileReader, TestData.class);


        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        for(user user : testData.getData()){
            dataToReturn.add(new Object[]{user});
        }
        return dataToReturn.iterator();
    }

    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<user> loginCSVDataProvider(){
        return csvReaderUtility.readCSVFile("loginData.csv");
    }
    @DataProvider(name = "LoginTestExcelDataProvider")
    public Iterator<user> loginExcelDataProvider(){
        return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
    }
}
