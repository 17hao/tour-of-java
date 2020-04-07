package xyz.shiqihao.effective.java.chapter02;

import java.util.Objects;

/**
 * Prefer dependency injection to hardwiring resources.
 */
public class Item05 {
    public static void main(String[] args) {
        SpellChecker zh = new SpellChecker(new Lexicon("zh"));
        SpellChecker en = new SpellChecker(new Lexicon("en"));
        System.out.println(zh.isValid("zh") + " " + en.language());
    }
}

/**
 * What required is the ability to support multi instances of
 * the class(in our example, SpellChecker).
 * We need several kinds of SpellCheckers support multi languages,
 */
class SpellChecker {
    // Inappropriate use of static utility
    // private static Lexicon dictionary = new Lexicon("xx");
    //
    // private SpellChecker() {
    // }

    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    boolean isValid(String word) {
        return word.equals(Lexicon.language);
    }

    String language() {
        return dictionary.suggestion;
    }
}

class Lexicon {
    static String language;
    String suggestion;

    Lexicon(String val) {
        language = val;
    }
}
