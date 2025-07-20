package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();
        driver = this.getDriverByPlatformEnv(capabilities);
        this.rotateScreenPortrait();
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

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (platform.equals(PLATFORM_ANDROID)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Pixel9");
            capabilities.setCapability("platformVersion", "15");
            capabilities.setCapability("appPackage", "org.wikipedia.alpha");
            capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("app", "/Users/olga/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/app-alpha-universal-release.apk");
        } else if (platform.equals(PLATFORM_IOS)) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone 16 Pro");
            capabilities.setCapability("platformVersion", "18.3");
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("app", "/Users/olga/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/Wikipedia.app");
        } else {
            throw new Exception("Cannot get run platform from env variable. Platform value " + platform);
        }
        return capabilities;
    }

    private AppiumDriver getDriverByPlatformEnv(DesiredCapabilities capabilities) throws Exception {
        String platform = System.getenv("PLATFORM");
        AppiumDriver driver;
        if (platform.equals(PLATFORM_ANDROID)) {
            driver = new AndroidDriver(new URL(AppiumURL), capabilities);
        } else if (platform.equals(PLATFORM_IOS)) {
            driver = new IOSDriver(new URL(AppiumURL), capabilities);
        } else {
            throw new Exception("Cannot get driver platform from env variable. Platform value " + platform);
        }
        return driver;
    }
}

