package trees.problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import trees.node.TreeNode;
/**
 * important for interview
 * @author shivam.rohilla
 *
 */
public class LevelOrderAndZigZagTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, null, null);
		root.setLeft(new TreeNode(2, null, null));
		root.setRight(new TreeNode(3, null, null));
		root.getLeft().setLeft(new TreeNode(4, null, null));
		root.getLeft().setRight(new TreeNode(5, null, null));
		root.getRight().setLeft(new TreeNode(6, null, null));
		root.getRight().setRight(new TreeNode(7, null, null));
		
		levelOrderTraversal(root);
		System.out.println("----------ZIGZAG--------");
		zigZagTraversal(root);
	}

	private static void zigZagTraversal(TreeNode root) {
		System.out.println("---------ZIGZAG WITH STACK-------");
		zigZagTraversalWithStack(root);
		System.out.println("-----------ZIGZAG WITH 2 STACK IN 1-------");
		zigzagWithTwoStack(root);
		System.out.println();
	}

	private static void zigzagWithTwoStack(TreeNode root) {
		if(root == null)
			return;
		
		Deque<TreeNode> nodeList = new LinkedList<>();
		nodeList.offerFirst(root);
		int count = 1;
		boolean flip = true;
		while(!nodeList.isEmpty()) {
			int currCount = 0;
			while(count > 0) {
				if(flip) {
					TreeNode node = nodeList.poll();
					System.out.println(node.getValue()+" ");
					if(node.getLeft() != null) {
						nodeList.offerLast(node.getLeft());
						currCount++;
					}
					if(node.getRight() != null) {
						nodeList.offerLast(node.getRight());
						currCount++;
					}
				} else {
					 TreeNode node = nodeList.pollLast();
					 System.out.println(node.getValue()+" ");
					 if(node.getRight() != null) {
						 nodeList.offerFirst(node.getRight());
						 currCount++;
					 }
					 if(node.getLeft() != null) {
						 nodeList.offerFirst(node.getLeft());
						 currCount++;
					 }
				}
				count--;
			}
			flip = !flip;
			count = currCount;
		}
	}

	private static void zigZagTraversalWithStack(TreeNode root) {
		Stack<TreeNode> nodeStack = new Stack<>();
		Stack<TreeNode> nodeStackNew = new Stack<>();
		nodeStack.add(root);
		boolean level = true;
		while(!nodeStack.isEmpty() || !nodeStackNew.isEmpty()) {
			if(!nodeStack.isEmpty() && level) {
				executeTraversal(nodeStack.pop(), nodeStackNew, level);
				if(nodeStack.isEmpty() && !nodeStackNew.isEmpty())
					level = false;
			}
			if(!nodeStackNew.isEmpty() && !level) {
				executeTraversal(nodeStackNew.pop(), nodeStack, level);
				if(nodeStackNew.isEmpty() && !nodeStack.isEmpty())
					level = true;
			}
		}
	}

	private static void executeTraversal(TreeNode node, Stack<TreeNode> nodeStackNew, boolean level) {
		if(node == null)
			return;
		System.out.println(node.getValue());
		if(!level) {
			nodeStackNew.push(node.getRight());
			nodeStackNew.push(node.getLeft());
		} else {
			nodeStackNew.push(node.getLeft());
			nodeStackNew.push(node.getRight());
		}
	}

	private static void levelOrderTraversal(TreeNode root) {
		// recursion traversal
		System.out.println("================RECURSIVE=============");
		recursiveLevelOrder(root);
		System.out.println("================QUEUE TRAVERSAL=======");
		queueLevelOrder(root);
	}

	private static void queueLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		queue.add(null);
		int level = 1;
		while(!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if(node == null && queue.isEmpty())
				break;
			if(node == null && !queue.isEmpty()) {
				queue.add(null);
				level++;
			} else {
				System.out.println("level :: "+level +" value :: "+node.getValue());
				if(node.getLeft() != null)
					queue.add(node.getLeft());
				if(node.getRight() != null)
					queue.add(node.getRight());
			} 
		}
	}

	private static void recursiveLevelOrder(TreeNode root) {
		if(root == null)
			return;
		int depth = depthOfTree(root, 0);
		
		for(int i=0; i<depth; i++) {
			recursiveLevelOrderTraversalUtils(root, i, 0);
		}
	}

	private static int depthOfTree(TreeNode root, int depth) {
		if(root == null)
			return depth;
		
		int leftDepth = depthOfTree(root.getLeft(), depth + 1);
		int rightDepth = depthOfTree(root.getRight(), depth + 1);
		
		int maxDepth = depth;
		if(leftDepth > maxDepth) maxDepth = leftDepth;
		if(rightDepth > maxDepth) maxDepth = rightDepth;
		
		return maxDepth;
	}

	private static void recursiveLevelOrderTraversalUtils(TreeNode root, int level, int currentDepth) {
		if(root == null)
			return;
		
		if(level == currentDepth) {
			System.out.println(root.getValue());
		}
		
		recursiveLevelOrderTraversalUtils(root.getLeft(), level, currentDepth + 1);
		recursiveLevelOrderTraversalUtils(root.getRight(), level, currentDepth + 1);
	}
}
