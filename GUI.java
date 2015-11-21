/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinogameproject;

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
    JButton quitBtn = new JButton("Quit");
    JTextField money = new JTextField();
    int [] winningNumbers = new int[3];

    final int PLAYERS_BET = -1;
    int playerBank;
    int casinoBank;
    
    //CONSTRUCTOR
    public GUI(LogoAnimatorPanel animation1, LogoAnimatorPanel animation2,
               LogoAnimatorPanel animation3){
        super("Casino Game");
        setSize(500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        playerBank = 1000;
        casinoBank = 1000;
        panel.add(spinBtn);
        panel.add(quitBtn);
        panel.add(animation1);
        panel.add(animation2);
        panel.add(animation3);
        
        quitBtn.addActionListener((ActionEvent e) -> {
            
        });

        int delay1 = 10000; 
        ActionListener taskPerformer1 = (ActionEvent evt) -> {
            winningNumbers[0] = animation1.stopAnimation();
        };
        int delay2 = 7500; 
        ActionListener taskPerformer2 = (ActionEvent evt) -> {
            winningNumbers[1] = animation2.stopAnimation();
        };
        int delay3 = 5000; 
        ActionListener taskPerformer3 = (ActionEvent evt) -> {
            winningNumbers[2] = animation3.stopAnimation();
        };
  
        Timer spinTimer1 = new Timer(delay1, taskPerformer1);
        Timer spinTimer2 = new Timer(delay2, taskPerformer2);
        Timer spinTimer3 = new Timer(delay3, taskPerformer3);
        spinTimer1.setRepeats(false);
        spinTimer2.setRepeats(false);
        spinTimer3.setRepeats(false);
    
    
        spinBtn.addActionListener((ActionEvent e) -> {
            spinTimer1.start();
            spinTimer2.start();
            spinTimer3.start();
            
            animation1.startAnimation();
            animation2.startAnimation();
            animation3.startAnimation();
            if (casinoBank == 0)
                casinoBank = 1000;
        });
    
    
    setVisible(true);
    }
    
    public boolean didPlayerWin(int [] arr){
        if(winningNumbers[0] == winningNumbers[1])
            return true;
        else return false;
    }

}
