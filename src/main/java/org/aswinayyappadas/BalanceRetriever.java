package org.aswinayyappadas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceRetriever {

    public static double retrieveBalance(String accountNumber) {
        double currentBalance = 0.0;

        // Connect to the database and retrieve the current balance
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT balance FROM customer_accounts WHERE account_number = ?")) {

            preparedStatement.setString(1, accountNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    currentBalance = resultSet.getDouble("balance");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currentBalance;
    }
}
