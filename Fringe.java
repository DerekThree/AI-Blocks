package bin;

import java.util.*;

public class Fringe {		  
	LinkedList<Node> list = new LinkedList<>();
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

	Node pollByMisplaced() {
		if (list.isEmpty()) return null;
		Node temp = list.element();
		for (Node node : list)
			if (node.misplaced < temp.misplaced) temp = node;
		list.remove(temp);
		return temp;
	}

	Node pollByManhattan() {
		if (list.isEmpty()) return null;
		Node temp = list.element();
		for (Node node : list)
			if (node.misplaced < temp.misplaced) temp = node;
		list.remove(temp);
		return temp;
	}

	boolean isEmpty() {
		return list.isEmpty();
	}

}

