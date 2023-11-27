
package org.aswinayyappadas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class TransactionRecorder {

    public static void recordTransaction(String accountNumber, double amount, String transactionType, double newBalance) {
        // Generate a unique transaction ID
        String transactionId = TransactionIdGenerator.generateTransactionId();

        // Get the current date and time
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());

        // Connect to the database and insert the transaction record
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO transactions (transactionid, accountnumber, amount, transactiondate, type) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, transactionId);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.setDouble(3, amount);
            preparedStatement.setTimestamp(4, timestamp);
            preparedStatement.setString(5, transactionType);

            preparedStatement.executeUpdate();

            // Update the balance after a successful transaction
            BalanceUpdater.updateBalance(accountNumber, newBalance);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
