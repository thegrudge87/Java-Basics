import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_ActivityTracker {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());

		Map<Integer, Map<String, Integer>> dataMap = new TreeMap<>();
		
		// loop through all data lines
		for (int i = 0; i < n; i++) {
			String[] inLine = input.nextLine().split("\\s+");
			int month = Integer.parseInt(inLine[0].substring(3, 5));
			String user = inLine[1];
			int distance = Integer.parseInt(inLine[2]);
			
			// check is the month is already in the Map
			if (dataMap.get(month) == null) {
				// if it's not we add it and add the user and distance
				dataMap.put(month, new LinkedHashMap<>());
				dataMap.get(month).put(user, distance);
			} else {
				// check if the user exists
				if (dataMap.get(month).get(user) == null) {
					// user don't exist
					dataMap.get(month).put(user, distance);
				} else {
					// the user exists
					int currDistance = dataMap.get(month).get(user);
					dataMap.get(month).put(user, currDistance + distance);
				}
			}
		}
		
		for (int month : dataMap.keySet()) {
			String output = month + ": ";
			// here we set the monthly map to Tree set. 
			// This sorts the Map by username.
			Map<String, Integer> infoMap = new TreeMap<>(dataMap.get(month));
			for (String user : infoMap.keySet()) {
				output += String.format("%s(%d), ", user, infoMap.get(user));
			}
			// we need to remove the ", " after the last user.
			System.out.println(output.substring(0, output.length()-2));
		}
	}
}
