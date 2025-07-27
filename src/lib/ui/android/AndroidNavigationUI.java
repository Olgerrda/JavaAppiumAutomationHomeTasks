package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class AndroidNavigationUI extends NavigationUI {

    static {
        TAB_READING_LISTS = "id:org.wikipedia.alpha:id/nav_tab_reading_lists";
    }

    public AndroidNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
