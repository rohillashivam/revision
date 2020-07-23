package arrays;

import java.util.LinkedList;
import java.util.Queue;

public class VisitAllPetrolPump {

	public static void main(String[] args) {
		PetrolDistance[] petrolDistanceArr = new PetrolDistance[4];
		petrolDistanceArr[0] = new PetrolDistance(6, 4);
		petrolDistanceArr[1] = new PetrolDistance(5, 6);
		petrolDistanceArr[2] = new PetrolDistance(3, 7);
		petrolDistanceArr[3] = new PetrolDistance(5, 4);
		
		//visitAllPetrolPumps(petrolDistanceArr);
		visitAllPumpsCorrect(petrolDistanceArr);
	}
	
	private static void visitAllPumpsCorrect(PetrolDistance[] petrolDistanceArr) {
		if(petrolDistanceArr == null || petrolDistanceArr.length == 0)
				System.out.println(-1);
		int start=0, end=0;
		int currentFuel =0, totalFuel = 0;
		while(start  < petrolDistanceArr.length) {
			currentFuel +=  petrolDistanceArr[start].fuel - petrolDistanceArr[start].distance;
			totalFuel += petrolDistanceArr[start].fuel - petrolDistanceArr[start].distance;
			
			if(currentFuel > 0) {
				start++;
			} else {
				currentFuel = 0;
				end = start+1;
				start++;
			}
		}
		if(totalFuel < 0)
			System.out.println(-1);
		else
			System.out.println(end);
	}

	/**
	 * failed solution
	 * @param petrolDistanceArr
	 */
	private static void visitAllPetrolPumps(PetrolDistance[] petrolDistanceArr) {
		if(petrolDistanceArr == null || petrolDistanceArr.length == 0)
			return;
		
		Queue<PetrolDistance> petrolDistanceQueue = new LinkedList<>();
		int currentFuel = 0;
		for(int i=0; i<petrolDistanceArr.length; i++) {
			petrolDistanceQueue.add(petrolDistanceArr[i]);
		}
		int count=0;
		boolean found = false;
		while(!petrolDistanceQueue.isEmpty()) {
			PetrolDistance pd = petrolDistanceQueue.remove();
			currentFuel += pd.getFuel();
			if(currentFuel < pd.getDistance()) {
				currentFuel -= pd.getFuel();
				petrolDistanceQueue.add(pd);
			} else {
				currentFuel -= pd.getDistance();
				System.out.println("");
				found =true;
			}
			if(!found) count++;
		}
		System.out.println("start count :: "+count);
	}

	static class PetrolDistance {
		private int distance;
		private int fuel;
		
		public PetrolDistance(int distance, int fuel) {
			this.distance = distance;
			this.fuel = fuel;
		}

		public int getDistance() {
			return distance;
		}

		public int getFuel() {
			return fuel;
		}

	}
}
