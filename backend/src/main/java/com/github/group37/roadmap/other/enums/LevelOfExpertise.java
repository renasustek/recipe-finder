package com.github.group37.roadmap.other.enums;

public enum LevelOfExpertise {
    NOVICE("Novice"),
    INTERMEDIATE("Intermediate"),
    EXPERT("Expert");

    private final String value;

    LevelOfExpertise(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // Method to convert a string back to an enum constant
    public static LevelOfExpertise fromValue(String value) {
        for (LevelOfExpertise expertise : values()) {
            if (expertise.getValue().equals(value)) {
                return expertise;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}