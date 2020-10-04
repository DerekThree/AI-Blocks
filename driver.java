import bin.*;
import java.util.Scanner;
import java.io.PrintWriter;

public class driver{
	public static void main (String[] argv) throws Exception {
		Board b = new Board("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0");
		Board temp;
		b.draw();

		Scanner myObj = new Scanner(System.in);
		String key = myObj.nextLine();
		PrintWriter writer = new PrintWriter("input", "UTF-8");
		while (true) {
			switch (key) {
				case "w":
					temp = b.up();
					b = (temp!=null) ? temp : b;
					b.draw();
					break;
				case "s":
					temp = b.down();
					b = (temp!=null) ? temp : b;
					b.draw();
					break;
				case "a":
					temp = b.left();
					b = (temp!=null) ? temp : b;
					b.draw();
					break;
				case "d":
					temp = b.right();
					b = (temp!=null) ? temp : b;
					b.draw();
					break;
				case "q":
					byte[] state = b.getState();
					for (int i=1; i<16; i++){
						writer.print(state[i] + " ");
					}
					writer.print(state[0]);
					writer.close();
					return;
			}
			key = myObj.nextLine();
		}			  
	}
}
