import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Ex3Tests  extends BaseTest {

    @Test
    public void testCancelSearch() {
        clickSkipButton();

        waitForElementAndClick
                (By.id("org.wikipedia:id/search_container"), "Cannot find first search input", 5);

        waitForElementAndSendKeys
                (By.xpath("//*[contains(@text, 'Search Wikipedia')]"), "Batman", "Cannot find second search input", 5);

        waitForMultipleElementsPresent
                (By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and contains(@text, 'Batman')]"), "No search results found", 15);

        waitForElementAndClick
                (By.id("org.wikipedia:id/search_close_btn"), "Cannot clear search field", 5);

        waitForElementNotPresent
                (By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']//*[@text='Batman']"), "Search results are still present on the page", 5);
    }

    private List<WebElement> waitForMultipleElementsPresent(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
       List<WebElement> elements = driver.findElements(by);
       if (elements.size() > 1) {
           return elements;
       }
       return null;
    }
}
