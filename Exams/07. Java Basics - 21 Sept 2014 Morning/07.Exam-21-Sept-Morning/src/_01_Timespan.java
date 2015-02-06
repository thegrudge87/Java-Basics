import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class _01_Timespan {
	public static void main(String[] args) throws ParseException {
		
		Scanner input = new Scanner(System.in);
		String strStart = input.nextLine();
		String strEnd = input.nextLine();
		
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Date start =format.parse(strStart);
		Date end = format.parse(strEnd);
		
		// in milliseconds
		long timestamp = start.getTime()-end.getTime();
		long seconds = (timestamp / 1000)%60;
		long minutes = timestamp / (60 * 1000) % 60;
		long hours = timestamp / (60 * 60 * 1000);
		System.out.printf("%d:%02d:%02d", hours, minutes, seconds);
		
		
		
	}
}
