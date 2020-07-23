package trees.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import trees.node.TreeNode;

public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, null, null);
		root.setLeft(new TreeNode(2, null, null));
		root.setRight(new TreeNode(3, null, null));
		root.getLeft().setLeft(new TreeNode(4, null, null));
		root.getLeft().setRight(new TreeNode(5, null, null));
		root.getRight().setLeft(new TreeNode(6, null, null));
		root.getRight().setRight(new TreeNode(7, null, null));
		
		printReverseLevelOrder(root);
	}

	private static void printReverseLevelOrder(TreeNode root) {
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Stack<TreeNode> nodeStack = new Stack<>();
		
		nodeQueue.add(root);
		nodeQueue.add(null);
		
		while(!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();
			if(node == null) {
				if(nodeQueue.isEmpty())
					break;
				nodeQueue.add(node);
				nodeStack.push(node);
				continue;
			}
			nodeStack.add(node);
			
			if(node.getRight() != null)
				nodeQueue.add(node.getRight());
			
			if(node.getLeft() != null)
				nodeQueue.add(node.getLeft());
			
		}
		
		printNodeStack(nodeStack);
		
	}

	private static void printNodeStack(Stack<TreeNode> nodeStack) {
		while(!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			if(node == null) {
				System.out.println();
				continue;
			}
			System.out.print(node.getValue()+" ");
		}
	}
}
