package backtracking;

public class NQueenProblem {

	public static void main(String[] args) {
		int N=4;
		int[][] matrix = new int[N][N];
		boolean nQueenPlacementSuccess = nQueenPlacement(matrix, N);
		System.out.println(nQueenPlacementSuccess);
		printMatrix(matrix);
	}

	private static void printMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static boolean nQueenPlacement(int[][] matrix, int n) {
		if(matrix == null || matrix.length != n)
			return false;

		int col=0;
		for(int j=0; j<matrix[0].length; j++) {
			matrix[j][col]=1;
			if(nQueenPlacementUtils(matrix, n, col+1, 1)) {
				return true;
			}
			matrix[j][col] = 0;
		}
		return false;
	}

	private static boolean nQueenPlacementUtils(int[][] matrix, int n, int colNum, int count) {
		if(count == n)
			return true;
		
		for(int i=0; i<n; i++) {
			if(isSafe(matrix, i, colNum)) {
				matrix[i][colNum] = 1;
				if(nQueenPlacementUtils(matrix, n, colNum+1, count + 1))
					return true;
				matrix[i][colNum] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] matrix, int row, int col) {
		if(!(row >=0 && row < matrix.length && col>=0 && col < matrix[0].length))
			return false;

		// row wise check
		int colNum=0;
		for(; colNum < matrix[0].length; colNum++) {
			if(colNum == col)
				continue;
			if(matrix[row][colNum] == 1)
				return false;
		}

		// col wise check
		int rowNum=0;
		for(; rowNum < matrix.length; rowNum++) {
			if(rowNum == row)
				continue;
			if(matrix[rowNum][col] == 1)
				return false;
		}
		// upper daigonal check
		rowNum=row-1; colNum=col-1;
		while(rowNum >= 0 && colNum >= 0) {
			if(matrix[rowNum][colNum] == 1) {
				return false;
			}
			rowNum--; colNum--;
		}

		// lower daigonal check
		rowNum=row+1; colNum=col-1;
		while(rowNum < matrix.length && colNum >=0) {
			if(matrix[rowNum][colNum] == 1) {
				return false;
			}
			rowNum++; colNum--;
		}

		return true;
	}
}
