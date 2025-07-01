import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Ex6Tests extends BaseTest{

    @Test
    public void testArticleTitlePresent() {
        clickSkipButton();
        waitForElementAndClick
                (By.xpath("//*[contains(@text, 'Search Wikipedia')]"), "Cannot find first search input", 5);
        String search_line = "Java";
        waitForElementAndSendKeys
                (By.xpath("//*[contains(@text, 'Search Wikipedia')]"), search_line, "Cannot find second search input", 5);
        waitForElementAndClick
                (By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Object-oriented programming language']"),
                        "Cannot find 'Object-oriented programming language' topic searching by " + search_line, 15);
        String opened_articles_title = "org.wikipedia:id/view_page_title_text";
        assertElementPresent
                (By.id(opened_articles_title), "Cannot find the title of article");
    }
    private void assertElementPresent(By by, String error_message) {
        List element = driver.findElements(by);
        int amount_of_elements = element.size();
        if (amount_of_elements <= 0 ) {
            String default_message = "An element '" + by.toString() + "' supposed to be not present: ";
            throw new AssertionError(default_message + " " + error_message);
        }
        Assert.assertNotNull(error_message, element);
    }
}
