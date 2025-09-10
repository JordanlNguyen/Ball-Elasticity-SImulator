import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;


public class Sim extends Frame{

    Ball ball = new Ball();
    Menu menu = new Menu();
    boolean simStatus = false; //true - sim is executing, false - sim is not executing
    long prevTime;
    
    public Sim(){
        //initialize frame and exit function
        setSize(750,750);
        setBackground(Color.BLACK);
        setResizable(false);
        setLayout(null); //for manual positioning
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
                long currentTime = System.nanoTime();
                double dt = (currentTime - prevTime) / 1e9;
                prevTime = currentTime;

                ball.calculatePositionY(dt);
                repaint();
            }
        }, 0, 16);
    }

    //this method is automatically called since it is part of the awt rendering system
    @Override
    public void paint(Graphics g){
        //draw the ground
        g.setColor(Color.GREEN);
        g.fillRect(0,700 ,750, 100);
        //draw the ball
        g.setColor(Color.RED);
        g.fillOval((int)ball.positionX, (int)ball.positionY, ball.size, ball.size);
        //draw menu outline
        g.setColor(Color.BLUE);
        g.fillRect(menu.positionX, menu.positionY, menu.width, menu.height);
    }
}