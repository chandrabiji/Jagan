package com.chandra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProduct {

    public static void main(String[] args) {
        try {
            //step1:Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step2:Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
            //step3:Prepare the statement
            Statement st = con.createStatement();
            //step4:Execute the query
            int n = st.executeUpdate("insert into product(pname,qty,price) values('soap',1,120)");
            if (n != 0) {
                System.out.println("Product Record Inserted Successfully.....");
            } else {
                System.out.println("Product Notable to Inserted.Please try again...");
            }
            //step5:close the statement and connection
            st.close();
            con.close();
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }
}
