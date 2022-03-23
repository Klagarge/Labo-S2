package lab13_streams;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * A sample garage application for demonstrating text file output
 * @author Pierre-André Mudry, HES-SO Valais 2010
 */
public class GarageManager {
	HashMap<String, Integer> services = new HashMap<String, Integer>();

	GarageManager(){
		// The various services provided in this garage
		services.put("Oil level control", 20);
		services.put("Tire replacement ", 50);
		services.put("Windshield exchange", 60);
		services.put("Oil filter change", 210);
		services.put("Battery replacement", 320);
		services.put("Pollution control", 200);
		services.put("Brake revision", 400);
	}
	
	String generateBill(int[] operationsPerformed){
		int total_sum = 0;
		Object[] keys = services.keySet().toArray();
		
		String result = "";
		result += "*******************************\n";
		result += "* Super Auto 20000 invoice ****\n";
		result += "*******************************\n\n";
		
		// Generate the text corresponding to the operations done in the garage
		for(int i = 0; i < operationsPerformed.length; i++){
			if(operationsPerformed[i] > services.size()){
				System.out.println("Error, non existing prestation !");
				System.exit(-1);
			}
			
			String cKey = (String) keys[operationsPerformed[i]];
			result += "- " + cKey + " \t" + services.get(cKey) + "\n";
			total_sum += services.get(cKey);
		}
		
		result += "\n----------------------------------\n";
		result += " Invoice total \t\t" + total_sum + "\n";
		result += "----------------------------------\n";
		result += "\nPayment in 30 days. Thank you !";		
		return result;	
	}
	
	public static void main(String[] args) {
		GarageManager gm = new GarageManager();
		

		// Prestation 0 is "Windshield exchange"
		// Prestation 1 is "Battery replacement"
		// Prestation 2 is "Oil level control"
		// Prestation 3 is "Pollution control"
		// Prestation 4 is "Tire replacement"
		// Prestation 5 is "Brake revision"
		// Prestation 6 is "Oil filter change"
		int[] client1 = {1, 2, 3};
		String bill1 = gm.generateBill(client1);
		System.out.println(bill1);
		
		int[] client2 = {4, 4, 4, 4, 4, 6};
		String bill2 = gm.generateBill(client2);
		System.out.println(bill2);
				
		// Complete with your code here !

		try {
			FileOutputStream bill = new FileOutputStream("C://tmp//bill.txt");
			PrintWriter billWriter = new PrintWriter(bill);
			billWriter.print(bill1 + "\n\n\n\n\n\n\n" + bill2);
			billWriter.close();
		} catch (Exception e) {
			System.out.println("File can't be written");
            e.printStackTrace();
		}
	}

}
