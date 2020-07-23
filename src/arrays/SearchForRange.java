package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchForRange {

	private static int startPos = -1;
	private static int endPos = -1;

	public static void main(String[] args) {
		Integer[] arr = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
				6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8,
				8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
				10, 10, 10 };
		ArrayList<Integer> arrList = (ArrayList<Integer>) Stream.of(arr).collect(Collectors.toList());
		ArrayList<Integer> resultList = searchRange(arrList, 10);
		for (Integer res : resultList) {
			System.out.println(res);
		}

		Integer[] arr1 = { 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9,
				10, 10, 10 };
		arrList = (ArrayList<Integer>) Stream.of(arr1).collect(Collectors.toList());
		resultList = searchRange(arrList, 1);
		for (Integer res : resultList) {
			System.out.println(res);
		}
	}

	public static ArrayList<Integer> searchRange(final List<Integer> arr, int num) {
		startFound = false;endFound=false;
        startPos=-1; endPos=-1;
		ArrayList<Integer> resultList = new ArrayList<>();
		if (arr == null || arr.isEmpty()) {
			resultList.add(-1);
			return resultList;
		}
		if (arr.size() == 1 && arr.get(0) == num) {
			resultList.add(0);
			resultList.add(0);
			return resultList;
		}
		searchElements(arr, num, 0, arr.size() - 1);

		if (startFound && endFound) {
			resultList.add(startPos);
			resultList.add(endPos);
		} else {
			resultList.add(-1);
			resultList.add(-1);
		}
		return resultList;
	}

	private static boolean startFound = false;
	private static boolean endFound = false;

	private static void searchElements(List<Integer> arr, int num, int start, int end) {
		if (end < start)
			return;

		int mid = (start + end) >> 1;
		if (arr.get(mid) == num) {
			if ((mid > 0 && arr.get(mid - 1) != num) || mid == 0) {
				startPos = mid;
				startFound = true;
			}
			if ((mid < arr.size() - 1 && arr.get(mid + 1) != num) || mid == arr.size() - 1) {
				endPos = mid;
				endFound = true;
			}

			if (endFound && startFound)
				return;

			if (!startFound)
				searchElements(arr, num, start, mid - 1);
			if (!endFound)
				searchElements(arr, num, mid + 1, end);
		}

		if (num > arr.get(mid)) {
			searchElements(arr, num, mid + 1, end);
		} else {
			searchElements(arr, num, start, mid - 1);
		}
	}
	
	public ArrayList<Integer> searchRangeIBIT(final List<Integer> a, int b) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(getIndex(a, b, 0));
        ans.add(getIndex(a, b, 1));
        return ans;
    }
    public int getIndex(List<Integer> a, int b, int i) {
        int low = 0, high = a.size() - 1, mid = 0;
        int ans = -1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if((int)a.get(mid) == b)
                ans = mid;
            if(i == 0)
                if((int)a.get(mid) < b ) 
                    low = mid + 1;
                else
                    high = mid - 1;
            else
                if((int)a.get(mid) <= b ) 
                    low = mid + 1;
                else
                    high = mid - 1;
        }
        return ans;
    }
}
