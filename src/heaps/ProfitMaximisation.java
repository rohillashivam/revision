package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProfitMaximisation {

	public static void main(String[] args) {
		Integer[] data = {2, 3};
		ArrayList<Integer> dataList = (ArrayList<Integer>) Stream.of(data).collect(Collectors.toList());
		ProfitMaximisation pm = new ProfitMaximisation();
		System.out.println(pm.solve(dataList, 3));

	}
	
	public int solve(ArrayList<Integer> arr, int num) {
        if(num <= 0)
            return 0;
        if(arr == null || arr.isEmpty())
            return 0;
        Queue<Integer> dataQueue = new PriorityQueue<>((o1, o2) -> {
            return (-1*(o1.compareTo(o2)));
        });
        
        for(Integer data : arr) {
            dataQueue.add(data);
        }
        
        int val = 0;
        while(num > 0 ){
            Integer data = dataQueue.poll();
            val += data;
            data--;
            if(data > 0)
                dataQueue.add(data);
            num--;
        }
        return val;
        
    }

}
