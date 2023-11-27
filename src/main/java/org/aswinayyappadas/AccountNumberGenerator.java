package org.aswinayyappadas;

import java.util.Random;

public class AccountNumberGenerator {
    private static final String BRANCH_CODE = "ABC"; // Replace with your actual branch code
    private static int generateUniqueNumber() {
        // For simplicity, using a random number as an example
        Random random = new Random();
        return random.nextInt(1000000);
    }

    // Method to generate the account number by combining branch code and unique number
    public static String generateAccountNumber() {
        // Customize the format of your account number as needed
        return BRANCH_CODE + String.format("%06d", generateUniqueNumber());
    }
}
