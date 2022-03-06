package com.gelato.code.rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 * RMI interface class
 * @author Nipuna Thathsara
 */
public interface ServiceInterface extends Remote{
     
    public Boolean login(String name, String Password) throws RemoteException;
    
    public String YNAnswer(JRadioButton a1, JRadioButton a2 , ButtonGroup group) throws RemoteException;
    
    public String GetItemandRating(JRadioButton a1, JRadioButton a2 , JRadioButton a3, ButtonGroup group ,int num) throws RemoteException;
    
    public String GetIceCream(JRadioButton a1, JRadioButton a2 , JRadioButton a3 ,JRadioButton a4, JRadioButton a5, ButtonGroup group) throws RemoteException;
    
    public String SubmitResults (String array[]) throws RemoteException;
    
    public String printicecreamChart() throws RemoteException;
    
    public String printOtherfoodChart() throws RemoteException;
    
    public String printRatingfoodChart() throws RemoteException;
    
    public String printOpiniondChart() throws RemoteException;
    
}
