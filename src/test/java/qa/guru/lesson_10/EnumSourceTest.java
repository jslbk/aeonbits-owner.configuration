package qa.guru.lesson_10;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import qa.guru.lesson_10.data.Language;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnumSourceTest {

    @BeforeEach
    void setUp() {
        open("https://www.jetbrains.com/idea/");
        if ($(".language-suggest-bar").isDisplayed()) {
            $(".language-suggest-bar__close").click();
        }
    }

    @EnumSource(Language.class)
    @ParameterizedTest(name = "Set language '{0}' language and check it is selected")
    void selenideSiteShouldDisplayCorrectText(Language language) {
        SelenideElement languagePickerOption = $$(".wt-list-item__content")
                .findBy(text(language.getLanguageName()));
        $("[data-test=language-picker]").click();
        languagePickerOption.click();
        $("[data-test=language-picker]").click();
        languagePickerOption.parent().shouldHave(cssClass("wt-list-item_selected"));
    }
}