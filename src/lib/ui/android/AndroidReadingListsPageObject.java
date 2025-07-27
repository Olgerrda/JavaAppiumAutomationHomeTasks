package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ReadingListsPageObject;

public class AndroidReadingListsPageObject extends ReadingListsPageObject {

    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{SUBSTRING}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{SUBSTRING}']";
        GOT_IT_DIALOG_BUTTON = "xpath://*[@text='Got it']";
    }

    public AndroidReadingListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
