package arrays;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxProductOf3 {

	public static void main(String[] args) {
		final Integer[] arrVal = { 0, -1, 3, 100, -70, -50};
		MaxProductOf3 mp3 = new MaxProductOf3();
		ArrayList<Integer> dataList = (ArrayList<Integer>) Stream.of(arrVal).collect(Collectors.toList());
		System.out.println(mp3.maxp3(dataList));
		System.out.println("------------------");
		System.out.println(mp3.maxp3Optimized(dataList));
		final Integer[] arrValNew = {1, 2, -3};
		ArrayList<Integer> dataListNew = (ArrayList<Integer>) Stream.of(arrValNew).collect(Collectors.toList());
		System.out.println(mp3.maxp3Optimized(dataListNew));
	}
	private int maxp3Optimized(ArrayList<Integer> dataList) {
		if(dataList == null || dataList.isEmpty())
			return -1;
		Integer maxOne = Integer.MIN_VALUE, maxTwo = Integer.MIN_VALUE, maxThree = Integer.MIN_VALUE;
		Integer minOne = Integer.MAX_VALUE, minTwo = Integer.MAX_VALUE, minThree = Integer.MAX_VALUE;
		for (Integer data : dataList) {
			if(data > maxOne) {
				maxThree = maxTwo;
				maxTwo = maxOne;
				maxOne = data;
			} else if(data > maxTwo) {
				maxThree = maxTwo;
				maxTwo = data;
			} else if(data > maxThree) {
				maxThree = data;
			}
			if(data < minOne) {
				minThree = minTwo;
				minTwo = minOne;
				minOne = data;
			} else if(data < minTwo) {
				minThree = minTwo;
				minTwo = data;
			} else if (data < minThree) {
				minThree = data;
			}
		}
		
		long maxProduct = maxOne * maxTwo * maxThree;
		long minProduct = minOne*minTwo;
		if(minProduct > 0 && minThree < 0) {
			minProduct *= maxOne;
		} else {
			minProduct *= minThree;
		}
		return (int) Math.max(maxProduct, minProduct);
	}
	public int maxp3(ArrayList<Integer> arr) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((d1, d2) -> d2.compareTo(d1));
        for(Integer data : arr) {
            if(minHeap.size() > 3)
                minHeap.remove();
            if(maxHeap.size() > 3)
                maxHeap.remove();
            minHeap.add(data);
            maxHeap.add(data);
        }
        int productMax = 1, productMin=1;
        
        // computing with max
        int maxValue = 1;
        while(!minHeap.isEmpty()) {
            if(minHeap.size() > 3) {
                minHeap.poll();
                continue;
            }
            Integer val = minHeap.poll();
            //System.out.println(val);
            if(val > maxValue) 
                maxValue = val;
            productMax *= val;
        }
        // computing with min
        Integer maxMinVal = Integer.MIN_VALUE;
        System.out.println("maxHeap Size :: "+ maxHeap.size());
        while(!maxHeap.isEmpty()) {
            if(maxHeap.size() > 3) {
                System.out.println(maxHeap.poll());
                continue;
            }
            Integer val = maxHeap.poll();
            System.out.println(val);
            if(maxMinVal == Integer.MIN_VALUE) {
            	maxMinVal = val;
            	continue;
            }
            /*if(maxHeap.isEmpty()) {
                System.out.println("empty heap");
                if(val < 0 && productMin > 0)
                    productMin *= maxValue;
            } else {
            */
            productMin *= val;
            //}
        }
        if(maxMinVal > 0)
        	productMin *= maxValue;
        else
        	productMin *= maxValue;
        return Math.max(productMax, productMin);
	}
}
