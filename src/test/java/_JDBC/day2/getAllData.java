package _JDBC.day2;

import _JDBC.Parent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class getAllData extends Parent {


    @Test
    public void test1() throws SQLException {

        // City tablosundan cityId ve City namelerin hepsini yazdiriniz?
        ResultSet resultSet = statement.executeQuery("select * from city");

        while (resultSet.next()) {
            String cityId = resultSet.getString(1);
            String cityName = resultSet.getNString("city");
            System.out.println(cityId + " " + cityName);
        }

    }

    @Test
    public void test2() throws SQLException {

        // city tablosundan tum verileri tablo seklinde getiriniz(column Name ler dahil)?
        ResultSet resultSet = statement.executeQuery("select * from city");
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

    @Test
    public void test3() throws SQLException {
        open();
        getDate("select * from actor");
        close();
    }
}
