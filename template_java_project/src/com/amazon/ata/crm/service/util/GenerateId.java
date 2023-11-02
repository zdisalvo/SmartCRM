package com.amazon.ata.crm.service.util;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateId {

    static final int ID_LENGTH = 6;

    public GenerateId() {}

    public static String generateClientId() {
        return "C" + RandomStringUtils.randomNumeric(ID_LENGTH);
    }

    public static String generateUserId() {
        return "U" + RandomStringUtils.randomNumeric(ID_LENGTH);
    }

    public static String generateManagerId() {
        return "M" + RandomStringUtils.randomNumeric(ID_LENGTH);
    }

}
