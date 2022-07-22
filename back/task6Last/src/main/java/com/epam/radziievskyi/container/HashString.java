package com.epam.radziievskyi.container;

public class HashString implements HashEl {
    private final int DEFAULT_CHARS_COUNT = 4;
    private final String string;

    public HashString (String string) {
        this.string = string;
    }

    @Override
    public Integer hashByLength (String hash) {
        return string.length();
    }

    @Override
    public Integer hashByElements (String hash) {
        int sum = 0;
        int charsCount = DEFAULT_CHARS_COUNT;
        if (string.length() < DEFAULT_CHARS_COUNT) {
            charsCount = string.length();
        }
        for (int i = 0; i < charsCount; i++) {
            sum += string.codePointAt(i);
        }
        return sum;
    }
}
