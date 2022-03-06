/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gelato.code.rmiserver;

import io.quickchart.QuickChart;
import java.awt.HeadlessException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 *
 * @author Nipuna Thathsara
 */
public class ImplementationRMI extends UnicastRemoteObject implements ServiceInterface{
    
    protected ImplementationRMI() throws RemoteException 
    {
	super();
    }
    
    /**
     * Creating a connection with the mysql database server
     */
    Connection conn = Mysql_Connection.dbconn();

    /**
     * Login function
     * @param name
     * @param Password
     * @return
     * @throws RemoteException 
     */
    @Override
    public Boolean login(String name, String Password) throws RemoteException {
        
        Boolean login = false;
        String sql = "SELECT * FROM `users` WHERE `User`='"+name+"' AND `Password`='"+Password+"'";
        PreparedStatement ps;
        ResultSet rs ;
            try {
                
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                if(rs.next())
                {
                   login = true;
                }
                
            } catch (SQLException ex) {
                System.out.println("SQL Exception "+ex);
            }catch (HeadlessException e) {
                System.out.println("HeadlessException "+e);
            }
            return login;
    }

    /**
     * Method for getting input from 2 choice answers from radio buttons
     * @param a1
     * @param a2
     * @param group
     * @return
     * @throws RemoteException 
     */
    @Override
    public String YNAnswer(JRadioButton a1, JRadioButton a2, ButtonGroup group) throws RemoteException {
        String res = null;
        a1.setActionCommand("Yes");
        a2.setActionCommand("No");
        if(a1.isSelected() || a2.isSelected())
        {
            res = group.getSelection().getActionCommand();
            System.out.println("Answer is ---> "+res);
        }
        return res;
    }

    /**
     * Method for getting input from questions with 3 choice answers from radio buttons
     * @param a1
     * @param a2
     * @param a3
     * @param group
     * @param num
     * @return
     * @throws RemoteException 
     */
    @Override
    public String GetItemandRating(JRadioButton a1, JRadioButton a2, JRadioButton a3 , ButtonGroup group , int num) throws RemoteException {
        if(num == 1)
        {
            a1.setActionCommand("Milk Shakes");
            a2.setActionCommand("Cakes");
            a3.setActionCommand("Mousses");
        }
        else
        {
            a1.setActionCommand("Bad");
            a2.setActionCommand("Avg");
            a3.setActionCommand("Good");
        }
        String res = null;
        if(a1.isSelected() || a2.isSelected() || a3.isSelected())
        {
            res = group.getSelection().getActionCommand();
            System.out.println("Answer is ---> "+res);
        }
        return res;
    }

    /**
     * Method for getting input from the ice cream selection
     * @param a1
     * @param a2
     * @param a3
     * @param a4
     * @param a5
     * @param a6
     * @param group
     * @return
     * @throws RemoteException 
     */
    @Override
    public String GetIceCream(JRadioButton a1, JRadioButton a2, JRadioButton a3, JRadioButton a4, JRadioButton a5, ButtonGroup group) throws RemoteException {
        
        String res = null;
        a1.setActionCommand("Vanilla");
        a2.setActionCommand("Chocolate");
        a3.setActionCommand("Strawberry");
        a4.setActionCommand("Chocolate Vanila Mix");
        a5.setActionCommand("Fruity");

        if(a1.isSelected() || a2.isSelected() || a3.isSelected() || a4.isSelected() || a5.isSelected())
        {
            res = group.getSelection().getActionCommand();
            System.out.println("Answer is ---> "+res);
        }
        return res;
    }

