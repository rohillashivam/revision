package backtracking;

public class SudokuSolve {

	public static void main(String[] args) {
		int[][] board = new int[][] { 
			{ 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
			{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
			{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
			{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
			{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
		};
		
		print(board);
		solveSudoku(board);
		System.out.println();
		print(board);

	}

	private static void print(int[][] board) {
		for(int i=0; i< board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}


	private static boolean solveSudoku(int[][] board) {
		int row=0, col=0;
		boolean empty= true;
		// finding the empty space
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] == 0) {
					row = i; col=j;
					empty=false;
					break;
				}
			}
			if(!empty)
				break;
		}
		
		if(empty)
			return true;
		
		for(int num=1; num<=board.length; num++) {
			if(isSafe(board, row, col, num)) {
				board[row][col] = num;
				if(solveSudoku(board))
					return true;
				board[row][col]=0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] board, int row, int col, int num) {
		
		if(!(row >=0 && row< board.length && col>=0 && col<board[0].length))
			return false;

		for(int i=col; i<board.length; i++) {
			if(board[row][i] == num)
				return false;
		}

		for(int i=row; i<board.length; i++) {
			if(board[i][col] == num)
				return false;
		}

		int sqrt = (int) Math.sqrt(board.length);
		int rowBoard = row - row % sqrt;
		int colBoard = col - col % sqrt;

		for(int i=rowBoard; i<rowBoard + sqrt; i++) {
			for(int j=colBoard; j<colBoard+sqrt; j++) {
				if(board[i][j] == num)
					return false;
			}
		}

		return true;
	}
}
