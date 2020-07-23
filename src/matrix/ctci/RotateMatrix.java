package matrix.ctci;

import java.util.ArrayList;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix = { 
		        { 1, 2, 3, 4 }, 
		        { 5, 6, 7, 8 }, 
		        { 9, 10, 11, 12 }, 
		        { 13, 14, 15, 16 }};
		printMatrix(matrix);
		System.out.println();
		rotateMatrix(matrix);
		System.out.println("---------------");
		int[][] matrixObj = { 
		        { 1, 2, 3, 4 }, 
		        { 5, 6, 7, 8 }, 
		        { 9, 10, 11, 12 }, 
		        { 13, 14, 15, 16 }};
		ArrayList<ArrayList<Integer>> arrayMatrix = new ArrayList<>();
		convert(arrayMatrix, matrixObj);
		rotate(arrayMatrix);
	}

	private static void convert(ArrayList<ArrayList<Integer>> arrayMatrix, int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			ArrayList<Integer> intList = new ArrayList<>();
			for(int j=0; j<matrix[0].length; j++) {
				intList.add(matrix[i][j]);
			}
			arrayMatrix.add(intList);
		}
	}

	private static void rotateMatrix(int[][] matrix) {
		int colLength = matrix[0].length - 1;
		int rowLength = matrix.length - 1;
		int i=0, j=0;
		for(i=0; i<(rowLength+1)/2; i++) {
			for (j=i; j<colLength - i ; j++) {
				int temp = matrix[colLength-j][i];
				matrix[colLength-j][i] = matrix[rowLength-i][colLength - j];
				matrix[rowLength-i][colLength-j] = matrix[j][colLength - i];
				matrix[j][colLength-i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
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
	
	public static void rotate(ArrayList<ArrayList<Integer>> matrix) {
        if(matrix == null)
            return;
            
        int rowLength = matrix.size()-1;
        int colLength = matrix.get(0).size()-1;
            
        for(int i=0; i<(rowLength+1)/2; i++) {
            for(int j=i;j<colLength-i; j++) {
                int temp = matrix.get(rowLength-j).get(i);
                matrix.get(rowLength-j).set(i, matrix.get(rowLength-i).get(colLength-j));
                matrix.get(rowLength-i).set(colLength-j, matrix.get(j).get(colLength-i));
                matrix.get(j).set(colLength-i, matrix.get(i).get(j));
                matrix.get(i).set(j, temp);
            }
        }
        /*for(int i=0; i<matrix.size(); i++) {
            for(int j=0; j<matrix.get(0).size(); j++) {
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }*/
    }
}
