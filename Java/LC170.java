public class TwoSum {
    Map<Integer, Integer> nums;
    
    public TwoSum() {
        nums = new HashMap<>();
    }
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    nums.put(number, nums.getOrDefault(number, 0) + 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Integer i : nums.keySet()) {
	        int time = nums.getOrDefault(value - i, 0);
	        if (time == 1) {
	            if (value - i != i) {
	                return true;
	            }
	        } else if (time > 1) {
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);