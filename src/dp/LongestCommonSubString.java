package dp;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubString {

	private Map<String, Integer> cache = new HashMap<>();
	private int[][] dp = null;
	
	public static void main(String[] args) {
		String str1 = "zxabcdezy", str2 = "yzabcdezx";
		LongestCommonSubString longestCommonSubtring = new LongestCommonSubString();
		System.out.println(longestCommonSubtring.findLCS(str1, str2, 0, 0));
		System.out.println("----------------------------------");
		System.out.println(longestCommonSubtring.findLCSMemo(str1, str2, 0, 0));
		System.out.println("----------------------------------");
		System.out.println(longestCommonSubtring.findLCSTabulation(str1, str2, 0, 0));
	}

	private int findLCSTabulation(String str1, String str2, int str1Index, int str2Index) {
		if(str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty())
			return 0;
		
		dp = new int[str1.length()+1][str2.length()+1];
		for(int i=1; i<str1.length(); i++) {
			for(int j=1; j<str2.length(); j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					int val = 1 + subStringSize(str1, str2, i, j);
					dp[i][j] = val;
				} else 
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		int max = -1;
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				if(max < dp[i][j])
					max = dp[i][j];
			}
		}
		return max;
	}

	private int findLCSMemo(String str1, String str2, int str1Index, int str2Index) {
		if(str1Index == str1.length() || str2Index == str2.length())
			return 0;
		
		if(str1.charAt(str1Index) == str2.charAt(str2Index))
			return 1 + subStringSize(str1, str2, str1Index+1, str2Index+1);
		
		int str1Extend = 0;
		if(cache.containsKey((str1Index+1)+"|"+str2Index)) {
			str1Extend = cache.get((str1Index+1)+"|"+str2Index);
		} else {
			str1Extend = findLCS(str1, str2, str1Index+1, str2Index);
			cache.put((str1Index+1)+"|"+str2Index, str1Extend);
		}
		
		int str2Extend = 0;
		if(cache.containsKey(str1Index+"|"+(str2Index+1))) {
			str2Extend = cache.get(str1Index+"|"+(str2Index+1));
		} else {
			str2Extend = findLCS(str1, str2, str1Index+1, str2Index);
			cache.put(str1Index+"|"+(str2Index+1), str2Extend);
		}
		
		return Math.max(str1Extend, str2Extend);
	}

	
	private int findLCS(String str1, String str2, Integer str1Index, Integer str2Index) {
		if(str1Index == str1.length() || str2Index == str2.length())
			return 0;
		
		if(str1.charAt(str1Index) == str2.charAt(str2Index))
			return 1 + subStringSize(str1, str2, str1Index+1, str2Index+1);
		
		return Math.max(findLCS(str1, str2, str1Index+1, str2Index), findLCS(str1, str2, str1Index, str2Index + 1));
	}

	private int subStringSize(String str1, String str2, Integer str1Index, Integer str2Index) {
		if(str1.length() == str1Index || str2Index == str2.length())
			return 0;
		int count=0;
		while(str1.charAt(str1Index) == str2.charAt(str2Index)) {
			count++;
			str1Index++; str2Index++;
			if(str1Index == str2.length() || str2Index == str2.length())
				break;
		}
		return count;
	}

}
