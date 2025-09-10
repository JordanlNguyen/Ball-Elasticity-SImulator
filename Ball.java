public class Ball {

    int size;
    double g = 9.81;
    double elasticity = .9; // leastElastic(0) -> mostElastic(1)

    double positionX;
    double positionY;
    double velocityY;

    public Ball(){
        size = 20;
        positionX = 200;
        positionY = 0;
        velocityY = 0;
    }

    public void calculatePositionY(double dt){
        velocityY += + g*dt; //calculating current velocity
        positionY += velocityY * dt * 100; //calculating current position
        if(positionY + size > 700){
            positionY = 700 - size; //sets positionY to ground level
            velocityY = -(velocityY * elasticity); //reverse velocity to simulate bunce
        }
    }
}

/*
 * a = 9.81 m/s^2
 * 
 * positionY = y0 + v0 * t - (1/2)*(g)*(t^2)
 * 
 * elasticity = velocity after bounce / velocity before bounce
 */