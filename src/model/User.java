/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Eranga
 */
public class User {
    private String name;
    private String ID;
    private Thumb thumb;
    private IndexFinger index;
    private MiddleFinger middle;
    private RingFinger ring;
    private BabyFinger baby;
    private static Statement stmt = null;
    public User(){
        /*CREATE  TABLE "main"."Hand" ("thumb" FLOAT, "index_finger" FLOAT,
        "middle_finger" FLOAT, "ring_finger" FLOAT, "baby_finger" FLOAT, 
        "user_id" INTEGER)*/
    }
    public void setFingers(Thumb thumb,IndexFinger index,MiddleFinger middle,
            RingFinger ring,BabyFinger baby){
        this.thumb=thumb;
        this.index=index;
        this.middle=middle;
        this.baby=baby;
        this.ring=ring;
    }
    public static boolean checkForMatch(Thumb thumb,IndexFinger index,MiddleFinger middle,
        RingFinger ring,BabyFinger baby){
        Connection con=Connect.connectDb();
        try{
            stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Hand;" );
            
            while ( rs.next() ) {
                float[] lengthAndWidth=new float[10];
                lengthAndWidth[0]=rs.getFloat("thumb_length");
                lengthAndWidth[1]=rs.getFloat("thumb_width");
                lengthAndWidth[2]=rs.getFloat("index_length");
                lengthAndWidth[3]=rs.getFloat("index_width");
                lengthAndWidth[4]=rs.getFloat("middle_length");
                lengthAndWidth[5]=rs.getFloat("middle_width");
                lengthAndWidth[6]=rs.getFloat("ring_length");
                lengthAndWidth[7]=rs.getFloat("ring_width");
                lengthAndWidth[8]=rs.getFloat("baby_length");
                lengthAndWidth[9]=rs.getFloat("baby_widths");
                //reconvert to the actual data using cesar's method shift back by 2
                
                
                
            }
        }catch(Exception e){
            
        }
        
        return true;
    }
    public void createUser(){
        Connection con=Connect.connectDb();
        float[] lengthAndWidth=new float[10];
        lengthAndWidth[0]=thumb.getLength();
        lengthAndWidth[1]=thumb.getWidth();
        lengthAndWidth[2]=index.getLength();
        lengthAndWidth[3]=index.getWidth();
        lengthAndWidth[4]=middle.getLength();
        lengthAndWidth[5]=middle.getWidth();
        lengthAndWidth[6]=ring.getLength();
        lengthAndWidth[7]=ring.getWidth();
        lengthAndWidth[8]=baby.getLength();
        lengthAndWidth[9]=baby.getWidth();
        for(float d:lengthAndWidth){
            String value=String.valueOf(d);
            String[] splitedValue=value.split("");
            int i=1;
            for(String s:splitedValue){
                if(s.equals('.')){
                    
                }
                int digit=Integer.parseInt(s);
                int newDegit=digit+i;
                i++;
            }
        }
        
        try {
            
            stmt=con.createStatement();
            String sql = "INSERT INTO User (name,n_id)"
                + "VALUES ("+name+","+ID+");";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery( "SELECT id FROM User where name="+name+" LIMIT 1;" );
            int id;
            while (rs.next()) {
                id = rs.getInt("id");
                String sql1 = "INSERT INTO Hand VALUES ("+id+","+thumb.getLength()+","+
                        +","++","++","+
                        +","++","++","+
                        ring.getWidth()+","++","++");";
                stmt.executeUpdate(sql1);
            }
            rs.close();
        } catch (Exception e) {
        }
        
        
        
    }
}
