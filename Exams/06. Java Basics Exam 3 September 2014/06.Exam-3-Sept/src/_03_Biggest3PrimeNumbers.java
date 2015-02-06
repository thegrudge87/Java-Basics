import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class _03_Biggest3PrimeNumbers {
	 public static void main(String[] args) {
		 
		Scanner input = new Scanner(System.in);
		String[] strNums = input.nextLine().split("[( )]+");
		
		TreeSet<Integer> numbersSet = new TreeSet<>(Collections.reverseOrder());
		for (int i = 0; i < strNums.length; i++) {
			if (!strNums[i].equals("")) {
				int number = Integer.parseInt(strNums[i]);
				numbersSet.add(number);
			}
		}
		
		int primeCount = 0;
		int primeSum = 0;
		
		for (Integer number : numbersSet) {
			// if we already have the 3 biggest prime numbers
			// break the loop;
			if (number <= 1 || primeCount == 3) {
				break;
			}
			
			// Check is the current number is prime.
			boolean isPrime = true;
			for (int i = 2; i < number; i++) {
				if (number % i == 0) {
					isPrime = false;
				}
			}
			
			if (isPrime) {
				primeCount++;
				primeSum += number;
			}
		}
		
		if (primeCount == 3) {
			System.out.println(primeSum);
		} else {
			System.out.println("No");
		}
	}
}
