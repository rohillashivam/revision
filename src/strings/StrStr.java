package strings;

public class StrStr {

	public static void main(String[] args) {
		String str="bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba";
		String subStr = "babaaa";
		System.out.println(strStr(str, subStr));
	}
	
	public static int strStr(final String str, final String subStr) {
        if(str == null || str.isEmpty())
            return  -1;
            
        if((str != null && !str.isEmpty()) && (subStr == null || subStr.isEmpty()))
            return -1;
            
        int start=0, i=0, index=-1;
        while(start < str.length() && i < subStr.length()) {
            if(str.charAt(start) == subStr.charAt(i)) {
                if(index == -1) {
                    index = start;
                }
                start++;
                if(i<subStr.length())
                    i++;
                else
                    break;
            } else {
                i=0;
                if(index != -1) {
                    start = index+1;
                    index=-1;
                }
            }
            
        }
        if(i<subStr.length() && start==str.length())
            return -1;
        return index;
    }
}
