import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;


public class Sim extends Frame{

    Ball ball = new Ball();
    boolean simStatus = false; //true - sim is executing, false - sim is not executing
    Menu menu = new Menu(this);
    long prevTime;
    final BufferedImage buffer = new BufferedImage(750, 750, BufferedImage.TYPE_4BYTE_ABGR);
    
    public Sim(){
        //initialize frame and exit function
        setSize(750,750);
        setBackground(Color.BLACK);
        setResizable(false);
        setLayout(null); //for manual positioning

        //interactable components
        add(menu.startButton);


        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        setVisible(true);

        prevTime = System.nanoTime();

        //loop
        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                if(simStatus == true){
                    long currentTime = System.nanoTime();
                    double dt = (currentTime - prevTime) / 1e9;
                    prevTime = currentTime;

                    ball.calculatePositionY(dt);
                }
                else{
                    prevTime = System.nanoTime();
                    //reseting ball variables
                    ball.positionY = ball.initialPositionY;
                    ball.velocityY = 0;
                }
                repaint();
            }
        }, 0, 16);
    }

    @Override
    public void update(Graphics g){
        paint(g);
    }

    //this method is automatically called since it is part of the awt rendering system
    @Override
    public void paint(Graphics g){
        //add buffer
        Graphics2D g2 = buffer.createGraphics(); //storing buffer 
        //clearing the buffer
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
        //draw the ground
        g2.setColor(Color.GREEN);
        g2.fillRect(0,700 ,750, 100);
        //draw the ball
        g2.setColor(Color.RED);
        g2.fillOval((int)ball.positionX, (int)ball.positionY, ball.size, ball.size);
        //draw menu outline
        g2.setColor(Color.BLUE);
        g2.fillRect(menu.positionX, menu.positionY, menu.width, menu.height);
        g.drawImage(buffer, 0, 0, null);
        g2.dispose();
        /* g represents the frame, meaning anythin passed through g will be 
         * displayed in the frame
         * 
         * g2 is a subclass of graphics with extra features
         */
    }
}