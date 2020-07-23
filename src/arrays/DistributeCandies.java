package arrays;

public class DistributeCandies {

	public static void main(String[] args) {
		//int n = 45, k = 3;
		int n = 45, k = 3;
		candies(n, k);
	}

	private static void candies(int n, int k) {
		// Count number of complete turns
		int count = 0;

		// Stores the number of candies
		int[] arr = new int[k];

		for (int i = 0; i < k; i++)
			arr[i] = 0;

		int low = 0, high = n;

		// Do a binary search to find the number whose
		// sum is less than N.
		while (low <= high) {

			// Get mide
			int mid = (low + high) >> 1;
			int sum = (mid * (mid + 1)) >> 1;

			// If sum is below N
			if (sum <= n) {

				// Find number of complete turns
				count = mid / k;

				// Right halve
				low = mid + 1;
			} else {

				// Left halve
				high = mid - 1;
			}
		}

		// Last term of last complete series
		int last = (count * k);

		// Subtract the sum till
		n -= (last * (last + 1)) / 2;

		int j = 0;

		// First term of incomplete series
		int term = (count * k) + 1;

		while (n > 0) {
			if (term <= n) {
				arr[j++] = term;
				n -= term;
				term++;
			} else {
				arr[j] += n;
				n = 0;
			}
		}

		// Count the total candies
		for (int i = 0; i < k; i++)
			arr[i] += (count * (i + 1)) + (k * (count * (count - 1)) / 2);

		// Print the total candies
		for (int i = 0; i < k; i++)
			System.out.print(arr[i] + " ");
	}
}
