package utils;

import java.util.Random;

public class RandomUtils {

    private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com"};
    private static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM = new Random();


    public static String generateRandomEmail() {
        int length = 8 + RANDOM.nextInt(5);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(ALPHABETS.charAt(RANDOM.nextInt(ALPHABETS.length())));
        }

        String domain = DOMAINS[RANDOM.nextInt(DOMAINS.length)];
        return sb.toString() + "@" + domain;
    }

    public static String generateRandomIndianPhoneNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(RANDOM.nextInt(4) + 6);
        for (int i = 0; i < 9; i++) {
            sb.append(RANDOM.nextInt(10));
        }
        return sb.toString();
    }


}