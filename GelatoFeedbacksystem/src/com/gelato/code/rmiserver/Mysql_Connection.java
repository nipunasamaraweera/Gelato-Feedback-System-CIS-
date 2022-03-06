/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gelato.code.rmiserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *this class will connect the survey to the database
 * @author Nipuna Thathsara
 */
public class Mysql_Connection {
    
        private static final String UN = "root";
        private static final String pw = "";
        private static final String URL = "jdbc:mysql://localhost:3306/gelato_db"; 
    
        public static Connection dbconn()
    {
        Connection con ;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(URL, UN, pw);
            System.out.println("Connection Successfully Established");
            return con;
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException");
            return null;
        }
        catch(SQLException ee)
        {
            System.out.println("SQLException");
            return null;
        }
        catch(NullPointerException ex){
            System.out.println("Null pointer Error");
            return null;
        }
    }
    
}
