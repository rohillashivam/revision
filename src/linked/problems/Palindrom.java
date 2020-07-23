package linked.problems;

import java.util.Stack;

import linked.node.LinkedNode;

public class Palindrom {

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(1,
				new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, new LinkedNode(3, 
						new LinkedNode(2, new LinkedNode(1, null)))))));
		System.out.println(isPalindromUsingStack(head));
		System.out.println(isPalindromReverse(head));
		head = new LinkedNode(1,
				new LinkedNode(2, new LinkedNode(3, new LinkedNode(3, 
						new LinkedNode(2, new LinkedNode(1, null))))));
		System.out.println(isPalindromUsingStack(head));
	}

	/**
	 * TODO complete
	 * @param head
	 * @return
	 */
	private static boolean isPalindromReverse(LinkedNode head) {
		if(head == null)
			return true;
		if(head.getNext() == null)
			return true;
		
		LinkedNode slow = head.getNext(), fast = slow.getNext().getNext();
		while(fast != null) {
			
		}
		return false;
	}

	private static boolean isPalindromUsingStack(LinkedNode head) {
		if(head == null)
			return true;
		if(head.getNext() == null)
			return true;
		LinkedNode temp = head, nextNode = temp.getNext();
		Stack<LinkedNode> nodeStack = new Stack<>();
		int length = 2;
		while(nextNode != null) {
			nodeStack.push(temp);
			temp = temp.getNext();
			if(nextNode.getNext() != null) {
				if(nextNode.getNext().getNext() != null) 
					length +=2;
				else
					length ++;
				nextNode = nextNode.getNext().getNext();
			} else {
				nextNode = null;
			}
		}
		boolean isPalindrom = true;
		if(length % 2 != 0)
			temp = temp.getNext();
		while(temp != null) {
			LinkedNode data = nodeStack.pop();
			if(temp.getValue() != data.getValue())
				return false;
			temp = temp.getNext();
		}
		return isPalindrom;
	}
	
	
}
