import java.util.Scanner;

public class _03_WeirdString {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String s = input.nextLine().replaceAll("[\\\\ \\/ \\( \\) \\|]", "");
		String[] inString = s.split("[^a-zA-Z]+");		
		
		int maxWeight = 0;
		String[] longestWords = new String[2];
		
		for (int i = 0; i < inString.length-1; i++) {		
			String twoWords = (inString[i]+inString[i+1]).toLowerCase();
			int weight = 0;
			
			for (int j = 0; j < twoWords.length(); j++) {
				// the dec code of char 'a' is 97. 'b'=98, 'c'=99'...
				weight += twoWords.charAt(j) - 96; 
			}
			
			if (weight >= maxWeight) {
				maxWeight = weight;
				longestWords[0] = inString[i];
				longestWords[1] = inString[i+1];
			}
		}
		
		for (String string : longestWords) {
			System.out.println(string);
		}
		
	}
}
