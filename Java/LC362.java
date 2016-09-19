public class HitCounter {
    Map<Integer, Integer> counter;
    int hitCount;
    /** Initialize your data structure here. */
    public HitCounter() {
        counter = new HashMap<>();
        hitCount = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (counter.size() > 300) {
            refreshCounter(timestamp);
        }
        counter.put(timestamp, counter.getOrDefault(timestamp, 0) + 1);
        hitCount += 1;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        refreshCounter(timestamp);
        return hitCount;
    }
    
    private void refreshCounter(int timestamp) {
        Set<Integer> rmSet = new HashSet<>();
        for (Integer time : counter.keySet()) {
            if (time <= timestamp - 300) {
                hitCount -= counter.get(time);
                rmSet.add(time);
            }
        }
        for (Integer time : rmSet) {
            counter.remove(time);
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */