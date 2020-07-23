package linked.problems;

import linked.node.LinkedNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(1,
				new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, new LinkedNode(5, null)))));

		printLinkedList(head);
		printLinkedList(reverseLinkedList(head));
		System.out.println("---------------------------K-REVERSE-----------------------");
		head = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4,
				new LinkedNode(5, new LinkedNode(6, new LinkedNode(7, new LinkedNode(8, new LinkedNode(9, null)))))))));
		printLinkedList(kReverseLinkedList(head, 3));

		head = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3,
				new LinkedNode(4, new LinkedNode(5, new LinkedNode(6, new LinkedNode(7, new LinkedNode(8, null))))))));
		printLinkedList(kReverseLinkedList(head, 3));

		System.out.println("----------------------RECURSIVE REVERSE LIST--------------");
		head = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3,
				new LinkedNode(4, new LinkedNode(5, new LinkedNode(6, new LinkedNode(7, new LinkedNode(8, null))))))));
		printLinkedList(recursiveReverse(head));
	}

	private static LinkedNode kReverseLinkedList(LinkedNode head, int k) {
		if (head == null)
			return null;

		int counter = 1;
		LinkedNode prevNode = null, currNode = head, nextNode = currNode.getNext();
		while (nextNode != null && counter < k) {
			currNode.setNext(prevNode);
			prevNode = currNode;
			currNode = nextNode;
			nextNode = nextNode.getNext();
			counter++;
		}
		currNode.setNext(prevNode);

		if (nextNode != null)
			head.setNext(kReverseLinkedList(nextNode, k));

		return currNode;
	}

	private static LinkedNode reverseLinkedList(LinkedNode head) {
		if (head == null)
			return null;

		LinkedNode prevNode = null, currNode = head, nextNode = head.getNext();
		while (nextNode != null) {
			currNode.setNext(prevNode);
			prevNode = currNode;
			currNode = nextNode;
			nextNode = currNode.getNext();
		}
		if (nextNode == null)
			currNode.setNext(prevNode);

		return currNode;
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

	private static LinkedNode recursiveReverse(LinkedNode node) {
		if(node == null || node.getNext() == null)
			return node;
		
		LinkedNode newHead = recursiveReverse(node.getNext());
		node.getNext().setNext(node);
		node.setNext(null);
		
		return newHead;
	}
}
