package bin;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Node {
	public final Board board;
	public final Node parent;
	public final char action;
	public final int misplaced;
	public final int manhattan;

	public Node(Board board, Board userBoard, Node parent, char action){
		this.board = board;
		this.parent = parent;
		this.action = action;

		// count manhattan and misplaced
		int manTemp = 0;
		int misTemp = 0;
		for (int i=0; i<board.getState().length; i++) {
			if (userBoard.getState()[i] != board.getState()[i]) {
				misTemp++;
				int diff = i - findIndex(userBoard.getState(), i);
				manTemp += diff>0 ? diff : -diff;
			}
		}
		manhattan = manTemp;
		misplaced = misTemp;
	}

	// encodes game state as String
	public String encode(){
		return  Utils.encode(board.getState());
	}

	int findIndex(byte[] arr, int elem) {
		for (int i=0; i<arr.length; i++)
			if ((int)arr[i] == elem)
				return i;
		System.out.println("Error in Node.findIndex!\n");
		return -1;
	}
}

