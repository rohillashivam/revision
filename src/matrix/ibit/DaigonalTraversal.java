package matrix.ibit;

import java.util.ArrayList;

public class DaigonalTraversal {

	public static void main(String[] args) {

	}
	
	public ArrayList<ArrayList<Integer>> diagonalSelf(ArrayList<ArrayList<Integer>> mat) {
        if(mat == null || mat.size() ==0 )
            return mat;
            
        int currRow = 0, row = 0;
        int currCol = 0, col = 0;
        ArrayList<ArrayList<Integer>> daigonalList = new ArrayList<>();
        
        while(currCol < mat.get(0).size()) {
            if(!isSafe(row, col, mat)) {
                col = currCol;
                row = currRow;
            }
            ArrayList<Integer> dataList = new ArrayList<>();
            while(isSafe(row, col, mat)) {
                dataList.add(mat.get(row).get(col));
                row++;
                col--;
            }
            if(dataList.size() > 0)
                daigonalList.add(dataList);
            currCol++;
        }
        
        currRow++;
        currCol -= 1;
        //System.out.println("row :: "+row+" - col :: "+col);
        //System.out.println("currRow :: "+currRow+" - currCol :: "+currCol);
        while(currRow < mat.size()) {
            //System.out.println("2nd fret");
            if(!isSafe(row, col, mat)) {
                col = currCol;
                row = currRow;
            }
            ArrayList<Integer> dataList = new ArrayList<>();
            //System.out.println("[BEFORE] row :: "+row+" - col :: "+col);
            while(isSafe(row, col, mat)) {
                //System.out.println("row :: "+row+" - col :: "+col);
                dataList.add(mat.get(row).get(col));
                row++;
                col--;
            }
            //System.out.println("datalist size :: " + dataList.size());
            daigonalList.add(dataList);
            currRow++;
            //System.out.println("currRow :: "+currRow+" currCol :: "+currCol+" and mat.size() :: "+mat.size());
        }
        
        return daigonalList;
    }
    
    private boolean isSafe(int row, int col, ArrayList<ArrayList<Integer>> mat) {
        return row >=0 && row < mat.size() && col >= 0 && col < mat.get(0).size();
    }

	// ibit solution -- [START]
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int dimension = a.size();
		for (int i = 0; i < dimension * 2 - 1; i++) {
			result.add(getDiagonal(i, a));
		}
		return result;
	}

	public ArrayList<Integer> getDiagonal(int layer, ArrayList<ArrayList<Integer>> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i <= layer; i++) {
			int j = layer - i;
			if (i < a.size() && j < a.size()) {
				result.add(a.get(i).get(j));
			}
		}
		return result;
	}
	// ibit solution -- [END]
}
