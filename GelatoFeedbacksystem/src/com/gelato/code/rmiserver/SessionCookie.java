/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gelato.code.rmiserver;

/**
 * this class contains the getters and setters for the cookie
 * @author Nipuna Thathsara
 */
public class SessionCookie {
    private static String Cookie;

    public static String getCookie() {
        return Cookie;
    }

    public static void setCookie(String Cookie) {
        SessionCookie.Cookie = Cookie;
    }

    
    
    
}
