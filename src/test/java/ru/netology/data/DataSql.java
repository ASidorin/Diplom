package ru.netology.data;

import lombok.val;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSql {

    //public final static String urlForMysql = "jdbc:mysql://localhost:3306/app";
    //public final static String  userForMysql = "app";
    //public final static String  passwordForMysql = "pass";

    public final static String urlForPostgres = "jdbc:postgresql://localhost:5432/postgres";
    public final static String  userForPostgres = "app";
    public final static String  passwordForPostgres = "pass";


    public static String getPaymentStatus() {
        val getStatus = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1;";
        try (
                val connect = DriverManager.getConnection(urlForPostgres, userForPostgres, passwordForPostgres);
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
                val connect = DriverManager.getConnection(urlForPostgres, userForPostgres, passwordForPostgres);
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
