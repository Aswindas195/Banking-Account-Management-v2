package org.aswinayyappadas;

import java.util.Random;

public class Customer extends PersonalDetails {
    int customerId;
    public int getCustomerId() {
        Random random = new Random();
        return (random.nextInt((9999 - 1000) + 1) + 1000);
    }
}
