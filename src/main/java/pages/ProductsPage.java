package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    private final By titleText=By.className("title");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        try{
            return driver.findElement(titleText).getText();
        }
        catch (NoSuchElementException noSuchElementException){
            implicitWait();
            return driver.findElement(titleText).getText();
        }

    }
}
