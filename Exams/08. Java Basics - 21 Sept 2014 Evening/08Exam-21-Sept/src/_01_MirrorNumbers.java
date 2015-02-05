import java.util.Scanner;

public class _01_MirrorNumbers {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		input.nextLine();
		String[] numbers = input.nextLine().split("\\s+");
		boolean isFound = false;
		
		for (int i = 0; i < numbers.length-1; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				String rvrsNumber = new StringBuffer(numbers[j]).reverse().toString();
				if (numbers[i].equals(rvrsNumber)) {
					System.out.println(numbers[i] + "<!>" + numbers[j]);
					isFound = true;					
				}
			}
		}
		
		if (!isFound) {
			System.out.println("No");
		}
	}
}
