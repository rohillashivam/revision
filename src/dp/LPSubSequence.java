package dp;

import java.util.HashMap;
import java.util.Map;

public class LPSubSequence {

	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";
		int count = findLongestPalindromSequence(str, 0, str.length()-1);
		System.out.println("max length :: "+count);
		System.out.println("---------------------------------------------");
		count = findLongestPalindromSequenceMemo(str, 0, str.length() - 1);
		System.out.println("max length :: "+count);
		System.out.println("------------------------------------------");
		count = findLongestPalindromSequenceOpt(str);
	}

	private static int findLongestPalindromSequenceOpt(String str) {
		if(str.length() == 1)
			return 1;
		int[][] table = new int[str.length()+1][str.length()+1];
		
		int maxLength = 1;
		for(int i=0; i<str.length(); i++)
			table[i][i] = 1;
		
		for(int i=0; i<str.length(); i++) {
			for(int j=str.length()-1; j>=0; j--) {
				if(i == j)
					continue;
				
				if(i+1 == j && str.charAt(i) == str.charAt(j)) {
					table[i][j]=2;
					maxLength = Math.max(maxLength, table[i][j]);
				}
				
				if(str.charAt(i) == str.charAt(j)) {
					table[i][j] = 2+table[i+1][j-1];
					maxLength = Math.max(maxLength, table[i][j]);
				}
				
				table[i][j] = Math.max(table[i][j+1], table[i-1][j]);
			}
		}
		
		return maxLength;
	}

	private static Map<String, Integer> cache = new HashMap<>();
	
	private static int findLongestPalindromSequenceMemo(String str, int startIndex, int endIndex) {
		if(startIndex == endIndex)
			return 1;
		
		if(startIndex+1 == endIndex && str.charAt(startIndex) == str.charAt(endIndex))
			return 2;
		
		if(str.charAt(startIndex) == str.charAt(endIndex)) {
			if(!cache.containsKey((startIndex+1)+"|"+(endIndex-1))) {
				int val = 2 + findLongestPalindromSequenceMemo(str, startIndex+1, endIndex-1);
				cache.put((startIndex+1)+"|"+(endIndex-1), (val-2));
			}else {
				return 2 + cache.get((startIndex+1)+"|"+(endIndex-1));
			}
		}
		
		int moveStartAhead = 0;
		if(cache.containsKey((startIndex+1)+"|"+(endIndex)))
			moveStartAhead = cache.get((startIndex+1)+"|"+(endIndex));
		else
			moveStartAhead = findLongestPalindromSequenceMemo(str, startIndex+1, endIndex);
		
		int moveEndBehind = 0;
		if(cache.containsKey((startIndex)+"|"+(endIndex-1)))
			moveEndBehind = cache.get((startIndex)+"|"+(endIndex-1));
		else
			moveEndBehind = findLongestPalindromSequenceMemo(str, startIndex, endIndex-1);
		
		return Math.max(moveStartAhead, moveEndBehind);
	}

	private static int findLongestPalindromSequence(String str, int startIndex, int endIndex) {
		if(endIndex == startIndex)
			return 1;
		
		if(endIndex == startIndex+1 && str.charAt(startIndex) == str.charAt(endIndex))
			return 2;
		
		if(str.charAt(startIndex) == str.charAt(endIndex))
			return 2 + findLongestPalindromSequence(str, startIndex+1, endIndex-1);
		
		return Math.max(findLongestPalindromSequence(str, startIndex+1, endIndex) , 
				findLongestPalindromSequence(str, startIndex, endIndex-1));
	}

}
