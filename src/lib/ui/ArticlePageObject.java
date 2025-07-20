package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
            WIKIGAMES_DIALOG_CLOSE_BUTTON_ID = "id:org.wikipedia.alpha:id/closeButton",
            AFTER_WIKIGAMES_SPACE_ID = "id:org.wikipedia.alpha:id/snackbar_text",
            TITLE_BY_SUBSTRING_TPL_XPATH = "xpath://*[@resource-id='pcs']//*[@text='{SUBSTRING}']",
            FOOTER_ELEMENT_XPATH = "xpath://*[@text='View article in browser']",
            SAVE_OPTION_BUTTON_ID = "id:org.wikipedia.alpha:id/page_save",
            OPTIONS_ADD_TO_LIST_XPATH = "xpath://android.widget.Button[@resource-id='org.wikipedia.alpha:id/snackbar_action']",
            MY_LIST_INPUT_FIELD_ID = "id:org.wikipedia.alpha:id/text_input",
            MY_LIST_OK_BUTTON_ID = "id:android:id/button1",
            CLOSE_ARTICLE_BUTTON_XPATH = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void closeWikipediaGamesDialog() {
        this.waitForElementAndClick(WIKIGAMES_DIALOG_CLOSE_BUTTON_ID, "Cannot find dialog's close button", 15);
        this.waitForElementAndClick(AFTER_WIKIGAMES_SPACE_ID, "Cannot find space to click after closing dialog", 15);
    }

    public WebElement waitForTitleElement(String substring) {
        String search_result_xpath = getLocatorOfElement(TITLE_BY_SUBSTRING_TPL_XPATH, substring);
        return this.waitForElementPresent(search_result_xpath, "Cannot find title " + substring + " on page", 15);
    }

    public String getArticleTitle(String substring) {
        WebElement title_element = waitForTitleElement(substring);
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(FOOTER_ELEMENT_XPATH, "Cannot find the end of article", 20);
    }

    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(
                SAVE_OPTION_BUTTON_ID, "Cannot find button to save article", 5);
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_LIST_XPATH, "Cannot find option to add article to reading list", 5);
        this.waitForElementAndClear(
                MY_LIST_INPUT_FIELD_ID, "Cannot find text input to clear it", 5);
        this.waitForElementAndSendKeys(
                MY_LIST_INPUT_FIELD_ID, name_of_folder,"Cannot put text into articles folder input", 5);
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON_ID, "Cannot press Ok button", 5);
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON_XPATH, "Cannot close article, cannot find back link", 5);
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON_XPATH, "Cannot close article, cannot find back link", 5);
    }

    public void checkArticleTitle(String substring) {
        this.assertElementPresent(getLocatorOfElement(TITLE_BY_SUBSTRING_TPL_XPATH, substring), "Cannot find the title of article");
    }
}
