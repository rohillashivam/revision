package dp.ibit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestSubSequenceLength {
	
	public static void main(String[] args) {
		LongestSubSequenceLength lssl = new LongestSubSequenceLength();
		Integer[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
		List<Integer> arrList = Stream.of(arr).collect(Collectors.toList());
		System.out.println(lssl.longestSubsequenceLength(arrList));
		Integer[] arr1 = {1, 2, 1};
		arrList = Stream.of(arr1).collect(Collectors.toList());
		System.out.println(lssl.longestSubsequenceLength(arrList));
		Integer[] arr2 = {8, 6, 3, 4, 2, 1};
		arrList = Stream.of(arr2).collect(Collectors.toList());
		System.out.println(lssl.longestSubsequenceLength(arrList));
	}

	public int longestSubsequenceLength(final List<Integer> arr) {
        if(arr ==null || arr.isEmpty())
            return 0;
        int incr = lis(arr, 0, Integer.MIN_VALUE);
        if(incr == 1)
        	return incr + lds(arr, arr.size()-1, Integer.MIN_VALUE, true);
        return incr + lds(arr, arr.size()-1, Integer.MIN_VALUE, false);
    }

	private int lis(List<Integer> arr, int index, int lastMax) {
		if(index > arr.size()/2-1)
			return 0;

		if(arr.get(index) > lastMax)
			return 1 + lis(arr, index+1, arr.get(index));
		
		return Math.max(lis(arr, index+1, lastMax), 
				lis(arr, index+1, arr.get(index)));
		
	}

	private int lds(List<Integer> arr, int index, int lastMax, boolean complete) {
		if(!complete && index < arr.size()/2) {
			return 0;
		}
		if(complete && index == 0)
			return 0;
		
		if(arr.get(index) > lastMax)
			return 1 + lds(arr, index-1, arr.get(index), complete);
		
		return Math.max(lds(arr, index-1, lastMax, complete), 
				lds(arr, index-1, arr.get(index), complete));
	}
}
