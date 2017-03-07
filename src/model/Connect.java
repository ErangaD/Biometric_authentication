/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;


/**
 *
 * @author Eranga
 */
public class Connect {
    static Connection conn=null;
    
    public static Connection connectDb(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn=DriverManager.getConnection("jdbc:sqlite:biometrixAuth.sqlite");
            
            return conn;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
