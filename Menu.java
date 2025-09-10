import java.awt.*;
import java.awt.event.*;

public class Menu {
    int width = 300;
    int height = 200;
    int positionX = 500;
    int positionY = 100;
    final Sim sim;

    Button startButton = new Button("START"); //button will have START and RESTART

    public Menu(Sim sim){
        this.sim = sim; //stores the referenced sim in the Menu class private sim
        //start/restart button functionality
        startButton.setBounds(575, 200, 100, 50);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                changeButtonName();
                System.out.println(sim.simStatus);
            }
        });
    }

    public void changeButtonName(){
        sim.simStatus = !sim.simStatus;
        if(sim.simStatus == true){
            startButton.setLabel("RESTART");
        }
        else{
            startButton.setLabel("START");
        }
    }
}
