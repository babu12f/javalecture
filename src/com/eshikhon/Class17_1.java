package com.eshikhon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Class17_1 {
    public static void main(String[] args) {
        try{
            /*
            *
            * jar download link
            *
            * https://osdn.net/projects/sfnet_id2d/downloads/jdbc%20drivers/mysql-connector-java-5.1.15-bin.jar/
            *
            * */
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javaclass","root","");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from person_info");

            while(rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println();
                System.out.println();
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
