package lab13_streams;

import java.awt.Dimension;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Vector;

/**
 * This class allows to save a SVG file
 * 
 * @author Pierre Roduit (pierre.roduit@hevs.ch)
 * @version 1.0
 * 
 */
public class SVGWriter {
	// Output stream. PrintStream enable to print strings (println()).
	PrintStream svgOut;

	/**
	 * Constructor
	 * 
	 * @param svgFile
	 *            File where to save the SVG drawing
	 * @throws FileNotFoundException
	 */
	public SVGWriter(File svgFile) throws FileNotFoundException {
		svgOut = new PrintStream(new BufferedOutputStream(new FileOutputStream(svgFile)));

	}

	/**
	 * Write the SVG header to the file
	 * 
	 * @param imgDim
	 *            Dimension of the image
	 */
	public void writeHeader(Dimension imgDim) {
		// Print XML Header
		svgOut.println("<?xml version=\"1.0\" standalone=\"no\"?>");
		svgOut.println("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
		svgOut.print("<svg width=\"");
		svgOut.print(imgDim.height);
		svgOut.print("\" height=\"");
		svgOut.print(imgDim.width);
		svgOut.println("\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">");

	}

	/**
	 * Close the file when the class is destroyed
	 */
	protected void finalize() throws Throwable {
		this.close();

	}

	/**
	 * Write the footer, flush the data and close the file
	 */
	public void close() {
		// Print XML Footer
		svgOut.println("</svg>");
		if (svgOut != null) {
			svgOut.flush();
			svgOut.close();
		}
	}

	/**
	 * Write the shapes contained in the dynamic list in the SVG file.
	 * 
	 * @param shapes Vector of shapes
	 */
	void writeLines(Vector<Line> lines) {
		// TODO Complete here
	}

}
