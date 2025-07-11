package tests;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    @Test
    public void testSaveFirstArticleToMyList() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipButton();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickAtArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.closeWikipediaGamesDialog();
        ArticlePageObject.waitForTitleElement("Java (programming language)");

        String article_title = ArticlePageObject.getArticleTitle("Java (programming language)");
        String name_of_folder = "Learning programming";

        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        ReadingListsPageObject ReadingListsPageObject = new ReadingListsPageObject(driver);
        ReadingListsPageObject.openFolderByName(name_of_folder);
        ReadingListsPageObject.clickGotItDialogButton();
        ReadingListsPageObject.swipeByArticleToDelete(article_title);
    }

}
