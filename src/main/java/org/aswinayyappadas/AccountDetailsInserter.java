package org.aswinayyappadas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDetailsInserter {

    public static void insertNewAccount(String accountNumber, int customerId, double balance, String accountType) {
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO account_details (accountnumber, customerid, balance, accounttype) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, accountNumber);
            preparedStatement.setInt(2, customerId);
            preparedStatement.setDouble(3, balance);
            preparedStatement.setString(4, accountType);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewAccount(String accountNumber, int customerId, double balance, String accountType, double interestRate) {
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO account_details (accountnumber, customerid, balance, accounttype, interestrate) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, accountNumber);
            preparedStatement.setInt(2, customerId);
            preparedStatement.setDouble(3, balance);
            preparedStatement.setString(4, accountType);
            preparedStatement.setDouble(5, interestRate);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
