package appleInsider;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

/**
 * Страница с найденными статьями
 */
public class SearchPage {

    private final ElementsCollection articleTitles = $$x("//h2//a");

    /**
     * Возвращаем href из первой статьи
     */
    public String getHrefFromFirstArticle() {
        return articleTitles.first().getAttribute("href");
    }
}

