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
	// nodes waiting to be expanded
	private Fringe queue = new Fringe();

	// takes user input as String with 16 numbers, space seperated
	// input represents starting game state
	public Agent(String input, boolean manSwitch){
		this.userBoard = new Board(input);
		this.userState = Utils.encode(userBoard.getState());
		queue.add(new Node(new Board(), userBoard, null, 'X'));
		queue.manSwitch = manSwitch;
		search();
	}

	// takes node from queue, checks for solution, and expands it
	void search(){
		while(!queue.isEmpty()){
			Node temp = queue.remove();
			if (temp.encode().equals(userState)) {
				displaySolution(temp);
				return;
			}
			else
				expand(temp);
		}
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
				queue.add(newNode);
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
