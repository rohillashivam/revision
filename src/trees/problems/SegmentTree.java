package trees.problems;

public class SegmentTree {
	
	public static void main(String[] args) {
		int[] arr = {5, 2, 7, 1 ,3};
		int[] st = new int[2*arr.length-1];
		constructSegmentTree(arr, 0, arr.length -1, st, 0);
		for (int i = 0; i < st.length; i++) {
			System.out.print(st[i]+" ");
		}
		System.out.println();
		System.out.println(rangeMinQuery(st, 0, st.length-1, 0, 2, 0));
	}

	private static int rangeMinQuery(int[] st, int low, int high, int lowQ, int highQ, int pos) {
		if(lowQ <= low && highQ >= high) {
			return st[pos];
		} 
		if(lowQ > high || highQ < low)
			return Integer.MAX_VALUE;
		int mid = (low+high)/2;
		return Math.min(rangeMinQuery(st, low, mid, lowQ, highQ, 2*pos + 1), 
				rangeMinQuery(st, mid+1, high, lowQ, highQ, 2*pos + 2));
	}

	private static int constructSegmentTree(int[] arr, int start, int end, int[] st, int si) {
		if(start == end) {
			st[si] = arr[start];
			return arr[start];
		}
		//if(end < start)
		//	return Integer.MAX_VALUE;
		int mid = (start+end) >> 1;
		
		st[si] = Math.min(constructSegmentTree(arr, start, mid, st, 2*si+1),
				constructSegmentTree(arr, mid+1, end, st, 2*si+2));
		return st[si];
	}


}
