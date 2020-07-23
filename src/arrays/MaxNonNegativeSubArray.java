package arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, -7, 2, 3 };
		ArrayList<Integer> data = (ArrayList<Integer>) Stream.of(1, 2, 5, -7, 2, 3).collect(Collectors.toList());
		ArrayList<Integer> dataList = maxSet(data);
		printDataList(dataList);

		data = (ArrayList<Integer>) Stream.of(-1, -1, -1, -1, -1, -1).collect(Collectors.toList());
		dataList = maxSet(data);
		printDataList(dataList);

		data = (ArrayList<Integer>) Stream.of(0, 0, 0, -1, 0, 0).collect(Collectors.toList());
		dataList = maxSet(data);
		printDataList(dataList);

		data = (ArrayList<Integer>) Stream.of(1967513926, 1540383426, -1303455736, -521595368)
				.collect(Collectors.toList());
		dataList = maxSet(data);
		printDataList(dataList);

		data = (ArrayList<Integer>) Stream.of(756898537, -1973594324, -2038664370, -184803526, 1424268980)
				.collect(Collectors.toList());
		dataList = maxSet(data);
		printDataList(dataList);
		// A : [ 24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716,
		// 54438, -51501, 83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142,
		// 27968, -260, 41594, 16395, 19113, 71006, -97942, 42082, -30767, 85695, -73671
		// ]

		data = (ArrayList<Integer>) Stream.of(24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438,
				-51501, 83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395, 19113,
				71006, -97942, 42082, -30767, 85695, -73671).collect(Collectors.toList());
		dataList = maxSet(data);
		printDataList(dataList);

		// A : [ 24831, 53057, 19790, -10679, 77006, -36098, 75319, -45223, -56760,
		// -86126, -29506, 76770, 29094, 87844, 40534, -15394, 18738, 59590, -45159,
		// -64947, 7217, -55539, 42385, -94885, 82420, -31968, -99915, 63534, -96011,
		// 24152, 77295 ]
		data = (ArrayList<Integer>) Stream.of(24831, 53057, 19790, -10679, 77006, -36098, 75319, -45223, -56760, -86126,
				-29506, 76770, 29094, 87844, 40534, -15394, 18738, 59590, -45159, -64947, 7217, -55539, 42385, -94885,
				82420, -31968, -99915, 63534, -96011, 24152, 77295).collect(Collectors.toList());
		dataList = maxSet(data);
		printDataList(dataList);
	}

	private static void printDataList(ArrayList<Integer> dataList) {
		if (dataList == null || dataList.isEmpty())
			return;
		for (Integer data : dataList) {
			System.out.print(data + " ");
		}
		System.out.println();
	}

	public static ArrayList<Integer> maxSet(ArrayList<Integer> arrList) {
		if (arrList == null || arrList.isEmpty())
			return arrList;

		ArrayList<Integer> arrListData = new ArrayList<>();
		ArrayList<Integer> arrListDataNew = new ArrayList<>();
		BigInteger sum = BigInteger.ZERO, maxSum = BigInteger.ZERO;

		for (Integer val : arrList) {
			if (val < 0) {
				if ((maxSum.compareTo(sum) < 0)
						|| (maxSum.compareTo(sum) == 0 && arrListDataNew.size() > arrListData.size())) {
					arrListData = new ArrayList<>(arrListDataNew);
					maxSum = sum;
				}
				sum = BigInteger.ZERO;
				arrListDataNew.clear();
				continue;
			}
			sum = sum.add(new BigInteger(String.valueOf(val)));
			// sum += val;
			arrListDataNew.add(val);
		}
		if ((maxSum.compareTo(sum) < 0) || (maxSum.compareTo(sum) == 0 && arrListDataNew.size() > arrListData.size()))
			arrListData = new ArrayList<>(arrListDataNew);

		return arrListData;
	}

	public ArrayList<Integer> maxset(ArrayList<Integer> arrList) {
		if (arrList == null || arrList.isEmpty())
			return arrList;

		Map<Integer, List<Integer>> sumMap = new TreeMap<>();

		int sum = 0;
		for (Integer val : arrList) {
			sum += val;
			List<Integer> indexList = null;
			if (sumMap.containsKey(sum)) {
				indexList = sumMap.get(sum);
			} else {
				indexList = new ArrayList<>();
			}
			indexList.add(val);
			sumMap.put(sum, indexList);
		}

		return null;
	}
}
