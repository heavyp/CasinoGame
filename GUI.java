/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinogameproject.CasinoGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
    
    private ImageIcon image1;
    

    final int PLAYERS_BET = -1;
    int playerBank;
    int casinoBank;
    
    
    

    //CONSTRUCTOR
    public GUI(LogoAnimatorPanel animation1, LogoAnimatorPanel animation2,
               LogoAnimatorPanel animation3) throws IOException {
        super("Casino Game");
        image1 = new ImageIcon("background.jpg");
        
        setSize(800, 700);
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

        int delay1 = 5000; 
        ActionListener taskPerformer1 = (ActionEvent evt) -> {
            winningNumbers[0] = animation1.stopAnimation();

        };
        int delay2 = 7000; 
        ActionListener taskPerformer2 = (ActionEvent evt) -> {
            winningNumbers[1] = animation2.stopAnimation();

        };
        int delay3 = 10000; 
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
        if(winningNumbers[0] == winningNumbers[1] || winningNumbers[0] == winningNumbers[2] ||
                winningNumbers[1] == winningNumbers[2])
            return true;
        else 
            return false;
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        image1.paintIcon(this, g, 200, 200);
    }
    public void youWinWindow(){
        
    
    }

}
