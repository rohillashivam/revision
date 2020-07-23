package trees.node;

public class TrieNode {
	
	private static final Integer ALPHABET_SIZE = 26;
	private Character ch;
	private boolean isEndOfWordLeaf;
	private TrieNode[] children = new TrieNode[ALPHABET_SIZE];

	public Character getCh() {
		return ch;
	}

	public void setCh(Character ch) {
		this.ch = ch;
	}

	public TrieNode[] getChildren() {
		return children;
	}

	public void setChildren(TrieNode[] children) {
		this.children = children;
	}

	public boolean isEndOfWordLeaf() {
		return isEndOfWordLeaf;
	}

	public void setEndOfWordLeaf(boolean isEndOfWordLeaf) {
		this.isEndOfWordLeaf = isEndOfWordLeaf;
	}
}
