package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDistance {

	public int maximumGap(final List<Integer> arr) {
		if (arr == null || arr.isEmpty())
			return -1;

		if (arr.size() == 1)
			return 0;

		int maxDiff = Integer.MIN_VALUE;
		List<Pair> pairList = new ArrayList<>(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			Pair pair = new Pair(arr.get(i), i);
			pairList.add(pair);
		}
		Collections.sort(pairList, (obj1, obj2) -> obj1.value.compareTo(obj2.value));

		int i = 0, j = 1;
		while (i < arr.size() && j < arr.size()) {
			Pair pairI = pairList.get(i);
			Pair pairJ = pairList.get(j);
			if (pairJ.index < pairI.index) {
				i++;
			} else {
				j++;
				if (pairJ.value >= pairI.value) {
					maxDiff = Math.max(maxDiff, pairJ.index - pairI.index);
				}
			}
		}

		if (maxDiff == Integer.MIN_VALUE)
			return -1;
		return maxDiff;
	}

	public int maximumGapIBIT(final List<Integer> arr) {
		int maxDiff;
		int i, j;
		int n = arr.size();

		int[] LMin = new int[n];
		int[] RMax = new int[n];

		/*
		 * Construct LMin[] such that LMin[i] stores the minimum value from (arr[0],
		 * arr[1], ... arr[i])
		 */
		LMin[0] = arr.get(0);
		for (i = 1; i < n; ++i)
			LMin[i] = Math.min(arr.get(i), LMin[i - 1]);

		/*
		 * Construct RMax[] such that RMax[j] stores the maximum value from (arr[j],
		 * arr[j+1], ..arr[n-1])
		 */
		RMax[n - 1] = arr.get(n - 1);
		for (j = n - 2; j >= 0; --j)
			RMax[j] = Math.max(arr.get(j), RMax[j + 1]);

		/*
		 * Traverse both arrays from left to right to find optimum j - i This process is
		 * similar to merge() of MergeSort
		 */
		i = 0;
		j = 0;
		maxDiff = 0;
		while (j < n && i < n) {
			if (LMin[i] <= RMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}

		return maxDiff;
	}

}

class Pair {
	Integer value;
	Integer index;

	public Pair(Integer value, Integer index) {
		this.value = value;
		this.index = index;
	}
}
