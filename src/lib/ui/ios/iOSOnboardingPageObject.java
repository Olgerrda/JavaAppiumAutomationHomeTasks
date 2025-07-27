package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.OnboardingPageObject;

public class iOSOnboardingPageObject extends OnboardingPageObject {

    static {
        SKIP_ONBOARDING_BUTTON = "xpath://XCUIElementTypeButton[@name='Skip']";
        DONE_ONBOARDING_BUTTON = "xpath://XCUIElementTypeButton[@name='Get started']";
        ONBOARDING_SCREEN_TITLE_TPL = "xpath://*[contains(@text, '{SUBSTRING}')]";
        ONBOARDING_DONE_BUTTON = "id:org.wikipedia.alpha:id/fragment_onboarding_done_button";
        WIKIPEDIA_HEADER = "id:org.wikipedia.alpha:id/main_toolbar_wordmark";
        LEARN_MORE_LINK = "xpath://XCUIElementTypeStaticText[@name='Learn more about Wikipedia']";
        NEW_WAYS_TO_EXPLORE = "id:New ways to explore";
        ADD_EDIT_PREFERRED_LANG = "xpath://XCUIElementTypeButton[@name='Add or edit preferred languages']";
        LEARN_MORE_ABOUT_DATA = "xpath://XCUIElementTypeButton[@name='Learn more about data collected']";
        NEXT_BUTTON = "xpath://XCUIElementTypeButton[@name='Next']";
        GET_STARTED_BUTTON = "xpath://XCUIElementTypeButton[@name='Get started']";
    }
    public iOSOnboardingPageObject(AppiumDriver driver) {
        super(driver);
    }
}
