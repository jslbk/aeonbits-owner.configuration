package data.providers.tests;

import data.providers.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CsvFileSearchTest extends TestBase {

    @CsvFileSource(resources = "/test_data/searchResultsShouldNotBeEmpty.csv", delimiter = '|')
    @ParameterizedTest(name = "Set {0} language main page title is {1}, subtitle is {2} and download button's text is {3}")
    void selenideSiteShouldDisplayCorrectButtons(String language, String title, String subtitle, String downloadButton) {
        $("[data-test=language-picker]").click();
        $$(".wt-list-item__content").findBy(text(language))
                .click();
        $(".wt-container h1").shouldHave(text(title));
        $(".rs-subtitle-2").shouldHave(text(subtitle));
        $(".wt-section a[data-test=button]", 0).shouldHave(text(downloadButton));
    }

}
