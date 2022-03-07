package lab13_streams;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Part 1 of the lab session on streams
 * 
 * @author <a href='mailto:pandre.mudry&#64;hevs.ch'> Pierre-Andre Mudry</a>
 * @version 1.0
 */
public class ReadFileApplication {	
	static Vector<Line> parseFile(String in){
		// This vector hold the lines
		Vector<Line> lines = new Vector<Line>();

		/*
		 * Read the lines from the CSV file
		 */
		try {
			// Read the CSV File
			BufferedReader csvReader = new BufferedReader(new FileReader(in));
			
			// TODO: complete here
			
			System.out.println(lines.size() + " shapes found in csv file.");
			csvReader.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("Bad input file " + in + " !\n");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("Error reading file " + " !\n");
			e.printStackTrace();
			System.exit(-1);
		}

		return lines;
	}
	
	/**
	 * Entry point of the program
	 */
	public static void main(String[] args) {					
		Vector<Line> theLines = ReadFileApplication.parseFile("drawingTest.csv");		

		// Display what we read
		ReadFileApplication.displayLines(theLines);
		
		// Optional part
		ReadFileApplication.writeSVG(theLines);			
	}

	/**
	 * Writes the lines to an SVG file !
	 * @param lines
	 */
	static void writeSVG(Vector<Line> lines){
		final String SVG_FILENAME = "drawingTest.svg";
		
		/*
		 * Write the SVG File
		 */
		try {			
			SVGWriter svgWriter = new SVGWriter(new File(SVG_FILENAME));
			svgWriter.writeHeader(getDimensions(lines));
			svgWriter.writeLines(lines);
			svgWriter.close();
		} catch (FileNotFoundException e) {
			System.err.println("Bad output file " + SVG_FILENAME  + " !\n");
			e.printStackTrace();
			System.exit(-1);
		}
	}	
	
	/**
	 * Computes the required space on the screen for the given lines
	 * @param lines Different vector lines
	 * @return The space required to display that on screen
	 */
	static Dimension getDimensions(Vector<Line> lines){
		// The dimension of the image, used for SVG output & the view Frame.
		Dimension imgDim = new Dimension();
		
		/*
		 * Compute the image dimension
		 */
		for (int i = 0; i < lines.size(); i++) {
			imgDim.height = Math.max(imgDim.height, lines.get(i).p2.x);
			imgDim.width = Math.max(imgDim.width, lines.get(i).p2.y);
		}
		
		imgDim.height += 50;
		imgDim.width += 50;
		return imgDim;
	}
	
	/**
	 * Displays a vector of lines on a graphical window
	 * @param lines
	 */
	static void displayLines(Vector<Line> lines){ 
		// This is a display Frame for the lines
		SimpleGraphics display;

		// The dimension of the image, used for SVG output & the view Frame.
		Dimension imgDim = new Dimension(0, 0);
			
		/*
		 * Compute the image dimension
		 */
		for (int i = 0; i < lines.size(); i++) {
			imgDim.height = Math.max(imgDim.height, lines.get(i).p2.x);
			imgDim.width = Math.max(imgDim.width, lines.get(i).p2.y);
		}
		
		imgDim.height += 50;
		imgDim.width += 50;

		/*
		 * Display the lines
		 */
		display = new SimpleGraphics(imgDim.height, imgDim.width,"CSV File Drawing");

		// Draw each line
		for (int i = 0; i < lines.size(); i++){
			Line p = lines.get(i);
			display.setColor(p.color);
			display.drawLine(p.p1.x, p.p1.y, p.p2.x, p.p2.y);
		}

		// Refresh the screen
		for(int i = 0; i < 10; i++)
			display.repaint();	
	}
	
}
