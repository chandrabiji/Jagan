package com.chandra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) throws  ClassNotFoundException, SQLException {
        //step1:Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //step2:Establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");

        if(con!=null){
            System.out.println("Connection Established Successfully.....");
        }else{
            System.out.println("Connection Failed.Please try again....");
        }
    }
}
