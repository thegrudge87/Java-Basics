import java.util.ArrayList;
import java.util.Scanner;

public class _02_MagicSum {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// read the first number (D - the divider)
		int divider = Integer.parseInt(input.nextLine());
		
		boolean isFound = false;
		int magicSum = Integer.MIN_VALUE;
		
		// read the first line
		String inputLine = input.nextLine();
		
		ArrayList<Integer> allNumbers = new ArrayList<>();
		while (!inputLine.equals("End")) {
			// get all numbers into arraylist;
			allNumbers.add(Integer.parseInt(inputLine));
			// read the next line
			inputLine = input.nextLine();
		}
		
		int[] magicNumbers = new int[3];
		
		for (int i = 0; i < allNumbers.size(); i++) {
			for (int j = i+1; j < allNumbers.size(); j++) {
				for (int k = j+1; k < allNumbers.size(); k++) {
					
					int a = allNumbers.get(i);
					int b = allNumbers.get(j);
					int c = allNumbers.get(k);
					
					if ((a + b + c) % divider == 0) {
						isFound = true;
						if (a + b + c > magicSum) {
							magicSum = a + b +c;
							magicNumbers[0] = a;
							magicNumbers[1] = b;
							magicNumbers[2] = c;
						}
					}
					
				}
			}
		}
		
		if (isFound) {
			System.out.printf("(%d + %d + %d) %% %d = 0",  
					magicNumbers[0], magicNumbers[1], 
					magicNumbers[2], divider);
		} else {
			System.out.println("No");
		}
	}
}
