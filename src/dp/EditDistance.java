package dp;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {

	private static Map<String, Integer> memo = new HashMap<>();
	
	public static void main(String[] args) {
		String str1= "sunday";
		String str2= "saturday";
		System.out.println(editDistanceRec(str1, str2, str1.length()-1, str2.length()-1));
		str1 = "food"; str2="money";
		System.out.println(editDistanceRec(str1, str2, str1.length()-1, str2.length()-1));
		str1="geek"; str2="gesek";
		System.out.println(editDistanceRec(str1, str2, str1.length()-1, str2.length()-1));
		System.out.println("-----------------memo-----------");
		memo.clear();
		System.out.println(editDistanceMemo(str1, str2, str1.length()-1, str2.length()-1));
		System.out.println("---------tab---------");
		System.out.println(editDistanceTab(str1, str2));
	}

	private static int editDistanceTab(String str1, String str2) {
		if((str1 == null || str1.isEmpty()) && (str2 != null && !str2.isEmpty())) {
			return str2.length();
		}
		if((str1 != null && !str1.isEmpty()) && (str1 == null || str2.isEmpty()))
			return str1.length();
		
		int str1Length = str1.length();
		int str2Length = str2.length();
		int[][] dp = new int[str1Length][str2Length];
		
		for(int i=0; i<str1Length; i++) {
			for(int j=0; j<str2Length; j++) {
				if(i == 0) {
					dp[i][j] = j;
					continue;
				}
				if(j == 0) {
					dp[i][j] = i;
					continue;
				}
				
				if(str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i-1][j-1];
					continue;
				}
				
				dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
			}
		}
		return dp[str1Length-1][str2Length-1];
	}

	private static int editDistanceRec(String str1, String str2, int currStr1Index, int currStr2Index) {
		if(currStr1Index == 0)
			return currStr2Index;
		if(currStr2Index == 0)
			return currStr1Index;
		
		if(str1.charAt(currStr1Index) == str2.charAt(currStr2Index))
			return editDistanceRec(str1, str2, currStr1Index-1, currStr2Index-1);
		
		return 1 + Math.min(editDistanceRec(str1, str2, currStr1Index, currStr2Index-1), // insert
				Math.min(editDistanceRec(str1, str2, currStr1Index-1, currStr2Index), // delete
						editDistanceRec(str1, str2, currStr1Index-1, currStr2Index-1))); // replaces
	}
	
	private static int editDistanceMemo(String str1, String str2, int currStr1Index, int currStr2Index) {
		if(currStr1Index == 0)
			return currStr2Index;
		if(currStr2Index == 0)
			return currStr1Index;
		
		if(str1.charAt(currStr1Index) == str2.charAt(currStr2Index)) {
			String key = (currStr1Index-1)+"|"+(currStr2Index-1);
			if(!memo.containsKey(key)) {
				evaluateMemoEditDistance(str1, str2, currStr1Index-1, currStr2Index-1, key);
			}
			return memo.get(key);
		}
		
		String insertKey = (currStr1Index-1)+"|"+currStr2Index;
		if(!memo.containsKey(insertKey)) {
			evaluateMemoEditDistance(str1, str2, currStr1Index-1, currStr2Index, insertKey);
		}
		
		String deleteKey = currStr1Index+"|"+(currStr2Index-1);
		if(!memo.containsKey(deleteKey)) {
			evaluateMemoEditDistance(str1, str2, currStr1Index, currStr2Index-1, deleteKey);
		}
		
		String replaceKey = (currStr1Index-1)+"|"+(currStr2Index-1);
		if(!memo.containsKey(replaceKey)) {
			evaluateMemoEditDistance(str1, str2, currStr1Index-1, currStr2Index-1, replaceKey);
		}
		
		return 1+ Math.min(memo.get(insertKey), 
				Math.min(memo.get(deleteKey), 
						memo.get(replaceKey)));
	}

	private static void evaluateMemoEditDistance(String str1, String str2, int currStr1Index, int currStr2Index,
			String key) {
		Integer editDistance = editDistanceMemo(str1, str2, currStr1Index, currStr2Index);
		memo.put(key, editDistance);
	}
}
