/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.BabyFinger;
import model.User;
import model.IndexFinger;
import model.MiddleFinger;
import model.RingFinger;
import model.Thumb;

/**
 *
 * @author Eranga
 */
public class AuthenticationController {
    public static void createUser(MiddleFinger middle,IndexFinger index,RingFinger ring,
            BabyFinger baby,Thumb thumb){
        
        if(User.checkForMatch(thumb, index, middle, ring, baby)){
            JOptionPane.showMessageDialog(null, "You have already registered",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            User hand=new User();
            hand.setFingers(thumb, index, middle, ring, baby);
            hand.createUser();
        }
        
    }
    public static void authenticateUser(MiddleFinger middle,IndexFinger index,RingFinger ring,
            BabyFinger baby,Thumb thumb){
        if(User.checkForMatch(thumb, index, middle, ring, baby)){
            JOptionPane.showMessageDialog(null, "You have been authenticated",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "You are not allowed to access",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
