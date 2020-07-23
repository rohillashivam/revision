package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] arr = {100, 4, 99, 1, 3, 2, 101};
		int maxLength = printLongestConsecutiveSequence(arr);
		System.out.println("max length :: "+maxLength);
	}

	private static int printLongestConsecutiveSequence(int[] arr) {
		if(arr==null || arr.length==0)
			return 0;
		
		Map<Integer, Integer> intSet = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			intSet.put(arr[i], i);
		}
		
		Set<Integer> visitedIndex = new HashSet<>();
		Integer maxLength = Integer.MIN_VALUE;
		List<Integer> numIndexList = new LinkedList<Integer>();
		List<Integer> maxLengthSequence = null;
		for(int i=0; i<arr.length; i++) {
			if(visitedIndex.contains(i))
				continue;
			numIndexList.add(i);
			int num = arr[i];
			int length = 1;
			int consecutiveNum = num - 1;
			while(intSet.containsKey(consecutiveNum) && !visitedIndex.contains(intSet.get(consecutiveNum))) {
				visitedIndex.add(intSet.get(consecutiveNum));
				length++;
				numIndexList.add(intSet.get(consecutiveNum));
				consecutiveNum--;
			}
			visitedIndex.add(i);
			consecutiveNum=num+1;
			while(intSet.containsKey(consecutiveNum) && !visitedIndex.contains(intSet.get(consecutiveNum))) {
				visitedIndex.add(intSet.get(consecutiveNum));
				length++;
				numIndexList.add(intSet.get(consecutiveNum));
				consecutiveNum++;
			}
			
			
			if(maxLength < length) {
				maxLength = length;
				maxLengthSequence = new ArrayList<>(numIndexList);
				numIndexList.clear();
			}
		}
		maxLengthSequence.forEach(data -> System.out.println(arr[data]));
		return maxLength;
	}
}
