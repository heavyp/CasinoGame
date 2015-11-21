/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinogameproject;


import java.awt.GridLayout;
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
        LogoAnimatorPanel animation1 = new LogoAnimatorPanel();
        LogoAnimatorPanel animation2 = new LogoAnimatorPanel();
        LogoAnimatorPanel animation3 = new LogoAnimatorPanel();
        GUI gui = new GUI(animation1, animation2, animation3);
        
       // GridLayout grid = new GridLayout();
        /*
        JFrame window = new JFrame("Animation Test");
        grid.layoutContainer(window);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(animation1);
        window.add(animation2);
        window.add(animation3);
        
        window.pack();
        window.setVisible(true);
        JButton btn = new JButton("Animate");
        window.add(btn);
        */
        
    }
}
    
   