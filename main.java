import bin.Agent;
import java.util.Scanner;

public class main{
	public static void main(String[] argv){
		// new Agent(stdin)
		String input = new Scanner(System.in).nextLine();
		System.out.println("Number of misplaced tiles search:");
	   new Agent(input, false);
		System.out.println("Manhattan distance search:");
	   new Agent(input, true);
	}
}
