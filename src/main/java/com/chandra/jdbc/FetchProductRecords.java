package com.chandra.jdbc;

import java.sql.*;

public class FetchProductRecords {

    public static void main(String[] args) {
        try {
            //step1:Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step2:Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
            //step3:Prepare the statement
            Statement st = con.createStatement();
            //step4:Execute the query
            ResultSet rs = st.executeQuery("select * from product");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1)+"\t"+rsmd.getColumnName(2)+"\t"+rsmd.getColumnName(3)+"\t"+rsmd.getColumnName(4));
            System.out.println("---------------------------");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getDouble(4));
            }
            //step5:close the statement and connection
            st.close();
            con.close();
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }
}
