package trees.problems.ctci;

import trees.node.TreeNode;

public class CheckTreeIsBalanced {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, null, null);
		root.setLeft(new TreeNode(2, null, null));
		root.getLeft().setLeft(new TreeNode(3, null, null));
		root.setRight(new TreeNode(4, null, null));
		
		boolean treeBalanced = isTreeBalanced(root);
		System.out.println(treeBalanced);
		
		root = new TreeNode(1, null, null);
		root.setLeft(new TreeNode(2, null, null));
		root.getLeft().setLeft(new TreeNode(3, null, null));
		root.getLeft().getLeft().setRight(new TreeNode(4, null, null));
		root.setRight(new TreeNode(5, null, null));
		
		treeBalanced = isTreeBalanced(root);
		System.out.println(treeBalanced);
		System.out.println("-------------------[OPTIMIZED]-------------------");
		System.out.println(treeBalancedOptimized(root, new Height()));
	}

	private static boolean treeBalancedOptimized(TreeNode root, Height nodeHeight) {
		if(root == null) {
			nodeHeight.setHeight(0);
			return true;
		}
		
		Height leftHeight = new Height();
		Height rightHeight = new Height();
		
		boolean leftBalance = treeBalancedOptimized(root.getLeft(), leftHeight);
		boolean rightBalance = treeBalancedOptimized(root.getRight(), rightHeight);
		
		nodeHeight.setHeight(1 + Math.max(leftHeight.getHeight(), rightHeight.getHeight()));
		
		if(leftHeight.getHeight() - rightHeight.getHeight() > 1 || leftHeight.getHeight() - rightHeight.getHeight() < -1)
			return false;
		
		return leftBalance && rightBalance;
	}

	private static boolean isTreeBalanced(TreeNode root) {
		if(root == null)
			return true;
		
		int leftHeight = findHeight(root.getLeft());
		int rightHeight = findHeight(root.getRight());
		
		if(leftHeight - rightHeight > 1 || leftHeight - rightHeight < -1)
			return false;
		
		boolean leftBalance = isTreeBalanced(root.getLeft());
		boolean rightBalance = isTreeBalanced(root.getRight());
		
		return leftBalance && rightBalance;
	}

	private static int findHeight(TreeNode node) {
		if(node == null)
			return 0;
		
		return 1 + Math.max(findHeight(node.getLeft()), findHeight(node.getRight()));
	}
	
}

class Height{
	
	public Height() {
		super();
	}
	
	private int height;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}

