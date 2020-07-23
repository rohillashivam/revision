package stackqueue.ibit;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LargestRectangleArea {

	public static void main(String[] args) {
		LargestRectangleArea lra = new LargestRectangleArea();
		Integer arr[] = { 90, 58, 69, 70, 82, 100, 13, 57, 47, 18 };
		// System.out.println(getMaxArea(arr, arr.length-1));
		ArrayList<Integer> arrList = (ArrayList<Integer>) Stream.of(arr).collect(Collectors.toList());
		System.out.println(lra.largestRectangleArea(arrList));
		arrList.clear();
		arrList.add(1);
		System.out.println(lra.largestRectangleArea(arrList));
		Integer[] arr1 = { 6, 2, 5, 4, 5, 1, 6 };
		arrList = (ArrayList<Integer>) Stream.of(arr1).collect(Collectors.toList());
		System.out.println(lra.largestRectangleArea(arrList));
		Integer[] arr2 = { 47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72,
				87, 52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100,
				28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44,
				18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27 };
		arrList = (ArrayList<Integer>) Stream.of(arr2).collect(Collectors.toList());
		System.out.println(lra.largestRectangleArea(arrList));
	}

	public int largestRectangleArea(ArrayList<Integer> arr) {
		if (arr == null || arr.isEmpty())
			return 0;
		Stack<Integer> stack = new Stack<>();

		int index = 0, length = arr.size();
		int max = 0;
		while (index < length) {
			if (stack.isEmpty() || arr.get(stack.peek()) <= arr.get(index)) {
				stack.push(index);
				index++;
			} else {
				int currIndex = stack.pop();
				//int currArrIndexArea = arr.get(currIndex);
				int areaTillNow = (stack.isEmpty() ? index : index - stack.peek() - 1) * arr.get(currIndex);
				//max = Math.max(Math.max(currArrIndexArea, areaTillNow), max);
				max = Math.max(max, areaTillNow);
			}
		}
		if (!stack.isEmpty()) {
			int currIndex = stack.pop();
			max = Math.max(Math.max(arr.get(currIndex) * 1,
					(stack.isEmpty() ? index : index - stack.peek() - 1) * arr.get(currIndex)), max);
		}
		return max;
	}

	static int getMaxArea(Integer hist[], int n) {
		// Create an empty stack. The stack holds indexes of hist[] array
		// The bars stored in stack are always in increasing order of their
		// heights.
		Stack<Integer> s = new Stack<>();

		int max_area = 0; // Initialize max area
		int tp; // To store top of stack
		int area_with_top; // To store area with top bar as the smallest bar

		// Run through all bars of given histogram
		int i = 0;
		while (i < n) {
			// If this bar is higher than the bar on top stack, push it to stack
			if (s.empty() || hist[s.peek()] <= hist[i])
				s.push(i++);

			// If this bar is lower than top of stack, then calculate area of rectangle
			// with stack top as the smallest (or minimum height) bar. 'i' is
			// 'right index' for the top and element before top in stack is 'left index'
			else {
				tp = s.peek(); // store the top index
				s.pop(); // pop the top

				// Calculate the area with hist[tp] stack as smallest bar
				area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

				// update max area, if needed
				if (max_area < area_with_top)
					max_area = area_with_top;
			}
		}

		// Now pop the remaining bars from stack and calculate area with every
		// popped bar as the smallest bar
		while (s.empty() == false) {
			tp = s.peek();
			s.pop();
			area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

			if (max_area < area_with_top)
				max_area = area_with_top;
		}

		return max_area;
	}

	/**
	 * InterviewBit Solution
	 */
	public int largestRectangleAreaIBIT(ArrayList<Integer> A) {

		Stack<Integer> st = new Stack<>();
		int curr = 0;
		int area = 0;

		st.push(curr++);

		while (curr < A.size()) {
			while (!st.isEmpty() && (A.get(curr) < A.get(st.peek()))) { // we found smaller element than TOS
				int tosIndex = st.pop(); // pop the TOS , we are considering it as minimum height and ll find area for
											// it

				// if stack is empty after popping : then no smaller bar on left hand side of
				// TOS , so multiply it with curr
				// index bcz it will cover overall region including left hand side : bcz its a
				// right bound
				if (st.isEmpty()) {
					int width = curr;
					area = Math.max(area, A.get(tosIndex) * width);
				} else {
					// if stck is not empty after popping the element means we hv stored smaller bar
					// tht is thr on lhs of it
					// so width would be between rhs smaller bar (curr) - lhs smaller bar (tos now)
					// -1
					int width = curr - st.peek() - 1;
					area = Math.max(area, A.get(tosIndex) * width);
				}
			}

			// if upcoming bar is larger than TOS then push it onto the stack bcz tht means
			// stack elements can expand themselves into
			// this larger bar
			st.push(curr++);

		}

		// corner case is : if stack is not empty that means we hv elements in ascending
		// height of bars into the stack : so just pop elements one by one and calculate
		// area
		// for them : u hv smaller bar below them and consider rightmost smaller bar as
		// 'curr'
		// as ther is no rightmost smaller bar so it cn expand till end
		if (!st.isEmpty()) {
			int t = -1;

			while (!st.isEmpty()) {
				t = st.pop();

				if (st.isEmpty()) {
					int width = curr;
					area = Math.max(area, A.get(t) * width);
				} else {
					// if stck is not empty after popping the element means we hv stored smaller bar
					// tht is thr on lhs of it
					// so width would be between rhs smaller bar (curr) - lhs smaller bar (tos now)
					// -1
					int width = curr - st.peek() - 1;
					area = Math.max(area, A.get(t) * width);
				}
			}

		}

		return area;
	}
}
