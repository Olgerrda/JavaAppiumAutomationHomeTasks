package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INPUT = "xpath://*[contains(@text, 'Search Wikipedia')]";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia.alpha:id/search_close_btn";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia.alpha:id/search_results_list']//*[@text='{SUBSTRING}']";
        SEARCH_RESUL_ELEMENT = "xpath://*[contains(@text, 'Linkin Park discography')]";
        SEARCH_EMPTY_RESULTS_ELEMENT = "xpath://*[@text='No results']";
        SEARCH_RESULTS_LIST_TPL = "xpath://*[@resource-id='org.wikipedia.alpha:id/page_list_item_title' and contains(@text, '{SUBSTRING}')]";
    }

    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
