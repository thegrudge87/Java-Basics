import java.util.Arrays;
import java.util.Scanner;

public class _02_PossibleTriangles {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		boolean isFound = false;
		String inLine = input.nextLine();
		
		while (!inLine.equals("End")) {
			String[] strNums = inLine.split("\\s+");
			double[] numbers = new double[strNums.length];
			
			for (int i = 0; i < strNums.length; i++) {
				numbers[i] = Double.parseDouble(strNums[i]);
			}
			
			Arrays.sort(numbers);
			if (numbers[0] + numbers[1] > numbers[2]) {
				System.out.printf("%.2f+%.2f>%.2f%n", numbers[0], numbers[1], numbers[2]);
				isFound = true;
			}
			
			// read next line
			inLine = input.nextLine();
		}
		
		if (!isFound) {
			System.out.println("No");
		}
	}
}
