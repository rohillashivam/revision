package trees.problems;

import java.util.Map;
import java.util.TreeMap;

import trees.node.TreeNode;

public class TreeViews {

	private static Map<Integer, TreeNode> treeNodeMap = new TreeMap<>();
	
	public static void printTopView(TreeNode root) {
		traverseTopView(root, 0);
		printMap();
	}
	
	private static void printLeftView(TreeNode root) {
		traverseLeftView(root, 0);
		printMap();
	}
	
	private static void traverseLeftView(TreeNode node, int level) {
		if(node == null)
			return;
		
		if(!treeNodeMap.containsKey(level))
			treeNodeMap.put(level, node);
		
		traverseLeftView(node.getLeft(), level + 1);
		traverseLeftView(node.getRight(), level + 1);
	}

	private static void printRightView(TreeNode root) {
		traverseRightView(root, 0);
		printMap();
	}
	
	private static void traverseRightView(TreeNode node, int level) {
		if(node == null)
			return;
		
		if(treeNodeMap.containsKey(level))
			treeNodeMap.remove(level);
		
		treeNodeMap.put(level, node);
		traverseRightView(node.getLeft(), level+1);
		traverseRightView(node.getRight(), level+1);
	}

	private static void printBottomView(TreeNode root) {
		traverseBottomView(root, 0);
		printMap();
	}
	
	private static void traverseBottomView(TreeNode node, int level) {
		if(node == null)
			return;
		
		if(treeNodeMap.containsKey(level))
			treeNodeMap.remove(level);
		treeNodeMap.put(level, node);
		
		traverseBottomView(node.getLeft(), level - 1);
		traverseBottomView(node.getRight(), level + 1);
	}

	private static void printMap() {
		if(treeNodeMap.size() == 0)
			return;
		
		for (Integer level : treeNodeMap.keySet()) {
			System.out.println(treeNodeMap.get(level).getValue());
		}
		
		treeNodeMap.clear();
	}

	private static void traverseTopView(TreeNode node, int level) {
		if(node == null)
			return;
		if(!treeNodeMap.containsKey(level))
			treeNodeMap.put(level, node);
		
		traverseTopView(node.getLeft(), level - 1);
		traverseTopView(node.getRight(), level + 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4, null, null);
		root.setLeft(new TreeNode(5, null, null));
		root.setRight(new TreeNode(2, null, null));
		root.getRight().setLeft(new TreeNode(3, null, null));
		root.getRight().setRight(new TreeNode(1, null, null));
		root.getRight().getLeft().setLeft(new TreeNode(6, null, null));
		root.getRight().getLeft().setRight(new TreeNode(7, null, null));
		System.out.println("----------TOP VIEW---------");
		printTopView(root);
		System.out.println();
		System.out.println("----------LEFT VIEW--------");
		printLeftView(root);
		System.out.println();
		System.out.println("----------RIGHT VIEW--------");
		printRightView(root);
		System.out.println();
		System.out.println("----------BOTTOM VIEW--------");
		printBottomView(root);
		System.out.println("----------RIGHT DAIGONAL VIEW--------");
		printRightDaigonalView(root);
	}

	private static void printRightDaigonalView(TreeNode root) {
		traverseRightDaigonalView(root, 0);
		printMap();
	}

	private static void traverseRightDaigonalView(TreeNode node, int level) {
		if(node == null)
			return;
		
		if(treeNodeMap.containsKey(level))
			treeNodeMap.remove(level);
		
		treeNodeMap.put(level, node);
		
		traverseRightDaigonalView(node.getLeft(), level + 1);
		traverseRightDaigonalView(node.getRight(), level );
	}

}
