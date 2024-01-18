package data.providers.tests;

import com.codeborne.selenide.SelenideElement;
import data.providers.TestBase;
import org.junit.jupiter.api.BeforeEach;
import data.providers.data.Language;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnumSourceTest extends TestBase {

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