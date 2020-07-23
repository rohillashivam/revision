package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NMaxPairCombination {

	public static void main(String[] args) {
		Integer a1[]={1,4,2,3};
		Integer b1[]={2,5,1,6};
		Arrays.sort(a1);
		Arrays.sort(b1);
		Queue<PairN> minHeap = new PriorityQueue<>();
		
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
		ArrayList<Integer> A = (ArrayList<Integer>) Stream.of(a1).collect(Collectors.toList());
		ArrayList<Integer> B = (ArrayList<Integer>) Stream.of(b1).collect(Collectors.toList());
        Collections.sort(A);
        Collections.sort(B);
        for(int i=A.size()-1;i>=0;i--)
        {
            for(int j=B.size()-1;j>=0;j--)
            {
                if(pq.size()<A.size())
                {
                    pq.add(A.get(i)+B.get(j));
                }
                else
                {
                    if(A.get(i)+B.get(j)<=pq.peek())// it is less
                    {
                        break;
                    }
                    else
                    {
                        pq.poll();
                        pq.add(A.get(i)+B.get(j));
                    }
                }
            }
        }
        ArrayList<Integer> result= new ArrayList<Integer>();
        while(pq.size()>0)
            result.add(0,pq.poll());
		
        for(Integer data : result) {
        	System.out.println(result);
        }
	}

	private static boolean isSamePair(PairN pairN, PairN minPair) {
		return (pairN.x * pairN.y == minPair.x*minPair.y) && (pairN.x + pairN.y == minPair.x+minPair.y)
				&& (pairN.x == minPair.x && pairN.y == minPair.y);
	}
}

class PairN implements Comparable {
	Integer x;
	Integer y;
	int a1[];
	int b1[];
	public PairN(Integer x, Integer y, int[] a1, int[] b1) {
		this.x = x;
		this.y = y;
		this.a1 = a1;
		this.b1 = b1;
	}
	
	@Override
	public int compareTo(Object o) {
		Integer currSum = a1[x]+b1[y];
		PairN obj = (PairN) o;
		return currSum.compareTo(a1[obj.x] + b1[obj.y]);
	}
}
