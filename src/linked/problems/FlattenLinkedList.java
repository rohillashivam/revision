package linked.problems;

import linked.node.LinkedNode;

public class FlattenLinkedList {

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(5, new LinkedNode(10, new LinkedNode(19, new LinkedNode(28, null))));
		head.setDown(new LinkedNode(7, null));
		head.getDown().setDown(new LinkedNode(8, null));
		head.getDown().getDown().setDown(new LinkedNode(30, null));
		head.getNext().setDown(new LinkedNode(20, null));
		head.getNext().getNext().setDown(new LinkedNode(22, null));
		head.getNext().getNext().getDown().setDown(new LinkedNode(50, null));
		head.getNext().getNext().getNext().setDown(new LinkedNode(35, null));
		head.getNext().getNext().getNext().getDown().setDown(new LinkedNode(40, null));
		head.getNext().getNext().getNext().getDown().getDown().setDown(new LinkedNode(45, null));
		
		flattenLinkedList(head);
		printLinkedList(head);
		System.out.println("");
		
		head = new LinkedNode(5, new LinkedNode(10, new LinkedNode(19, new LinkedNode(28, null))));
		head.setDown(new LinkedNode(7, null));
		head.getDown().setDown(new LinkedNode(8, null));
		head.getDown().getDown().setDown(new LinkedNode(30, null));
		head.getNext().setDown(new LinkedNode(20, null));
		head.getNext().getNext().setDown(new LinkedNode(22, null));
		head.getNext().getNext().getDown().setDown(new LinkedNode(50, null));
		head.getNext().getNext().getNext().setDown(new LinkedNode(35, null));
		head.getNext().getNext().getNext().getDown().setDown(new LinkedNode(40, null));
		head.getNext().getNext().getNext().getDown().getDown().setDown(new LinkedNode(45, null));
		
		flattenSortedLinkedList1(head);
		printLinkedList(head);
	}

	private static void flattenSortedLinkedList1(LinkedNode node) {
		if(node == null) return;
		
		if(node.getNext() != null)
			flattenSortedLinkedList1(node.getNext());
		if(node.getDown() != null)
			mergeDown(node);
		
	}

	private static void mergeDown(LinkedNode head) {
		LinkedNode node = head;
		LinkedNode downNode = node.getDown();
		while(downNode != null) {
			node = mergeNode(node, downNode);
			downNode = downNode.getDown();
		}
		node.setDown(null);
	}

	private static LinkedNode mergeNode(LinkedNode node, LinkedNode downNode) {
		LinkedNode prevNode = node;
		LinkedNode cuLinkedNode = node;
		while(cuLinkedNode != null) {
			if(cuLinkedNode.getValue() > downNode.getValue())
				break;
			prevNode = cuLinkedNode;
			cuLinkedNode = cuLinkedNode.getNext();
		}
		downNode.setNext(prevNode.getNext());
		prevNode.setNext(downNode);
		return downNode;
	}

	private static void flattenLinkedList(LinkedNode node) {
		if(node == null)
			return;
		LinkedNode nextNode = null;
		if(node.getDown() != null) {
			nextNode = node.getNext();
			node.setNext(node.getDown());
			node.getNext().setNext(nextNode);
			node.setDown(null);
			flattenLinkedList(node.getNext());
		} else {
			if(node.getNext() != null) {
				flattenLinkedList(node.getNext());
			}
		}
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
