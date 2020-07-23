package linked.problems.ctci;

import java.util.HashSet;
import java.util.Set;

import linked.node.LinkedNode;

public class RemoveDupsForUnsortedLL {

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(30, new LinkedNode(10,
				new LinkedNode(20, new LinkedNode(50, new LinkedNode(10, new LinkedNode(30, null))))));

		printLinkedList(head);
		removeDuplicate(head);
		printLinkedList(head);
	}

	private static void removeDuplicate(LinkedNode head) {
		LinkedNode node = head, prevNode = null;
		Set<Integer> dataSet = new HashSet<>();
		while (node != null) {
			if(!dataSet.contains(node.getValue())) {
				dataSet.add(node.getValue());
				prevNode = node;
			} else {
				deleteNodeFromList(prevNode, node);
			}
			node = node.getNext();
		}
	}

	private static void deleteNodeFromList(LinkedNode prevNode, LinkedNode node) {
		prevNode.setNext(node.getNext());
		node.setNext(null);
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
