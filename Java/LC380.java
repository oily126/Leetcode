public class RandomizedSet {
    Map<Integer, Integer> numMap;
    List<Integer> numList;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        numMap = new HashMap<>();
        numList = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (numMap.containsKey(val)) return false;
        numList.add(val);
        numMap.put(val, numList.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!numMap.containsKey(val)) return false;
        
        int pos = numMap.get(val), last = numList.size() - 1;
        numList.set(pos, numList.get(last));
        numList.set(last, val);
        numMap.put(numList.get(pos), pos);
        numMap.remove(val);
        numList.remove(numList.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return numList.get(rand.nextInt(numList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */