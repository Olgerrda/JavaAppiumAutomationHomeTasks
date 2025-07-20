package lib.ui;

import io.appium.java_client.AppiumDriver;

public class ReadingListsPageObject extends MainPageObject {

    public static final String
            FOLDER_BY_NAME_XPATH_TPL = "xpath://*[@text='{SUBSTRING}']",
            ARTICLE_BY_TITLE_XPATH_TPL = "xpath://*[@text='{SUBSTRING}']",
            GOT_IT_DIALOG_BUTTON_XPATH = "xpath://*[@text='Got it']";

    public ReadingListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openFolderByName(String folder_name) {
        String folder_name_xpath = getLocatorOfElement(FOLDER_BY_NAME_XPATH_TPL, folder_name);
        this.waitForElementAndClick
                (folder_name_xpath, "Cannot find folder by name " + folder_name, 5);
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        String article_title_xpath = getLocatorOfElement(ARTICLE_BY_TITLE_XPATH_TPL, article_title);
        this.waitForElementPresent
                (article_title_xpath, "Cannot find saved article by title " + article_title, 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_title_xpath = getLocatorOfElement(ARTICLE_BY_TITLE_XPATH_TPL, article_title);
        this.waitForElementNotPresent
                (article_title_xpath, "Cannot delete saved article " + article_title, 15);
    }

    public void swipeByArticleToDelete(String article_title) {
        String article_title_xpath = getLocatorOfElement(ARTICLE_BY_TITLE_XPATH_TPL, article_title);
        this.waitForArticleToAppearByTitle(article_title);
        this.swipeElementToLeft
                (article_title_xpath, "Cannot find saved article");
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void clickGotItDialogButton() {
        this.waitForElementAndClick
                (GOT_IT_DIALOG_BUTTON_XPATH, "Cannot find Got it dialog button", 5);
    }
}
