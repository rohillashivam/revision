package linked.problems.ctci;

import linked.node.LinkedNode;

public class ReturnKFromLast {

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(30, new LinkedNode(10,
				new LinkedNode(20, new LinkedNode(50, new LinkedNode(10, new LinkedNode(30, null))))));

		printLinkedList(head);
		LinkedNode node = kthElementFromLast(head, 3);
		if(node != null) {
			System.out.println("kth element is :: "+node.getValue());
		}
		node = kthElementFromLast(head, 0);
		if(node != null) {
			System.out.println("kth element is :: "+node.getValue());
		}
		node = kthElementFromLast(head, 10);
		if(node != null) {
			System.out.println("kth element is :: "+node.getValue());
		}
	}
	
	private static LinkedNode kthElementFromLast(LinkedNode head, int k) {
		if(head == null || k < 0)
			return null;
		LinkedNode curr = head, aheadNode = head;
		int count = 0;
		while(count < k) {
			if(aheadNode == null) {
				System.err.println("k is more than length of list ");
				return null;
			}
			aheadNode = aheadNode.getNext();
			count++;
		}
		
		if(aheadNode == null) {
			System.err.println("k more than length of linkedlist");
			return null;
		}
		
		while(aheadNode != null) {
			curr = curr.getNext();
			aheadNode = aheadNode.getNext();
		}
		return curr;
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
