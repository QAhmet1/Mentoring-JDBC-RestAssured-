package _JDBC;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;

public class Parent {
    private static Connection connection;
    protected static Statement statement;

    @BeforeTest
    public void open() {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";
        try {


            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterTest
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getDate(String value) throws SQLException {
        ResultSet resultSet = statement.executeQuery(value);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {

            String columnName = resultSetMetaData.getColumnName(i);
            System.out.printf("%-20s", columnName + " ");
        }
        System.out.println();
        resultSet.last();
        int rowCount = resultSet.getRow();
        for (int i = 1; i <= rowCount; i++) {
            resultSet.absolute(i);
            for (int j = 1; j <= columnCount; j++) {
                System.out.printf("%-20s", resultSet.getString(j) + " ");
            }
            System.out.println();

        }

    }

}
