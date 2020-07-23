package dp;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		String  str = "ABDCBCDBDCBBC";
		int count = findLongestPalindromicSubString(str, 0, str.length()-1, 0);
		System.out.println("coutn :: "+count);
		str = "forgeeksskeegfor";
		count = findLongestPalindromicSubString(str, 0, str.length()-1, 0);
		System.out.println("coutn :: "+count);
		System.out.println("----------------MEMO-----------------");
		count = findLongestPalindromicSubStringOpt(str);
	}

	private static int findLongestPalindromicSubStringOpt(String str) {
		boolean[][] table = new boolean[str.length()][str.length()];
		
		int maxLength=1, start=0, end = 0;
		for(int i=0; i<str.length(); i++) 
			table[i][i] = true;
		// for length 2
		for(int i=1; i<str.length()-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				table[i][i+1] = true;
				maxLength = 2;
			}
		}
		
		// for 3-n length
		for(int i=3; i<=str.length(); i++) {
			for(int j=0; j<str.length(); j++) {
				int kthIndex = j + i - 1;
				
				if(kthIndex < str.length() && str.charAt(j) == str.charAt(kthIndex) && table[j+1][kthIndex-1]) {
					table[j][kthIndex] = true;
					start = j;
					end = kthIndex;
					maxLength = i;
				}
			}
		}
		
		System.out.println("maxLength :: "+maxLength);
		
		return 0;
	}

	private static int findLongestPalindromicSubString(String str, int start, int end, int count) {
		if(end < start)
			return 0;
		
		if(str.charAt(start) == str.charAt(end) && isPalindromSubString(str, start, end)) {
			int length = end-start+1;
			if(length > count)
				System.out.println("palindromic substring :: "+str.substring(start, end));
			return Math.max(count, length);
		}
		
		return Math.max(Math.max(findLongestPalindromicSubString(str, start+1, end, count), 
				findLongestPalindromicSubString(str, start, end-1, count)), count);
	}

	private static boolean isPalindromSubString(String str, int start, int end) {
		while(start <= end && str.charAt(start) == str.charAt(end)) {
			start++;
			end--;
		}
		return start > end ? true : false;
	}
}
