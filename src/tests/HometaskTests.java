package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.OnboardingPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class HometaskTests extends CoreTestCase {

    //Ex3
    @Test
    public void testCancelSearch() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipButton();

        String search_line = "Batman";
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForMultipleSearchResults(search_line);
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForNoSearchResultsPresent(search_line);
    }

    //Ex5
    @Test
    public void testSwipeOnboarding() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.initOnboarding();
        OnboardingPageObject.swipeOnboardingLeft(1000);
        OnboardingPageObject.waitForNextOnboardingScreenPresent("New ways to explore");
        OnboardingPageObject.swipeOnboardingLeft(1000);
        OnboardingPageObject.waitForNextOnboardingScreenPresent("Reading lists with sync");
        OnboardingPageObject.swipeOnboardingLeft(1000);
        OnboardingPageObject.waitForNextOnboardingScreenPresent("Data & Privacy");
        OnboardingPageObject.finishOnboarding();
    }

    //Ex6
    @Test
    public void testArticleTitlePresent() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipButton();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickAtArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.closeWikipediaGamesDialog();
        ArticlePageObject.checkArticleTitle("Java (programming language)");
    }
}

