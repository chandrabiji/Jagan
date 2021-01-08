package com.chandra.jdbc;

import java.sql.*;

public class CallableStatementDemo {

    public static void main(String[] args) {
        try {
            //step1:Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step2:Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
            //step3:Prepare the statement
            CallableStatement cs = con.prepareCall("{call proc1(?,?)}");
            cs.registerOutParameter(2, Types.INTEGER);
            cs.setInt(1, 25);
            //step4:Execute the query
            cs.execute();
            int result = cs.getInt(2);
            System.out.println("SQRT Value = " + result);
            //step5:close the statement and connection
            cs.close();
            con.close();
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }
}
