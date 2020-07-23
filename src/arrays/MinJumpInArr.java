package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinJumpInArr {

	public static void main(String[] args) {
		/*
		  Integer[] arr = { 33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17,
		  34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0,
		  2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1,
		  0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0,
		  11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0,
		  42, 15, 25, 0, 41, 2, 48, 28 };
		 */
		Integer[] arr = {2,3,1,1,4};
		/*Integer[] arr = { 9, 0, 0, 22, 0, 0, 39, 11, 3, 0, 0, 24, 1, 0, 50, 23, 3, 44, 0, 23, 2, 8, 20, 35, 0, 40, 34,
				26, 36, 0, 35, 19, 20, 18, 11, 43, 19, 21, 40, 0, 14, 0, 14, 0, 0, 25, 35, 24, 49, 15, 13, 3, 0, 10, 31,
				25, 27, 37, 27, 43, 44, 27, 8, 43, 0, 0, 33, 25, 19, 47, 0, 29, 5, 2, 12, 8, 7, 0, 16, 36, 0, 6, 17, 35,
				36, 21, 0, 9, 1, 0, 43, 29, 39, 15, 18, 0, 34, 26, 48, 0, 34, 35, 7, 10, 0, 0, 15, 5, 12, 26, 0, 37, 30,
				33, 27, 34, 9, 37, 22, 0, 0, 24, 30, 0, 0, 38, 23, 25, 0, 30, 39, 24, 31, 0, 6, 19, 25, 0, 28, 15, 8, 0,
				48, 0, 35, 41, 0, 24, 1, 41, 31, 0, 35, 21, 15, 26, 15, 27, 4, 0, 8, 4, 0, 0, 2, 42, 18, 0, 28, 18, 49,
				34, 5, 10, 41, 48, 26, 14, 45, 44, 9, 0, 49, 50, 24, 0, 0, 0, 23, 0, 17, 0, 47, 31, 0, 42, 0, 0, 0, 40,
				46, 22, 50, 32, 20, 3, 44, 22, 0, 37, 25, 0, 19, 26, 14, 23, 27, 41, 0, 1, 13, 0, 48, 20, 37, 8, 0, 18,
				0, 26, 12, 19, 32, 19, 22, 0, 0, 0, 0, 0, 16, 0, 0, 43, 0, 10, 5, 0, 6, 26, 0, 24, 40, 29, 0, 43, 18,
				27, 0, 0, 37, 0, 46, 35, 17, 0, 20, 44, 29, 29, 40, 33, 22, 27, 0, 0, 38, 21, 4, 0, 0, 15, 31, 48, 36,
				10, 0, 41, 0, 45, 39, 0, 11, 9, 3, 38, 16, 0, 11, 22, 37, 0, 3, 44, 10, 12, 47, 22, 32, 7, 24, 1, 0, 22,
				25, 0, 14, 0, 0, 0, 23, 0, 36, 1, 42, 46, 0, 48, 0, 33, 5, 27, 45, 0, 15, 29, 0, 50, 2, 31, 25, 6, 36,
				19, 10, 23, 0, 37, 4, 1, 7, 12, 0, 0, 49 };
		*/
		/*Integer[] arr = { 0, 46, 46, 0, 2, 47, 1, 24, 45, 0, 0, 24, 18, 29, 27, 11, 0, 0, 40, 12, 4, 0, 0, 0, 49, 42,
				13, 5, 12, 45, 10, 0, 29, 11, 22, 15, 17, 41, 34, 23, 11, 35, 0, 18, 47, 0, 38, 37, 3, 37, 0, 43, 50, 0,
				25, 12, 0, 38, 28, 37, 5, 4, 12, 23, 31, 9, 26, 19, 11, 21, 0, 0, 40, 18, 44, 0, 0, 0, 0, 30, 26, 37, 0,
				26, 39, 10, 1, 0, 0, 3, 50, 46, 1, 38, 38, 7, 6, 38, 27, 7, 25, 30, 0, 0, 36, 37, 6, 39, 40, 32, 41, 12,
				3, 44, 44, 39, 2, 26, 40, 36, 35, 21, 14, 41, 48, 50, 21, 0, 0, 23, 49, 21, 11, 27, 40, 47, 49 };
		*/
		ArrayList<Integer> listArr = (ArrayList<Integer>) Stream.of(arr).collect(Collectors.toList());
		System.out.println(minJump(listArr, 0));
		System.out.println(minJumpNew(listArr));
		System.out.println("--------------");
		Integer[] arr1 = {1, 4, 3, 7, 1, 2, 6, 7, 6, 10};
		listArr = (ArrayList<Integer>) Stream.of(arr1).collect(Collectors.toList());
		System.out.println(minJumpNew(listArr));
	}

	private static int minJumpNew(ArrayList<Integer> listArr) {
		int maxReach = listArr.get(0);
		if(maxReach == 0)
			return 0;
		int stairs = maxReach;
		int jump = 1;
		for(int level=1; level<listArr.size(); level++) {
			/*if(maxReach == i && listArr.get(i) != 0) {
				maxReach += i;
				jump++;
			}
			if(maxReach < listArr.size()-1 && i+listArr.get(i) > maxReach) {
				maxReach = i+listArr.get(i);
				jump++;
			}*/
			if(level == listArr.size() - 1)
				return jump;
			if(maxReach < listArr.size()-1 && level + listArr.get(level) > maxReach) {
				maxReach = level + listArr.get(level);
			}
			stairs--;
			if(stairs == 0) {
				jump++;
				stairs = maxReach - level;
			}
		}
		return jump;
	}

	private static Map<Integer, Integer> cache = new HashMap<>();

	public static int minJump(ArrayList<Integer> arr, Integer currIndex) {
		if (currIndex >= arr.size())
			return 0;
		int val = arr.get(currIndex);
		Integer minValue = Integer.MAX_VALUE - 1000;
		if(val == 0)
			return -1;
		for (int i = val; i >= 1; i--) {
			int newIndex = currIndex + i;
			if (!cache.containsKey(newIndex)) {
				cache.put(newIndex, minJump(arr, newIndex));
			}
			minValue = Math.min(minValue, cache.get(newIndex));
		}
		return 1 + minValue;
		// return arr.get(currIndex) + minJump(arr, );
	}
}
