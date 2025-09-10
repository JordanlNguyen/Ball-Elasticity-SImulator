import java.awt.*;
import java.awt.event.*;

public class Menu {
    int width = 300;
    int height = 200;
    int positionX = 500;
    int positionY = 100;

    Button startButton = new Button("START");
    // Sim sim = new Sim();

    public Menu(){
        startButton.setBounds(575, 200, 100, 50);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                sim.simStatus = !(sim.simStatus);
            }
        });
    }
}
