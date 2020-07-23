package arrays;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// need to do again good question
public class MaximumUnsortedSubArray {

	public static void main(String[] args) {
		Integer arr[] = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
		ArrayList<Integer> arrList = (ArrayList<Integer>) Stream.of(arr).collect(Collectors.toList());
		subUnsort(arrList);
		Integer arrNew[] = { 1, 3, 2, 4, 5 };
		arrList = (ArrayList<Integer>) Stream.of(arrNew).collect(Collectors.toList());
		subUnsort(arrList);
	}

	public static ArrayList<Integer> subUnsort(ArrayList<Integer> arr) {
		int start = -1;
		for (int i = 0; i < arr.size()-1; i++) {
			if (arr.get(i) > arr.get(i + 1)) {
				start = i;
				break;
			}
		}
		if (start == -1) {
			ArrayList<Integer> listArr = new ArrayList<>();
			listArr.add(-1);
			return listArr;
		}

		int end = arr.size();
		for (int i = arr.size() - 1; i > 0; i--) {
			if (arr.get(i) < arr.get(i - 1)) {
				end = i;
				break;
			}
		}

		if (end == arr.size()) {
			ArrayList<Integer> listArr = new ArrayList<>();
			listArr.add(-1);
			return listArr;
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=start; i<=end;i++) {
			if(arr.get(i) > max)
				max = arr.get(i);
			if(arr.get(i) < min)
				min = arr.get(i);
		}
		
		// for identifying if any index before start
		for(int i=0; i<start; i++) {
			if(arr.get(i) > min) {
				start = i;
				break;
			}
		}
		// for identifying if any index after end
		for(int i=arr.size()-1; i>=end; i--) {
			if(arr.get(i) < max) {
				end = i;
				break;
			}
		}
		
		System.out.println("start :: "+start+" and end :: "+end);

		return null;
	}
}
