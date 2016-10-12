public class PhoneDirectory {
    Set<Integer> nums;
    Queue<Integer> unused;
    int maxLen;
    int index;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        nums = new HashSet<>();
        unused = new LinkedList<>();
        maxLen = maxNumbers;
        index = 0;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int num = -1;
        if (!unused.isEmpty()) num = unused.poll();
        else {
            if (index < maxLen) num = index++;
        }
        nums.add(num);
        return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !nums.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (nums.remove(number) && number < index) {
            unused.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */