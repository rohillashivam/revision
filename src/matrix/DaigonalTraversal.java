package matrix;

public class DaigonalTraversal {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, 
				{ 13, 14, 15, 16 }, { 17, 18, 19, 20 }, };

		printZigZagMatrix(matrix);
	}

	private static void printZigZagMatrix(int[][] matrix) {
		boolean flag = false;
		int row=0, col=0;
		while(row < matrix.length && col < matrix[0].length) {
			System.out.print(matrix[row][col] +" ");
			if(!flag) {
				if(isSafe(matrix, row-1, col+1)) {
					row--;
					col++;
				} else if(isSafe(matrix, row, col+1)){
					col++;
					flag = !flag;
					System.out.println();
				} else if(isSafe(matrix, row+1, col)){
					row++;
					flag = !flag;
					System.out.println();
				} 
			} else {
				if(isSafe(matrix, row+1, col-1)) {
					row++;
					col--;
				} else if ((row == matrix.length - 1) && !isSafe(matrix, row+1, col-1)) {
					col++;
					flag = !flag;
					System.out.println();
				} else if(isSafe(matrix, row+1, col)){
					row++;
					flag = !flag;
					System.out.println();
				}
			}
		}
	}

	private static boolean isSafe(int[][] matrix, int row, int col) {
		return row >= 0 && row < matrix.length && col >=0 && col < matrix[0].length;
	}

}
