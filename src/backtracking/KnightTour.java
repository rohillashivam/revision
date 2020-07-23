package backtracking;

public class KnightTour {

	private static int rowMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static int colMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {
		int[][] chessBoard = new int[8][8];
		resetChessBoard(chessBoard);
		chessBoard[0][0] = 0;
		boolean isKnightTourCompleted = knightTour(chessBoard, 0, 0, 1);
		System.out.println("is knight tour completed :: " + isKnightTourCompleted);
		printMatrix(chessBoard);
	}

	private static boolean knightTour(int[][] chessBoard, int rowIndex, int colIndex, int moveCounter) {

		if (moveCounter == chessBoard.length * chessBoard[0].length)
			return true;

		for (int i = 0; i < rowMove.length; i++) {
			if (isSafe(chessBoard, rowIndex + rowMove[i], colIndex + colMove[i])) {
				chessBoard[rowIndex + rowMove[i]][colIndex + colMove[i]] = moveCounter;
				if(knightTour(chessBoard, rowIndex + rowMove[i], colIndex + colMove[i], moveCounter+1))
					return true;
				else
					chessBoard[rowIndex + rowMove[i]][colIndex + colMove[i]] = -1;
			}
		}

		return false;
	}

	private static boolean isSafe(int[][] chessBoard, int row, int col) {
		return row >= 0 && row < chessBoard.length && col >= 0 && col < chessBoard[0].length
				&& chessBoard[row][col] == -1;
	}

	private static void resetChessBoard(int[][] chessBoard) {
		if (chessBoard == null)
			return;

		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[0].length; j++) {
				chessBoard[i][j] = -1;
				// System.out.print(chessBoard[i][j]+" ");
			}
		}
	}

	private static void printMatrix(int[][] chessBoard) {
		if (chessBoard == null)
			return;

		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[0].length; j++) {
				System.out.print(chessBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
}
