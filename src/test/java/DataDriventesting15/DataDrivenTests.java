package DataDriventesting15;

import excel.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;


public class DataDrivenTests {
    @Test
    public void DDtest() {
        Xls_Reader reader = new Xls_Reader("C:\\Automation Testing\\GitHub\\DataDrivenTesting2025\\src\\test\\java\\TestData\\Data.xlsx"); // Update this path
        String URL = reader.getCellData("TestData", "URL", 2);
        String ProductName = reader.getCellData("TestData", "ProductName", 2);
        System.out.println(URL  + ProductName);

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.xpath("//*[@id=\"gnav20-search-icon\"]")).click();
        driver.findElement(By.id( "search_box_gnav_input")).sendKeys(ProductName);
        driver.findElement(By.id("search_box_gnav_input")).sendKeys(Keys.ENTER);

    }
}
