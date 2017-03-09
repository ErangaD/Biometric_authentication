/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Eranga
 */
public class Connect {
    static Connection conn=null;
    static Statement stmt = null;
    static {
        try{
            Class.forName("org.sqlite.JDBC");
            conn=DriverManager.getConnection("jdbc:sqlite:biometrixAuth.sqlite");
            stmt = conn.createStatement();
            String sql1="CREATE TABLE IF NOT EXISTS \"Hand\" (\"user_id\" INTEGER NOT NULL , \"thumb_length\" VARCHAR, \"thumb_width\" VARCHAR, \"index_length\" VARCHAR, \"index_width\" VARCHAR, \"middle_length\" VARCHAR, \"middle_width\" VARCHAR, \"ring_length\" VARCHAR, "
                    + "\"ring_width\" VARCHAR, \"baby_length\" VARCHAR, \"baby_width\" VARCHAR)";
            stmt.executeUpdate(sql1);
            String sql2="CREATE TABLE IF NOT EXISTS \"User\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  "
                    + "NOT NULL  UNIQUE , \"name\" VARCHAR, \"user_id\" VARCHAR)";
            stmt.executeUpdate(sql2);
            stmt.close();
        }
        catch(Exception e){
            System.out.println(e + "In the static method");
        }finally{
            try {
                if(conn!=null)
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
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
