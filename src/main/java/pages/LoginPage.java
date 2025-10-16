package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final By usernameField = By.id("user-name");
    private final By passwordField=By.id("password");
    private final By loginButton=By.id("login-button");
    private final By titleText=By.className("title");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public String getTitleText(){
        return driver.findElement(titleText).getText();
    }
}
