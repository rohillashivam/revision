package arrays;

import java.util.ArrayList;

public class MaxAbsoluteDIff {

	public static void main(String[] args) {
		int[] arr = {1, 3, -1};
		System.out.println(maxArr(arr));
	}
	
	public static int maxArr(int[] arr) {
        if(arr == null)
            return 0;
        //int[][] dataVal = new int[arr.size()][arr.size()];
        int maxVal = 0;
        /*for(int i=0; i<arr.size(); i++) {
            for(int j=i; j<arr.size(); j++) {
                if(i == j)
                    continue;
                /*if(dataVal[i][j] != 0 || dataVal[j][i] != 0) {
                    int val = dataVal[i][j] == 0 ? dataVal[j][i] : dataVal[i][j];
                    maxVal = Math.max(dataVal[i][j], maxVal);
                } else {
                   //int val = calculateDiff(i, j, arr);
                    //dataVal[i][j] = val;
                    //dataVal[j][i] = val;
                    maxVal = Math.max(maxVal, calculateDiff(i, j, arr));
                //}
            }
        }*/
        
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            max1 = Math.max(max1, (arr[i]-i));
            max2 = Math.max(max2, (arr[i]+i));
            min1 = Math.min(min1, (arr[i]-i));
            min2 = Math.min(min2, (arr[i]+i));
        }
        
        
        return Math.max(max1-min1, max2-min2);
    }
	public int calculateDiff(int i, int j, ArrayList<Integer> arr) {
        return Math.abs(arr.get(i) - arr.get(j)) + Math.abs(i - j);
    }

}
