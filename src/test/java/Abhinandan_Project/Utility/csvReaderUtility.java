package Abhinandan_Project.Utility;

import Abhinandan_Project.UI.POJOS.user;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class csvReaderUtility {

    public static Iterator<user> readCSVFile(String filename) {

        File csvfile = new File(System.getProperty("user.dir")+"/TestData/" + filename);
        FileReader fileReader= null;
        CSVReader csvReader;
        String[] line;
        List<user> userList =null;
        user userData;


        try {
             fileReader = new FileReader(csvfile);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();
//            csvReader.readNext(); //Reading the col - Row 1
//            csvReader.readNext(); //Row 2
//            data = csvReader.readNext();//Row 3

            userList = new ArrayList<user>();

            while((line = csvReader.readNext())!= null){
                 userData = new user(line[0], line[1]);
                userList.add(userData);
            }
        }
        catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        return userList.iterator();
    }
}
