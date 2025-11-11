package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model class representing the Login page of the application.
 * <p>
 * This class provides reusable actions and element locators related to the login functionality.
 * It follows the Fluent Interface pattern, allowing method chaining for cleaner test steps.
 */
public class LoginPage extends BasePage {

    // Locators for elements on the Login page
    private static final By USERNAME_FIELD = By.id("user-name");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By INVALID_LOGIN_ERROR = By.xpath("//div[@class='error-message-container error']/h3");


    /**
     * Constructor for LoginPage.
     *
     * @param driver the WebDriver instance used to interact with page elements
     */

    public LoginPage(WebDriver driver) {
        super(driver);
        logger.debug("Initialized LoginPage");
    }

    /**
     * Enters the provided username into the username input field.
     *
     * @param username the username to enter
     * @return the current {@link LoginPage} instance for method chaining
     */
    public LoginPage enterUsername(String username) {
        logger.debug("Entering username: {}", username);
        type(USERNAME_FIELD, username,"Username field");
        logger.info("Username entered successfully.");
        return this;
    }

    /**
     * Enters the provided password into the password input field.
     *
     * @param password the password to enter
     * @return the current {@link LoginPage} instance for method chaining
     */
    public LoginPage enterPassword(String password) {
        logger.debug("Entering password: [HIDDEN]");
        type(PASSWORD_FIELD,password,"Password field");
        logger.info("Password entered successfully.");
        return this;
    }

    /**
     * Clicks the login button and navigates to the {@link ProductsPage}.
     *
     * @return a new instance of {@link ProductsPage} representing the next page after successful login
     */
    public ProductsPage clickLoginButton() {
        logger.debug("Clicking on the Login button.");
        click(LOGIN_BUTTON,"Login button");
        logger.info("Login button clicked successfully.");
        return new ProductsPage(driver);
    }

//    public ProductsPage loginAsValidUser(String username, String password){
//        return enterUsername(username).enterPassword(password).clickLoginButton();
//    }

    /**
     * Retrieves the error message displayed after an invalid login attempt.
     *
     * @return the invalid login error message text
     */
    public String getInvalidLoginErrorMessage() {
        logger.debug("Fetching invalid login error message.");
        String errorMessage = getText(INVALID_LOGIN_ERROR,"Invalid login error");
        logger.info("Invalid login error message captured: {}", errorMessage);
        return errorMessage;
    }

}
