package bin;

// TODO: delete movements
public class Board{
	private byte state[]; // game state
	private int pos; // position of the blank
	static private final int NONE = -1;
			
	public Board(){
		String s = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0";
		state = Utils.tokenize(s);
		pos = 0;
	}

	public Board(String s){
		this.state = Utils.tokenize(s);
		for (int i=0; i<16; i++) if (state[i] == 0) pos = i;
	}

	private Board(byte[] state, int pos){
		this.state = state;
		this.pos = pos;
	}

	// returns a new board with blank moved to next
	private Board getNewBoard(int next){
		byte newState[] = new byte[16];
		System.arraycopy(state, 0, newState, 0,16);
		newState[pos] = newState[next];
		newState[next] = 0;
		return new Board(newState, next);	
	}

	// moves the blank
	public Board up(){
		int next;
		if (pos == 0) next = 12;
		else next = (0 < pos && pos < 5) ? NONE : pos - 4;
		if (next == NONE) return null;
		else return getNewBoard(next);
	}

	public Board down(){
		int next;
		if (pos == 0) next = NONE;
		else if (pos == 12) next = 0;
		else next = (pos > 12) ? NONE : pos + 4;
		if (next == NONE) return null;
		else return getNewBoard(next);
	}

	public Board left(){
		int next;
		if (pos == 0) next = 15;
		else next = ((pos - 1) % 4 == 0) ? NONE : pos - 1;
		if (next == NONE) return null;
		else return getNewBoard(next);
	}

	public Board right(){
		int next;
		if (pos == 15) next = 0;
		else next = (pos % 4 == 0) ? NONE : pos + 1;
		if (next == NONE) return null;
		else return getNewBoard(next);
	}

	public byte[] getState(){
		return state;
	}

	public int getPos(){
		return pos;
	}

	// draws the board
	public void draw(){ 
		System.out.println("---------------");
		System.out.printf("| %2d %2d %2d %2d |\n", state[1], state[2], state[3], state[4]);
		System.out.printf("| %2d %2d %2d %2d |\n", state[5], state[6], state[7], state[8]);
		System.out.printf("| %2d %2d %2d %2d |\n", state[9], state[10], state[11], state[12]);
		System.out.printf("| %2d %2d %2d %2d |\n", state[13], state[14], state[15], state[0]);
		System.out.println("---------------");
	}

	// converts String to byte[]
	private byte[] tokenize(String s){
      String[] tokens = s.split(" ");
      byte[] result = new byte[16];
      result[0] = (byte) Integer.parseInt(tokens[15]);
      for (int i=0; i<15; i++)
         result[i+1] = (byte) Integer.parseInt(tokens[i]);
      return result;
   }

}
