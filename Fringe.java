package bin;

import java.util.*;

public class Fringe {		  
	private LinkedList<Node> list = new LinkedList<>();
	public boolean manSwitch = false;

	void add(Node node) {
		list.add(node);
	}

	Node remove() {
		return manSwitch ? pollByManhattan() : pollByMisplaced();
	}

	void clear() {
		list.clear();
	}

	private Node pollByMisplaced() {
		if (list.isEmpty()) return null;
		Node temp = list.element();
		for (Node node : list)
			if (node.misplaced < temp.misplaced) temp = node;
		list.remove(temp);
		return temp;
	}

	private Node pollByManhattan() {
		if (list.isEmpty()) return null;
		Node temp = list.element();
		for (Node node : list)
			if (node.manhattan < temp.manhattan) temp = node;
		list.remove(temp);
		return temp;
	}

	boolean isEmpty() {
		return list.isEmpty();
	}

}

