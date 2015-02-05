import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_OfficeStuff {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int numberOfOrders = Integer.parseInt(input.nextLine());
		
		String[] orders = new String[numberOfOrders];
		Map<String, Map<String, Integer>> ordersMap = new TreeMap<>();
		
		// loop through all orders
		for (int i = 0; i < numberOfOrders; i++) {
			// split the order to elements and set them to variables.
			String[] orderAsStringArr = input.nextLine().split(" - ");
			String company = orderAsStringArr[0].substring(1, orderAsStringArr[0].length());
			int amount = Integer.parseInt(orderAsStringArr[1]);
			String product = orderAsStringArr[2].substring(0, orderAsStringArr[2].length()-1);
			
			// check if the company is already in the Map
			if (ordersMap.get(company) == null) {
				ordersMap.put(company, new LinkedHashMap<>());
				ordersMap.get(company).put(product, amount);
			} else {
				// the company is already in the Map, but we check if there is such product.
				// if the is no such product we add it to the Map.
				if (ordersMap.get(company).get(product) == null) {
					ordersMap.get(company).put(product, amount);
				} else {
					// if there is such product we add the new amount to the current.
					int currAmount = ordersMap.get(company).get(product);
					ordersMap.get(company).put(product, currAmount + amount);
				}
			}
		}
		for (String key : ordersMap.keySet()) {
			String output = key + ": ";
			Map<String, Integer> infoMap = ordersMap.get(key);
			for (String infoMapKey : infoMap.keySet()) {
				output += String.format("%s-%d",infoMapKey, infoMap.get(infoMapKey));
			}
			System.out.println(output);
		}
	}
}
