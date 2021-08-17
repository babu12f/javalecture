package com.jdbcclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Class18 {
    public static void main(String[] args) {
        //insertdata();
        updateData();
        readData();
    }

    private static void updateData() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/javaclass", "root", "");

            Statement statement = connection.createStatement();

            String updateQuery = "update person_info set name_p = 'ratul', age = 33, address = 'sylhet', " +
                    "email = 'ratul@kmail.com' " +
                    "where id=6";

            statement.execute(updateQuery);
        }
        catch (Exception e){}
    }

    private static void insertdata() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/javaclass", "root", "");

            Statement stmt = con.createStatement();
            String insertQuery = "insert into person_info (name_p, age, address, email) values('mz', 25, 'dhaka', 'mz@g.com')";

            stmt.execute(insertQuery);
            con.close();
        }
        catch (Exception e){}
    }

    private static void readData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/javaclass", "root", "");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select  name_p as name, age, address as addr, email, id as p_id from person_info");

            while (rs.next()) {
                int personId = rs.getInt("p_id");
                String personName = rs.getString("name");
                int personAge = rs.getInt("age");
                String personAddress = rs.getString("addr");
                String personEmail = rs.getString("email");

                PersonInfo personInfo = new PersonInfo(personId, personName, personAge, personAddress, personEmail);

                personInfo.print();
            }

            con.close();
        }
        catch (Exception e){}
    }
}
