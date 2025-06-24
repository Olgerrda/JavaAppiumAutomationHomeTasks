import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class HomeTaskTests {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel9");
        capabilities.setCapability("platformVersion", "15");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", "/Users/olga/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/org-wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSimpleSearch() {
        clickSkipButton();
        assertElementHasText
                (By.xpath("//*[contains(@text, 'Search Wikipedia')]"), "Search Wikipedia3", "Presented text not found");
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    private void clickSkipButton() {
        WebElement element_to_init_skip = driver.findElementByXPath("//*[contains(@text, 'SKIP')]");
        List<WebElement> skip_element_exists = driver.findElementsByXPath("//*[contains(@text, 'SKIP')]");
        if (!skip_element_exists.isEmpty()) {
            element_to_init_skip.click();
        }
    }

    private void assertElementHasText(By by, String text, String error_message) {
        WebElement element = waitForElementPresent(by, "Cannot find first search input", 5);
        Assert.assertEquals(error_message, text, element.getText());
    }
}
