package ru.netology.data;

import lombok.val;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSql {


    public static String getPaymentStatus() {
        val getStatus = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1;";
        try (
                val connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
                val createStmt = connect.createStatement();
        ) {
            try (val resultSet = createStmt.executeQuery(getStatus)) {
                if (resultSet.next()) {
                    val paymentStatus = resultSet.getString(1);
                    return paymentStatus;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }


    public static String getPaymentFromCreditStatus() {
        val getStatus = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
        try (
                val connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
                val createStmt = connect.createStatement();
        ) {
            try (val resultSet = createStmt.executeQuery(getStatus)) {
                if (resultSet.next()) {
                    val paymentStatus = resultSet.getString(1);
                    return paymentStatus;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }


}
