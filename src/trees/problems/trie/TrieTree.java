package trees.problems.trie;

import trees.node.TrieNode;

public class TrieTree {

	private TrieNode root = new TrieNode();

	public static void main(String[] args) {
		TrieTree tree = new TrieTree();
		tree.insert("Shivam");
		tree.insert("shubham");
		boolean testFound = tree.searchWord("test");
		boolean shivamFound = tree.searchWord("shivam");
		System.out.println("test :: " + testFound + " shivam :: " + shivamFound);
	}

	private void insert(String word) {
		if (word == null || word.isEmpty())
			return;

		String data = (new String(word)).toLowerCase();
		TrieNode temp = root;
		for (int i = 0; i < data.length(); i++) {

			if (data.charAt(i) == 'i')
				System.out.println("");
			TrieNode[] children = temp.getChildren();
			int index = data.charAt(i) - 'a';
			TrieNode node = null;
			if (children[index] != null)
				node = children[index];
			else {
				node = new TrieNode();
				node.setCh(data.charAt(i));
			}
			children[index] = node;
			temp = node;
		}
		temp.setEndOfWordLeaf(true);
	}

	private boolean searchWord(String word) {
		if (root == null || word == null || word.isEmpty())
			return false;

		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode[] children = node.getChildren();
			int index = word.charAt(i) - 'a';
			if (children[index] == null)
				return false;
			node = children[index];
		}
		if (node != null && node.isEndOfWordLeaf())
			return true;

		return false;
	}
}