    /**
     * Method for submitting a set of results in the survey to mysql database  
     * @param array
     * @return
     * @throws RemoteException 
     */
    @Override
    public String SubmitResults(String[] array) throws RemoteException {
        String res;
        String sql = "INSERT INTO `answers`(`ID`, `Answer1`, `Answer2`, `Answer3`, `Answer4`, `Answer5`, `Answer6`, `Answer7`) VALUES (null,?,?,?,?,?,?,?)";
        PreparedStatement ps;
                
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, array[0]);
            ps.setString(2, array[1]);
            ps.setString(3, array[2]);
            ps.setString(4, array[3]);
            ps.setString(5, array[4]);
            ps.setString(6, array[5]);
            ps.setString(7, array[6]);
            ps.execute();
            res= "Results Submited Successfully ...!" ;
            
        } catch (SQLException ex) {
            System.out.println("Exception --> "+ex);
            res = null;
        }
        
        return res;
        
    }
    /**
     * method for getting chart url for favorite ice cream chart
     * @return
     * @throws RemoteException 
     */
    @Override
    public String printicecreamChart() throws RemoteException { 
        PreparedStatement ps;
        ResultSet rs;
        String results [][] = new String[5][2];
        int i =0;
        String sql ="SELECT `Answer4`,ROUND(100*COUNT(`Answer4`)/(SELECT COUNT(*) FROM `answers`),0)AS Precentage\n" +
                    "FROM `answers`\n" +
                    "GROUP BY `Answer4`\n" +
                    "ORDER BY `Answer4`";
        String url = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                results[i][0] = rs.getString("Answer4");
                results[i][1] = rs.getString("Precentage");
                
                i++;
            }
            System.out.println(results[0][0]+" "+results[0][1]+"\n"+results[1][0]+" "+results[1][1]+"\n"+results[2][0]+" "+results[2][1]);     
        } catch (SQLException ex) {
            System.out.println("DataAnalysis class iceCreamChart method\n  "+ex);
        }
        url = QuickCharts.geticecreamChart(results);
        
        return url;
    }
    /**
     * method for getting chart url for favorite other food tham ice cream chart
     * @return
     * @throws RemoteException 
     */
    @Override
    public String printOtherfoodChart() throws RemoteException { 
        PreparedStatement ps;
        ResultSet rs;
        String results [][] = new String[3][2];
        int i =0;
        String sql ="SELECT `Answer5`,ROUND(100*COUNT(`Answer5`)/(SELECT COUNT(*) FROM `answers`),0)AS Precentage\n" +
                    "FROM `answers`\n" +
                    "GROUP BY `Answer5`\n" +
                    "ORDER BY `Answer5`";
        String url = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                results[i][0] = rs.getString("Answer5");
                results[i][1] = rs.getString("Precentage");
                
                i++;
            }
            System.out.println(results[0][0]+" "+results[0][1]+"\n"+results[1][0]+" "+results[1][1]+"\n"+results[2][0]+" "+results[2][1]);     
        } catch (SQLException ex) {
            System.out.println("DataAnalysis class OtherfoodChart method\n  "+ex);
        }
        url = QuickCharts. getOtherfoodChart(results);
        
        return url;
    }
    /**
     * method for getting chart url for ratings for the foods that on the shop
     * @return
     * @throws RemoteException 
     */
     @Override
    public String printRatingfoodChart() throws RemoteException { 
        PreparedStatement ps;
        ResultSet rs;
        String results [][] = new String[3][2];
        int i =0;
        String sql ="SELECT `Answer7`,ROUND(100*COUNT(`Answer7`)/(SELECT COUNT(*) FROM `answers`),0)AS Precentage\n" +
                    "FROM `answers`\n" +
                    "GROUP BY `Answer7`\n" +
                    "ORDER BY `Answer7`";
        String url = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                results[i][0] = rs.getString("Answer7");
                results[i][1] = rs.getString("Precentage");
                
                i++;
            }
            System.out.println(results[0][0]+" "+results[0][1]+"\n"+results[1][0]+" "+results[1][1]+"\n"+results[2][0]+" "+results[2][1]);     
        } catch (SQLException ex) {
            System.out.println("DataAnalysis class RatingfoodChart method\n  "+ex);
        }
        url = QuickCharts. getRatingfoodChart(results);
        
        return url;
    }
    /**
     * method for getting chart url for see people opinion on ice cream
     * @return
     * @throws RemoteException 
     */
     @Override
    public String printOpiniondChart() throws RemoteException { 
        PreparedStatement ps;
        ResultSet rs;
        String results [][] = new String[2][2];
        int i =0;
        String sql ="SELECT `Answer3`,ROUND(100*COUNT(`Answer3`)/(SELECT COUNT(*) FROM `answers`),0)AS Precentage\n" +
                    "FROM `answers`\n" +
                    "GROUP BY `Answer3`\n" +
                    "ORDER BY `Answer3`";
        String url = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                results[i][0] = rs.getString("Answer3");
                results[i][1] = rs.getString("Precentage");
                
                i++;
            }
            System.out.println(results[0][0]+" "+results[0][1]);     
        } catch (SQLException ex) {
            System.out.println("DataAnalysis class RatingfoodChart method\n  "+ex);
        }
        url = QuickCharts. getOpinionChart(results);
        
        return url;
    }
    

  
    
}
