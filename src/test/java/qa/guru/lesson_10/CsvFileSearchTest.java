package qa.guru.lesson_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import qa.guru.lesson_10.data.Language;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CsvFileSearchTest {

    @BeforeEach
    void setUp() {
        open("https://www.jetbrains.com/idea/");
        if ($(".language-suggest-bar").isDisplayed()) {
            $(".language-suggest-bar__close").click();
        }
    }

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
