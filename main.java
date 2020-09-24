import bin.*;
import java.util.Scanner;

public class main{
	public static void main(String[] argv){

		Agent a = new Agent(new Scanner(System.in).nextLine());
		System.out.println(a.userState);
	}

}
