package dp;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		String str1 = "ABCDGH", str2= "AEDFHR";
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		System.out.println(lcs.findLCS(str1, str2));
		System.out.println("-------------");
		System.out.println(lcs.findLCSOptimized(str1, str2));
	}

	private int findLCSOptimized(String str1, String str2) {
		if(str1 == null && str2 == null)
			return 0;
		if(str1.isEmpty() && str2.isEmpty())
			return 0;
		if(str1.equals(str2))
			return str1.length();
		
		return lcsUtilsMemo(str1, str2, 0, 0);
	}

	private Map<String, Integer> cache = new HashMap<>();
	private int lcsUtilsMemo(String str1, String str2, int str1Index, int str2Index) {
		if(str1Index == str1.length() || str2Index == str2.length())
			return 0;
		
		if(str1.charAt(str1Index) == str2.charAt(str2Index)) {
			if(cache.containsKey((str1Index+1)+"|"+(str2Index+1)))
					return 1 + cache.get((str1Index+1)+"|"+(str2Index+1));
			 int value = 1 + findLCSUtilsNew(str1, str2, str1Index+1, str2Index+1);
			 cache.put((str1Index+1)+"|"+(str2Index+1), value);
			 return value;
		}

		int extendingFirst = 0;
		if(cache.containsKey((str1Index+1)+"|"+str2Index)) {
			extendingFirst = cache.get((str1Index+1)+"|"+str2Index);
		} else {
			extendingFirst = findLCSUtilsNew(str1, str2, str1Index+1, str2Index);
			cache.put((str1Index+1)+"|"+str2Index, extendingFirst);
		}
		int extendingSecond = 0;
		if(cache.containsKey(str1Index+"|"+(str2Index+1))) {
			extendingSecond = cache.get(str1Index+"|"+(str2Index+1));
		} else {
			extendingSecond = findLCSUtilsNew(str1, str2, str1Index, str2Index+1);
			cache.put(str1Index+"|"+(str2Index+1), extendingSecond);
		}
		
		return Math.max(extendingFirst, extendingSecond);
	}

	private int findLCS(String str1, String str2) {
		if(str1 == null && str2 == null)
			return 0;
		if(str1.isEmpty() && str2.isEmpty())
			return 0;
		if(str1.equals(str2))
			return str1.length();
		
		// return findLCSUtilsNew(str1, str2, str1.length()-1, str2.length() -1);
		return findLCSUtilsNew(str1, str2, 0, 0);
	}

	private int findLCSUtilsNew(String str1, String str2, int str1Index, int str2Index) {
		if(str1Index == str1.length() || str2Index == str2.length())
			return 0;
		
		if(str1.charAt(str1Index) == str2.charAt(str2Index))
			return 1 + findLCSUtilsNew(str1, str2, str1Index+1, str2Index+1);
		
		return Math.max(findLCSUtilsNew(str1, str2, str1Index+1, str2Index), 
				findLCSUtilsNew(str1, str2, str1Index, str2Index+1));
	}

	@Deprecated
	private int findLCSUtils(String str1, String str2, int str1Index, int str2Index) {
		if(str1Index < 0 || str2Index < 0)
			return 0;
		
		if(str1.charAt(str1Index) == str2.charAt(str2Index))
			return 1+findLCSUtils(str1, str2, str1Index-1, str2Index -1);
		
		
		return Math.max(findLCSUtils(str1, str2, str1Index-1, str2Index), 
				findLCSUtils(str1, str2, str1Index, str2Index -1));
	}
}
