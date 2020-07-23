package arrays;

import java.util.ArrayList;
import java.util.List;

public class GSRangeQuestion {

	public static void main(String[] args) {
		List<PriceTime> priceTimeList = new ArrayList<>();
		PriceTime pt = new PriceTime(10, 02);
		PriceTime pt1 = new PriceTime(10, 03);
		PriceTime pt2 = new PriceTime(15, 04);
		PriceTime pt3 = new PriceTime(7, 07);
		priceTimeList.add(pt);
		priceTimeList.add(pt1);
		priceTimeList.add(pt2);
		priceTimeList.add(pt3);
		
		PriceTime price = findPrice(priceTimeList, 5);
		System.out.println(price.getPrice());
		System.out.println("--------------------s");
		price = findPriceNew(priceTimeList, 5, 0, priceTimeList.size()-1);
		System.out.println(price.getPrice());
	}

	private static PriceTime findPriceNew(List<PriceTime> priceTimeList, int time, int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start+end) >> 1;
		if((priceTimeList.get(mid).getTime() == time) || 
				(priceTimeList.get(mid+1).getTime() > time && priceTimeList.get(mid).getTime() < time))
			return priceTimeList.get(mid);
		
		if(priceTimeList.get(mid).getTime() < time) {
			return findPriceNew(priceTimeList, time, mid+1, end);
		} else {
			return findPriceNew(priceTimeList, time, start, mid-1);
		}
		
	}

	private static int near = Integer.MAX_VALUE;
	private static PriceTime findPrice(List<PriceTime> priceTimeList, int time) {
		PriceTime pt = null;
		int end = priceTimeList.size() - 1, start =0;
		while(start <= end) {
			int mid = (start + end) >> 1;
			PriceTime midPrice = priceTimeList.get(mid);
			if(midPrice.getTime() == time) {
				pt = priceTimeList.get(mid); 
				break;
			}
			if(midPrice.getTime() > time) {
				end = mid-1;
			} else {
				start = mid+1;
			}
			
			if(midPrice.getTime() - time < 0) {
				if(near > Math.abs(midPrice.getTime() - time)) {
					near = Math.abs(midPrice.getTime() - time);
					pt = midPrice;
				}
			}
		}
		return pt;
	}
}

class PriceTime {
	
	private int price;
	private int time;
	
	public PriceTime(int price, int time) {
		this.price = price;
		this.time = time;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
