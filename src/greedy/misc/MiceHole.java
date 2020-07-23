package greedy.misc;

import java.util.Arrays;

// TODO after 2-3 days
public class MiceHole {

	public static void main(String[] args) {
		int[] mice = new int[] {4, -4, 2}; // -- {-4, 2, 4}
		int[] holes = new int[] {4, 0, 5}; // -- {0, 4, 5}
		
		System.out.println(timeToAssignMiceHoles(mice, holes));
		
		int[] miceNew = new int[] {-49, 58, 72, -78, 9, 65, -42, -3 };
		int[] holesNew = new int[] {30, -13, -70, 58, -34, 79, -36, 27};
		System.out.println(timeToAssignMiceHoles(miceNew, holesNew));
	}

	private static int timeToAssignMiceHoles(int[] mice, int[] holes) {
		if(mice == null || holes == null || mice.length != holes.length)
			return 0;
		
		Arrays.sort(mice);
		Arrays.sort(holes);
		
		int timeTaken = 0;
		for(int i=0; i<mice.length; i++) {
			if(holes[i] - mice[i] > 0) {
				timeTaken = Math.max(timeTaken, holes[i] - mice[i]);
			} else {
				timeTaken = Math.max(timeTaken,mice[i] - holes[i]);
			}
		}
		return timeTaken;
	}
}
