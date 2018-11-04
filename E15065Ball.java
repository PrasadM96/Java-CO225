

import static java.lang.Math.*;

/**
 *
 * @author e15065
 */
public class E15065Ball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ball b1 = new Ball(0.0, 1.0, 10.0, 45.0); //create ball object b1
        Ball.updateTime(5.0); //update time for b1

        Ball b2 = new Ball(0.0, 1.0, 20.0, 45.0); // create ball object b2
        Ball.updateTime(5.0); //update time for b2

        boolean collision1 = b1.willCollide(b2); //check whether b1 will collide or not with b2

        if (collision1 == true) {
            System.out.println("b1 and b2 collide");
        } else {
            System.out.println("b1 and b2 not collide");

        }

        Ball b3 = new Ball(-10.0, 5.0, 3.0, 30.0); //create ball object b3
        Ball.updateTime(20.0); //update time for b3

        boolean collision2 = b2.willCollide(b3); //check whether b2 will collide or not with b3

        if (collision2 == true) {
            System.out.println("b2 and b3 collide");
        } else {
            System.out.println("b2 and b3 not collide");

        }
    }
}

class Ball {

    private double x;
    private double y;
    private final double speed;
    private final double angleOfSpeedWithX;
    public static double globalTime = 0;
    private final double time = globalTime;

    public Ball(double x, double y, double speed, double angleOfSpeedWithX) { //constructor
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angleOfSpeedWithX = angleOfSpeedWithX;
       
    }
   
    public static void updateTime(double time1) {   
        globalTime += time1;
    }

    public boolean willCollide(Ball ball2) {

        //System.out.println("Before x = "+this.x+" y = "+this.y+" this.time = "+this.time+" globslTime = "+globalTime);
        double disX = (this.speed * Math.cos(Math.toRadians(this.angleOfSpeedWithX))) * (globalTime - this.time);
        double disY = (this.speed * Math.sin(Math.toRadians(this.angleOfSpeedWithX))) * (globalTime - this.time);
        this.x += disX; //updating ball1 x position
        this.y += disY; //updating ball1 y position
        //System.out.println(" After x = "+this.x+" y = "+this.y);

        //System.out.println("Before x = "+ball2.x+" y = "+ball2.y+" this.time = "+ball2.time+" globslTime = "+globalTime);
        double disX1 = (ball2.speed * Math.cos(Math.toRadians(ball2.angleOfSpeedWithX))) * (globalTime - ball2.time);
        double disY1 = (ball2.speed * Math.sin(Math.toRadians(ball2.angleOfSpeedWithX))) * (globalTime - ball2.time);
        ball2.x += disX1; //updating ball2 x position
        ball2.y += disY1; //updating ball2 y position
        //System.out.println(" After x = "+ball2.x+" y = "+ball2.y);

        return this.x == ball2.x && this.y == ball2.y; //check whether balls are in same position or not

    }

}
