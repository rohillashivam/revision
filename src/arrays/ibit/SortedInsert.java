package arrays.ibit;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortedInsert {

	public static void main(String[] args) {
		Integer[] arr = { 3, 4, 18, 19, 20, 27, 28, 31, 36, 42, 44, 71, 72, 75, 82, 86, 88, 97, 100, 103, 105, 107, 110,
				116, 118, 119, 121, 122, 140, 141, 142, 155, 157, 166, 176, 184, 190, 199, 201, 210, 212, 220, 225, 234,
				235, 236, 238, 244, 259, 265, 266, 280, 283, 285, 293, 299, 309, 312, 317, 335, 341, 352, 354, 360, 365,
				368, 370, 379, 386, 391, 400, 405, 410, 414, 416, 428, 433, 437, 438, 445, 453, 457, 458, 472, 476, 480,
				485, 489, 491, 493, 501, 502, 505, 510, 511, 520, 526, 535, 557, 574, 593, 595, 604, 605, 612, 629, 632,
				633, 634, 642, 647, 653, 654, 656, 658, 686, 689, 690, 691, 709, 716, 717, 737, 738, 746, 759, 765, 775,
				778, 783, 786, 787, 791, 797, 801, 806, 815, 820, 822, 823, 832, 839, 841, 847, 859, 873, 877, 880, 886,
				904, 909, 911, 917, 919, 937, 946, 948, 951, 961, 971, 979, 980, 986, 993 };
		
		ArrayList<Integer> dataList = (ArrayList<Integer>) Stream.of(arr).collect(Collectors.toList());
		System.out.println(new SortedInsert().searchInsert(dataList, 902));

	}

	public int searchInsert(ArrayList<Integer> a, int b) {
		if (a == null || a.isEmpty())
			return 0;

		return findIndex(a, b, 0, a.size() - 1);
	}

	private int findIndex(ArrayList<Integer> a, int b, int start, int end) {
		if (start == end) {
			if (b > a.get(start)) {
				return start + 1;
			} else if (b == a.get(start)) {
				return start;
			} else {
				if (start == 0)
					return 0;
				else
					return start;
			}
		}

		int mid = (start + end) >> 1;
		if (a.get(mid) == b)
			return mid;

		if (a.get(mid) > b) {
			return findIndex(a, b, 0, mid - 1);
		} else {
			return findIndex(a, b, mid + 1, end);
		}
	}
}
