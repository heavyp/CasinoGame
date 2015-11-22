/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinogameproject.CasinoGame;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import javax.swing.Timer;

/**
 *
 * @author heavyp
 */

public class GUI extends JFrame{
    JFrame frame = new JFrame();
    JPanel topPanel = new JPanel(new GridBagLayout());
    JPanel animationPanel = new JPanel(new GridBagLayout());
    JPanel bottomPanel = new JPanel(new GridBagLayout());
    
    JButton spinBtn = new JButton("Spin");
    JButton quitBtn = new JButton("Quit");
    JButton rulesBtn = new JButton("Rules");
    JLabel bank = new JLabel("Bank: $");
    JTextField money = new JTextField();
    JLabel playerBankLbl = new JLabel("Player's Bank: $");
    JTextField playerBankField = new JTextField();
    
    Double casinoBank, playerBank;
    static DecimalFormat df = new DecimalFormat(".###");
    
    String tempStr;
    Double tempDbl;
    int [] winningNumbers = new int[3];
    
    private ImageIcon image1;
    
    //private AudioClip welcome, backgroundSound, spinSound, winSound;
    
    String soundName = "welcome.wav";
    String winName = "youwin.wav";
    String backgroundName = "background.wav";
    AudioInputStream openingSound, winningSound, backgroundSound;
    Clip welcomeClip, backgroundClip, spinClip, winClip;
    
    
    final int PLAYERS_BET = 1;

    //CONSTRUCTOR
    public GUI(LogoAnimatorPanel animation1, LogoAnimatorPanel animation2,
               LogoAnimatorPanel animation3) throws  UnsupportedAudioFileException, 
                                            IOException, LineUnavailableException 
    {
        super("Casino Game");
        
        df.applyPattern("#,#00.00");
        //setSize(1000, 700);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.setBounds(0, 0, 600, 400);
        playerBank = 1000.00;
        casinoBank = 1000.00;
        
        animationPanel.add(animation1);
        animationPanel.add(animation2);
        animationPanel.add(animation3);
        frame.add(animationPanel, BorderLayout.CENTER);
        
        topPanel.add(bank);
        topPanel.add(money);
        topPanel.add(rulesBtn);
        
        bottomPanel.add(playerBankLbl);
        bottomPanel.add(playerBankField);
        playerBankField.setEditable(false);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        
        playerBankField.setText(df.format(1000.00));
        
        money.setText(df.format(1000.00));
        money.setEditable(false);
        bottomPanel.add(spinBtn);
        bottomPanel.add(quitBtn);
        backgroundSound = AudioSystem.getAudioInputStream(new File(backgroundName).getAbsoluteFile());
        backgroundClip = AudioSystem.getClip();
        openingSound = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        welcomeClip = AudioSystem.getClip();
        winningSound = AudioSystem.getAudioInputStream(new File(winName).getAbsoluteFile());
        winClip = AudioSystem.getClip();
        image1 = new ImageIcon("background.jpg");
        
        welcomeClip.open(openingSound);
        welcomeClip.start();
        backgroundClip.open(backgroundSound);
        backgroundClip.start();
        
        backgroundClip.loop(99);
        
        quitBtn.addActionListener((ActionEvent e) -> {
            JFrame frame = new JFrame();
            JPanel topPanel = new JPanel(new GridBagLayout());
            JPanel midPanel = new JPanel(new GridBagLayout());
            frame.setBounds(0, 0, 200, 200);
            JButton yes = new JButton("Yes");
            JButton no = new JButton("No");
            JLabel label = new JLabel("Are you sure you wish to exit?");
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.add(midPanel, BorderLayout.CENTER);
            topPanel.add(label);
            frame.add(topPanel, BorderLayout.NORTH);
            midPanel.add(yes);
            midPanel.add(no);
            frame.setVisible(true);
            
            yes.addActionListener(f -> {
                System.exit(0);
            });
            no.addActionListener(f -> {
                frame.setVisible(false);
            });
            
        });

        int delay1 = 4934; 
        ActionListener taskPerformer1 = (ActionEvent evt) -> {
            animation1.stopAnimation();
            winningNumbers[0] = animation1.getCurrentImageNum();

        };
        int delay2 = 7496; 
        ActionListener taskPerformer2 = (ActionEvent evt) -> {
            animation2.stopAnimation();
            winningNumbers[1] = animation2.getCurrentImageNum();
        };
        int delay3 = 10000; 
        ActionListener taskPerformer3 = (ActionEvent evt) -> {
            animation3.stopAnimation();
            if (animation3.getCurrentImageNum() != 0)
            winningNumbers[2] = animation3.getCurrentImageNum();
            else 
                winningNumbers[2] = 7;
            
            
            if(didPlayerWin(winningNumbers)){
                    playerBank += casinoBank;
                    playerBankField.setText(df.format(playerBank));
                    casinoBank = 1000.00;
                    money.setText(df.format(casinoBank));
                try {
                    
                    winningSound = AudioSystem.getAudioInputStream(new File(winName).getAbsoluteFile());
                    winClip = AudioSystem.getClip();
                    winClip.open(winningSound);
                    winClip.start();
                    JOptionPane.showMessageDialog(topPanel, "YOU WIN!!!!");
                } catch (UnsupportedAudioFileException ex) {
                    
                } catch (IOException ex) {
                    
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
        
            }
        };
  
        Timer spinTimer1 = new Timer(delay1, taskPerformer1);
        Timer spinTimer2 = new Timer(delay2, taskPerformer2);
        Timer spinTimer3 = new Timer(delay3, taskPerformer3);
        spinTimer1.setRepeats(false);
        spinTimer2.setRepeats(false);
        spinTimer3.setRepeats(false);
    
        rulesBtn.addActionListener(e ->{
        JOptionPane.showMessageDialog(topPanel, "If all three pictures match: YOU WIN!");
    });
        spinBtn.addActionListener((ActionEvent e) -> {
            if(doesPlayerHaveMoney(playerBank)){
            playerBank -= PLAYERS_BET;
            casinoBank += PLAYERS_BET;
            playerBankField.setText(df.format(playerBank));
            money.setText(df.format(casinoBank));
            spinTimer1.start();
            spinTimer2.start();
            spinTimer3.start();
            
            animation1.startAnimation();
            animation2.startAnimation();
            animation3.startAnimation();
            }
        });
    
    
    
    frame.setVisible(true);
    }
    
    private boolean didPlayerWin(int [] arr){
        return (winningNumbers[0] == winningNumbers[1] && winningNumbers[0] == winningNumbers[2] &&
                winningNumbers[1] == winningNumbers[2] );
    }
    
    private boolean doesPlayerHaveMoney(Double money){
        if (money == 0){
            JOptionPane.showMessageDialog(topPanel, "You are out of money! Sorry, you got to go!");
            System.exit(0);
            return false;
        }
        else
            return true;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        image1.paintIcon(this, g, 200, 200);
    }
    

}
