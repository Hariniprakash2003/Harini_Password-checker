package com.example.passwordchecker;

public interface PasswordValidator {
    boolean isPasswordStrong(String password) throws IllegalArgumentException;
}
