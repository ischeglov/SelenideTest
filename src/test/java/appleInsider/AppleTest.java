package appleInsider;

import core.BaseSelenideTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppleTest extends BaseSelenideTest {

    private final static String URL = "https://appleinsider.ru/";
    private final static String SEARCH_STRING = "Чем iPhone 13 отличается от iPhone 12";
    private final static String EXPECTED_WORD = "iphone-13";

    @Test
    public void checkHref() {
        /**
         * Первый вариант
         */
//        MainPage mainPage = new MainPage(URL);
//        mainPage.search(SEARCH_STRING);
//
//        SearchPage searchPage = new SearchPage();
//        String href = searchPage.getHrefFromFirstArticle();
//
//        Assertions.assertTrue(href.contains(EXPECTED_WORD));

        /**
         * Второй вариант
         */
        Assertions.assertTrue(new MainPage(URL)
                .search(SEARCH_STRING)
                .getHrefFromFirstArticle()
                .contains(EXPECTED_WORD));
    }
}
