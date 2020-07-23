package matrix;

public class SpiralOrderTraversal {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrixInSpiralOrder(matrix);
		System.out.println("------------RECURSIVE-----------");
		printMatrixInSpiralOrderInRecursive(matrix, 0, 0, 0, 0, matrix.length, matrix[0].length);
		System.out.println("--------------REVERSE SPIRAL ORDER-------------");
		printMatrixInSpiralOrderInRecursiveReverse(matrix, 0, 0, 0, 0, matrix.length, matrix[0].length);
	}

	private static void printMatrixInSpiralOrderInRecursiveReverse(int[][] matrix, int startRow, int startCol, int rowIndex,
			int colIndex, int rowLength, int colLength) {
		if (rowIndex > rowLength && colIndex > colLength)
			return;
		
		printMatrixInSpiralOrderInRecursive(matrix, startRow + 1, startCol + 1, startRow+1, startCol+1, rowLength - 1, colLength -1);
		
	}

	private static void printMatrixInSpiralOrderInRecursive(int[][] matrix, int startRow, int startCol, int rowIndex,
			int colIndex, int rowLength, int colLength) {

		if (rowIndex > rowLength && colIndex > colLength)
			return;
		// top row traversal
		int i = 0;
		for (i = colIndex; i < colLength; i++)
			System.out.print(matrix[rowIndex][i] + " ");
		rowIndex++;
		colIndex = i - 1;
		System.out.println();
		// print left col
		for (i = rowIndex; i < rowLength; i++)
			System.out.print(matrix[i][colIndex] + " ");
		colIndex--;
		rowIndex = i - 1;
		System.out.println();
		// bottom row
		for (i = colIndex; i >= startCol; i--)
			System.out.print(matrix[rowIndex][i] + " ");
		rowIndex--;
		colIndex = i + 1;
		System.out.println();
		// right col
		for (i = rowIndex; i > startRow; i--)
			System.out.print(matrix[i][colIndex] + " ");
		System.out.println();
		
		printMatrixInSpiralOrderInRecursive(matrix, startRow + 1, startCol + 1, startRow+1, startCol+1, rowLength - 1, colLength -1);

	}

	private static void printMatrixInSpiralOrder(int[][] matrix) {
		int rowIndex = 0, colIndex = 0, rowLength = matrix.length, colLength = matrix[0].length;
		int startRow = 0, startCol = 0;
		while (rowIndex < rowLength && colIndex < colLength) {
			// top row traversal
			int i = 0;
			for (i = colIndex; i < colLength; i++)
				System.out.print(matrix[rowIndex][i] + " ");
			rowIndex++;
			colIndex = i - 1;
			System.out.println();
			// print left col
			for (i = rowIndex; i < rowLength; i++)
				System.out.print(matrix[i][colIndex] + " ");
			colIndex--;
			rowIndex = i - 1;
			System.out.println();
			// bottom row
			for (i = colIndex; i >= startCol; i--)
				System.out.print(matrix[rowIndex][i] + " ");
			rowIndex--;
			colIndex = i + 1;
			System.out.println();
			// right col
			for (i = rowIndex; i > startRow; i--)
				System.out.print(matrix[i][colIndex] + " ");
			System.out.println();
			startRow++;
			startCol++;
			rowLength--;
			colLength--;
			rowIndex = startRow;
			colIndex = startCol;
			System.out.println();
		}
	}
}
