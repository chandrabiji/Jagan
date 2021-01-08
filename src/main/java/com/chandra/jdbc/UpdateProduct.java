package com.chandra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateProduct {
    public static void main(String[] args) {
        try {
            //step1:Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step2:Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
            //step3:Prepare the statement
            Statement st = con.createStatement();
            //step4:execute the query
            int n = st.executeUpdate("update product set qty=2 where pid=2");
            if (n!=0){
                System.out.println("Successfully Product Qty Updated....");
            }else{
                System.out.println("Notable to Updated.Pleaes try again...");
            }
            //step5:close the statement and connection
            st.close();
            con.close();
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }
}
