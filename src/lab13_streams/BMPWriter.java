package lab13_streams;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class allows to save a BMP file
 * 
 * @author Pierre Roduit (pierre.roduit@hevs.ch)
 * @version 1.0
 */
public class BMPWriter {
	// Data writer
	private DataOutputStream out = null;
	// Image dimensions
	private int width;
	private int height;
	private final int headerSize = 54;

	/**
	 * Constructor
	 * 
	 * @param fileName
	 *            Name of the BMP file to save
	 * @param width
	 *            Width of the image
	 * @param height
	 *            Height of the image
	 * @throws FileNotFoundException
	 */
	BMPWriter(File file, int height, int width) throws FileNotFoundException {
		this.width = width;
		this.height = height;
		out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
	}

	/**
	 * Close the file when the class is destroyed
	 */
	protected void finalize() throws Throwable {
		this.close();

	}

	/**
	 * Close the file
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		if (out != null) {
			out.flush();
			out.close();
		}
	}

	/**
	 * Write the BMP header
	 * 
	 * @throws IOException
	 */
	public void writeHeader() throws IOException {
		// Write header
		// You can refer to this web site
		// (http://www.fastgraph.com/help/bmp_header_format.html) to
		// understand the use of each value
		// Signature
		out.write(0x42);
		out.write(0x4D);
		// FileSize (Byte 3-6)
		out.writeInt(convertToLED(width * height * 3 + headerSize));
		// Reserved (Byte 7-10)
		out.writeInt(0);
		// Header Size (Byte 11-14)
		out.writeInt(convertToLED(headerSize));

		// TODO Complete header 
		
		out.flush();
	}

	/**
	 * Write a pixel data in the BMP file
	 * 
	 * @param color
	 * @throws IOException
	 */
	public void writePixel(int color) throws IOException {

		// TODO Complete here

	}

	/**
	 * Fill the image with a color gradient
	 * 
	 * @throws IOException
	 */
	public void fillImage() throws IOException {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// Each pixel is written one after the other
				// Blue
				out.write(j % 256);
				// Green
				out.write(0);
				// Red
				out.write(i % 256);
			}
			insertPadding();
		}
		out.flush();
	}

	/**
	 * Write the pixel values of a graphic to the file
	 * 
	 * @param display
	 *            Graphic
	 * @throws IOException
	 */
	public void writeImage(SimpleGraphics display) throws IOException {
		// TODO complete here
	}

	/**
	 * Insert the padding needed at the end of each line in a BMP file, to a end
	 * a line in a multiple of 4 (in byte)
	 * 
	 * @throws IOException
	 */
	public void insertPadding() throws IOException {
		// Padding for the end of line
		for (int j = 0; j < (4 - ((3 * width) % 4)) % 4; j++)
			out.write(0);
	}

	/**
	 * Convert an integer into a Little Endian integer
	 * 
	 * @param input
	 * @return
	 */
	static private int convertToLED(int input) {
		int result = 0;
		for (int shiftBy = 24; shiftBy >= 0; shiftBy -= 8) {
			result |= (input & 0xff) << shiftBy;
			input >>= 8;
		}

		return result;
	}

	/**
	 * Convert a short number into a Little Endian short
	 * 
	 * @param input
	 * @return
	 */
	static private short convertToLED(short input) {
		return (short) (((input & 0xff) << 8) | ((input & 0xff00) >> 8));
	}
}
