/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Eranga
 */
public class User {
    private static float threshold;
    public static void setThreshold(float t){
        threshold=t;
    }
    public static String checkForId(String id) {
        Connection con=Connect.connectDb();
        try{
            stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT id FROM User where user_id=\'"+id+"\';");
            while(rs.next()){
                return rs.getString("id");
            }
            
        }catch(Exception e){
            
        }
        return null;
        
            
    }
    private String user_name;
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
    public static boolean checkForMatch(String user_id,Thumb thumb,IndexFinger index,MiddleFinger middle,
        RingFinger ring,BabyFinger baby){
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
        Connection con=Connect.connectDb();
        try{
            stmt=con.createStatement();
            ResultSet res = stmt.executeQuery( "SELECT * FROM Hand where user_id"
                    + " = \'"+user_id+"\';" );
            while (res.next()) {
                
                String[] lengthAndWidth=new String[10];
                lengthAndWidth[0]=res.getString("thumb_length");
                lengthAndWidth[1]=res.getString("thumb_width");
                lengthAndWidth[2]=res.getString("index_length");
                lengthAndWidth[3]=res.getString("index_width");
                lengthAndWidth[4]=res.getString("middle_length");
                lengthAndWidth[5]=res.getString("middle_width");
                lengthAndWidth[6]=res.getString("ring_length");
                lengthAndWidth[7]=res.getString("ring_width");
                lengthAndWidth[8]=res.getString("baby_length");
                lengthAndWidth[9]=res.getString("baby_width");
                float[] convertedValues=new float[10];
                int y=0;
                for(String s:lengthAndWidth){
                    int lenString=s.length();
                    int decimalPoint=Integer.parseInt(s.substring(lenString-4),8);
                    int number=Integer.parseInt(s.substring(0,decimalPoint),2);
                    int fraction=Integer.parseInt(s.substring(decimalPoint,lenString-4),16);
                    float val=Float.parseFloat(number+"."+fraction);
                    convertedValues[y]=val;
                    y++;
                }
                float cumulativeDifference=0;
                for(int i=0;i<10;i++){
                    float difference=0;
                    difference=Math.abs(convertedValues[i]-handProperties[i]);
                    cumulativeDifference+=difference*difference;
                }
                if(Math.sqrt(cumulativeDifference)<threshold){
                    return true;
                }
               
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
       
    }
    public void createUser(String id1,String name){
        this.ID=id1;
        this.name=name;
        Connection con=Connect.connectDb();
        float[] lengthAndWidth=new float[10];
        String[] storedVal=new String[10];
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
            String[] splitedValue=value.split("\\.");
            int number=Integer.parseInt(splitedValue[0]);
            int fraction=Integer.parseInt(splitedValue[1]);
            String bNumber=Integer.toBinaryString(number);
            String bFraction=Integer.toHexString(fraction);
            int decimalPoint=bNumber.length();
            String bDecimalPoint=Integer.toOctalString(decimalPoint);
            String decimalLength=("0000"+bDecimalPoint).substring(bDecimalPoint.length());
            String cipheredChar="";
            cipheredChar+=bNumber+bFraction+decimalLength;
            storedVal[j]=cipheredChar;
            j++;
        }
        
        try {
            
            stmt=con.createStatement();
            String sql = "INSERT INTO User(name,user_id) VALUES (\'"+ name +"\',\'"+ID+"\');";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery( "SELECT id FROM User where name=\'"+name+"\' LIMIT 1;" );
            int id;
            while (rs.next()) {
                id = rs.getInt("id");
                String sql1 = "INSERT INTO Hand VALUES ("+id+",\'"+storedVal[0]+"\',\'"+storedVal[1]
                        +"\',\'"+storedVal[2]+"\',\'"+storedVal[3]+"\',\'"+storedVal[4]
                        +"\',\'"+storedVal[5]+"\',\'"+storedVal[6]+"\',\'"+storedVal[7]
                        +"\',\'"+storedVal[8]+"\',\'"+storedVal[9]+"\');";
                stmt.executeUpdate(sql1);
            }
            rs.close();
            con.close();
            JOptionPane.showMessageDialog(null, "You have successfully registered",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
    }
}
