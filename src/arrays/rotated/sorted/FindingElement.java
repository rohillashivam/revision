package arrays.rotated.sorted;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindingElement {

	public static void main(String[] args) {
		Integer[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
		List<Integer> arrList = Stream.of(arr).collect(Collectors.toList());
		FindingElement findingElement = new FindingElement();
		System.out.println(findingElement.search(arrList, 6));
		System.out.println(findingElement.searchOptimised(arrList, 6));
	}

	private int searchOptimised(List<Integer> arrList, int num) {
		int i = 0;
		int j = arrList.size() - 1;

		while (i <= j) {
			int mid = (i + j) / 2;

			if (arrList.get(mid) == num)
				return mid;
			if (arrList.get(mid) >= arrList.get(i)) {
				if (num >= arrList.get(i) && num < arrList.get(mid))
					j = mid - 1;
				else
					i = mid + 1;
			} else {
				if (num > arrList.get(mid) && num <= arrList.get(j))
					i = mid + 1;
				else
					j = mid - 1;
			}
		}
		return -1;
	}

	public int search(final List<Integer> arr, int num) {
		if (arr == null || arr.isEmpty())
			return -1;

		// return searchLinear(arr, num);

		int pivot = findPivot(arr, 0, arr.size() - 1);
		if (pivot == -1)
			return binarySearchElement(arr, 0, arr.size() - 1, num);

		if (arr.get(pivot) == num)
			return pivot;

		if (num > arr.get(0) && num > arr.get(pivot))
			return binarySearchElement(arr, 0, pivot - 1, num);

		return binarySearchElement(arr, pivot, arr.size() - 1, num);
	}

	private int searchLinear(List<Integer> arr, int num) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == num)
				return i;
		}
		return -1;
	}

	private int binarySearchElement(List<Integer> arr, int start, int end, int num) {
		if (end < start)
			return -1;

		int mid = (start + end) / 2;

		if (arr.get(mid) == num)
			return mid;

		if (arr.get(mid) < num)
			return binarySearchElement(arr, mid + 1, end, num);
		else
			return binarySearchElement(arr, start, mid - 1, num);
	}

	private int findPivot(List<Integer> arr, int start, int end) {
		if (end <= start)
			return -1;
		int mid = (start + end) / 2;

		if (mid != 0 && arr.get(mid) == arr.get(mid - 1)) {
			while (arr.get(mid) == arr.get(mid - 1)) {
				mid--;
			}
		}

		if (mid != 0 && arr.get(mid) < arr.get(mid - 1))
			return mid;

		if (mid != arr.size() - 1 && arr.get(mid) > arr.get(mid + 1)) {
			while (arr.get(mid) == arr.get(mid - 1)) {
				mid++;
			}
		}
		if (mid != arr.size() - 1 && arr.get(mid) > arr.get(mid + 1))
			return mid + 1;

		if (arr.get(mid) < arr.get(mid + 1)) {
			return findPivot(arr, mid + 1, end);
		}

		return findPivot(arr, start, mid - 1);
	}
}
