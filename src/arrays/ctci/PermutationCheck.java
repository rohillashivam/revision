package arrays.ctci;

import java.util.HashMap;
import java.util.Map;

public class PermutationCheck {

	public static void main(String[] args) {
		String str1 = "geeksforgeeks"; 
	    String str2 = "forgeeksgeeks";
	    
	    boolean ip = isPermutation(str1, str2);
	    System.out.println("is permutation :: "+ip);
	    
	    str1 = "test"; 
	    str2 = "ttew"; 
	    ip = isPermutation(str1, str2);
	    System.out.println("is permutation :: "+ip);
	}

	private static boolean isPermutation(String str1, String str2) {
		if((str1 == null && str2 != null) || (str1 != null && str2 == null) || (str1.isEmpty() && !str2.isEmpty())
				|| (!str1.isEmpty() && str2.isEmpty()) || (str1.length() != str2.length()))
			return false;
		
		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for(int i=0; i<str1.length(); i++) {
			Integer val = 1;
			if(charCountMap.containsKey(str1.charAt(i))) {
				val = charCountMap.get(str1.charAt(i));
				val++;
			}
			charCountMap.put(str1.charAt(i), val);
		}
		
		for(int j=0; j<str2.length(); j++) {
			Integer val = charCountMap.get(str2.charAt(j));
			if(val == null)
				continue;
			val--;
			if(val == 0) {
				charCountMap.remove(str2.charAt(j));
			} else {
				charCountMap.put(str2.charAt(j), val);
			}
		}
		
		return charCountMap.size() == 0 ? true : false;
	}
}
