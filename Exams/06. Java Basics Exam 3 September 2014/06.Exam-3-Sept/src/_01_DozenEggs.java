import java.util.Scanner;

public class _01_DozenEggs {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int eggs = 0;
		
		for (int i = 0; i < 7; i++) {
			String[] inLine = input.nextLine().split("\\s+");
			int count = Integer.parseInt(inLine[0]);
			
			if (inLine[1].equals("eggs")) {
				eggs += count;
			} else {
				eggs += count * 12;
			}
		}
		
		System.out.println(eggs/12 + " dozens + " + eggs%12 + " eggs");
	}
}
