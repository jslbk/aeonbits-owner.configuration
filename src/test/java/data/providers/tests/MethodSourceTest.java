package data.providers.tests;

import data.providers.TestBase;
import data.providers.data.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MethodSourceTest extends TestBase {

    @MethodSource("getTopMenuOptionsInAllLanguages")
    @ParameterizedTest(name = "Set language {0} and check top menu contains {1}")
    void selenideSiteShouldDisplayCorrectButtons(Language language, List<String> topMenuButtons) {
        $("[data-test=language-picker]").click();
        $$(".wt-list-item__content").findBy(text(language.getLanguageName()))
                .click();
        $$("[data-test=main-menu-item]").filter(visible)
                .shouldHave(texts(topMenuButtons));
    }

    public static Stream<Arguments> getTopMenuOptionsInAllLanguages() {
        return Stream.of(
                Arguments.of(Language.RU, List.of("Разработчикам", "Командам", "Образование", "Решения", "Поддержка", "Магазин")),
                Arguments.of(Language.EN, List.of("Developer Tools", "Team Tools", "Education", "Solutions", "Support", "Store")),
                Arguments.of(Language.FR, List.of("Pour développer", "Pour les équipes", "Enseignement", "Solutions", "Prise en charge", "Boutique")),
                Arguments.of(Language.DN, List.of("Entwicklungstools", "Team-Tools", "Bildung", "Lösungen", "Support", "Store")),
                Arguments.of(Language.JA, List.of("開発者ツール", "チームツール", "教育ツール", "ソリューション", "サポート", "ストア")),
                Arguments.of(Language.ZH, List.of("开发者工具", "团队工具", "教育", "解决方案", "支持", "在线商店")),
                Arguments.of(Language.ES, List.of("Para desarrolladores", "Para equipos", "Educación", "Soluciones", "Asistencia", "Tienda")),
                Arguments.of(Language.KO, List.of("개발자 도구", "팀 도구", "교육", "솔루션", "지원", "스토어")),
                Arguments.of(Language.PT_BR, List.of("Para desenvolvimento", "Para equipes", "Educação", "Soluções", "Suporte", "Loja"))
        );
    }
}