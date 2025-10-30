package tests;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class LoginTest extends baseTest {

    @Test 
    public void testValidLogin(){
        String username=ConfigReader.getProperty("username");
        String password=ConfigReader.getProperty("password");
        LoginPage loginPage=new LoginPage(driver);
        ProductsPage productsPage=new ProductsPage(driver);
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(productsPage.getTitleText(),"Products");

    }
}
