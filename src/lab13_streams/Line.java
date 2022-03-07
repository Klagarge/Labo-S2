package lab13_streams;

import java.awt.Color;
import java.awt.Point;

/**
 * Class stores the information corresponding to a line
 * 
 * @author Pierre Roduit (pierre.roduit@hevs.ch)
 * @version 1.0
 * 
 */
public class Line {
	public Point p1, p2;
	public Color color;

	/**
	 * Constructor
	 * 
	 * @param p1
	 *            First point
	 * @param p2
	 *            Second point
	 * @param color
	 *            Line color
	 */
	public Line(Point p1, Point p2, Color color) {
		this.p1 = p1;
		this.p2 = p2;
		this.color = color;
	}
	
	public String toString()
	{
		return "Line from " + p1.x + "-" + p1.y + " to " + p2.x + "-" + p2.y;
	}
}
