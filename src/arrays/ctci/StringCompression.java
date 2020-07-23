package arrays.ctci;

public class StringCompression {

	public static void main(String[] args) {
		String str = "aabcccccaaa";
		System.out.println(compressString(str));
		str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbxccbsjcbsjcbsj";
		System.out.println(compressString(str));
	}

	private static String compressString(String str) {
		if(str == null || str.isEmpty())
			return str;
		Character prevChar = null;
		StringBuilder sb  = new StringBuilder();
		int count=0;
		for(int i=0; i< str.length(); i++) {
			if(prevChar == null) {
				prevChar = str.charAt(i);
			}
			if(prevChar != str.charAt(i)) {
				appendCompress(prevChar, sb, count);
				prevChar = str.charAt(i);
				count=0;
			}
			count++;
		}
		appendCompress(prevChar, sb, count);
		
		return sb.toString();
	}

	private static void appendCompress(Character prevChar, StringBuilder sb, int count) {
		sb.append(prevChar);
		sb.append(count);
	}
}
