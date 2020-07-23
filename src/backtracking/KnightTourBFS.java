package backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class KnightTourBFS {
	
	private static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {
		int[][] chessBoard = new int[8][8];
		resetChessBoard(chessBoard);
		chessBoard[0][0] = 0;
		int isKnightTourCompleted = knightTour(chessBoard, 0, 0, 8, 8);
		System.out.println("is knight tour completed :: " + isKnightTourCompleted);
		printMatrix(chessBoard);
	}

	private static void printMatrix(int[][] chessBoard) {
		
	}

	private static int knightTour(int[][] chessBoard, int startX, int startY, int endX, int endY) {
		Queue<ChessNode> nodeQueue = new LinkedList<>();
		
		nodeQueue.add(new ChessNode(startX, startY));
		nodeQueue.add(null);
		Map<ChessNode, Boolean> chessNodeMap = new HashMap<>();
		int level = 0;
		while(!nodeQueue.isEmpty()) {
			ChessNode node = nodeQueue.remove();
			if(node != null) {
				if(node.x == endX && node.y == endY) {
					return level;
				}
				for(int i=0; i< xMove.length; i++) {
					ChessNode chessNode = new ChessNode(node.x + xMove[i], node.y+yMove[i]);
					if(isValid(chessNode, chessBoard) && !chessNodeMap.containsKey(chessNode)) {
						nodeQueue.add(chessNode);
						chessNodeMap.put(chessNode, true);
					}
				}
			} else {
				level++;
				nodeQueue.add(null);
			}
		}
		
		return -1;
	}

	private static boolean isValid(ChessNode chessNode, int[][] chessBoard) {
		return chessNode.x >= 0 && chessNode.y >=0 && chessNode.x < chessBoard.length 
				&& chessNode.y < chessBoard[0].length;
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

}

class ChessNode {
	int x;
	int y;
	
	public ChessNode(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
