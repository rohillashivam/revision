package trees.problems;

import trees.node.TreeNode;

public class DistanceBetweenNodesBST {
	
	public static void main(String[] args) {
		int[] arr = {5, 2, 12, 1, 3, 9, 21, -1, -1, 19, 25};
		TreeNode root = buildTree(arr);
		System.out.println(findDistanceBetweenTwoNode(root, 3, 9));
		
	}

	private static int findDistanceBetweenTwoNode(TreeNode root, int num1, int num2) {
		if(root == null)
			return -1;
		
		if(num1 > root.getValue() && num2 > root.getValue())
			return findDistanceBetweenTwoNode(root.getRight(), num1, num2);
		
		if(num1 < root.getValue() && num2 < root.getValue())
			return findDistanceBetweenTwoNode(root.getLeft(), num1, num2);
		
		if(num1 <= root.getValue() && num2 >= root.getValue()) {
			return findDistanceFromRoot(root.getLeft(), num1, 0) + findDistanceFromRoot(root.getRight(), num2, 0);
		}
		return 0;
	}

	private static int findDistanceFromRoot(TreeNode root, int num, int level) {
		if(root == null)
			return level;
		if(root.getValue() > num)
			return findDistanceFromRoot(root.getLeft(), num, level+1);
		
		return findDistanceFromRoot(root.getRight(), num, level+1);
	}

	private static TreeNode buildTree(int[] arr) {
		TreeNode root = null;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == -1)
				continue;
			root = insert(root, arr[i]);
		}
		return root;
	}

	private static TreeNode insert(TreeNode root, int data) {
		if(root == null) {
			return new TreeNode(data, null, null);
		}
		if(root.getValue() > data ) {
			if(root.getLeft() == null)
				root.setLeft(new TreeNode(data, null, null));
			else
				root.setLeft(insert(root.getLeft(), data));
		} else {
			if(root.getRight() == null)
				root.setRight(new TreeNode(data, null, null));
			else
				root.setRight(insert(root.getRight(), data));
		} 
		return root;
	}

}
