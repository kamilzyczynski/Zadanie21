package com.example.zadanie21;

public enum Category {
    FOOD("Spożywcze"),
    HOME("Domowe"),
    OTHER("Inne");

    private final String translation;

    Category(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
