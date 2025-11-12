package pages;

import exceptions.PageException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the Products Page of the application.
 * <p>
 * This class provides methods to interact with and retrieve data
 * from the Products page, such as verifying the page title.
 * </p>
 *
 * <p><b>Usage:</b></p>
 * <pre>
 *     ProductsPage productsPage = new ProductsPage(driver);
 *     String title = productsPage.getTitleText();
 * </pre>
 */
public class ProductsPage extends BasePage {

    /** Locator for the title text element on the Products page. */
    private static final By TITLE_TEXT = By.className("title");

    /**
     * Constructor to initialize the ProductsPage.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public ProductsPage(WebDriver driver) {
        super(driver);
        logger.debug("Initialized ProductsPage");
    }

    /**
     * Retrieves the title text displayed on the Products page.
     *
     * @return The title text as a {@link String}.
     * @throws PageException if the title element is not found or not visible.
     */
    public String getTitleText() {
        logger.info("Fetching title text from the Products page");
        String title = getText(TITLE_TEXT, "Title text");
        logger.debug("Retrieved title text: '{}'", title);
        return title;
    }
}
