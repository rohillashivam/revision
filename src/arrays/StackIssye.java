package arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StackIssye {

	public static void main(String[] args) {
		String[] arr = {"5", "-2" ,"4", "Z", "X", "9", "+", "+" };
		List<String> block = Stream.of(arr).collect(Collectors.toList());
		System.out.println(totalScore(block.size(), block));
	}
	
    public static int totalScore(int num, List<String> blocks)
    {
        // WRITE YOUR CODE HERE
        if(num == 0)
            return 0;
        if(blocks == null || blocks.isEmpty())
            return 0;
            
        int index = 0;
        Stack<Integer> prevIndex = new Stack<>();
        Score[] val = new Score[blocks.size()];
        int sum = 0;
        boolean lastZ = false;
        while(index < blocks.size()) {
            String data = blocks.get(index);
            if(index == 3 || index == 4 || index == 5)
            	System.out.println();
            if(data.equals("Z")) {
                if(!lastZ)
                    prevIndex.pop();
                int lastIndexVal = prevIndex.pop();
                sum = val[lastIndexVal].getTotalScore();
                prevIndex.push(lastIndexVal);
                val[index] = new Score(sum, sum);
                lastZ = true;
            } else if(data.equals("X")) {
                if(lastZ) 
                    lastZ = false;
                int lastIndexVal = prevIndex.pop();
                try{
                    Integer score = Integer.parseInt(blocks.get(lastIndexVal));
                    sum += 2*score;
                    prevIndex.push(index);
                    val[index] = new Score(2*score, sum);
                }finally {
                    //System.out.println("error in X");
                }
            } else if(data.equals("+")) {
                if(lastZ) 
                    lastZ = false;
                int lastIndexVal = prevIndex.pop();
                int lastIndexValLast = prevIndex.peek();
                try{
                	int value = -1;
                	try {
                		value = Integer.parseInt(blocks.get(lastIndexVal));
                	} catch(Exception e) {
                		while(true) {
                			Stack<Integer> indexList = new Stack<>();
                			try {
                				indexList.add(lastIndexVal);
                				lastIndexVal = prevIndex.pop();
                				value = Integer.parseInt(blocks.get(lastIndexVal));
                				while(!indexList.isEmpty()) {
                					prevIndex.push(indexList.pop());
                				}
                				break;
                			} finally {
                				
                			}
                		}
                	}
                	int currScore = val[lastIndexValLast].getCurrentScore();
                	currScore = currScore + value;
                	sum += currScore;
                	val[index] = new Score(currScore, sum);
                	prevIndex.push(lastIndexVal);
                	prevIndex.push(index);
                } finally {
                   //System.out.println("error in +");
                }
            } else {
            	if(lastZ)
            		lastZ = false;
                int value=0;
                try {
                value = Integer.parseInt(data);
                sum += value;
                val[index] = new Score(value, sum);
                prevIndex.push(index);
                index++;
                if(lastZ)
                    lastZ = false;
                continue;
            } catch(Exception e) {
                
            }
            }
                    
            index++;
            
        }
        
        return sum;
    }
}
class Score {
	private int currentScore;
	private int totalScore;
	public Score(int currentScore, int totalScore) {
		this.currentScore = currentScore;
		this.totalScore = totalScore;
	}
	public int getCurrentScore() {
		return currentScore;
	}
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
}
