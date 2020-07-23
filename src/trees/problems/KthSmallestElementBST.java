package trees.problems;

import trees.node.TreeNode;

// TODO
public class KthSmallestElementBST {

	private static int count=0;
	private static boolean flag = false;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20, null, null);
		root.setLeft(new TreeNode(8,new TreeNode(12, null, null), new TreeNode(4, null, null)));
		root.getLeft().getRight().setLeft(new TreeNode(10, null, null));
		root.getLeft().getRight().setRight(new TreeNode(14, null, null));
		root.setRight(new TreeNode(22, null, null));
		
		findKSmallestElement(root, 3);
		count=0; flag =false;
		findKSmallestElement(root, 4);
		count=0;flag =false;
		findKSmallestElement(root, 5);
		count=0;flag =false;
		findKSmallestElement(root, 6);
		count=0;flag =false;
		findKSmallestElement(root, 7);
		count=0;flag =false;
		
		
		root = new TreeNode(7, null, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(1, null, null)));
		System.out.println(kthsmallest(root, 2));
	}
	
	public static int kthsmallest(TreeNode node, int k) {
        if(node == null)
            return Integer.MIN_VALUE;

        int data = kthsmallest(node.getLeft(), k);
        if(data != Integer.MIN_VALUE) {
        	flag = true;
        	return data;
        }
        if(!flag) {
            count++;
            if(isKthElement(node, k))
                return node.getValue();
            return kthsmallest(node.getRight(), k);
        }
        return Integer.MIN_VALUE;
    }
    
    private static boolean isKthElement(TreeNode node, int k) {
        if(!flag && k == count) {
            flag = true;
            return true;
        }
        return false;
    }

	private static void findKSmallestElement(TreeNode root, int k) {
		if(root == null)
			return;
		
		findKSmallestElement(root.getLeft(), k);
		if(!flag) {
			count++;
			printKthNode(root, k);
			findKSmallestElement(root.getRight(), k);
		}
	}
	private static void printKthNode(TreeNode root, int k) {
		if(!flag && count == k) {
			System.out.println("kth smallest element found for "+k+" : "+root.getValue());
			flag = true;
		}
	}
	
	
}
