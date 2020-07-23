package trees.problems;

import trees.node.TreeNode;

// REDO imp can be asked in interview
public class LargestBSTinBT {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(50,
				new TreeNode(60, new TreeNode(70, new TreeNode(80, null, null), new TreeNode(65, null, null)),
						new TreeNode(45, null, null)),
				new TreeNode(30, new TreeNode(20, null, null), new TreeNode(5, null, null)));
		NodeInfo largestBSTInfo = largestBSTInBT(root);
		System.out.println("largest BST length :: "+ largestBSTInfo.sizeOfLargestBST);
	}

	private static NodeInfo largestBSTInBT(TreeNode root) {
		if(root == null)
			return new NodeInfo(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
		
		if(root.getLeft() == null && root.getRight() == null) {
			return new NodeInfo(true, 1, root.getValue(), root.getValue(), 1);
		}
		
		NodeInfo leftNodeInfo = largestBSTInBT(root.getLeft());
		NodeInfo rightNodeInfo = largestBSTInBT(root.getRight());
		
		int sizeOfLargestBST = 1 + leftNodeInfo.sizeOfLargestBST + rightNodeInfo.sizeOfLargestBST;
		
		if(leftNodeInfo != null && rightNodeInfo != null && leftNodeInfo.isBST && 
				rightNodeInfo.isBST && root.getValue() > leftNodeInfo.max && root.getValue() < rightNodeInfo.min) {
			
			NodeInfo nodeInfoObj = new NodeInfo(true, sizeOfLargestBST, Math.min(root.getValue(), 
					leftNodeInfo.min), Math.max(root.getValue(), rightNodeInfo.max), sizeOfLargestBST);
			return nodeInfoObj;
		}
		
		NodeInfo nodeInfoObj = new NodeInfo(false, sizeOfLargestBST, Integer.MIN_VALUE, Integer.MAX_VALUE, 
				Math.max(leftNodeInfo.sizeOfLargestBST, rightNodeInfo.sizeOfLargestBST));
		return nodeInfoObj;
	}

}

class NodeInfo {
	boolean isBST;
	int size;
	int min;
	int max;
	int sizeOfLargestBST;
	
	public NodeInfo(boolean isBST, int size, int min, int max, int sizeOfLargestBST) {
		super();
		this.isBST = isBST;
		this.size = size;
		this.min = min;
		this.max = max;
		this.sizeOfLargestBST = sizeOfLargestBST;
	}
	
}