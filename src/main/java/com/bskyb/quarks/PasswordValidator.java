package com.bskyb.quarks;

import java.util.HashMap;
import java.util.Map;

public class PasswordValidator {
    public boolean isValid(String password) {
        var rulesFollowed = 0;
        HashMap<String, Boolean> rules = new HashMap<>();

        //Assignation of rules
        rules.put("8 characters", false);
        rules.put("a capital letter", false);
        rules.put("a lowercase", false);
        rules.put("a number", false);
        rules.put("an underscore", false);

        //Check of the 8 characters
        if (password.length() >= 8) {
            rules.put("8 characters", true);
        }

        //Check of a number, lowercase and capital letter
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                rules.put("a number", true);
            }
            if (Character.isLowerCase(c)) {
                rules.put("a lowercase", true);
            }
            if (Character.isUpperCase(c)) {
                rules.put("a capital letter", true);
            }
        }

        //Check for the underscore
        if (password.contains("_")) {
            rules.put("an underscore", true);
        }

        for (Map.Entry<String, Boolean> rule : rules.entrySet()) {
            if (rule.getValue() == false) {
                System.out.println("Your password needs " + rule.getKey() + ".");
            }else{
                ++rulesFollowed;
            }
        }
        return rulesFollowed == rules.size();
    }
}