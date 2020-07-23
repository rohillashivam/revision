package trees.problems;

import trees.node.TreeNode;

public class LCA {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, null, null);
		root.setLeft(new TreeNode(2, null, null));
		root.setRight(new TreeNode(3, null, null));
		root.getLeft().setLeft(new TreeNode(4, null, null));
		root.getLeft().setRight(new TreeNode(5, null, null));
		root.getRight().setLeft(new TreeNode(6, null, null));
		root.getRight().setRight(new TreeNode(7, null, null));
		
		System.out.println("LCA(4, 5): " + findLCA(root, 4,5).getValue()); 
        System.out.println("LCA(4, 6): " + findLCA(root, 4,6).getValue()); 
        System.out.println("LCA(3, 4): " + findLCA(root, 3,4).getValue()); 
        System.out.println("LCA(2, 4): " + findLCA(root, 2,4).getValue()); 
        
        System.out.println("LCA(2, 10) : " + findLCANew(root, 2, 10));
        System.out.println("LCA(2, 4) : " + findLCANew(root, 2, 10));
	}

	private static boolean v1 = false, v2 = false;
	private static TreeNode findLCANew(TreeNode root, int val1, int val2) {
		v1=false; v2=false;
		TreeNode lcaNode = lcaUtils(root, val1, val2);
		
		if(v1 && v2)
			return lcaNode;
		
		return null;
	}

	private static TreeNode lcaUtils(TreeNode root, int val1, int val2) {
		if(root == null)
			return null;
		
		TreeNode temp =null;
		
		if(val1 == root.getValue()) {
			v1 = true;
			temp = root;
		}
		
		if(val2 == root.getValue()) {
			v2 = true;
			temp = root;
		}
		
		TreeNode leftLCA = lcaUtils(root.getLeft(), val1, val2);
		TreeNode rightLCA = lcaUtils(root.getRight(), val1, val2);
		
		if(temp != null)
			return temp;
		
		if(leftLCA != null && rightLCA != null)
			return root;
			
		return leftLCA != null ? leftLCA : rightLCA;
	}

	private static TreeNode findLCA(TreeNode root, int num1, int num2) {
		if(root == null)
			return null;
		
		if(root.getValue() == num1 || root.getValue() == num2)
			return root;
		
		TreeNode leftLCA = findLCA(root.getLeft(), num1, num2);
		TreeNode rightLCA = findLCA(root.getRight(), num1, num2);
		
		if(leftLCA != null && rightLCA != null)
			return root;
		
		return leftLCA != null ? leftLCA : rightLCA;
	}
}
