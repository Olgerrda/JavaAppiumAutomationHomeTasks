import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Ex2Tests extends BaseTest {

    @Test
    public void testSimpleSearch() {
        clickSkipButton();

        assertElementHasText
                (By.xpath("//*[contains(@text, 'Search Wikipedia')]"), "Search Wikipedia", "Presented text not found");
    }

    private void assertElementHasText(By by, String text, String error_message) {
        WebElement element = waitForElementPresent(by, "Cannot find first search input", 5);
        Assert.assertEquals(error_message, text, element.getText());
    }

}
