package backtracking;

import java.util.ArrayList;

public class RatMaze {

	public static void main(String[] args) {

	}
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> maze) {
		return uniquePathsWithObstaclesUtils(maze, 0, 0, maze.size() - 1, maze.get(0).size() - 1);
	}

	public int uniquePathsWithObstaclesUtils(ArrayList<ArrayList<Integer>> maze, int rowIndex, int colIndex,
			int destinationRowIndex, int destinationColIndex) {
		if (!isValid(rowIndex, colIndex, maze)) {
			return 0;
		}

		if (rowIndex == destinationRowIndex && colIndex == destinationColIndex)
			return 1;

		return uniquePathsWithObstaclesUtils(maze, rowIndex + 1, colIndex, destinationRowIndex, destinationColIndex)
				+ uniquePathsWithObstaclesUtils(maze, rowIndex, colIndex + 1, destinationRowIndex, destinationColIndex);
	}

	public boolean isValid(int rowIndex, int colIndex, ArrayList<ArrayList<Integer>> maze) {
		return rowIndex >= 0 && colIndex >= 0 && rowIndex < maze.size() && colIndex < maze.get(0).size()
				&& maze.get(rowIndex).get(colIndex) != 1;
	}

}
