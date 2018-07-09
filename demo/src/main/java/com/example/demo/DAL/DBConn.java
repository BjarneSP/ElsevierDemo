package com.example.demo.DAL;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
        private static final String  serverName = "mysql67.unoeuro.com";
        private static final String  databaseName = "bjarnestorgaard_dk_db";

        String url = "jdbc:mysql://" + serverName + "/" + databaseName;

        private String  userName = "bjarnestorgaard_dk";
        private String  password = "bjarne1985";

        private static DBConn  instance = null;
        private static Connection conn;

        public DBConn(){


            try{
                //load of driver
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver class loaded ok");

            }
            catch(Exception e){
                System.out.println("Cannot find the driver");
                System.out.println(e.getMessage());
            }

            try {
                conn = DriverManager.getConnection(url, userName, password);
            }
            catch (SQLException e) {
                System.out.println("Problems with the connection to the database:");
                System.out.println(e.getMessage());
                System.out.println(url);
            }
        }

    //getDBcon: returns the singleton instance of the DB connection
    public  Connection getDBcon()
    {
        return conn;
    }
    //this method is used to get the instance of the connection
    public static DBConn getInstance()
    {
        if (instance == null)
        {
            instance = new DBConn();
        }
        return instance;
    }
}
