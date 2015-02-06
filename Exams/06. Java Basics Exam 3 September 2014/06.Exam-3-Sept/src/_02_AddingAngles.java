import java.util.Scanner;

public class _02_AddingAngles {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = Integer.parseInt(input.nextLine());
		int[] degrees = new int[n];		
		for (int i = 0; i < degrees.length; i++) {
			degrees[i] = input.nextInt();
		}
		
		boolean isFound = false;
		for (int i = 0; i < degrees.length; i++) {
			for (int j = i+1; j < degrees.length; j++) {
				for (int k = j+1; k < degrees.length; k++) {
					int a = degrees[i];
					int b = degrees[j];
					int c = degrees[k];
					
					if ((a + b + c) % 360 == 0) {
						System.out.printf("%d + %d + %d = %d degrees\n", a, b, c, a+b+c);
						isFound = true;
					}
				}
			}
		}
		
		if (!isFound) {
			System.out.println("No");
		}
	}
}
