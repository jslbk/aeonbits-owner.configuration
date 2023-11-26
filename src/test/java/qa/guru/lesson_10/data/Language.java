package qa.guru.lesson_10.data;

public enum Language {
    RU("Русский"),
    EN("English"),
    FR("Français"),
    DN("Deutsch"),
    ES("Español"),
    KO("한국어"),
    ZH("简体中文"),
    PT_BR("Português do Brasil"),
    JA("日本語");

    private final String displayName;

    Language(String displayName) {
        this.displayName = displayName;
    }

    public String getLanguageName() {
        return displayName;
    }
}

