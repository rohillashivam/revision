package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelBookingPossible {
	public static void main(String[] args) {
		Integer[] A = { 1, 2, 3, 4 };
		ArrayList<Integer> arrA = (ArrayList<Integer>) Stream.of(A).collect(Collectors.toList());
		Integer[] B = { 10, 2, 6, 14 };
		ArrayList<Integer> arrB = (ArrayList<Integer>) Stream.of(B).collect(Collectors.toList());
		System.out.println(hotel(arrA, arrB, 4));
	}

	public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        if(arrive == null || depart == null || arrive.size() != depart.size())
            return false;
        
        Collections.sort(arrive);
        Collections.sort(depart);
        
        int arriveIndex = 1, departIndex = 1;
        int count = 1;
        int currArrive = arrive.get(0), currentDepart = depart.get(0);
        while(arriveIndex < arrive.size() && departIndex < depart.size()) {
            if(currentDepart >= arrive.get(arriveIndex)) {
                count++;
                arriveIndex++;
            } else {
                count--;
                departIndex++;
                currentDepart = depart.get(0);
            }
            
            if(count > K) {
                System.out.println(count);
                return false;
            }
        }
        return true;
    }
}
