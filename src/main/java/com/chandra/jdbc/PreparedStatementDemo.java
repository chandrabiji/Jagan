package com.chandra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            //step1:Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step2:Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
            //step3:Prepare the statement
            PreparedStatement ps = con.prepareStatement("insert into product(pname,qty,price) values(?,?,?)");
            System.out.println("Enter Product Name ?");
            ps.setString(1, sc.next());
            System.out.println("Enter Product Qty ?");
            ps.setInt(2, sc.nextInt());
            System.out.println("Enter Product Price ?");
            ps.setDouble(3, sc.nextDouble());
            //step4:Execute the query
            int n = ps.executeUpdate();
            if (n != 0) {
                System.out.println("Successfully Product Inserted....");
            } else {
                System.out.println("Notable to Inserted.Pleaes try again....");
            }
            //step5:close the statement and connection
            ps.close();
            con.close();
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }
}
