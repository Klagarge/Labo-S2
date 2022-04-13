package lab14_recursivity;

import java.awt.Point;

import hevs.graphics.TurtleGraphics;

public class Tree {

    private static TurtleGraphics turtle;
    private static final int height = 500;
    private static final int weight = 500;
    public static void main(String[] args) {
        turtle = new TurtleGraphics(weight, height, "Tree");
        turtle.forward(-(height/2)+20);
        turtle.penDown();

        drawTree(25, 100);
    }

    private static void drawBranch(double length){
        turtle.forward(length);
    }

    private static void drawTree(int n, double length){
        if(n > 1){
            drawBranch(length);

            Point position = turtle.getPosition();
            double angle = turtle.getTurtleAngle();
            
            // Left subtree
            turtle.turn(-20);
            drawTree(n-1, (length/4)*3);
            
            turtle.jump(position.x, position.y);
            turtle.setAngle(angle);
            
            // Right subtree
            turtle.turn(20);
            drawTree(n-1, (length/4)*3);
        }  else{
            drawBranch(length);
        }
    } 

}
