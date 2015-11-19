package casinogameproject;


import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heavyp
 */
public class LogoAnimatorPanel extends JPanel{
    private final static String IMAGE_NAME = "slotPic";
    protected ImageIcon images[];
    private final int TOTAL_IMAGES = 8;
    private int currentImage = 0;
    private final int ANIMATION_DELAY = 50;
    private int width;
    private int height;
    
    private Timer animationTimer;
    
    public LogoAnimatorPanel()
    {
        images = new ImageIcon[ TOTAL_IMAGES ];
        
        for (int count = 0; count < images.length ; count++){
            images[count] = new ImageIcon(getClass().getResource(
                IMAGE_NAME + (count + 1) + ".jpg"));
            
            width = images[0].getIconWidth();
            height = images[0].getIconHeight();
        }
        
    
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            images[currentImage].paintIcon(this, g, 0, 0);
            
            if(animationTimer.isRunning()){
                currentImage = (currentImage + 1) % TOTAL_IMAGES;
            }             
        }
        public JButton btn = new JButton("Animate");
        public void startAnimation(){
        if (animationTimer == null){
                currentImage = 0;
                animationTimer = new Timer(ANIMATION_DELAY,  );
                animationTimer.start();
            }
        else
            if (!animationTimer.isRunning()){
            animationTimer.restart();
            }
        } 
    }
    
    
    

