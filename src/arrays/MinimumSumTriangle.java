package arrays;

import java.util.ArrayList;

public class MinimumSumTriangle {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
		
		ArrayList<Integer> dataList = new ArrayList<>();
		dataList.add(2);
		
		arrList.add(dataList);
		dataList = new ArrayList<>();
		dataList.add(6);
		dataList.add(6);
		arrList.add(dataList);
		
		dataList = new ArrayList<>();
		dataList.add(7); dataList.add(8); dataList.add(4);
		arrList.add(dataList);
		
		MinimumSumTriangle mst = new MinimumSumTriangle();
		System.out.println(mst.minimumTotal(arrList));
		System.out.println(mst.minimumTotal(arrList, 0, 0));
	}
	
	private int minimumTotal(ArrayList<ArrayList<Integer>> arrList, int row, int col) {
		if(!isSafe(row, col, arrList))
			return 0;
		
		return arrList.get(row).get(col) + Math.min(minimumTotal(arrList, row+1, col), 
				minimumTotal(arrList, row+1, col+1));
	}

	private boolean isSafe(int row, int col, ArrayList<ArrayList<Integer>> arrList) {
		return row >=0 && row < arrList.size() && col >=0 && col < arrList.get(row).size();
	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> arrList) {
	    if(arrList == null || arrList.isEmpty())
	        return 0;
	        
	    int[] memo = new int[arrList.get(arrList.size()-1).size()];
	    int length = arrList.size()-1;
	    for(int i=0; i<arrList.get(length).size(); i++) {
	        memo[i] = arrList.get(length).get(i);
	    }
	    
	    for(int i=length-1; i>=0; i--) {
	        for(int j=0; j<arrList.get(i).size(); j++) {
	            //memo[i] += Math.min(arrList.get(i).get(j), arrList.get(i).get(j+1));
	        	System.out.println("size :: "+arrList.get(i).size()+" index j :: "+j);
	            memo[j] = arrList.get(i).get(j) + Math.min(memo[j], memo[j+1]);
	        }
	    }
	    return memo[0];
	}
}
