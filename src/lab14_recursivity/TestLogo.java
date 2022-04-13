package lab14_recursivity;

import java.awt.Point;
import hevs.graphics.TurtleGraphics;

public class TestLogo {

    private static TurtleGraphics turtle;
    private static Point startPosition;

    public static void main(String[] args) {
        turtle = new TurtleGraphics(400, 400, "Test logo");
        startPosition = turtle.getPosition();
        turtle.penDown();
        
        polygoneGenerator(100, 120);
        polygoneGenerator(100, 90);
        polygoneGenerator(100, 72);
        turtle.penUp();
        turtle.forward(50);
        turtle.penDown();
        startPosition = turtle.getPosition();
        polygoneGenerator(5, 5);
    }

    static void polygoneGenerator(int forward, int angle){
        turtle.forward(forward);
        turtle.turn(angle);
        if (!turtle.getPosition().equals(startPosition)) polygoneGenerator(forward, angle);
    }
}
