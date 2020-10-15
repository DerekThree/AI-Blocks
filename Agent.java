package bin;

import java.util.*;

// AI agent that computes and displays a solution to a puzzle
public class Agent {
	private long time = System.nanoTime();
	private long freeMemory = Runtime.getRuntime().freeMemory();
	private int nodeCount = 1;
	final private Board userBoard;
	final private String userState; // starting game state 
	// visited nodes stored here as strings
	private HashSet<String> visited = new HashSet<String>();

	// takes user input as String with 16 numbers, space seperated
	// input represents starting game state
	public Agent(String input, boolean manSwitch){
		this.userBoard = new Board(input);
		this.userState = Utils.encode(userBoard.getState());
		Fringe.manSwitch = manSwitch;
		Node root = new Node(new Board(), userBoard, null, 'X');
		for (int i=0; !search(root, i); i++);
	}

	// takes child from node's queue, checks for solution, and expands it
	boolean search(Node node, int i){
		if (i<=0) return false;
		expand(node);
		while(!node.queue.isEmpty()){
			Node child = node.queue.remove();
System.out.print(node.queue.length());
			if (child.encode().equals(userState)) {
				displaySolution(child);
				return true;
			}
			if (search(child, i-1)) return true;
		}
		return false;
	}

	// creates children and puts them in queue
	// each child remembers one move back home
	void expand(Node node){
		enqueue(node.board.up(), node, 'D');
		enqueue(node.board.down(), node, 'U');
		enqueue(node.board.left(), node, 'R');
		enqueue(node.board.right(), node, 'L');
	}

	// creates and enqueues a Node containing newBoard
	void enqueue(Board newBoard, Node parent, char action){
		if (newBoard!=null){
			Node newNode = new Node(newBoard, userBoard, parent, action);
			// if not visited then enqueue
			if (!visited.contains(newNode.encode())){
				parent.queue.add(newNode);
				nodeCount++;
				visited.add(newNode.encode());
			}
		}
	}

	void displaySolution(Node node){
		System.out.print("Moves: ");
		while (node.parent!=null){
			System.out.print(node.action);
			node = node.parent;
		}
		System.out.println();
		displayStats();
	}

	void displayStats(){
		System.out.println("Number of Nodes expanded: " + nodeCount);
		
		System.out.println("Time Taken: " + (System.nanoTime() - time) + " ns");
		System.out.println("Memory Used: " + (freeMemory - Runtime.getRuntime().freeMemory()) + " bytes");
		System.out.println();
	}
}
