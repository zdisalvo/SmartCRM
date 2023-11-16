package com.amazon.ata.crm.service.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateValidPhone {

    private static final Pattern VALID_PHONE_PATTERN =
            Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *[x]?([\\d]{0,6}))?\\s*$");

    private CreateValidPhone() {

    }

    public static boolean isValidPhone(final String phoneToValidate) {
        if (phoneToValidate == null) {
            return false;
        }

        Matcher matcher = VALID_PHONE_PATTERN.matcher(phoneToValidate);

        return matcher.matches();
    }

    public static String formatPhoneNumber(final String phoneNumber) {
        String formattedPhone = "";
        String rawNumbers = "";

        // Define the regular expression pattern to match numbers
        Pattern pattern = Pattern.compile("\\d+");

        // Create a Matcher object to find the matches in the input string
        Matcher matcher = pattern.matcher(phoneNumber);

        // Iterate through the matches and extract the numbers
        while (matcher.find()) {
            String number = matcher.group(); // Get the matched number
            rawNumbers = rawNumbers + number;
        }
        int p = 0;
        int d = 6;

        for (int i = 0 ; i < rawNumbers.length() ; i++) {
            if (i == 0 && rawNumbers.charAt(i) == '1') {
                formattedPhone += rawNumbers.charAt(i) + " ";
                p++;
                d++;
            } else if (i == p) {
                formattedPhone += "(" + rawNumbers.charAt(i);
            } else if (i == p + 2) {
                formattedPhone += rawNumbers.charAt(i) + ") ";
            } else if (i == d) {
                formattedPhone += "-" + rawNumbers.charAt(i);
            } else if (i == p + 10) {
                formattedPhone += " x" + rawNumbers.charAt(i);
            } else {
                formattedPhone += rawNumbers.charAt(i);
            }
        }
        return formattedPhone;
    }
}
