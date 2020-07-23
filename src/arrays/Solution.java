package arrays;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		//Integer[] arr = {5, 6, 3, 1, 2, 4};
		//List<Integer> dataList = Stream.of(arr).collect(Collectors.toList());
		//System.out.println(s.bstDistance(6, dataList, 2, 4));
		Integer[] arr = {9, 7, 5, 3, 1};
		List<Integer> dataList = Stream.of(arr).collect(Collectors.toList());
		System.out.println(s.bstDistance(5, dataList, 7, 20));
	}
	public int bstDistance(int num, List<Integer> values, int node1, int node2) {
// WRITE YOUR CODE HERE
		TreeNode root = buildBST(values);
		return findDistance(root, node1, node2);
//if(distance == 0)
//   return -1;
	}

	private int findDistance(TreeNode root, int num1, int num2) {
		int temp = 0;
		if (num1 > num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}

		return findDistanceBetweenNodes(root, num1, num2);
	}

	private int findDistanceFromRoot(TreeNode root, int num) {
		if(root == null)
			return -1;
		if (root.val == num) {
			return 0;
		} else if (root.val > num) {
			int leftDis = findDistanceFromRoot(root.left, num);
			if(leftDis == -1)
				return -1;
			else
				return 1 + leftDis;
		}

		int rightDis = findDistanceFromRoot(root.right, num);
		if(rightDis == -1)
			return -1;
		else
			return 1 + rightDis;
	}

	private int findDistanceBetweenNodes(TreeNode root, int num1, int num2) {
		if (root == null)
			return -1;

		if (root.val > num1 && root.val > num2)
			return findDistanceBetweenNodes(root.left, num1, num2);

		if (root.val < num1 && root.val < num2)
			return findDistanceBetweenNodes(root.right, num1, num2);

		if (root.val >= num1 && root.val <= num2) {
			int leftDis = findDistanceFromRoot(root, num1);
			if(leftDis == -1)
				return -1;
			int rightDis = findDistanceFromRoot(root, num2);
			if(rightDis == -1)
				return -1;
			return leftDis+rightDis;
		}

		return 0;
	}

	private TreeNode buildBST(List<Integer> values) {
		TreeNode root = null;
		for (Integer val : values) {
			root = insertNode(root, val);
		}
		return root;
	}

	private TreeNode insertNode(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
		} else if (root.val > val) {
			root.left = insertNode(root.left, val);
		} else if (root.val < val) {
			root.right = insertNode(root.right, val);
		}

		return root;
	}
// METHOD SIGNATURE ENDS
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
}
