package arrays;

import java.util.ArrayList;

public class PascalTriangle {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> dataList = solve(5);
		System.out.println("");
	}
	
	public static ArrayList<ArrayList<Integer>> solve(int numOfRow) {
        if(numOfRow == 0)
            return null;
            
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>(numOfRow);
        ArrayList<Integer> firstList = new ArrayList<>(1);
        firstList.add(1);
        triangle.add(0, firstList);
        if(numOfRow == 1)
            return triangle;
        for(int i=1; i<numOfRow; i++) {
            ArrayList<Integer> numList = new ArrayList<>(i+1);
            for(int j=0; j<i+1;j++) {
                if(j == 0 || j == i) {
                    numList.add(1);
                    continue;
                }
                numList.add((triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j)));
            }
            triangle.add(numList);
        }
        
        return triangle;
    }
}
