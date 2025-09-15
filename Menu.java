import java.awt.*;
import java.awt.event.*;

public class Menu extends Panel{
    int width = 300;
    int height = 200;
    int positionX = 500;
    int positionY = 100;
    final Sim sim;
    final Ball ball;

    Button startButton = new Button("START"); //button will have START and RESTART

    Label heightLabel = new Label("HEIGHT");
    Label heightLabelValue = new Label(); //30 -> (700 - size)
    Button heightDecrement = new Button("-");
    Button heightIncrement = new Button("+");

    Label elasticityLabel = new Label("ELASTICITY");
    Label elasticityLabelValue = new Label(); //0 -> 1
    Button elasticityDecrement = new Button("-");
    Button elasticityIncrement = new Button("+");

    public Menu(Sim sim, Ball ball){
        this.sim = sim; //stores the referenced sim in the Menu class private sim
        this.ball = ball;

        setLayout(null);
        setBounds(positionX, positionY, width, height);

        heightLabelValue.setText(Double.toString(ball.positionY));
        elasticityLabelValue.setText(Double.toString(ball.elasticity));

        //height modification components
        heightLabel.setBounds(10, 20, 60, 25);
        heightLabel.setBackground(Color.WHITE);
        heightLabelValue.setBounds(150, 20, 60, 25);
        heightLabelValue.setBackground(Color.WHITE);
        heightDecrement.setBounds(125, 20, 25, 25);
        heightIncrement.setBounds(210, 20, 25, 25);

        //elasticity modifiation components
        elasticityLabel.setBounds(10, 60, 75, 25);
        elasticityLabel.setBackground(Color.WHITE);
        elasticityLabelValue.setBounds(150, 60, 60, 25);
        elasticityLabelValue.setBackground(Color.WHITE);
        elasticityDecrement.setBounds(125, 60, 25, 25);
        elasticityIncrement.setBounds(210, 60, 25, 25);

        startButton.setBounds(80, 120, 120, 40);

        add(startButton);
        add(heightLabel);
        add(heightLabelValue);
        add(heightDecrement);
        add(heightIncrement);
        add(elasticityLabel);
        add(elasticityLabelValue);
        add(elasticityDecrement);
        add(elasticityIncrement);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                sim.simStatus = !sim.simStatus;
                if(sim.simStatus == true){
                    startButton.setLabel("RESTART");
                }
                else{
                    startButton.setLabel("START");
                }
                    System.out.println(sim.simStatus);
            }
        });

        //height Increment
        heightIncrement.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(ball.initialPositionY > 30.0){
                    ball.initialPositionY -= 1.0;
                    heightLabelValue.setText(Double.toString(ball.initialPositionY));
                    System.out.println(Double.toString(ball.initialPositionY));
                }
            }
        });

        //height decrement
        heightDecrement.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(ball.initialPositionY < 700.0 - ball.size){
                    ball.initialPositionY += 1.0;
                    heightLabelValue.setText(Double.toString(ball.initialPositionY));
                    System.out.println(Double.toString(ball.initialPositionY));
                }
            }
        });

        elasticityIncrement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ball.elasticity < 1.0) { // keep elasticity between 0 and 1
                    ball.elasticity += 0.1;
                    elasticityLabelValue.setText(String.format("%.1f", ball.elasticity));
                    System.out.println(Double.toString(ball.elasticity));
                }
            }
        });

        elasticityDecrement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ball.elasticity >= 0.1) {
                    ball.elasticity -= 0.1;
                    elasticityLabelValue.setText(String.format("%.1f", ball.elasticity));
                    System.out.println(Double.toString(ball.elasticity));
                }
            }
        });
    }
}