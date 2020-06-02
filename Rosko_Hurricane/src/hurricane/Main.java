package hurricane;

import java.util.List;
import java.util.Scanner;

/**
 * Got canes?
 * @author plesio + rousko
 */
public class Main {
	
	private static List<Hurricane> hurricanes = Hurricane.loadFile("hurricanedata.txt");

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		for(;;){
			System.out.println("Y ( int min, int max ) -- Print year range");
			System.out.println("C ( String name ) -- Get category.");
			System.out.println("S ( void ) -- Sort all by speed.");
			System.out.println("Q ( void ) -- Exit");
			String next = sc.next();
			switch (next){
				case "Y":
					int min = sc.nextInt();
					int max = sc.nextInt();
					System.out.println(Hurricane.getRange(hurricanes, min, max));
					break;
				case "C":
					String name = sc.next();
					System.out.println(Hurricane.getLevel(hurricanes, name));
					break;
				case "Q":
					System.out.println("Goodbye :^)");
					System.exit(0);
					break;
				case "S":
					System.out.println(Hurricane.sortHurricanes(hurricanes));
				default :
					System.out.println("Invalid input.");
					break;
			}
		}
		
	}
	
}
