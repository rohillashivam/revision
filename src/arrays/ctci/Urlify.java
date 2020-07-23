package arrays.ctci;

public class Urlify {

	public static void main(String[] args) {
		String str = "Mr John Smith      ";
		String urlStr = urlifyString(str);
		System.out.println(urlStr);
	}

	private static String urlifyString(String str) {
		if(str == null || str.isEmpty())
			return str;
		
		char[] strChArr = str.toCharArray();
		str = null;
		int spaceCount = findNumOfSpacesInString(strChArr);
		System.out.println("space count :: "+spaceCount);
		strChArr = shiftTheChar(strChArr, spaceCount);
		strChArr = writeSpaceUrl(strChArr, spaceCount);
		return String.valueOf(strChArr);
	}

	private static char[] writeSpaceUrl(char[] strChArr, int spaceCount) {
		for(int i=0; i<strChArr.length; i++) {
			if(strChArr[i] == ' ') {
				strChArr[i]='%';
				strChArr[i+1]='2';
				strChArr[i+2]='0';
				i=i+2;
				spaceCount--;
			}
			if(spaceCount == 0)
				break;
		}
		return strChArr;
	}

	private static char[] shiftTheChar(char[] strChArr, int spaceCount) {
		boolean charFound = false;
		for(int j=strChArr.length - 1; j>=0 ; j--) {
			if(strChArr[j] != ' ' && !charFound) 
				charFound = true;
			if(charFound && strChArr[j] != ' ') {
				strChArr[j+(spaceCount*2)] = strChArr[j];
			}
			if(charFound && strChArr[j] == ' ') {
				spaceCount-- ;
				strChArr[j+(spaceCount*2)] = strChArr[j];
			}
			if(spaceCount == 0)
				break;
		}
		return strChArr;
	}

	private static int findNumOfSpacesInString(char[] strChArr) {
		boolean charFound = false;
		int count = 0;
		for(int j=strChArr.length - 1; j>=0 ; j--) {
			if(strChArr[j] != ' ' && !charFound) 
				charFound = true;
			if(charFound && strChArr[j] == ' ')
				count++;
		}
		return count;
	}
}
