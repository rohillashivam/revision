package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WindowStr {
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

	public static String minWindow(String str, String subSeq) {
        if(str == null || str.isEmpty()) 
            return str;
        if(subSeq == null || subSeq.isEmpty())
            return subSeq;
            
        String minStr = "";
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i=0; i<subSeq.length(); i++) {
        	charMap.put(subSeq.charAt(i), -1);
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<Character> charSetN = new HashSet<>();
        for(int i=0; i<str.length(); i++) {
        	if(charMap.containsKey(str.charAt(i))) {
        		charSetN.add(str.charAt(i));
            	max = Math.max(max, i);
            	min = Math.min(min, i);
            	if(charMap.get(str.charAt(i)) == min) {
            		charMap.put(str.charAt(i), i);
            		min = Integer.MAX_VALUE;
            		for(Character ch : charMap.keySet()) {
            			min = Math.min(min, charMap.get(ch));
            		}
            	}
            	charMap.put(str.charAt(i), i);
            	if(max - min < minLength && charSetN.size() == subSeq.length()) {
            		minStr = str.substring(min, max+1);
            		minLength = minStr.length();
            		charSetN.clear();
            	}
            }
        }
        return minStr;
    }
}
