package lib.ui;

import io.appium.java_client.AppiumDriver;

public class NavigationUI extends MainPageObject {

    private static final String
            TAB_READING_LISTS_ID = "id:org.wikipedia.alpha:id/nav_tab_reading_lists";

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists() {
        this.waitForElementAndClick(
                TAB_READING_LISTS_ID, "Cannot find navigation button to My lists", 5);
    }
}
