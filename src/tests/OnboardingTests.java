package tests;

import lib.CoreTestCase;
import lib.ui.OnboardingPageObject;
import org.junit.Test;

public class OnboardingTests extends CoreTestCase {

    @Test
    public void testSwipeOnboarding() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.waitForSkipOnboarding();
        OnboardingPageObject.swipeOnboarding(6);
    }

}
