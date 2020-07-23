package trees.problems.trie;

import java.util.ArrayList;
import java.util.List;

import trees.node.TrieNode;

public class CommonPrefix {

	public static void main(String[] args) {
		String[] strList = {"geeksforgeeks", "geeks", "geek", "geezer"};
		TrieNode root = buildTrie(strList);
		System.out.println(findCommonPrefix(root));
		System.out.println("----------------------------");
		printAllWords(root);
	}

	private static void printAllWords(TrieNode root) {
		if(root == null)
			return;
		
		List<String> words = printAllWordsUtils(root, "");
		for (String word : words) {
			System.out.println(word);
		}
	}

	private static List<String> printAllWordsUtils(TrieNode root, String str) {
		List<String> listStr = new ArrayList<>();
		if(root == null)
			return listStr;
		if(root.isEndOfWordLeaf()) {
			listStr.add(str);
		}
		int size = 0;
		for(int i=0; i<root.getChildren().length; i++) {
			if(root.getChildren()[i] != null)
				size++;
		}
		if(size == 0)
			return listStr; 
		
		for(int i=0; i<root.getChildren().length; i++) {
			if(root.getChildren()[i] == null) {
				continue;
			}
			listStr.addAll(printAllWordsUtils(root.getChildren()[i], str+root.getChildren()[i].getCh()));
		}
		return listStr;
	}

	private static String findCommonPrefix(TrieNode root) {
		if(root == null)
			return "";
		TrieNode node = root;
		StringBuilder sb = new StringBuilder();
		while(node != null && node.getChildren() != null) {
			
			TrieNode[] children = node.getChildren();
			int index=0, firstIndex=-1, count=0;
			while(index < children.length) {
				if(children[index] != null) {
					firstIndex = index;
					count++;
					if(count > 1) {
						sb.append(node.getCh());
						return sb.toString();
					}
				}
				index++;
			}
			if(node != root)
				sb.append(node.getCh());
			node = children[firstIndex];
		}
		return sb.toString();
	}

	private static TrieNode buildTrie(String[] strList) {
		TrieNode root = new TrieNode();
		for(String str : strList) {
			TrieNode temp = root;
			for(int i=0; i<str.length(); i++) {
				TrieNode node = new TrieNode();
				node.setCh(str.charAt(i));
				TrieNode[] children = temp.getChildren();
				if(children[str.charAt(i) - 'a'] != null) {
					temp = children[str.charAt(i) - 'a'];
					continue;
				}
				children[str.charAt(i) - 'a'] = node;
				temp = node;
			}
			temp.setEndOfWordLeaf(true);
		}
		
		return root;
	}
}
