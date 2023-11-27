package org.aswinayyappadas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BalanceUpdater {

    public static void updateBalance(String accountNumber, double newBalance) {
        // Connect to the database and update the customer's balance
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE accounts SET balance = ? WHERE account_number = ?")) {

            preparedStatement.setDouble(1, newBalance);
            preparedStatement.setString(2, accountNumber);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
