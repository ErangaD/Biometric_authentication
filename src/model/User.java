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
    private static float threshold;
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
        float[] handProperties=new float[10];
        handProperties[0]=thumb.getLength();
        handProperties[1]=thumb.getWidth();
        handProperties[2]=index.getLength();
        handProperties[3]=index.getWidth();
        handProperties[4]=middle.getLength();
        handProperties[5]=middle.getWidth();
        handProperties[6]=ring.getLength();
        handProperties[7]=ring.getWidth();
        handProperties[8]=baby.getLength();
        handProperties[9]=baby.getWidth();
        try{
            stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Hand;" );
            int y=0;
            while ( rs.next() ) {
                float[] lengthAndWidth=new float[10];
                float[] convertedValues=new float[10];
                float match;
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
                for(float d:lengthAndWidth){
                    String value=String.valueOf(d);
                    int len=value.length();
                    String[] splitedValue=value.split("");
                    int decimalPlace=Integer.parseInt(splitedValue[len-1]);
                    String decipheredVal="";
                    int decimalIndex=value.length();
                    for(int i=0;i<len-1;i++){
                        if(i==decimalPlace){
                            decipheredVal+=".";
                        }
                        int digit=Integer.parseInt(splitedValue[i]);
                        int newDegit=digit-i-1;
                        decipheredVal+=newDegit;                       
                    }
                    
                    match=Float.parseFloat(decipheredVal);
                    convertedValues[y]=match;
                    y++;
                }
                float cumulativeDifference=0;
                for(float val:convertedValues){
                    float difference=0;
                    for(float valr:handProperties){
                        difference=Math.abs(val-valr);
                    }
                    cumulativeDifference+=difference*difference;
                }
                if(Math.sqrt(cumulativeDifference)<threshold){
                    return true;
                }
            }
        }catch(Exception e){
            
        }
        
        return false;
    }
    public void createUser(){
        Connection con=Connect.connectDb();
        float[] lengthAndWidth=new float[10];
        float[] storedVal=new float[10];
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
        int j=0;
        for(float d:lengthAndWidth){
            String value=String.valueOf(d);
            String[] splitedValue=value.split("");
            String cipheredChar="";
            int i=1;
            int decimalIndex=value.length();
            for(String s:splitedValue){
                if(s.equals('.')){
                    decimalIndex=i-1;                   
                    i++;
                    continue;
                }
                int digit=Integer.parseInt(s);
                int newDegit=digit+i;
                cipheredChar+=newDegit;
                i++;
            }
            cipheredChar+=decimalIndex;
            storedVal[j]=Float.parseFloat(cipheredChar);
            j++;
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
                String sql1 = "INSERT INTO Hand VALUES ("+id+","+storedVal[0]+","+storedVal[1]
                        +","+storedVal[2]+","+storedVal[3]+","+storedVal[4]
                        +","+storedVal[5]+","+storedVal[6]+","+storedVal[7]
                        +","+storedVal[8]+","+storedVal[9]+");";
                stmt.executeUpdate(sql1);
            }
            rs.close();
        } catch (Exception e) {
        }
        
        
        
    }
}
