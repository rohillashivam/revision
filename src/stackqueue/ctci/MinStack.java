package stackqueue.ctci;

import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		
		int[] data = {15, 19, 9, 10, 3, 7, 9, 0};
		
		Stack<MinStackData> minStack = createMinStack(data);
		if(minStack != null) {
			while(!minStack.isEmpty()) {
				MinStackData minStackData = minStack.pop();
				System.out.println(minStackData.getValue() +" -- "+minStackData.getMinValue());
			}
		}
	}
	
	private static Stack<MinStackData> createMinStack(int[] data) {
		if(data == null)
			return null;
		
		Stack<MinStackData> minStack = new Stack<>();
		int minValue = Integer.MAX_VALUE;
		for (int val : data) {
			if(val < minValue)
				minValue = val;
			MinStackData minStackData = new MinStackData(val, minValue);
			minStack.push(minStackData);
		}
		return minStack;
	}

	private static class MinStackData {
		private final int value;
		private final int minValue;
		
		public MinStackData(int value, int minValue) {
			super();
			this.value = value;
			this.minValue = minValue;
		}
		
		private Integer getValue() {
			return this.value;
		}
		
		private Integer getMinValue() {
			return this.minValue;
		}
		
	}
}
