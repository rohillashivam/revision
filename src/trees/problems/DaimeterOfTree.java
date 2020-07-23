package trees.problems;

import trees.node.TreeNode;

public class DaimeterOfTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0, null, null);
		root.setRight(new TreeNode(1, null, null));
		root.setLeft(new TreeNode(2, null, null));
		root.getLeft().setRight(new TreeNode(3, null, null));
		root.getLeft().getRight().setRight(new TreeNode(4, null, null));
		root.getLeft().getRight().getRight().setRight(new TreeNode(5, null, null));
		root.getLeft().getRight().getRight().setLeft(new TreeNode(7, null, null));
		root.getLeft().getRight().getRight().getRight().setLeft(new TreeNode(6, null, null));
		root.getLeft().setLeft(new TreeNode(8, null, null));
		root.getLeft().getLeft().setRight(new TreeNode(9, null, null));
		root.getLeft().getLeft().getRight().setLeft(new TreeNode(10, null, null));
		root.getLeft().getLeft().getRight().getLeft().setRight(new TreeNode(11, null, null));
		root.getLeft().getLeft().setLeft(new TreeNode(12, null, null));
		
		int daimeter = daimeterOfTree(root);
		System.out.println(daimeter);
	}

	private static int daimeterOfTree(TreeNode node) {
		if(node == null)
			return 0;
		
		int leftHeight = findHeight(node.getLeft());
		int rightHeight = findHeight(node.getRight());
		
		int leftDaimeter = daimeterOfTree(node.getLeft());
		int rightDaimeter = daimeterOfTree(node.getRight());
		return Math.max(leftHeight + rightHeight + 1 , Math.max( leftDaimeter, rightDaimeter)); 
	}

	private static int findHeight(TreeNode node) {
		if(node == null)
			return 0;
		
		return 1 + Math.max(findHeight(node.getLeft()), findHeight(node.getRight()));
	}
}
