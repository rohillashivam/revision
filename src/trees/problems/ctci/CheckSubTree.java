package trees.problems.ctci;

import trees.node.TreeNode;

public class CheckSubTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(26, null, null);
		root.setLeft(new TreeNode(10, null, null));
		root.setRight(new TreeNode(3, null, null));
		root.getLeft().setLeft(new TreeNode(4, null, null));
		root.getLeft().getLeft().setRight(new TreeNode(30, null, null));
		root.getLeft().setRight(new TreeNode(6, null, null));
		root.getRight().setRight(new TreeNode(13, null, null));
		
		TreeNode subTreeRoot = new TreeNode(10, null, null);
		subTreeRoot.setLeft(new TreeNode(4, null, null));
		subTreeRoot.getLeft().setRight(new TreeNode(30, null, null));
		subTreeRoot.setRight(new TreeNode(6, null, null));
		
		boolean isSubTree = isSubTree(root, subTreeRoot);
		System.out.println(isSubTree);
		
		subTreeRoot = new TreeNode(10, null, null);
		subTreeRoot.setLeft(new TreeNode(4, null, null));
		subTreeRoot.getLeft().setRight(new TreeNode(300, null, null));
		subTreeRoot.setRight(new TreeNode(6, null, null));
		isSubTree = isSubTree(root, subTreeRoot);
		System.out.println(isSubTree);
	}

	private static boolean isSubTree(TreeNode node, TreeNode subTreeRoot) {
		if(node == null) 
			return false;
		
		if(node.getValue() == subTreeRoot.getValue())
			return isSameTree(node, subTreeRoot);
		
		boolean isLeftSubTree = isSubTree(node.getLeft(), subTreeRoot);
		boolean isRightSubTree = false;
		if(!isLeftSubTree)
			isRightSubTree = isSubTree(node.getRight(), subTreeRoot);
		
		return isLeftSubTree || isRightSubTree;
	}

	private static boolean isSameTree(TreeNode node, TreeNode subTreeRoot) {
		if(node == null && subTreeRoot == null)
			return true;
		if(node == null && subTreeRoot != null)
			return false;
		if(node != null && subTreeRoot == null)
			return false;
		
		if(node.getValue() == subTreeRoot.getValue()) {
			return isSameTree(node.getLeft(), subTreeRoot.getLeft()) 
					&& isSameTree(node.getRight(), subTreeRoot.getRight());
		}
		return false;
	}
}
