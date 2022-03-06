/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gelato.code.rmiserver;

/**
 * this class contains the methods for setting up the cookies
 * @author nipuna thathsara
 */
public class UserCookieCL {
    
    public void setCookie(String User)
    {
        SessionCookie.setCookie(User);
    }
    
    public String getCookie()
    {
        return SessionCookie.getCookie();
    }
    
}
