package com.studentRegistrationSysytem.utils;

import java.util.Random;

public class AutoGenerateUniqIDs {

    public  static String uniqueId(String input) {

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%04d", random.nextInt(10000)));

        String randomNumber = sb.toString();
        String result = input.substring(0, 4) + randomNumber;

        return result.toUpperCase();

    }
}
