package linked.problems.ctci;

import linked.node.LinkedNode;

public class Palindrome {
	
	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(1, new LinkedNode(2,
				new LinkedNode(3, new LinkedNode(4, new LinkedNode(3, new LinkedNode(2, new LinkedNode(1, null)))))));
		printLinkedList(head);
		boolean palindrom = isPalindrom(head);
		System.out.println("is palindrom :: "+palindrom);
		
		head = new LinkedNode(1, new LinkedNode(2,
				new LinkedNode(2, new LinkedNode(3, new LinkedNode(3, new LinkedNode(2, new LinkedNode(1, null)))))));
		printLinkedList(head);
		palindrom = isPalindrom(head);
		System.out.println("is palindrom :: "+palindrom);
	}
	
	private static LinkedNode left = null;
	
	private static boolean isPalindrom(LinkedNode node) {
		if(node == null) 
			return true;
		
		if(left == null)
			left = node;
		
		boolean isPalindromInSublist = isPalindrom(node.getNext());
		if(!isPalindromInSublist)
			return false;
		
		if(left.getValue() == node.getValue()) {
			left = left.getNext();
			return true;
		}
		return false;
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
