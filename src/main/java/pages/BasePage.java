package pages;

import exceptions.PageException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * Base class for all Page Object classes in the framework.
 * <p>
 * Provides a WebDriver instance and a logger to all page classes.
 * Ensures that the WebDriver is never null and initializes logging
 * for each subclass automatically.
 * </p>
 *
 * <p>Example usage:</p>
 * <pre>
 *     public class LoginPage extends BasePage {
 *         public LoginPage(WebDriver driver) {
 *             super(driver);
 *         }
 *     }
 * </pre>
 *
 * @author Reshma
 */
public abstract class BasePage {

    /**
     * WebDriver instance used for browser interactions.
     */
    protected final WebDriver driver;

    /**
     * SLF4J logger instance for logging actions, errors, and debug info.
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Explicit wait utility for WebElements using {@link WebDriverWait}.
     * <p>
     * This class provides reusable methods to wait for various element states such as
     * visibility, clickability, and invisibility. It helps ensure stable interaction
     * with web elements that may take time to appear or become ready for action.
     */
    private final WebDriverWait wait;

    /**
     * Constructs a new BasePage instance.
     *
     * @param driver WebDriver instance used to interact with the browser.
     * @throws IllegalArgumentException if the provided driver is {@code null}.
     */
    public BasePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("driver must not be null");
        }
        this.driver = driver;
        logger.info("{} initialized successfully.", getClass().getSimpleName());
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Waits for the specified element to become visible on the page and returns it.
     * <p>
     * This method combines explicit wait and exception handling to locate a visible element reliably.
     * It first waits for the element's visibility using {@link ExpectedConditions#visibilityOfElementLocated(By)},
     * ensuring that the element is both present in the DOM and visible before interacting with it.
     * <p>
     * If the element is not found or not visible within the specified wait duration, a {@link PageException}
     * is thrown with a descriptive error message.
     *
     * @param locator     the {@link By} locator used to find the WebElement
     * @param elementName a human-readable name of the element for logging and debugging purposes
     * @return the visible {@link WebElement} once located and visible
     * @throws PageException if the element is not found or not visible within the wait time
     */
    protected WebElement findElement(By locator, String elementName) {
        try {
            logger.debug("Waiting for visibility of element: {}", elementName);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.debug("Element '{}' is visible.", elementName);
            return element;
        } catch (TimeoutException e) {
            throw new PageException(elementName + " not visible after waiting on " + getClass().getSimpleName(), e);
        } catch (NoSuchElementException e) {
            throw new PageException(elementName + " not found on " + getClass().getSimpleName(), e);
        }
    }


    /**
     * Waits for the specified element to become clickable and performs a click action on it.
     * <p>
     * This method uses an explicit wait via {@link ExpectedConditions#elementToBeClickable(By)}
     * to ensure the element is ready for interaction. It also includes a retry mechanism to handle
     * {@link org.openqa.selenium.StaleElementReferenceException}, which may occur when the DOM updates
     * before the click is performed.
     * <p>
     * If the element cannot be clicked due to timeout or interception, a {@link PageException}
     * is thrown with a descriptive message to aid debugging.
     *
     * @param locator     the {@link By} locator used to identify the clickable element
     * @param elementName a human-readable name of the element, used for logging and error reporting
     * @throws PageException if the element is stale, not clickable, or not found within the wait time
     */
    protected void click(By locator, String elementName) {
        int retries = 2;
        while (retries > 0) {
            try {
                logger.info("Clicking on element: {}", elementName);
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                logger.debug("Clicked on '{}'", elementName);
                return; // success, so exit method
            } catch (StaleElementReferenceException e) {
                logger.warn("StaleElementReferenceException encountered for '{}'. Retrying... ({} attempts left)", elementName, retries - 1);
                retries--;
                if (retries == 0) {
                    throw new PageException("Element became stale and could not be clicked: " + elementName, e);
                }
            } catch (TimeoutException e) {
                throw new PageException("Timed out waiting for element to be clickable: " + elementName, e);
            } catch (ElementClickInterceptedException e) {
                throw new PageException("Element not clickable: " + elementName, e);
            }
        }
    }


    /**
     * Clears the existing text (if any) and types the specified value into the given element.
     * <p>
     * This method first waits for the element's visibility using {@link #findElement(By, String)},
     * ensuring the element is present and visible before interaction. It then clears any existing input
     * and types the provided text value.
     * <p>
     * If the element is not interactable or an unexpected error occurs, a {@link PageException}
     * is thrown with detailed context for easier debugging.
     *
     * @param locator     the {@link By} locator used to identify the input element
     * @param text        the text value to type into the element
     * @param elementName a human-readable name of the element, used for logging and reporting
     * @throws PageException if the element is not interactable or if any unexpected error occurs while typing
     */
    public void type(By locator, String text, String elementName) {
        try {
            WebElement element = findElement(locator, elementName);
            element.clear();
            element.sendKeys(text);
            String textForLog = elementName != null && elementName.toLowerCase().contains("password")
                    ? "[HIDDEN]"
                    : text;
            logger.info("Typed '{}' into '{}'", textForLog, elementName);
        } catch (ElementNotInteractableException e) {
            throw new PageException("Element not interactable for typing: " + elementName, e);
        } catch (Exception e) {
            throw new PageException("Unexpected error while typing into " + elementName, e);
        }
    }

    /**
     * Retrieves the visible text from the specified element.
     *
     * @param locator      the {@link By} locator of the element
     * @param elementName  a descriptive name for logging and exception messages
     * @return the text of the element
     * @throws PageException if the element is not interactable or an unexpected error occurs
     */
    public String getText(By locator, String elementName) {
        try {
            logger.info("Getting text from element: {}", elementName);
            WebElement element = findElement(locator, elementName);
            String text = element.getText();

            if (text.trim().isEmpty()) {
                logger.warn("Element '{}' returned empty text.", elementName);
            }

            logger.debug("Text retrieved from '{}': {}", elementName, text);
            return text;

        } catch (ElementNotInteractableException e) {
            throw new PageException("Element not interactable while getting text from: " + elementName, e);
        } catch (Exception e) {
            throw new PageException("Unexpected error while getting text from: " + elementName, e);
        }
    }


//    /**
//     * Waits until the specified {@link WebElement} is no longer visible on the page.
//     *
//     * @param element the WebElement to wait for
//     * @return {@code true} if the element becomes invisible within the wait time, {@code false} otherwise
//     * @throws org.openqa.selenium.TimeoutException if the element remains visible beyond the wait time
//     */
//    protected boolean waitForInvisibility(WebElement element) {
//        logger.debug("Waiting for invisibility of element: {}", element);
//        return wait.until(ExpectedConditions.invisibilityOf(element));
//    }


}
