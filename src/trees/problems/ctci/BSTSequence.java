package trees.problems.ctci;

import java.util.ArrayList;
import java.util.List;

import trees.node.TreeNode;

public class BSTSequence {

	public static void main(String[] args) {
	
		TreeNode root = new TreeNode(5, null, null);
		root.setLeft(new TreeNode(2, null, null));
		root.setRight(new TreeNode(8, null, null));
		root.getLeft().setLeft(new TreeNode(1, null, null));
		root.getLeft().setRight(new TreeNode(3, null, null));
		root.getRight().setLeft(new TreeNode(6, null, null));
		root.getRight().getLeft().setRight(new TreeNode(7, null, null));
		root.getRight().setRight(new TreeNode(9, null, null));
		
		List<List<TreeNode>> bstSequenceList = bstSequence(root);
		printBSTSequence(bstSequenceList);
	}

	private static void printBSTSequence(List<List<TreeNode>> bstSequenceList) {
		if(bstSequenceList == null || bstSequenceList.isEmpty())
			return;
		
		for (List<TreeNode> list : bstSequenceList) {
			if(list == null || list.isEmpty())
				continue;
			
			for(int i= list.size() - 1; i >=0 ; i--) {
				System.out.print(list.get(i).getValue()+" ");
			}
			System.out.println();
		}
	}

	private static List<List<TreeNode>> bstSequence(TreeNode root) {
		if(root == null)
			return null;
		
		List<List<TreeNode>> finalList = new ArrayList<>();
		
		List<List<TreeNode>> leftSequenceList = bstSequence(root.getLeft());
		List<List<TreeNode>> rightSequenceList = bstSequence(root.getRight());
		
		finalList = shuffleLeftAndRightList(leftSequenceList, rightSequenceList);
		
		appendNodeOnly(finalList, root);
		
		return finalList;
	}

	private static List<List<TreeNode>> shuffleLeftAndRightList(List<List<TreeNode>> leftSequenceList,
			List<List<TreeNode>> rightSequenceList) {
		List<List<TreeNode>> finalNodeList = new ArrayList<>();
		
		if((leftSequenceList == null || leftSequenceList.isEmpty())
				&& (rightSequenceList == null || rightSequenceList.isEmpty()))
			return finalNodeList;
		
		if((leftSequenceList != null && !leftSequenceList.isEmpty())
				&& (rightSequenceList == null || rightSequenceList.isEmpty()))
			return leftSequenceList;
		
		if((rightSequenceList != null && !rightSequenceList.isEmpty())
				&& (leftSequenceList == null || leftSequenceList.isEmpty()))
			return rightSequenceList;
		
		for (List<TreeNode> leftList : leftSequenceList) {
			for(List<TreeNode> rightList : rightSequenceList) {
				
				List<TreeNode> leftListArr = new ArrayList<>(leftList);
				leftListArr.addAll(rightList);
				List<TreeNode> rightListArr = new ArrayList<>(rightList);
				rightListArr.addAll(leftList);
				
				finalNodeList.add(leftListArr);
				finalNodeList.add(rightListArr);
			}
		}
		
		return finalNodeList;
	}

	private static List<List<TreeNode>> appendNodeOnly(List<List<TreeNode>> finalList, TreeNode node) {
		
		if(finalList == null || finalList.isEmpty()) {
			List<TreeNode> nodeList = new ArrayList<>();
			nodeList.add(node);
			finalList.add(nodeList);
			return finalList;
		}
		
		for (List<TreeNode> list : finalList) {
			list.add(node);
		}
		return finalList;
	}

}
