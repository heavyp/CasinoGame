/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinogameproject;


import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author heavyp
 */
public class CasinoGameProject {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LogoAnimatorPanel animation = new LogoAnimatorPanel();
        
        JFrame window = new JFrame("Animation Test");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(animation);
        
        window.pack();
        window.setVisible(true);
        JButton btn = new JButton("Animate");
        window.add(btn);
        
        animation.startAnimation();
    }
    
   