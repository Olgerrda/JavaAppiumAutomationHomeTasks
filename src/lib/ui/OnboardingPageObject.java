package lib.ui;

import io.appium.java_client.AppiumDriver;

public class OnboardingPageObject extends MainPageObject {

    private static final String
            SKIP_ONBOARDING_BUTTON_XPATH = "xpath://*[contains(@text, 'Skip')]",
            DONE_ONBOARDING_BUTTON_ID = "id:org.wikipedia.alpha:id/fragment_onboarding_done_button",
            ONBOARDING_SCREEN_TITLE_XPATH_TPL = "xpath://*[contains(@text, '{SUBSTRING}')]",
            ONBOARDING_DONE_BUTTON_ID = "id:org.wikipedia.alpha:id/fragment_onboarding_done_button",
            WIKIPEDIA_HEADER_ID = "id:org.wikipedia.alpha:id/main_toolbar_wordmark",
            LEARN_MORE_LINK_XPATH = "xpath://XCUIElementTypeStaticText[@name='Learn more about Wikipedia']",
            NEW_WAYS_TO_EXPLORE_ID = "id:New ways to explore",
            ADD_EDIT_PREFERRED_LANG_XPATH = "xpath://XCUIElementTypeButton[@name='Add or edit preferred languages']",
            LEARN_MORE_ABOUT_DATA_XPATH = "xpath://XCUIElementTypeButton[@name='Learn more about data collected']",
            NEXT_BUTTON_XPATH = "xpath://XCUIElementTypeButton[@name='Next']",
            GET_STARTED_BUTTON_XPATH = "xpath://XCUIElementTypeButton[@name='Get started']";

    public OnboardingPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickSkipOnboarding() {
        this.waitForElementAndClick(SKIP_ONBOARDING_BUTTON_XPATH, "Cannot find Skip button", 15);
    }

    public void waitForSkipOnboarding() {
        this.waitForElementPresent(SKIP_ONBOARDING_BUTTON_XPATH, "Cannot find Skip button", 15);
    }

    public void swipeOnboarding(int max_swipes) {
        this.swipeLeftToElement(DONE_ONBOARDING_BUTTON_ID,"Cannot find Done button", max_swipes);
    }

    public void swipeOnboardingLeft(int time_of_swipe_ms) {
        this.swipeLeft(time_of_swipe_ms);
    }

    public void waitForNextOnboardingScreenPresent(String screen_title) {
        this.waitForElementPresent
                (getLocatorOfElement(ONBOARDING_SCREEN_TITLE_XPATH_TPL, screen_title), "Cannot load onboarding screen with title " + screen_title, 15);
    }

    public void finishOnboarding () {
        this.waitForElementAndClick
                (ONBOARDING_DONE_BUTTON_ID, "Cannot find Get Started button ", 15);
        this.waitForElementPresent
                (WIKIPEDIA_HEADER_ID, "Cannot find Wikipedia header", 15);
    }

    public void waitForLearnMoreLink() {
        this.waitForElementPresent(LEARN_MORE_LINK_XPATH, "Cannot find 'Learn more about Wikipedia' link", 20);
    }

    public void waitForNewWaysToExploreText() {
        this.waitForElementPresent(NEW_WAYS_TO_EXPLORE_ID, "Cannot find 'New Ways to Explore' header", 10);
    }

    public void waitForAddOrEditPreferredLangLink() {
        this.waitForElementPresent(ADD_EDIT_PREFERRED_LANG_XPATH, "Cannot find 'Add or Edit Preferred Lang' link", 10);
    }

    public void waitForLearnMoreAboutDataCollectedLink() {
        this.waitForElementPresent(LEARN_MORE_ABOUT_DATA_XPATH, "Cannot find 'Learn more about data collected' link", 10);
    }

    public void clickNextButton() {
        this.waitForElementAndClick(NEXT_BUTTON_XPATH, "Cannot find and click Next button", 10);
    }

    public void clickGetStartedButton() {
        this.waitForElementAndClick(GET_STARTED_BUTTON_XPATH, "Cannot find and click Get Started button", 10);
    }
}
