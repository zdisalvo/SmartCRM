package com.amazon.ata.crm.service.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateValidPhone {

    private static final Pattern VALID_PHONE_PATTERN = Pattern.compile("^[^01][0-9]{7}");

    private CreateValidPhone() {

    }

    public static boolean isValidPhone(final String phoneToValidate) {
        if (phoneToValidate == null) {
            return false;
        }

        Matcher matcher = VALID_PHONE_PATTERN.matcher(phoneToValidate);

        return matcher.matches();
    }
}
