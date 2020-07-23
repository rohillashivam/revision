package trees.problems;

import trees.node.TreeNode;

public class DistanceBetweenNodesBT {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(7, null, null), 
				new TreeNode(6, new TreeNode(8, null, null), null)), 
				new TreeNode(2, new TreeNode(5, null, null), 
				new TreeNode(4, null, null)));
		System.out.println(findDistanceBetweenNode(root, 4, 5));
		reset();
		System.out.println(findDistanceBetweenNode(root, 4, 6));
		reset();
		System.out.println(findDistanceBetweenNode(root, 3, 4));
		reset();
		System.out.println(findDistanceBetweenNode(root, 2, 4));
		reset();
		System.out.println(findDistanceBetweenNode(root, 8, 5));
	}

	private static void reset() {
		num1Found = false;
		num2Found = false;
	}

	private static int findDistanceBetweenNode(TreeNode node, int num1, int num2) {
		if(node == null)
			return 0;
		TreeNode lcaNode = findLCA(node, num1, num2);
		if(num1Found && num2Found) {
			return findDistanceToNode(lcaNode, num1, 0) + findDistanceToNode(lcaNode, num2, 0);
		}
		return 0;
	}

	private static int findDistanceToNode(TreeNode node, int num, int level) {
		if(node == null)
			return -1;
		if(node.getValue() == num)
			return level;
		
		int leftDistance = findDistanceToNode(node.getLeft(), num, level+1);
		if(leftDistance  > 0)
			return leftDistance;
		int rightDistance = findDistanceToNode(node.getRight(), num, level+1);
		if(rightDistance > 0)
			return rightDistance;
		
		return 0;
	}

	private static boolean num1Found = false, num2Found = false;
	private static TreeNode findLCA(TreeNode node, int num1, int num2) {
		if(node == null)
			return null;
		
		TreeNode leftLCA= null;
		TreeNode rightLCA = null;
		TreeNode temp = null;
		
		if(node.getValue() == num1 || node.getValue() == num2) {
			if(!num1Found && num1 == node.getValue()) {
				num1Found = true;
				temp = node;
			}
			if(!num2Found && num2 == node.getValue()) {
				num2Found = true;
				temp = node;
			}
		}
		
		leftLCA = findLCA(node.getLeft(), num1, num2);
		rightLCA = findLCA(node.getRight(), num1, num2);
		
		if(temp != null)
			return temp;
		
		if(leftLCA != null && rightLCA != null)
			return node;
		
		return leftLCA != null ? leftLCA : rightLCA;
	}

}
