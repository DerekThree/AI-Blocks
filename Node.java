package bin;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Node {
	public final Board board;
	public final Node parent;
	public final char action;
	public final int misplaced;
	public final int manhattan;
	public Fringe queue = new Fringe();

	public Node(Board currentBoard, Board finalBoard, Node parent, char action){
		this.board = currentBoard;
		this.action = action;
		this.parent = parent;
		if (parent!=null) parent.queue.add(this);

		// count manhattan and misplaced
		int manTemp = 0;
		int misTemp = 0;
		int bLength = board.getState().length;
		for (int holderNum=0; holderNum<bLength; holderNum++) {
			if (currentBoard.getState()[holderNum] != finalBoard.getState()[holderNum]) {
				misTemp++;
				// count manhattan
				int tilesCurrentHolder = findIndex(currentBoard.getState(), finalBoard.getState()[holderNum]);
				if (tilesCurrentHolder == 0) tilesCurrentHolder = bLength; // 0 -> 16
				int tilesFinalHolder = holderNum;
				if (tilesFinalHolder == 0) tilesFinalHolder = bLength; // 0 -> 16
				int diff = tilesFinalHolder - tilesCurrentHolder;
				if (diff<0) diff = -diff;
				manTemp += (diff/4) + (diff%4); // 4 is num of columns
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

