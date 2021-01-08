package com.chandra.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) {
        try {
            File path = new File("G:\\New_MicroServices\\MicroServices\\Springboot-Microservice-main\\Springboot-Microservice-main\\Jdbc_Day1\\src\\main\\resources\\db.properties");
            FileInputStream fis = new FileInputStream(path);
            Properties p = new Properties();
            p.load(fis);
            Class.forName(p.getProperty("driver"));
            Connection con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pwd"));
            if (con != null) {
                System.out.println("Connection Established Successfully....");
            } else {
                System.out.println("Connection Failed.Please try again....");
            }
            con.close();
        }catch (IOException|ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }
}
