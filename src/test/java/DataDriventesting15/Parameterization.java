package DataDriventesting15;

import excel.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Parameterization {
    @Test
    public void Parameterization() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.verizon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        Xls_Reader reader = new Xls_Reader("C:\\Automation Testing\\GitHub\\DataDrivenTesting2025\\src\\test\\java\\TestData\\Data.xlsx");
        int rowcount = reader.getRowCount("TestData");
        System.out.println("number of rows:" + rowcount);

        for (int i=2; i<=rowcount; i++) {
            String productname = reader.getCellData("TestData", "ProductName", i);
            driver.findElement(By.xpath( "//*[@id=\"gnav20-search-icon\"]")).click();
            driver.findElement(By.id("search_box_gnav_input")).sendKeys(productname);
            driver.findElement(By.id("search_box_gnav_input")).sendKeys(Keys.ENTER);

        }

        driver.quit();
    }

}

