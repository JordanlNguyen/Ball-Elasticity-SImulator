import java.awt.*;
import java.awt.event.*;

public class Menu {
    int width = 300;
    int height = 200;
    int positionX = 500;
    int positionY = 100;
    private Sim sim;
    private String buttonName = "START";

    Button startButton = new Button(buttonName); //button will have START and RESTART

    public Menu(Sim sim){
        this.sim = sim; //stores the referenced sim in the Menu class private sim
        //start/restart button functionality
        startButton.setBounds(575, 200, 100, 50);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                changeButtonName();
                System.out.println(sim.simStatus);
            }
        });
    }

    public void changeButtonName(){
        sim.simStatus = !sim.simStatus;
        if(sim.simStatus == true){
            buttonName = "RESTART";
        }
        else{
            buttonName = "START";
        }
    }
}
