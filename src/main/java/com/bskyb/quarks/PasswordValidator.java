package com.bskyb.quarks;

import java.util.*;


public class PasswordValidator {
    private final List<String> requirements = Arrays.asList("8 characters",
                                                    "a number",
                                                    "a lowercase",
                                                    "a capital letter",
                                                    "an underscore");
    public Rules isValid(String password) {
        var rules = new Rules();

        //Check of the 8 characters
        if (password.length() < 8) rules.nulesNotAccomplished.add(requirements.get(0));

        //Check for the underscore
        if (!password.contains("_")) rules.nulesNotAccomplished.add(requirements.get(4));

        //Check of a number, lowercase and capital letter
        boolean countNumbers = false;
        boolean countLowercases = false;
        boolean countUppercases = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) countNumbers = true;
            if (Character.isLowerCase(c)) countLowercases = true;
            if (Character.isUpperCase(c)) countUppercases = true;
        }
        if(!countNumbers) rules.nulesNotAccomplished.add(requirements.get(1));
        if(!countLowercases) rules.nulesNotAccomplished.add(requirements.get(2));
        if(!countUppercases) rules.nulesNotAccomplished.add(requirements.get(3));

        if(!rules.nulesNotAccomplished.isEmpty()) rules.fulfilled = false;

        return rules;
    }
}