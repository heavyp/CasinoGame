package casinogameproject.CasinoGame;


import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class LogoAnimatorPanel extends JPanel{
    
    private final static String IMAGE_NAME = "slotPic";
    protected ImageIcon images[];
    private final int TOTAL_IMAGES = 8;
    private int currentImage = 0;
    private final int ANIMATION_DELAY = 200;
    private int width;
    private int height;
    
    private Timer animationTimer;
    
    public LogoAnimatorPanel()
    {
        images = new ImageIcon[ TOTAL_IMAGES ];
        
        for (int count = 0; count < images.length ; count++){
            images[count] = new ImageIcon(getClass().getResource(
                IMAGE_NAME + (count + 1) + ".jpg"));
           
        
        width = images[count].getIconWidth();
        height = images[count].getIconHeight();
        }  
    }
    
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            images[currentImage].paintIcon(this, g, 0, 0);
            try{
            if(animationTimer.isRunning()){
                currentImage = (currentImage + 1) % TOTAL_IMAGES;
            }
            }
            catch(NullPointerException e){
                System.out.println("WTF m8");
            }
        }
        public JButton btn = new JButton("Animate");
        public void startAnimation(){
        if (animationTimer == null){
                currentImage = 0;
                animationTimer = new Timer(ANIMATION_DELAY, new TimerHandler() );
                animationTimer.start();
            }
        else
            if (!animationTimer.isRunning()){
            animationTimer.restart();
            }
        } 
        
        public void stopAnimation(){
            animationTimer.stop();
        }
        
        public Dimension getMinimumSize(){
            return getPreferredSize();
        }
        
        public Dimension getPreferredSize(){
            return new Dimension(width, height);
        }
        
        private class TimerHandler implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent){
                repaint();
            }
        }
        
    }
    
    
    

