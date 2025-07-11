package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {

    private static final String
            TAB_READING_LISTS_ID = "org.wikipedia.alpha:id/nav_tab_reading_lists";

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists() {
        this.waitForElementAndClick(
                By.id(TAB_READING_LISTS_ID), "Cannot find navigation button to My lists", 5);
    }
}
