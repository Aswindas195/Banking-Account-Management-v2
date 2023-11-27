package org.aswinayyappadas;

import java.util.UUID;

public class TransactionIdGenerator {

    public static String generateTransactionId() {
        // Generate a unique transaction ID using UUID
        return UUID.randomUUID().toString();
    }
}
