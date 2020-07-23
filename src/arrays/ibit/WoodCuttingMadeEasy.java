package arrays.ibit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WoodCuttingMadeEasy {

	public static void main(String[] args) {
		Integer[] arr = {114, 55, 95, 131, 77, 111, 141};
		ArrayList arrList = (ArrayList) Stream.of(arr).collect(Collectors.toList());
		System.out.println((new WoodCuttingMadeEasy()).solve(arrList, 95));
	}
	
	public int solve(ArrayList<Integer> arr, int totalCut) {
        if(arr == null || arr.isEmpty())
            return 0;
            
        Collections.sort(arr);
        int start = arr.get(0), end = arr.get(arr.size()-1);
        int mid = (start + end) >> 1;
        
        while(start <= end) {
            mid = (start+end) >> 1;
            int executeCutVal = executeCut(arr, mid, totalCut);
            if(executeCutVal <= totalCut) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return end;
    }
    
    private int executeCut(ArrayList<Integer> arr, int midElementValue, int totalCut) {
        int cut=0;
        for(int i=arr.size()-1; i>=0; i--) {
            if(arr.get(i) < midElementValue || cut > totalCut)
                break;
            cut += arr.get(i) - midElementValue;
        }
        return cut;
    }
}
