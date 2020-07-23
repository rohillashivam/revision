package trees.node;

public class TreeNode {

	private int value;
	private TreeNode right;
	private TreeNode left;

	public TreeNode(int value, TreeNode right, TreeNode left) {
		super();
		this.value = value;
		this.right = right;
		this.left = left;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	
}
