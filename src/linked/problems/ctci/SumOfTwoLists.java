package linked.problems.ctci;

import linked.node.LinkedNode;

public class SumOfTwoLists {

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(7, new LinkedNode(1, new LinkedNode(6, null)));
		LinkedNode headSec = new LinkedNode(5, new LinkedNode(9, new LinkedNode(2, new LinkedNode(1, null))));
		
		LinkedNode node = head, nodeSec = headSec, sumHead = null, sumTail = null;
		int carry = 0;
		while(node != null || nodeSec != null) {
			if(node == null && nodeSec == null && carry == 0) 
				continue;
			int sum = carry;
			if(node != null && nodeSec == null)
				sum += node.getValue();
			else if(node == null && nodeSec != null)
				sum += nodeSec.getValue();
			else
				sum += node.getValue() + nodeSec.getValue();
			
			carry = sum/10 ;
			sum = sum % 10;
			LinkedNode sumNode = new LinkedNode(sum, null);
			if(sumHead == null) {
				sumHead = sumNode;
				sumTail = sumHead;
			} else {
				sumTail.setNext(sumNode);
				sumTail = sumTail.getNext();
			}
			if(node != null)
				node = node.getNext();
			if(nodeSec != null)
				nodeSec = nodeSec.getNext();
		}
		
		printLinkedList(sumHead);
		
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
