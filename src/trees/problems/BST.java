package trees.problems;

import trees.node.TreeNode;

public class BST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4, null, null);
		root.setLeft(new TreeNode(2, null, null));
		root.setRight(new TreeNode(5, null, null));
		root.getLeft().setLeft(new TreeNode(1, null, null));
		root.getLeft().setRight(new TreeNode(3, null, null));
		
		System.out.println(isBST(root));
		System.out.println("-------------");
		root = new TreeNode(3, null, null);
		root.setLeft(new TreeNode(2, null, null));
		root.setRight(new TreeNode(5, null, null));
		root.getLeft().setLeft(new TreeNode(1, null, null));
		root.getLeft().setRight(new TreeNode(4, null, null));
		System.out.println(isBST(root));
		
		
		root = new TreeNode(44, null, null);
		root.setLeft(new TreeNode(17, null, null));
		root.getLeft().setRight(new TreeNode(32, null, null));
		root.getLeft().getRight().setLeft(new TreeNode(28, null, null));
		root.getLeft().getRight().getLeft().setRight(new TreeNode(29, null, null));
		System.out.println("=============delete a node =========");
		root = deleteNode(root, 32);
		System.out.println("-----------preorder traversal------");
		preOrderTraversal(root);
	}

	private static void preOrderTraversal(TreeNode root) {
		if(root == null)
			return;

		System.out.println(root.getValue());
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());
	}

	private static TreeNode deleteNode(TreeNode node, int value) {
		if(node == null)
			return node;
		
		if(node.getValue() > value)
			node.setLeft(deleteNode(node.getLeft(), value));
		else if (node.getValue() < value)
			node.setRight(deleteNode(node.getRight(), value));
		else {
			if(node.getLeft() == null)
				return node.getRight();
			else if(node.getRight() == null)
				return node.getLeft();
			
			int minVal = getMinimum(node.getRight());
			node.setValue(minVal);
			
			node.setRight(deleteNode(node.getRight(), value));
		}
		
		return node;
	}

	private static int getMinimum(TreeNode node) {
		int minVal = node.getValue();
		while(node != null) {
			node = node.getLeft();
			minVal = node.getValue();
		}
		return minVal;
	}

	private static boolean isBST(TreeNode root) {
		if(root == null)
			return true;
		
		return isBSTUtils(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBSTUtils(TreeNode node, int minValue, int maxValue) {
		if(node == null)
			return true;
		
		if(node.getValue() < minValue || node.getValue() > maxValue)
			return false;
		
		return isBSTUtils(node.getLeft(), minValue, node.getValue()) && 
				isBSTUtils(node.getRight(), node.getValue(), maxValue);
	}

}
