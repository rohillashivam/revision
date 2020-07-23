package linked.problems.ctci;

import linked.node.LinkedNode;

public class PartitioningLL {

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(1, new LinkedNode(4,
				new LinkedNode(3, new LinkedNode(2, new LinkedNode(5, new LinkedNode(2, new LinkedNode(3, null)))))));
		printLinkedList(head);
		
		int partitionVal = 3;
		LinkedNode paritionListHead = parititioningLinkedList(head, partitionVal);
		printLinkedList(paritionListHead);
		
		head = new LinkedNode(1, new LinkedNode(4,
				new LinkedNode(3, new LinkedNode(2, new LinkedNode(5, new LinkedNode(2, new LinkedNode(3, null)))))));
		printLinkedList(head);
		paritionListHead = parititioningLinkedListOptimized(head, partitionVal);
		printLinkedList(paritionListHead);
		
	}
	
	private static LinkedNode parititioningLinkedListOptimized(LinkedNode head, int partitionVal) {
		LinkedNode node = head;
		LinkedNode start = null, tail = null;
		while(node != null) {
			LinkedNode next = node.getNext();
			node.setNext(null);
			if(node.getValue() <= partitionVal) {
				if(start == null) {
					start = node;
					tail = node;
				} else {
					node.setNext(start);
					start = node;
				}
			} else {
				if(tail == null) {
					tail = node;
				} else {
					tail.setNext(node);
					tail = tail.getNext();
				}
			}
			node = next;
		}
		
		return start == null ? tail : start;
	}

	private static LinkedNode parititioningLinkedList(LinkedNode head, int partitionVal) {
		LinkedNode smallHead = null, smallTail = null;
		LinkedNode greaterHead = null, greaterTail = null;
		LinkedNode node = head;
		while(node != null) {
			LinkedNode next = node.getNext();
			node.setNext(null);
			
			if(node.getValue() <= partitionVal) {
				if(smallHead == null) {
					smallHead = node;
					smallTail = smallHead;
				} else {
					smallTail.setNext(node);
					smallTail = smallTail.getNext();
				}
			} else {
				if(greaterHead == null) {
					greaterHead = node;
					greaterTail = node;
				} else {
					greaterTail.setNext(node);
					greaterTail = greaterTail.getNext();
				}
			}
			node = next;
		}
		
		if(smallHead == null)
			return greaterHead;
		
		smallTail.setNext(greaterHead);
		
		return smallHead;
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
