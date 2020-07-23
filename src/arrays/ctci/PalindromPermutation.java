package arrays.ctci;

import java.util.HashSet;
import java.util.Set;

public class PalindromPermutation {

	public static void main(String[] args) {
		String str = "Tact Coa";
		boolean iPP = isPalindromPermutaton(str);
		System.out.println("is palindrom :: "+iPP);
		
		str = "tactcoapapaa";
		iPP = isPalindromPermutaton(str);
		System.out.println("is palindrom :: "+iPP);
	}

	private static boolean isPalindromPermutaton(String str) {
		Set<Character> charSet = new HashSet<>();
		String newStr = new String(str);
		newStr = newStr.toLowerCase();
		for(int i=0; i<newStr.length(); i++) {
			if(newStr.charAt(i) == ' ') {
				continue;
			}	
			if(charSet.contains(newStr.charAt(i))) {
				charSet.remove(newStr.charAt(i));
			} else {
				charSet.add(newStr.charAt(i));
			}
		}
		if(charSet.size() <= 1)
			return true;
		return false ;
	}
}
