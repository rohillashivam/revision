package trees.problems;

import trees.node.TreeNode;

public class BinaryTreeIntoDLL {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10, new TreeNode(15, null, new TreeNode(36, null, null)), 
				new TreeNode(12, new TreeNode(30, null, null), new TreeNode(25, null, null)));
		
		convertBinaryTreeToDLL(root);
		printListForward();
	}

	private static void printListForward() {
		DLLNode node = head;
		while(node != null) {
			System.out.print(node.getVal()+" ");
			node = node.getNext();
			if(node.getNext() == null) {
				System.out.print(node.getVal()+" ");
				break;
			}
		}
		System.out.println();
		printListBackward(node);
	}

	private static void printListBackward(DLLNode node) {
		while(node != null) {
			System.out.print(node.getVal()+" ");
			node = node.getPrev();
		}
	}

	private static DLLNode head, currNode;
	private static void convertBinaryTreeToDLL(TreeNode root) {
		if(root.getLeft() != null) {
			convertBinaryTreeToDLL(root.getLeft());
		}
		buildNode(root);
		if(root.getRight() != null) {
			convertBinaryTreeToDLL(root.getRight());
		}
	}
	private static void buildNode(TreeNode root) {
		DLLNode node = new DLLNode(root.getValue(), null, null);
		if(head == null) {
			head = node;
			currNode = head;
		} else {
			currNode.setNext(node);
			node.setPrev(currNode);
			currNode = node;
		}
	}
}

class DLLNode {
	
	private int val;
	private DLLNode next;
	private DLLNode prev;

	public DLLNode(int val, DLLNode next, DLLNode prev) {
		super();
		this.val = val;
		this.next = next;
		this.prev = prev;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public DLLNode getPrev() {
		return prev;
	}

	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}
	
}
