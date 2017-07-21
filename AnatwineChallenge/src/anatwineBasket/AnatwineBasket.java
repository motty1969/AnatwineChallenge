package anatwineBasket;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnatwineBasket {

	static Map<String, Double> catalogue = new HashMap<String, Double>();

	static Map<String, Double> discounts = new HashMap<String, Double>();
	
	public static void main(String[] args) {

		loadCatalogue();

		displayItems(args);
		
		/*if(args[0].equals("add"))
			for(int i = 1; i < args.length; i++) {
				catalogue.put(args[i], 150.00);
			}

		System.out.println(catalogue.size());
		System.out.println(args.length);*/
	}
	
	private static void displayItems(String[] args) {
		double total = 0.0;
		for(int i = 0; i < args.length; i++) {
			System.out.println(catalogue.get(args[i]));
			total += catalogue.get(args[i]);
		}
		System.out.println("Total: " + total);
	}

	private static void loadCatalogue() {
		File catalogueFile = new File("C:\\OmnixDev\\Java8\\anatwine-challenge\\src\\anatwineBasket\\catalogue.csv");
		Scanner input;
		try {
			input = new Scanner(catalogueFile);
			do {
				String item = input.nextLine();
				System.out.println(item);
				String[] itemDetails = item.split(",");
				catalogue.put(itemDetails[0], new Double(itemDetails[1]));
			} while(input.hasNext());
			System.out.println("Catalogue size: " + catalogue.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
