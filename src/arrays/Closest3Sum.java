package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Closest3Sum {

	public static void main(String[] args) {
		Integer arr[] = {1, 2, 3, 4, -5};
		ArrayList<Integer> dataList = (ArrayList<Integer>) Stream.of(arr).collect(Collectors.toList());
		System.out.println("nearest diff :: "+threeSumClosestNew(dataList, 10));
		Integer arrNew[] = {2147483647, -2147483648, -2147483648, 0, 1};
		dataList = (ArrayList<Integer>) Stream.of(arrNew).collect(Collectors.toList());
		System.out.println("nearest diff :: "+threeSumClosest(dataList, 0));
		Integer arrOne[] = {8, 4, 1, 6, 3, -8, -2, 0, 2, -8, 9, 7, -4, -2, -10, 6, 2, -6, 10, 10, 2, -9, -2, 1, 6, 6, -4, -6};
		dataList = (ArrayList<Integer>) Stream.of(arrOne).collect(Collectors.toList());
		System.out.println("nearest diff :: "+threeSumClosestNew(dataList, -5));
	}

	private static Integer threeSumClosestNew(ArrayList<Integer> dataList, int sum) {
		Integer closestSum = Integer.MAX_VALUE;
		int startPtr = -1, endPtr = -1;
		for(int i=0; i<dataList.size(); i++) {
			startPtr = i+1;
			endPtr = dataList.size()-1;
			while(startPtr < endPtr) {
				int dataSum = dataList.get(i)+dataList.get(startPtr)+dataList.get(endPtr);
				if(Math.abs(sum - dataSum) < Math.abs(sum - closestSum)) {
					closestSum = dataSum;
				}
				if(dataSum > sum)
					endPtr--;
				else
					startPtr++;
			}
		}
		return closestSum;
	}

	public static int threeSumClosest(ArrayList<Integer> arr, int sum) {
        Collections.sort(arr);
        
        Integer nearestDiff = Integer.MIN_VALUE;
        for(int i=0; i<arr.size(); i++) {
            int num = arr.get(i);
            int val = sum-num;
            for(int startPtr=i+1, endPtr=arr.size()-1;startPtr<endPtr;) {
            	int diff = val - (arr.get(startPtr)+arr.get(endPtr));
                int absDiff = Math.abs(diff);
                if(nearestDiff == Integer.MIN_VALUE) {
                	nearestDiff = diff;
                	continue;
                }
                if(absDiff == Integer.MIN_VALUE) {
                	startPtr++;
                	continue;
                }
                if(Math.abs(nearestDiff) > absDiff) {
                	nearestDiff = diff;
                }
                
                if(nearestDiff < diff) {
                	endPtr--;
                } else {
                	startPtr++;
                }
            }
        }
        
        return sum-nearestDiff;
    }
}
