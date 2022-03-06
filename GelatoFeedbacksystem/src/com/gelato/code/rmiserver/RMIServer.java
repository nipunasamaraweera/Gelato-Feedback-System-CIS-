package com.gelato.code.rmiserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 * RMI server class
 * @author Nipuna Thathsara
 */
public class RMIServer{
 
    public static void main(String [] args) throws RemoteException
    {
        Registry reg = LocateRegistry.createRegistry(1099);
        ImplementationRMI serv = new ImplementationRMI();
        reg.rebind("db", serv);
        System.out.println("Server is  Running");
    }
    
    
}

    
