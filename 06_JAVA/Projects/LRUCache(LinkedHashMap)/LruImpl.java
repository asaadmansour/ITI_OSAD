import java.util.LinkedHashMap;

public class LruImpl implements LruCache {
    private int capacity;
    LinkedHashMap<Integer,Integer> mp = new LinkedHashMap<Integer,Integer>(16, 0.75f, true);
    @Override
    public int get(int key) {
       return mp.getOrDefault(key, -1);
    }
    @Override
    public void put(int key, int value) {
        if(mp.size() >= capacity && !mp.containsKey(key))
            mp.remove(mp.keySet().iterator().next());
        mp.put(key, value);
    }
    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
        
    }
}
