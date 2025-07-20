package lib.ui;

import io.appium.java_client.AppiumDriver;

public class SearchPageObject extends MainPageObject {

    private static final String
            SEARCH_INPUT_XPATH = "xpath://*[contains(@text, 'Search Wikipedia')]",
            SEARCH_CANCEL_BUTTON_ID = "id:org.wikipedia.alpha:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_XPATH_TPL = "xpath://*[@resource-id='org.wikipedia.alpha:id/search_results_list']//*[@text='{SUBSTRING}']",
            SEARCH_RESUL_ELEMENT_XPATH = "xpath://*[contains(@text, 'Linkin Park discography')]",
            SEARCH_EMPTY_RESULTS_ELEMENT_XPATH = "xpath://*[@text='No results']",
            SEARCH_RESULTS_LIST_XPATH_TPL = "xpath://*[@resource-id='org.wikipedia.alpha:id/page_list_item_title' and contains(@text, '{SUBSTRING}')]";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_INPUT_XPATH, "Cannot find and click init search element", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON_ID, "Cannot find search back button and click on it", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON_ID, "Search back button is still present", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(SEARCH_INPUT_XPATH, search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String search_string){
        String search_result_xpath = getLocatorOfElement(SEARCH_RESULT_BY_SUBSTRING_XPATH_TPL, search_string);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with search_string " + search_string);
    }

    public void clickAtArticleWithSubstring(String search_string){
        String search_result_xpath = getLocatorOfElement(SEARCH_RESULT_BY_SUBSTRING_XPATH_TPL, search_string);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with search_string " + search_string, 10);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(SEARCH_RESUL_ELEMENT_XPATH, "Cannot find anything by request", 15);
        return this.getAmountOfElements(SEARCH_RESUL_ELEMENT_XPATH);
    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULTS_ELEMENT_XPATH, "Cannot find empty result element", 15);
    }

    public void assertThereIsNoResultOfSearch(String search_string) {
        this.assertElementNotPresent(getLocatorOfElement(SEARCH_RESULT_BY_SUBSTRING_XPATH_TPL, search_string), "We supposed not find any results");
    }

    public void waitForMultipleSearchResults (String search_string) {
        waitForMultipleElementsPresent
                (getLocatorOfElement(SEARCH_RESULTS_LIST_XPATH_TPL, search_string), "No search results found", 15);
    }

    public void waitForNoSearchResultsPresent(String search_string) {
        waitForElementNotPresent
                (getLocatorOfElement(SEARCH_RESULTS_LIST_XPATH_TPL, search_string), "Search results are still present on the page", 5);

    }
}
