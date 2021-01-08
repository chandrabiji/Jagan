package com.chandra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdate {

    public static void main(String[] args) {
        try {
            //step1:Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step2:Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
            //step3:Prepare the statement
            Statement st = con.createStatement();
            st.addBatch("insert into product(pname,qty,price) values('abc',10,500)");
            st.addBatch("update product set pname='Wheet' where pid=1");
            //step4:Execute the query
            int[] effectedRows = st.executeBatch();
            System.out.println("No of Rows Executed = " + effectedRows.length);
            //step5:close the statement and connection
            st.close();
            con.close();
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }

    }
}
