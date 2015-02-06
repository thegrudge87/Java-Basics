import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_Nuts {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		Map<String, Map<String, Integer>> ordersMap = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String[] inputLine = input.nextLine().split("\\s+");
			String company = inputLine[0];
			String nuts = inputLine[1];
			int amount = Integer.parseInt(inputLine[2].substring(0, inputLine[2].length()-2));
			
			if (ordersMap.get(company) == null) {
				ordersMap.put(company, new LinkedHashMap<>());
				ordersMap.get(company).put(nuts, amount);
			} else {
				if (ordersMap.get(company).get(nuts) == null) {
					ordersMap.get(company).put(nuts, amount);
				} else {
					int currAmount = ordersMap.get(company).get(nuts);
					ordersMap.get(company).put(nuts, currAmount + amount);
				}
			}
		}
		
		for (String company : ordersMap.keySet()) {
			String result = company + ": ";
			Map<String, Integer> nutsMap = ordersMap.get(company);
			
			for (String nutsData : nutsMap.keySet()) {
				result += String.format("%s-%dkg, ", nutsData, nutsMap.get(nutsData));
			}
			System.out.println(result.substring(0, result.length()-2));
		}
		
	}
}