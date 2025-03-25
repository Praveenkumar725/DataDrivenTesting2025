package DataDriventesting15;

import Utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.naming.Name;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

public class DDbyusingDproviderTest {


    public WebDriver driver;

    @BeforeMethod
    public void starts() {
        driver = new ChromeDriver();
        driver.get("https://www.verizon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Reporter.log("Browser started...");
    }

    @DataProvider(name = "VerizonData")
    public Iterator<Object[]> getTestData() {
        ArrayList<Object[]> testData1 = TestUtility.getDataFromExcel();
        return testData1.iterator();
    }

    @Test(dataProvider = "VerizonData")
    public void VerizonProductSearch(String ProductName) {
        Reporter.log("Search product: " + ProductName);
        driver.findElement(By.xpath( "//*[@id=\"gnav20-search-icon\"]")).click();
        driver.findElement(By.id("search_box_gnav_input")).sendKeys(ProductName);
        driver.findElement(By.id("search_box_gnav_input")).sendKeys(Keys.ENTER);
       Reporter.log("Product searched: " + ProductName);
    }

    @AfterMethod
    public void ends(){
        driver.quit();
        Reporter.log("Browser closed...");
    }

}
