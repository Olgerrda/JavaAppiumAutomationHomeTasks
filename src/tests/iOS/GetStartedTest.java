package tests.iOS;

import lib.CoreTestCase;
import lib.ui.OnboardingPageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.waitForLearnMoreLink();
        OnboardingPageObject.clickNextButton();
        OnboardingPageObject.waitForNewWaysToExploreText();
        OnboardingPageObject.clickNextButton();
        OnboardingPageObject.waitForAddOrEditPreferredLangLink();
        OnboardingPageObject.clickNextButton();
        OnboardingPageObject.waitForLearnMoreAboutDataCollectedLink();
        OnboardingPageObject.clickGetStartedButton();
    }
}
