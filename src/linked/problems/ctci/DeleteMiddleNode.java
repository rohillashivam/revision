package linked.problems.ctci;

import linked.node.LinkedNode;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(30, new LinkedNode(10,
				new LinkedNode(20, new LinkedNode(50, new LinkedNode(10, new LinkedNode(30, null))))));

		printLinkedList(head);
		deleteMiddleNode(head);
		printLinkedList(head);
	}
	
	private static void deleteMiddleNode(LinkedNode head) {
		if(head == null)
			return;
		LinkedNode slow = head, fast = head.getNext(), prev = null;
		while(fast != null && fast.getNext() != null) {
			prev = slow;
			slow = slow.getNext();
			fast = fast.getNext();
			if(fast != null) 
				fast = fast.getNext();
		}
		System.out.println("Middle element is :: "+slow.getValue());
		deleteMiddleElement(prev, slow);
	}

	private static void deleteMiddleElement(LinkedNode prev, LinkedNode slow) {
		prev.setNext(slow.getNext());
		slow.setNext(null);
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
