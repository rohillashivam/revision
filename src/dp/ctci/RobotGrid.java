package dp.ctci;

import java.util.HashMap;
import java.util.Map;

public class RobotGrid {

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, 
						 { 0, 0, 0 }, 
						 { 0, 0, 0 }
					};
		System.out.println(findUniquePath(2,2));
		System.out.println(findUniquePathNew(2,2));
		System.out.println(findUniquePathDP(2,2));
	}

	private static int findUniquePathDP(int row, int col) {
		int[][] dp = new int[row+1][col+1];
		for(int i=0; i<=row; i++) {
			dp[0][i] = 1;
		}
		for(int i=0; i<=col; i++) {
			dp[i][0] = 1;
		}
		
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[row][col];
	}

	static Map<String, Integer> findUniquePathCache = new HashMap<>();
	private static int findUniquePathNew(int row, int col) {
		if(row == 0 || col==0)
			return 1;
		if(!findUniquePathCache.containsKey((row-1)+"_"+col))
			findUniquePathCache.put((row-1)+"_"+col, findUniquePathNew(row-1, col));
		int rowTraverse = findUniquePathCache.get((row-1)+"_"+col);
		if(!findUniquePathCache.containsKey((row)+"_"+(col-1)))
			findUniquePathCache.put((row)+"_"+(col-1), findUniquePathNew(row, col-1));
		int colTraverse = findUniquePathCache.get((row)+"_"+(col-1));
		return rowTraverse + colTraverse;
	}

	private static int findUniquePath(int row, int col) {
		if(row == 0 || col == 0)
			return 1;
		return findUniquePath(row-1, col) + findUniquePath(row, col-1);
	}

	
}
