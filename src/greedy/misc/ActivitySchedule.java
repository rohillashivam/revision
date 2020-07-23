package greedy.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ActivitySchedule {

	public static void main(String[] args) {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int finish[] = { 2, 4, 6, 7, 9, 9 };

		int maxActivity = maxActivityScheduled(start.clone(), finish.clone());
		System.out.println("Activity count :: " + maxActivity);

		printActivitySelection(start, finish);

	}

	private static void printActivitySelection(int[] start, int[] finish) {
		if(start == null || start.length == 0 || finish == null || finish.length == 0)
			return;
		
		Activity[] activityList = buildActivityArr(start, finish);
		Arrays.sort(activityList, (act1, act2) -> act1.getFinish().compareTo(act2.getFinish()));
		
		List<Integer> indexArr = new LinkedList<>();
		indexArr.add(0); 
		int j=0;
		for(int i=1; i<activityList.length; i++) {
			if(activityList[i].getStart() >= activityList[j].getFinish()) {
				indexArr.add(i);
				j=i;
			}
		}
		System.out.println("Activity selected");
		for(int i=0; i<indexArr.size(); i++) {
			System.out.println(indexArr.get(i));
		}
	}


	private static Activity[] buildActivityArr(int[] start, int[] finish) {
		if(start.length != finish.length)
			return null;
		
		int length = start.length;
		Activity[] activityList = new Activity[length];
		for(int i=0; i<length; i++) {
			Activity activity = new Activity(start[i], finish[i]);
			activityList[i] = activity;
		}
		return activityList;
	}

	private static int maxActivityScheduled(int[] start, int[] finish) {
		if (start == null || start.length == 0 || finish == null || finish.length == 0)
			return 0;
		int maxActivity = Integer.MIN_VALUE, activityCount = 1;
		int i = 1, j = 0;
		Arrays.sort(start);
		Arrays.sort(finish);
		int length = start.length;
		while (i < length || j < length) {
			if (i < length && (start[i] < finish[j])) {
				activityCount++;
				i++;
			} else {
				j++;
				activityCount--;
			}
			if (activityCount > maxActivity)
				maxActivity = activityCount;
		}
		return maxActivity;
	}

}

class Activity {
	private final Integer start;
	private final Integer finish;

	public Activity(Integer start, Integer finish) {
		this.start = start;
		this.finish = finish;
	}

	public Integer getStart() {
		return start;
	}

	public Integer getFinish() {
		return finish;
	}
	
}
