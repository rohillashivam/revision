package backtracking;

public class BalancedParanthesis {

	public static void main(String[] args) {
		createAllBalancedParanthesis(3);
	}

	private static void createAllBalancedParanthesis(int num) {
		char[] strArr = new char[2 * num];
		generateAllBalancedParenthesis(num, strArr, 0, 0, 0);
	}

	private static void generateAllBalancedParenthesis(int num, char[] strArr, int pos, int openBraceCount,
			int closeBraceCount) {
		if (closeBraceCount == num) {
			System.out.println(new String(strArr));
			return;
		}
		if (openBraceCount > closeBraceCount) {
			strArr[pos] = '}';
			generateAllBalancedParenthesis(num, strArr, pos + 1, openBraceCount, closeBraceCount + 1);
		}
		if (openBraceCount < num) {
			strArr[pos] = '{';
			generateAllBalancedParenthesis(num, strArr, pos + 1, openBraceCount + 1, closeBraceCount);
		}
	}
}
