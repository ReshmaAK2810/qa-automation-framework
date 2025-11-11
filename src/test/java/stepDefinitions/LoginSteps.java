package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_sauce_demo_login_page() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        String url = ConfigReader.getProperty("url");
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    @When("I enter username and password")
    public void iEnterUsernameAndPassword() {
        loginPage.enterUsername(ConfigReader.getProperty("username")).enterPassword(ConfigReader.getProperty("password"));
    }


    @And("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the Products page")
    public void iShouldSeeTheProductsPage() {
        productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getTitleText(), "Product", "Page title mismatch!");
    }


    @When("I enter invalid username and password")
    public void iEnterInvalidUsernameAndPassword() {
        loginPage.enterUsername("Standard_user").enterPassword("Incorrect password");
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String error) {
        Assert.assertEquals(loginPage.getInvalidLoginErrorMessage(), error, "Incorrect error message displayed!");
    }

    @When("the user enters {string} as username and {string} as password")
    public void theUserEntersAsUsernameAndAsPassword(String usernameKey, String passwordKey) {
        String username = usernameKey.trim().isEmpty() ? "" : ConfigReader.getProperty("username");
        String password = passwordKey.trim().isEmpty() ? "" : ConfigReader.getProperty("password");
        loginPage.enterUsername(username).enterPassword(password);
    }
}
