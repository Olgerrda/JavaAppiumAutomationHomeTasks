package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ReadingListsPageObject extends MainPageObject {

    public static final String
            FOLDER_BY_NAME_XPATH_TPL = "//*[@text='{SUBSTRING}']",
            ARTICLE_BY_TITLE_XPATH_TPL = "//*[@text='{SUBSTRING}']",
            GOT_IT_DIALOG_BUTTON_XPATH = "//*[@text='Got it']";

    public ReadingListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openFolderByName(String folder_name) {
        String folder_name_xpath = getLocatorOfElement(FOLDER_BY_NAME_XPATH_TPL, folder_name);
        this.waitForElementAndClick(
                By.xpath(folder_name_xpath), "Cannot find folder by name " + folder_name, 5);
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        String article_title_xpath = getLocatorOfElement(ARTICLE_BY_TITLE_XPATH_TPL, article_title);
        this.waitForElementPresent(
                By.xpath(article_title_xpath), "Cannot find saved article by title " + article_title, 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_title_xpath = getLocatorOfElement(ARTICLE_BY_TITLE_XPATH_TPL, article_title);
        this.waitForElementNotPresent(
                By.xpath(article_title_xpath), "Cannot delete saved article " + article_title, 15);
    }

    public void swipeByArticleToDelete(String article_title) {
        String article_title_xpath = getLocatorOfElement(ARTICLE_BY_TITLE_XPATH_TPL, article_title);
        this.waitForArticleToAppearByTitle(article_title);
        this.swipeElementToLeft(
                By.xpath(article_title_xpath), "Cannot find saved article");
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void clickGotItDialogButton() {
        this.waitForElementAndClick(
                By.xpath(GOT_IT_DIALOG_BUTTON_XPATH), "Cannot find Got it dialog button", 5);
    }
}
