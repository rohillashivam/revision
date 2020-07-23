package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {
	private static Map<CustomKey, Integer> cache = null;
    private static Map<Integer, CustomKey> accessKey = null;
    private static PriorityQueue<CustomKey> keyList = null;
    private static Integer capacity = null;
    
    public LRUCache(int capacity) {
    	LRUCache.capacity = capacity;
        cache = new HashMap<>(capacity);
        accessKey = new HashMap<>(capacity);
        keyList = new PriorityQueue<>((d1, d2) -> (d1.count).compareTo(d2.count));
    }
    
    public int get(int key) {
        if(!accessKey.containsKey(key)) {
            return -1;
        }
        CustomKey customKey = accessKey.get(key);
        customKey.count += 1;
        CustomKey customKeyNew = keyList.remove();
        keyList.add(customKeyNew);
        return cache.get(customKey);
    }
    
    public void set(int key, int value) {
        if(accessKey.containsKey(key)) {
            CustomKey customKey = accessKey.get(key);
            cache.put(customKey, value);
            customKey.count += 1;
            CustomKey customKeyNew = keyList.remove();
            keyList.add(customKeyNew);
            return;
        }
        if(capacity == cache.size()) {
            CustomKey keyToRemove = keyList.poll();
            accessKey.remove(keyToRemove.key);
            cache.remove(keyToRemove);
        }
        
        CustomKey customKey = new CustomKey(key);
        cache.put(customKey, value);
        accessKey.put(key, customKey);
        keyList.add(customKey);
        /*if(key == 2) {
            System.out.println("key for 2 :: "+(accessKey.get(key) != null));
        }*/
    }
    
    public static void main(String[] args) {
		LRUCache cachOp = new LRUCache(2);
		cachOp.set(2, 1);
		cachOp.set(1, 1);
		cachOp.set(2, 3);
		cachOp.set(4, 1);
		System.out.println(cachOp.get(1));
		System.out.println(cachOp.get(2));
	}
    
}

class CustomKey {
    Integer key;
    Integer count;
    
    public CustomKey(Integer key) {
        this.key = key;
        this.count=1;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomKey other = (CustomKey) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
    
}
