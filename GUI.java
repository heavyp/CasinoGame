/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinogameproject.CasinoGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;
/**
 *
 * @author heavyp
 */

public class GUI extends JFrame{
    JPanel panel = new JPanel();
    JButton spinBtn = new JButton("Spin");
    JButton resetBtn = new JButton("Reset");
    
    JTextField money = new JTextField();
    
    
    //CONSTRUCTOR
    public GUI(LogoAnimatorPanel animation1, LogoAnimatorPanel animation2,
               LogoAnimatorPanel animation3){
        super("Casino Game");
        setSize(500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        
        panel.add(spinBtn);
        panel.add(resetBtn);
        panel.add(animation1);
        panel.add(animation2);
        panel.add(animation3);
        
        resetBtn.addActionListener((ActionEvent e) -> {
        
        });
    
        
        
    int delay = 10000; //milliseconds
  ActionListener taskPerformer = (ActionEvent evt) -> {
      //...Perform a task...
      animation1.stopAnimation();
        animation2.stopAnimation();
        animation3.stopAnimation();
        };
  
    Timer spinTimer = new Timer(delay, taskPerformer);
    //spinTimer.setRepeats(false);
    
    spinBtn.addActionListener((ActionEvent e) -> {
        spinTimer.start();
        
        animation1.startAnimation();
        animation2.startAnimation();
        animation3.startAnimation();
        });
    
    
    setVisible(true);
    }
}
