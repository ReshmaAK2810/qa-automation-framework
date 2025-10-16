package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        // Initialize driver
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void postTest(){
        // Quit driver after each test
        if(driver!=null){
            driver.quit();
        }
    }
}
