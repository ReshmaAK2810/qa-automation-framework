package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;


public class Hooks {
    protected WebDriver driver;
    @Before
    public void setUp(){
        DriverFactory.setBrowser("chrome");
        driver=DriverFactory.getDriver();
        System.out.println("🚀 Browser launched successfully!");
    }
    @After
    public void tearDown(){
        DriverFactory.quitDriver();
        System.out.println("🧹 Browser closed successfully!");
    }
}
