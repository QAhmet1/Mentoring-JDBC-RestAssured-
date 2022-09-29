package _JDBC.day1;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Intro {


    @Test
    public void test1(){

        String url="*********************";
        String username="*********************";
        String password="*********************";

         try{

             Connection connection= DriverManager.getConnection(url,username,password);

             Statement statement= connection.createStatement();

             ResultSet resultSet= statement.executeQuery("select * from actor");

             resultSet.next();
          String name= resultSet.getNString("first_name");
             System.out.println("name = " + name);
             String lastname= resultSet.getNString("last_name");
             System.out.println("lastname = " + lastname);

             System.out.println(name+" "+lastname);

         }catch (Exception e){
             System.out.println("e.getMessage() = " + e.getMessage());
         }





    }

    @Test
    public  void test2(){


        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        try{

            Connection connection= DriverManager.getConnection(url,username,password);

            Statement statement= connection.createStatement();

            ResultSet resultSet= statement.executeQuery("select * from actor");

            resultSet.next();
            String name= resultSet.getNString("first_name");
            System.out.println("name = " + name);
            String lastname= resultSet.getNString("last_name");
            System.out.println("lastname = " + lastname);

            System.out.println(name+" "+lastname);
            connection.close();

        }catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }


    }

}
