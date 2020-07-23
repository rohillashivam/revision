package matrix;

import java.util.ArrayList;

public class NumBlackShapesIBIT {

	public static void main(String[] args) {
		NumBlackShapesIBIT numBlackShapesIBIT = new NumBlackShapesIBIT();
		ArrayList<String> strArr = new ArrayList<>();
		strArr.add("XXX");
		strArr.add("XXX");
		strArr.add("XXX");
		System.out.println(numBlackShapesIBIT.black(strArr));
	}
	
	public int black(ArrayList<String> arr) {
        if(arr == null || arr.isEmpty())
            return 0;
            
        int count=0;
        for(int i=0; i<arr.size(); i++) {
            //String str = arr.get(i);
            if(arr.get(i) == null || arr.get(i).isEmpty())
                continue;
            for(int j=0; j<arr.get(i).length(); j++) {
                if(arr.get(i).charAt(j) == 'Y')
                    continue;
                if(arr.get(i).charAt(j) == 'X') {
                    checkConnectedComponents(arr, i, j);
                    count++;
                } else {
                    char[] chArr = arr.get(i).toCharArray();
                    chArr[j] = 'Y';
                    String str = new String(chArr);
                    arr.set(i, str);
                }
            }
        }
            
        return count;
    }
    int[] direction = {-1, 1, 0};
    private void checkConnectedComponents(ArrayList<String> arr, int rowIndex, int colIndex) {
        if(!isSafe(arr, rowIndex, colIndex))
            return;
        
        String str = arr.get(rowIndex);
        char[] chArr = str.toCharArray();
        chArr[colIndex] = 'Y';
        str = new String(chArr);
        arr.set(rowIndex, str);
        for(int i=0; i<direction.length; i++) {
            for(int j=0; j<direction.length; j++) {
                if(i == j)
                    continue;
                checkConnectedComponents(arr, rowIndex+i, colIndex+j);
            }
        }
        
    }
    
    private boolean isSafe(ArrayList<String> arr, int rowIndex, int colIndex) {
        return rowIndex >=0 && rowIndex < arr.size() && colIndex >=0 && colIndex < arr.get(rowIndex).length() && arr.get(rowIndex).charAt(colIndex) != 'Y' && arr.get(rowIndex).charAt(colIndex) != 'O';
    }
}
