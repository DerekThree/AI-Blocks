package bin;


public class Board{
	byte state[];
	int pos;
	private final int NONE = -1;
			
	public Board(byte state[]){
		this.state = state;
		for (int i=0; i<16; i++) if (state[i] == 0) pos = i;
	}

	public boolean up(){
		int next;
		if (pos == 0) next = 12;
		else next = (0 < pos && pos < 5) ? NONE : pos - 4;
		if (next == NONE) return false;
		state[pos] = state[next];
		state[next] = 0;
		pos = next;
		return true;
	}

	public boolean down(){
		int next;
		if (pos == 0) next = NONE;
		else if (pos == 12) next = 0;
		else next = (pos > 12) ? NONE : pos + 4;
		if (next == NONE) return false;
		state[pos] = state[next];
		state[next] = 0;
		pos = next;
		return true;
	}

	public boolean left(){
		int next;
		if (pos == 0) next = 15;
		else next = ((pos - 1) % 4 == 0) ? NONE : pos - 1;
		if (next == NONE) return false;
		state[pos] = state[next];
		state[next] = 0;
		pos = next;
		return true;
	}

	public boolean right(){
		int next = (pos % 4 == 0) ? NONE : pos + 1;
		if (next == NONE) return false;
		state[pos] = state[next];
		state[next] = 0;
		pos = next;
		return true;
	}

	public void draw(){ 
		System.out.println("---------------");
		System.out.printf("| %2d %2d %2d %2d |\n", state[1], state[2], state[3], state[4]);
		System.out.printf("| %2d %2d %2d %2d |\n", state[5], state[6], state[7], state[8]);
		System.out.printf("| %2d %2d %2d %2d |\n", state[9], state[10], state[11], state[12]);
		System.out.printf("| %2d %2d %2d %2d |\n", state[13], state[14], state[15], state[0]);
		System.out.println("---------------");
	}
}
