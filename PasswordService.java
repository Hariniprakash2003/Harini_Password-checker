package com.example.passwordchecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PasswordService extends AbstractPasswordValidator {

    @Override
    public boolean isPasswordStrong(String password) throws IllegalArgumentException {
        validatePassword(password);
        return true; // passed means then password is strong
    }

    private void validatePassword(String password) throws IllegalArgumentException {
        List<String> validationMessages = new ArrayList<>();

        // Checking length
        if (password.length() < Minimum_length) {
            validationMessages.add("Password must be at least " + Minimum_length + " characters long");
        }else if (password.length() < 14) {
            validationMessages.add("For better security, use a password with at least 14 characters.");
        }

        // Checking for adjacent duplicate 
        if (hasAdjacentDuplicates(password)) {
            validationMessages.add("Password must not have adjacent duplicate");
        }
        // Checking  for the character type uniqueness
        Set<String> characterTypes = getCharacterTypes(password);
        if (characterTypes.size() < 4) {
            validationMessages.add("Password should contain uppercase, lowercase, number, and symbols");
        }

        if (!validationMessages.isEmpty()) {
            throw new IllegalArgumentException(" " + String.join(" ", validationMessages));
        }
    }
}
