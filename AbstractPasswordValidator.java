package com.example.passwordchecker;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public abstract class AbstractPasswordValidator implements PasswordValidator {
    protected static final int Minimum_length = 12;
    protected static final Pattern UPPERCASE = Pattern.compile("[A-Z]");
    protected static final Pattern LOWERCASE = Pattern.compile("[a-z]");
    protected static final Pattern NUMBER = Pattern.compile("[0-9]");
    protected static final Pattern SYMBOL = Pattern.compile("[^a-zA-Z0-9]");

    protected boolean hasAdjacentDuplicates(String password) {
        return IntStream.range(0, password.length() - 1)
                .anyMatch(i -> password.charAt(i) == password.charAt(i + 1));
    }

    protected Set<String> getCharacterTypes(String password) {
        Set<String> characterTypes = new HashSet<>();

        if (UPPERCASE.matcher(password).find()) {
            characterTypes.add("uppercase");
        }
        if (LOWERCASE.matcher(password).find()) {
            characterTypes.add("lowercase");
        }
        if (NUMBER.matcher(password).find()) {
            characterTypes.add("number");
        }
        if (SYMBOL.matcher(password).find()) {
            characterTypes.add("symbol");
        }

        return characterTypes;
    }
}
