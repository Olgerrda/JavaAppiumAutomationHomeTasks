package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.OnboardingPageObject;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        //this.skipOnboardingPageForIOS();
    }

    @Override
    protected void tearDown()  throws Exception {
        super.tearDown();
        driver.quit();
    }

    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds) {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

    private void skipOnboardingPageForIOS() {
        if (Platform.getInstance().isIOS()) {
            OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
            OnboardingPageObject.clickSkip();
        }
    }
}

