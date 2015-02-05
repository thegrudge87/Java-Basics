import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_ValidUsernames {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// split by space, “(”, “)”, “/“, “\”
		String inputLine = input.nextLine();
		String[] usernames = inputLine.split("[\\s()/\\\\]+");
		ArrayList<String> validUsernames = new ArrayList<>();
		
		// Username starts with a letter and can contain only letters, digits and “_”.
		// It cannot be less than 3 or more than 25 symbols long.
		Pattern pattern = Pattern.compile("\\b[a-zA-Z][\\w_]{2,25}\\b");
		
		// if username match with a pattern -> add to valid usernames arraylist
		for (String user : usernames) {
			Matcher matcher = pattern.matcher(user);
			if (matcher.find()) {
				validUsernames.add(user);
			}
		}
		
		int maxLength = 0;
		String[] longestUsers = new String[2];
		
		for (int i = 0; i < validUsernames.size()-1; i++) {
			int currLength = validUsernames.get(i).length() + validUsernames.get(i+1).length();
			
			if (currLength > maxLength) {
				maxLength = currLength;
				longestUsers[0] = validUsernames.get(i);
				longestUsers[1] = validUsernames.get(i+1);
			}
		}
		
		
		// print the 2 longest valid usernames
		for (int i = 0; i < longestUsers.length; i++) {
			System.out.println(longestUsers[i]);
		}
	}
}
