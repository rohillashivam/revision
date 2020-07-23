package misc;

public class CountNumOfIslands {

	private static final int[] side = {-1, 0, 1};
	//private static boolean[][] visited = null;
	public static void main(String[] args) {
		int[][] region = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
				
		int count = countNumOfIsland(region);
		System.out.println("number of islands :: "+count);
		
		count = countNumOfIslandOptimized(region);
		System.out.println("num of island from optimized :: "+count);
		
		region = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1 } };
		int length = findMaxLengthOfIsland(region);
		System.out.println("max length of island :: "+length);
		
		int regionNew[][] = { {0, 0, 1, 1, 0},  
                {1, 0, 1, 1, 0},  
                {0, 1, 0, 0, 0},  
                {0, 0, 0, 0, 1}};
		
		length = findMaxLengthOfIsland(regionNew);
		System.out.println("length for new region :: "+length);
	}
	private static int findMaxLengthOfIsland(int[][] region) {
		Integer maxLength = Integer.MIN_VALUE, count = 0;
		for(int i=0; i<region.length; i++) {
			for(int j=0; j<region[0].length; j++) {
				if(region[i][j] == 0) {
					region[i][j] = 2;
					continue;
				}
				if(region[i][j] == 1) {
					count++;
					int length = findLengthOfIsland(region, i, j, 0);
					if(length > maxLength)
						maxLength = length;
				}
			}
		}
		System.out.println("region with island count :: "+count+" of max length :: "+maxLength);
		return maxLength;
	}
	
	private static int findLengthOfIsland(int[][] region, int currRowIndex, int currColIndex, int length) {
		region[currRowIndex][currColIndex] = 2;
		length++;
		for(int i=0; i<side.length; i++) {
			for(int j=0; j<side.length; j++) {
				if(side[i] == 0 && side[j] ==0)
					continue;
				int newRowIndex = currRowIndex + side[i];
				int newColIndex = currColIndex + side[j];
				if(!isSafe(region, newRowIndex, newColIndex) || region[newRowIndex][newColIndex] == 2)
					continue;
				
				if(region[newRowIndex][newColIndex] == 0) {
					region[newRowIndex][newColIndex] = 2;
					continue;
				}
				
				if(region[newRowIndex][newColIndex] == 1) {
					length = findLengthOfIsland(region, newRowIndex, newColIndex, length);
				}
			}
		}
		return length;
	}
	private static int countNumOfIslandOptimized(int[][] region) {
		int count = 0;
		for(int i=0; i<region.length; i++) {
			for(int j=0; j<region[0].length; j++) {
				if(region[i][j] == 0) {
					region[i][j] = 2;
					continue;
				}
				if(region[i][j] == 1) {
					count++;
					visitIsland(region, i, j);
				}
			}
		}
		return count;
	}
	private static void visitIsland(int[][] region, int currRowIndex, int currColIndex) {
		region[currRowIndex][currColIndex] = 2;
		for(int i=0; i<side.length; i++) {
			for(int j=0; j<side.length; j++) {
				if(side[i] == 0 && side[j] ==0)
					continue;
				int newRowIndex = currRowIndex + side[i];
				int newColIndex = currColIndex + side[j];
				if(!isSafe(region, newRowIndex, newColIndex) || region[newRowIndex][newColIndex] == 2)
					continue;
				
				if(region[newRowIndex][newColIndex] == 0) {
					region[newRowIndex][newColIndex] = 2;
					continue;
				}
				
				if(region[newRowIndex][newColIndex] == 1) {
					visitIsland(region, newRowIndex, newColIndex);
				}
			}
		}
	}
	private static int countNumOfIsland(int[][] region) {
		int count = 0;
		boolean[][] visited = new boolean[region.length][region[0].length];
		for(int i=0; i<region.length; i++) {
			for(int j=0; j<region[0].length; j++) {
				if(visited[i][j]) continue;
				if(region[i][j] == 0) {
					visited[i][j] = true;
					continue;
				}
				count++;
				traverseIsland(region, i, j, visited);
			}
		}
		return count;
	}
	private static void traverseIsland(int[][] region, int currRowIndex, int currColIndex, boolean[][] visited) {
		visited[currRowIndex][currColIndex] = true;
		for(int i=0; i< side.length; i++) {
			for(int j=0; j< side.length; j++) {
				System.out.println((currRowIndex+side[i])+", "+(currColIndex+side[j]));
				if(!(isSafe(region, currRowIndex+side[i], currColIndex+side[j]) && 
						!visited[currRowIndex+side[i]][currColIndex+side[j]]) || 
						(side[i] == 0 && side[j] == 0))
					continue;
				if(region[currRowIndex+side[i]][currColIndex+side[j]] == 0) {
					visited[currRowIndex + side[i]][currColIndex+side[j]] = true;
					continue;
				}
				traverseIsland(region, currRowIndex + side[i], currColIndex+side[j], visited);
			}
		}
	}
	private static boolean isSafe(int[][] region, int i, int j) {
		return (i>=0 && i <region.length) && (j >=0 && j < region[0].length);
	}
}
