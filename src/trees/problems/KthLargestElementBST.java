package trees.problems;

import trees.node.TreeNode;

public class KthLargestElementBST {
	
	private static int count = 0;
	private static boolean flag = false;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20, null, null);
		root.setLeft(new TreeNode(8,new TreeNode(12, null, null), new TreeNode(4, null, null)));
		root.getLeft().getRight().setLeft(new TreeNode(10, null, null));
		root.getLeft().getRight().setRight(new TreeNode(14, null, null));
		root.setRight(new TreeNode(22, null, null));
		
		findKLargestElement(root, 3);
		
	}

	private static void findKLargestElement(TreeNode root, int k) {
		if(root == null)
			return;
		
		if(!flag) {
			findKLargestElement(root.getRight(), k);
			count++;
			printkNode(root, k);
			findKLargestElement(root.getLeft(), k);
		}
	}

	private static void printkNode(TreeNode root, int k) {
		if(count == k) {
			System.out.println("Kth largest node for k : "+k+" -- "+root.getValue());
			flag = true;
		}
	}

}
