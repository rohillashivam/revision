package dp;

import java.util.ArrayList;
import java.util.List;

// TODO incomplete
public class PalindromPartition {

	public static void main(String[] args) {
		String str = "aabaa";
		// a a b a a b c
		// aa|b|aa|b|c
		// a|aba|a|b|c
		// aa|baab|c
		// aabaa|bc
		List<List<String>> strList = palindromPartition(str);
		System.out.println("");
	}

	private static List<List<String>> palindromPartition(String str) {
		if(str.isEmpty())
			return new ArrayList<>();
		List<List<String>> palinListAll = new ArrayList<>();
		palindromPartitionUtils(str, palinListAll);
		return palinListAll;
	}

	

	private static void palindromPartitionUtils(String str, List<List<String>> palinListAll) {
		if(str.isEmpty()) {
			List<String> strList = new ArrayList<>();
			palinListAll.add(strList);
			return;
		}
		List<String> subStrList = null;
		for(int i=1; i<=str.length(); i++) {
			String subStr = str.substring(0, i);
			if(isPalindrom(subStr)) {
				palindromPartitionUtils(str.substring(i), palinListAll);
				subStrList = palinListAll.get(palinListAll.size()-1);
				subStrList.add(subStr);
			}
		}
		//palinListAll.add(subStrList);
	}

	private static boolean isPalindrom(String subStr) {
		for(int i=0, j=subStr.length()-1; i<j; i++,j--) {
			if(subStr.charAt(i) != subStr.charAt(j))
				return false;
		}
		return true;
	}
}
