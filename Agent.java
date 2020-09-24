package bin;

import java.util.*;

// AI agent that computes and displays a solution to a puzzle
public class Agent {
//	private freeMemory = Runtime.getRuntime().freeMemory();
	private Node root = new Node(new Board(), null, 'X'); // BSF results
	private int nodeCount = 1;
	private String userState; // starting game state 
	// visited nodes stored here as strings
	private HashSet<String> visited = new HashSet<String>();
	// nodes waiting to be expanded
	private LinkedList<Node> queue = new LinkedList<Node>();

	// takes user input as String with 16 numbers, space seperated
	// input represents starting game state
	public Agent(String input){
		queue.add(root);
		this.userState = Utils.encode(Utils.tokenize(input));
		search();
	}

	// takes node from queue, checks for solution, and expands it
	void search(){
		while(!queue.isEmpty()){
			Node temp = queue.remove();
			if (temp.encode().equals(userState))
				displaySolution(temp);
			else
				expand(temp);
		}
	}

	// creates children and puts them in queue
	void expand(Node node){
		enqueue(node.board.up(), node, 'U');
		enqueue(node.board.down(), node, 'D');
		enqueue(node.board.left(), node, 'L');
		enqueue(node.board.right(), node, 'R');
	}

	// creates and enqueues a Node containing newBoard
	void enqueue(Board newBoard, Node parent, char action){
		if (newBoard!=null){
			Node newNode = new Node(newBoard, parent, action);
			// if not visited then enqueue
			if (!visited.contains(newNode.encode())){
				queue.add(newNode);
				nodeCount++;
				visited.add(newNode.encode());
			}
		}
	}

	void displaySolution(Node node){
		System.out.print("Moves: ");
		while (node!=root){
			System.out.print(node.action);
			node = node.parent;
		}
		System.out.println();
		displayStats();
		System.exit(0);
	}

	void displayStats(){
		System.out.println("Number of Nodes expanded: " + nodeCount);
		System.out.println("Time Taken: ");
		System.out.println("Memory Used: ");
	}
}
