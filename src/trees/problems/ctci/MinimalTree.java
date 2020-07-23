package trees.problems.ctci;

import trees.node.TreeNode;

public class MinimalTree {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 6, 8,9,10};
		
		TreeNode root = createMinimalTree(arr, 0, arr.length -1);
		inorderTraversal(root);
	}

	private static void inorderTraversal(TreeNode root) {
		if(root == null)
			return;
		
		inorderTraversal(root.getLeft());
		System.out.println(root.getValue());
		inorderTraversal(root.getRight());
	}

	private static TreeNode createMinimalTree(int[] arr, int startIndex, int endIndex) {
		if(startIndex < 0 || endIndex > arr.length || (startIndex > endIndex))
			return null;
		int midIndex = (startIndex + endIndex) / 2;
		TreeNode node = new TreeNode(arr[midIndex], null, null);
		
		node.setLeft(createMinimalTree(arr, startIndex, midIndex - 1));
		node.setRight(createMinimalTree(arr, midIndex+1, endIndex));
		
		return node;
	}

}
