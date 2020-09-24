package bin;

import java.nio.charset.StandardCharsets;

public class Node {
	public final Board board;
	public final Node parent;
	public final char action;

	public Node(Board board, Node parent, char action){
		this.board = board;
		this.parent = parent;
		this.action = action;
	}

	// encodes game state as String
	public String encode(){
		return  Utils.encode(board.getState());
	}
}

