package _JDBC.day1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class BeforeAfter {

    private Connection connection;

    private Statement statement;

    @BeforeTest
    public void beforeTest() throws SQLException {

        String url="j*********************";
        String username="*********************";
        String password="*********************";

        connection= DriverManager.getConnection(url,username,password);
        statement= connection.createStatement();
    }

    @AfterTest
    public void afterTest() throws SQLException {
        connection.close();
    }


    @Test
    public void test1() throws SQLException {
        ResultSet resultSet= statement.executeQuery("select * from language");
        resultSet.next();
        String name=resultSet.getNString("name");
        System.out.println("name = " + name);
        resultSet.next();
        name=resultSet.getNString("name");
        System.out.println("name = " + name);
        resultSet.previous();
        name=resultSet.getString("name");
        System.out.println("name = " + name);
        resultSet.last();
        name=resultSet.getString("name");
        System.out.println("name = " + name);
        resultSet.first();
        name=resultSet.getString("name");
        System.out.println("name = " + name);

    }


    @Test
    public void test2() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from film");

        rs.absolute(10) ;
        String title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15) ;
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(-15) ;
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(5) ;
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(-5) ;
        title=rs.getString("title");
        System.out.println("title = " + title);
    }

}
