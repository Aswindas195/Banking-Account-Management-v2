package org.aswinayyappadas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDetailsInserter {

    public static void insertNewCustomer(int customerid, String name, String phone, String address, String email, String passwordhash) {
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO customer (customerid, name, phone, address, email, passwordhash) VALUES (?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setInt(1, customerid);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, passwordhash);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
