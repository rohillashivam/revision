package trees.problems.ctci;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import trees.node.TreeNode;

public class TreeToLLOfEveryDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, null, null);
		root.setLeft(new TreeNode(2, null, null));
		root.setRight(new TreeNode(3, null, null));
		root.getLeft().setLeft(new TreeNode(4, null, null));
		root.getLeft().setRight(new TreeNode(5, null, null));
		root.getRight().setLeft(new TreeNode(6, null, null));
		root.getRight().setRight(new TreeNode(7, null, null));
		
		Map<Integer, LinkedList<Integer>> depthListMap = getDepthList(root);
		printList(depthListMap);
	}

	private static void printList(Map<Integer, LinkedList<Integer>> depthListMap) {
		for(Integer depth: depthListMap.keySet()) {
			LinkedList<Integer> list = depthListMap.get(depth);
			list.forEach(val -> System.out.print(val+" "));
			System.out.println();
		}
	}

	private static Map<Integer, LinkedList<Integer>> getDepthList(TreeNode root) {
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		nodeQueue.add(null);
		
		Map<Integer, LinkedList<Integer>> depthListMap = new HashMap<>();
		int depth = 0;
		LinkedList<Integer> list = new LinkedList<>();
		
		while(!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();
			if(node != null) {
				list.add(node.getValue());
			} else if(node == null && nodeQueue.isEmpty()) {
				if(list != null && list.size() > 0)
					depthListMap.put(depth, list);
				break;
			} else {
				depthListMap.put(depth, list);
				list = new LinkedList<>();
				depth++;
				nodeQueue.add(null);
				continue;
			}
			
			if(node.getLeft() != null)
				nodeQueue.add(node.getLeft());
			if(node.getRight() != null)
				nodeQueue.add(node.getRight());
			
		}
		
		return depthListMap;
	}
}
