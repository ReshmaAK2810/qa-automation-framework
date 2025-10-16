package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_sauce_demo_login_page() {
        driver=DriverFactory.getDriver();
        loginPage=new LoginPage(driver);
        String url=ConfigReader.getProperty("url");
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

//    @When("I enter username {string} and password {string}")
//    public void iEnterUsernameAndPassword(String username, String password) {
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//    }

    @When("I enter username and password")
    public void iEnterUsernameAndPassword() {
        loginPage.enterUsername(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
    }


    @And("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the Products page")
    public void iShouldSeeTheProductsPage() {
        Assert.assertEquals(loginPage.getTitleText(), "Products");
    }


}
