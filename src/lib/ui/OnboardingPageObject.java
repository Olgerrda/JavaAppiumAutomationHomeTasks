package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OnboardingPageObject extends MainPageObject {

    private static final String
            SKIP_ONBOARDING_BUTTON_XPATH = "//*[contains(@text, 'Skip')]",
            DONE_ONBOARDING_BUTTON_XPATH = "org.wikipedia.alpha:id/fragment_onboarding_done_button",
            ONBOARDING_SCREEN_TITLE_XPATH_TPL = "//*[contains(@text, '{SUBSTRING}')]",
            ONBOARDING_DONE_BUTTON_ID = "org.wikipedia.alpha:id/fragment_onboarding_done_button",
            WIKIPEDIA_HEADER_ID = "org.wikipedia.alpha:id/main_toolbar_wordmark";

    public OnboardingPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickSkipButton() {
        WebElement element_to_init_skip = driver.findElementByXPath(SKIP_ONBOARDING_BUTTON_XPATH);
        List<WebElement> skip_element_exists = driver.findElementsByXPath(SKIP_ONBOARDING_BUTTON_XPATH);
        if (!skip_element_exists.isEmpty()) {
            element_to_init_skip.click();
        }
    }

    public void initOnboarding() {
        this.waitForElementPresent(By.xpath(SKIP_ONBOARDING_BUTTON_XPATH), "Cannot find Skip button", 15);
    }

    public void swipeOnboarding(int max_swipes) {
        this.swipeLeftToElement(By.id(DONE_ONBOARDING_BUTTON_XPATH),"Cannot find Done button", max_swipes);
    }

    public void swipeOnboardingLeft(int time_of_swipe_ms) {
        this.swipeLeft(time_of_swipe_ms);
    }

    public void waitForNextOnboardingScreenPresent(String screen_title) {
        this.waitForElementPresent
                (By.xpath(getLocatorOfElement(ONBOARDING_SCREEN_TITLE_XPATH_TPL, screen_title)), "Cannot load onboarding screen with title " + screen_title, 15);
    }

    public void finishOnboarding () {
        waitForElementAndClick
                (By.id(ONBOARDING_DONE_BUTTON_ID), "Cannot find Get Started button ", 15);
        waitForElementPresent
                (By.id(WIKIPEDIA_HEADER_ID), "Cannot hind Wikipedia header", 15);
    }
}
