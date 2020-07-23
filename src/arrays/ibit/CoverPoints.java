package arrays.ibit;

import java.util.ArrayList;

/**
 * 
 * A = [0, 1, 1] B = [0, 1, 2] points are: (0, 0), (1, 1) and (1, 2). It takes 1
 * step to move from (0, 0) to (1, 1). It takes one more step to move from (1,
 * 1) to (1, 2).
 * 
 * @author shivam.rohilla
 *
 */
public class CoverPoints {
	
	public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		if ((A == null && B == null) || (A.isEmpty() && B.isEmpty())) {
			return 0;
		}
		if (A.size() != B.size())
			return 0;

		int distance = 0;
		for (int i = 1; i < A.size(); i++) {
			int pointA = Math.abs(A.get(i) - A.get(i - 1));
			int pointB = Math.abs(B.get(i) - B.get(i - 1));
			distance += Math.max(pointA, pointB);
		}
		return distance;
	}

}
