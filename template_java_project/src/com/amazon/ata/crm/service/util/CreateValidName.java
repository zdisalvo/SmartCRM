package com.amazon.ata.crm.service.util;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

public class CreateValidName {

    //TODO validate name
    private static final Pattern INVALID_NAME_PATTERN = Pattern.compile("[^a-zA-Z_'-.]");

    private CreateValidName() {}

    public static boolean isValidName(final String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        }

        return !INVALID_NAME_PATTERN.matcher(stringToValidate).find();
    }

    //TODO - create valid email
    //TODO - create valid phone number
}
