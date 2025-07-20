package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.OnboardingPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    @Test
    public void testCompareArticleTitle() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickAtArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.closeWikipediaGamesDialog();

        String expected_title = ArticlePageObject.getArticleTitle("Java (programming language)");
        assertEquals("We see unexpected title", "Java (programming language)", expected_title);
    }

    @Test
    public void testSwipeArticle() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Appium";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickAtArticleWithSubstring(search_line);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.closeWikipediaGamesDialog();
        ArticlePageObject.waitForTitleElement(search_line);
        ArticlePageObject.swipeToFooter();
    }


}
