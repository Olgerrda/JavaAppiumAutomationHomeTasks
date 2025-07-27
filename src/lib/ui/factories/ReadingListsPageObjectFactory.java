package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.ReadingListsPageObject;
import lib.ui.android.AndroidReadingListsPageObject;
import lib.ui.ios.iOSReadingListsPageObject;

public class ReadingListsPageObjectFactory {

    public static ReadingListsPageObject get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidReadingListsPageObject(driver);
        } else {
            return new iOSReadingListsPageObject(driver);
        }
    }
}
