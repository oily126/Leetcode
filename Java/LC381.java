public class RandomizedCollection {
    Map<Integer, Map<Integer, Integer>> numMap;
    List<Integer> numList;
    List<Integer> idList;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        rand = new Random();
        numMap = new HashMap<>();
        numList = new ArrayList<>();
        idList = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Map<Integer, Integer> indexes = numMap.get(val);
        boolean hasElement = (indexes != null);
        
        if (!hasElement) {
            indexes = new HashMap<>();
            numMap.put(val, indexes);
        }
        numList.add(val);
        idList.add(indexes.size());
        indexes.put(indexes.size(), numList.size() - 1); 
        return !hasElement;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Map<Integer, Integer> indexes = numMap.get(val);
        boolean hasElement = (indexes != null);
        if (hasElement) {
            int id = indexes.size() - 1, index = indexes.get(id),
                last = numList.size() - 1;
            numList.set(index, numList.get(last));
            idList.set(index, idList.get(last));
            numMap.get(numList.get(index)).put(idList.get(index), index);
            numList.remove(last);
            idList.remove(last);
            indexes.remove(id);
            if (indexes.size() == 0) numMap.remove(val);
        }
        return hasElement;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return numList.get(rand.nextInt(numList.size()));
    }
}
