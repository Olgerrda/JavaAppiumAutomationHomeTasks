import io.appium.java_client.TouchAction;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class Ex5Tests  extends BaseTest {

    @Test
    public void testSwipeOnboarding() {
        waitForElementPresent
                (By.xpath("//*[contains(@text, 'SKIP')]"), "Cannot find SKIP button", 15);
        swipeLeft(2000);
        waitForElementPresent
                (By.xpath("//*[contains(@text, 'New ways to explore')]"), "Cannot load second onboarding screen", 15);
        swipeLeft(2000);
        waitForElementPresent
                (By.xpath("//*[contains(@text, 'Reading lists with sync')]"), "Cannot load third onboarding screen", 15);
        swipeLeft(2000);
        waitForElementPresent
                (By.xpath("//*[contains(@text, 'Send anonymous data')]"), "Cannot load forth onboarding screen", 15);
        waitForElementAndClick
                (By.id("org.wikipedia:id/fragment_onboarding_done_button"), "Cannot load forth onboarding screen", 15);
        waitForElementPresent
                (By.id("org.wikipedia:id/single_fragment_toolbar_wordmark"), "Cannot hind Wikipedia header", 15);

        }

    protected void swipeLeft(long timeOfSwipeInMs) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int y = size.height/2;
        int start_x = (int) (size.width * 0.9);
        int end_x = (int) (size.width * 0.1);
        //action.press(PointOption.point(start_x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(timeOfSwipe))).moveTo(PointOption.point(end_x, y)).release().perform();
        //Вместо TouchAction в Appium 2 принято использовать W3C Actions, которые поддерживаются Selenium и Appium.

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start_x, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(timeOfSwipeInMs), PointerInput.Origin.viewport(), end_x, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

}
