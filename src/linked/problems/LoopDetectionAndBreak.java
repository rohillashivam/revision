package linked.problems;

import linked.node.LinkedNode;

public class LoopDetectionAndBreak {

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4,
				new LinkedNode(5, new LinkedNode(6, new LinkedNode(7, new LinkedNode(8, null))))))));
		createALoop(head, 3, 8);
		//printLinkedList(head);
		detectLoop(head);
	}

	private static void detectLoop(LinkedNode head) {
		if(head == null)
			return;

		LinkedNode slowNode = head.getNext(), fastNode = head.getNext().getNext();
		boolean loopFound = false;
		while(slowNode != null) {
			if(slowNode.getValue() == fastNode.getValue()) {
				loopFound = true;
				break;
			}
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}
		if(loopFound) {
			System.out.println("loop found");
			breakLoop(head, slowNode, fastNode);
			System.out.println("printing list after breaking loop");
			printLinkedList(head);
		}
	}

	private static void breakLoop(LinkedNode head, LinkedNode slowNode, LinkedNode fastNode) {
		System.out.println("In BREAKLOOP");
		if(slowNode.getValue() == fastNode.getValue()) {
			slowNode = head;
			while(slowNode.getNext() != fastNode.getNext()) {
				fastNode = fastNode.getNext();
				slowNode = slowNode.getNext();
			}
			fastNode.setNext(null);
		}
	}

	private static void createALoop(LinkedNode head, int val1, int val2) {
		if(head == null)
			return;
		
		LinkedNode node = head, node1 = null, node2 = null;
		while(node != null) {
			if(node.getValue() == val1) 
				node1 = node;
			if(node.getValue() == val2)
				node2 = node;
			if(node1 != null && node2 != null)
				break;
			node = node.getNext();
		}
		node2.setNext(node1);
	}
	
	private static void printLinkedList(LinkedNode head) {
		if (head == null)
			return;

		LinkedNode node = head;
		while (node != null) {
			System.out.print(node.getValue() + " ");
			node = node.getNext();
		}
		System.out.println();
	}
}
