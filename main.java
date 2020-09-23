import bin.*;

public class main{
	public static void main(String[] argv){
		byte state[] = new byte[16];
		for (byte i=0; i<16;i++) state[i] = i;
		Board b = new Board(state);
		b.draw();
		b.left();
		b.draw();
		b.left();
		b.draw();
		b.left();
		b.draw();
		b.up();
		b.draw();
		b.up();
		b.draw();
		b.up();
		b.draw();
		b.right();
		b.draw();
		b.right();
		b.draw();
		b.right();
		b.draw();
		b.down();
		b.draw();
		b.down();
		b.draw();
		b.down();
		b.draw();
		b.down();
		b.draw();
		b.right();
		b.draw();
	}
}
