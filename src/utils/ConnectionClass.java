/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author EddyF
 */
public class ConnectionClass {

    public Connection connection;

    public Connection getConnection() {
        String dbName = "hospitalmanagement";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName , username , password);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return connection;
    }
}
