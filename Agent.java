package bin;

import java.util.*;

public class Agent {
	private Board board = new Board(); // game board
	private Node root = new Node(board, null, 'x'); // BSF results
	private String userState; // given as starting game state 
	// visited nodes stored here as strings
	private HashSet<String> visited = new HashSet<String>();
	// nodes waiting to be expanded
	private LinkedList<Node> queue = new LinkedList<Node>();

	// takes user input as String with 16 numbers, space seperated
	// input represents starting game state
	public Agent(String input){
		queue.add(root);
		this.userState = Utils.encode(Utils.tokenize(input));
	}

	void search(){
		
	}

	// creates children and puts them in queue
	void expand(Node node){
		enqueue(node.board.up(), node, 'u');
		enqueue(node.board.down(), node, 'd');
		enqueue(node.board.left(), node, 'l');
		enqueue(node.board.right(), node, 'r');
	}

	// creates and enqueues a Node containing newBoard
	void enqueue(Board newBoard, Node parent, char action){
		if (newBoard!=null){
			Node newNode = new Node(newBoard, parent, action);
			// if not visited then enqueue
			if (!visited.contains(newNode.encode())){
				queue.add(newNode);
			}
		}
		
	}
}
