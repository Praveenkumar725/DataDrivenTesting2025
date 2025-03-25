package Utility;

import excel.Xls_Reader;

import java.util.ArrayList;

public class TestUtility {
    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExcel() {
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
       try {
           reader = new Xls_Reader("C:\\Automation Testing\\GitHub\\DataDrivenTesting2025\\src\\test\\java\\TestData\\Data.xlsx");
       } catch (Exception e) {
           System.out.println(e);
       }
for (int i=2; i<=reader.getRowCount("TestData"); i++) {
    String ProductName = reader.getCellData("TestData", "ProductName", i);
    Object ob[]= {ProductName};

    myData.add(ob);

}
return myData;
    }
}
