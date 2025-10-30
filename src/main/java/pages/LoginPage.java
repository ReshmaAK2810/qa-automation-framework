package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private final By usernameField = By.id("user-name");
    private final By passwordField=By.id("password");
    private final By loginButton=By.id("login-button");
    private final By invalidLoginError=By.xpath("//div[@class=\"error-message-container error\"]/h3");



    public LoginPage(WebDriver driver){
        super(driver);
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

    public String getInvalidLoginErrorMessage(){
        return driver.findElement(invalidLoginError).getText();
    }

}
