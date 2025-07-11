package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String
                    SEARCH_INPUT = "//*[contains(@text, 'Search Wikipedia')]",
                    SEARCH_CANCEL_BUTTON = "org.wikipedia.alpha:id/search_close_btn",
                    SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia.alpha:id/search_results_list']//*[@text='{SUBSTRING}']",
                    SEARCH_RESUL_ELEMENT = "//*[contains(@text, 'Linkin Park discography')]",
                    SEARCH_EMPTY_RESULTS_ELEMENT = "//*[@text='No results']",
                    SEARCH_RESULTS_LIST_TPL = "//*[@resource-id='org.wikipedia.alpha:id/page_list_item_title' and contains(@text, '{SUBSTRING}')]";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_INPUT), "Cannot find and click init search element", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search back button and click on it", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Search back button is still present", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String search_string){
        String search_result_xpath = getLocatorOfElement(SEARCH_RESULT_BY_SUBSTRING_TPL, search_string);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with search_string " + search_string);
    }

    public void clickAtArticleWithSubstring(String search_string){
        String search_result_xpath = getLocatorOfElement(SEARCH_RESULT_BY_SUBSTRING_TPL, search_string);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with search_string " + search_string, 10);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent
                (By.xpath(SEARCH_RESUL_ELEMENT), "Cannot find anything by request", 15);
        return this.getAmountOfElements(By.xpath(SEARCH_RESUL_ELEMENT));
    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent
                (By.xpath(SEARCH_EMPTY_RESULTS_ELEMENT), "Cannot find empty result element", 15);
    }

    public void assertThereIsNoResultOfSearch(String search_string) {
        this.assertElementNotPresent(By.xpath(getLocatorOfElement(SEARCH_RESULT_BY_SUBSTRING_TPL, search_string)), "We supposed not find any results");
    }

    public void waitForMultipleSearchResults (String search_string) {
        waitForMultipleElementsPresent
                (By.xpath(getLocatorOfElement(SEARCH_RESULTS_LIST_TPL, search_string)), "No search results found", 15);
    }

    public void waitForNoSearchResultsPresent(String search_string) {
        waitForElementNotPresent
                (By.xpath(getLocatorOfElement(SEARCH_RESULTS_LIST_TPL, search_string)), "Search results are still present on the page", 5);

    }
}
