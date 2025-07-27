package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        WIKIGAMES_DIALOG_CLOSE_BUTTON = "id:org.wikipedia.alpha:id/closeButton";
        AFTER_WIKIGAMES_SPACE = "id:org.wikipedia.alpha:id/snackbar_text";
        TITLE_BY_SUBSTRING_TPL = "id:{SUBSTRING}";
        FOOTER_ELEMENT = "id:View article in browser";
        SAVE_OPTION_BUTTON = "id:org.wikipedia.alpha:id/page_save";
        OPTIONS_ADD_TO_LIST = "id:Save for later";
        MY_LIST_INPUT_FIELD = "id:org.wikipedia.alpha:id/text_input";
        MY_LIST_OK_BUTTON = "id:android:id/button1";
        BACK_FROM_ARTICLE_BUTTON = "id:Back";
        CLOSE_SEARCH_BUTTON = "xpath://XCUIElementTypeButton[@name='Cancel']";
    }
    public iOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
