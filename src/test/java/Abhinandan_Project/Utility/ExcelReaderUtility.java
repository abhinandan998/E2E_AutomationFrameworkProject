package Abhinandan_Project.Utility;

import Abhinandan_Project.UI.POJOS.user;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
    public static Iterator<user> readExcelFile(String filename) {


        File xlsxfile = new File(System.getProperty("user.dir")+"/TestData/"+filename);
        XSSFWorkbook xssfWorkbook = null;
        XSSFSheet xssfSheet;
        List<user> userList = null;
        Row row;
        Cell emailIdCell;
        Cell passwordCell;
        user user;
        Iterator<Row> rowIterator;
        try {
            xssfWorkbook = new XSSFWorkbook(xlsxfile);

             userList = new ArrayList<user>();
             xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            rowIterator = xssfSheet.iterator();

            rowIterator.next();  //Skipping the cols name

            while (rowIterator.hasNext()){
                row = rowIterator.next();


                emailIdCell = row.getCell(0);
                passwordCell= row.getCell(1);
                user = new user(emailIdCell.toString(), passwordCell.toString());
                userList.add(user);
                xssfWorkbook.close();
            }

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
        return  userList.iterator();
    }
}
