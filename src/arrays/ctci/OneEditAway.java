package arrays.ctci;

public class OneEditAway {

	public static void main(String[] args) {
		String str1 = "pale", str2 = "ple";
		boolean isOneEdit = isEditAway(str1, str2);
		System.out.println(isOneEdit);
		str1 = "ale"; str2 = "pale";
		isOneEdit = isEditAway(str1, str2);
		System.out.println(isOneEdit);
		str1 = "bale"; str2 = "pale";
		isOneEdit = isEditAway(str1, str2);
		System.out.println(isOneEdit);
		str1 = "ape"; str2 = "pale";
		isOneEdit = isEditAway(str1, str2);
		System.out.println(isOneEdit);
		System.out.println("------------------------------");
		isOneEdit = isEditAwayOptimized(str1, str2);
		System.out.println(isOneEdit);
		str1 = "ale"; str2 = "pale";
		isOneEdit = isEditAway(str1, str2);
		System.out.println(isOneEdit);
		str1 = "pale"; str2 = "ple";
		isOneEdit = isEditAway(str1, str2);
		System.out.println(isOneEdit);
		str1 = "bale"; str2 = "pale";
		isOneEdit = isEditAway(str1, str2);
		System.out.println(isOneEdit);
	}

	private static boolean isEditAwayOptimized(String str1, String str2) {
		if(str1 == null || str2 == null)
			return false;
		return str2.length() > str1.length() ? isEditAwayUtils(str2, str1) : isEditAwayUtils(str1, str2);
	}

	private static boolean isEditAwayUtils(String str1, String str2) {
		int count = 0, index1 = 0, index2 = 0;
		while(index1 < str1.length() && index2 < str2.length()) {
			if(str1.charAt(index1) != str2.charAt(index2)) {
				count++;
				if(count < 1) {
					index1++;
					if(str1.length() == str2.length()) {
						index2++;
					}
				} else {
					return false;
				}
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	private static boolean isEditAway(String str1, String str2) {
		if(str1 == null || str2 == null)
			return false;
		if(str1.length() == str2.length()) {
			return isOneReplacementAway(str1, str2);
		} else if(str1.length() == str2.length() + 1) {
			return isOneInsert(str1, str2);
		} else if(str1.length() + 1 == str2.length()) {
			return isOneInsert(str2, str1);
		}
		return false;
	}

	private static boolean isOneInsert(String str1, String str2) {
		int count = 0, index1=0, index2=0;
		while(index1 < str1.length() && index2 < str2.length()) {
			if(str1.charAt(index1) != str2.charAt(index2)) {
				if(count < 1) {
					index1++;
					count++;
				} else
					return false;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	private static boolean isOneReplacementAway(String str1, String str2) {
		int count = 0, index1=0, index2=0;
		while(index1 < str1.length() && index2 < str2.length()) {
			if(str1.charAt(index1) != str2.charAt(index2)) {
				if(count < 1)
					count++;
				else
					return false;
			}
			index1++;
			index2++;
		}
		return true;
	}
}
