package pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}
