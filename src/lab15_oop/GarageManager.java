package labs.lab15_oop.BillGUI;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Vector;


/**
 * A sample garage application
 * @author Pierre-André Mudry, HES-SO Valais 2010-2016
 */
public class GarageManager {
	private LinkedHashMap<String, Integer> services = new LinkedHashMap<String, Integer>();


	GarageManager() {
		// The various services provided in this garage
		services.put("Oil level control", 20);
		services.put("Tire replacement ", 50);
		services.put("Windshield exchange", 60);
		services.put("Oil filter change", 210);
		services.put("Battery replacement", 320);
		services.put("Pollution control", 200);
		services.put("Brake revision", 400);
	}


	String[] getServices() {
		return services.keySet().toArray(new String[services.size()]);
	}


	int[] vectorToArray(Vector<Integer> prestations) {
		Integer[] v = prestations.toArray(new Integer[prestations.size()]);
		int[] array = new int[v.length];


		for (int i = 0; i < v.length; i++)
			array[i] = v[i].intValue();


		return array;
	}


	String generateBill(Vector<Integer> prestations) {
		return generateBill(vectorToArray(prestations));
	}


	String generateHTMLBill(Vector<Integer> prestations) {
		return generateHTMLBill(vectorToArray(prestations));
	}


	/**
	 * Generates an HTML formatted string with the bill
	 * 
	 * @param prestations
	 *            An array containing all the prestations
	 * @return The HTML formatted string
	 */
	String generateHTMLBill(int[] prestations) {
		int total_sum = 0;
		Object[] keys = services.keySet().toArray();


		String result = "<html>";
		result += "<hr><br>";
		result += "<center><h1>Super Auto 20000 bill</h1></center>";
		result += "<center><small>Version 1.0</small></center><br>";
		result += "<hr><br>";


		// Create an HTML table
		result += "<table cellpadding=\"2\" cellspacing=\"2\" width=\"100%\">";
		result += "<tr>";
		result += "<td bgcolor=\"#cccccc\">Prestation</td>";
		result += "<td bgcolor=\"#cccccc\">Price</td>";
		result += "</tr>";


		for (int i = 0; i < prestations.length; i++) {
			if (prestations[i] > services.size()) {
				System.out.println("Error, non existing prestation !");
				System.exit(-1);
			}


			String cKey = (String) keys[prestations[i]];


			// HTML row
			result += "<tr>";
			result += "<td>" + cKey + "</td><td>" + services.get(cKey) + "</td>";
			result += "</tr>";
			total_sum += services.get(cKey);
		}


		result += "<tr>";
		result += "<td><i>Total price</i></td>";
		result += "<td bgcolor=\"#dddddd\"><b>" + total_sum + "</b></td>";
		result += "</tr>";


		// End of the HTML table
		result += "</table>";


		result += "<br><hr width=\"50%\" noshade /><br>"; // Horizontal line


		result += "<small>Lab 15 generator</small>";
		result += "</html>";
		return result;
	}


	/**
	 * Generates a text bill
	 * 
	 * @param prestations
	 *            An array containing all the prestations
	 * @return The generated text bill
	 */
	String generateBill(int[] prestations) {
		int total_sum = 0;
		Object[] keys = services.keySet().toArray();


		String result = "";
		result += "*************************\n";
		result += "* Super Auto 20000 bill ****\n";
		result += "*******************************\n\n";


		for (int i = 0; i < prestations.length; i++) {
			if (prestations[i] > services.size()) {
				System.out.println("Error, non existing prestation !");
				System.exit(-1);
			}


			String cKey = (String) keys[prestations[i]];
			result += "- " + cKey + " \t" + services.get(cKey) + "\n";
			total_sum += services.get(cKey);
		}


		result += "\n----------------------------------\n";
		result += " Bill total \t\t" + total_sum + "\n";
		result += "----------------------------------\n";
		result += "\nPayment in 30 days. Thank you !";
		return result;
	}


	public static void main(String[] args) {
		GarageManager gm = new GarageManager();


		// Prestation 0 is "Oil level control"
		// Prestation 1 is "Tire replacement "
		// Prestation 2 is "Windshield exchange"
		// Prestation 3 is "Oil filter change"
		// Prestation 4 is "Battery replacement"
		// Prestation 5 is "Pollution control"
		// Prestation 6 is "Brake revision"


		int[] client1 = { 1, 1, 1, 1, 4, 6, 0 };
		String bill1 = gm.generateBill(client1);
		System.out.println(bill1);


		PrintWriter outputStreamName;


		try {
			outputStreamName = new PrintWriter(new FileOutputStream("bill.txt"));
			outputStreamName.print(bill1);
			outputStreamName.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}