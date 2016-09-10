public class MovingAverage {
    Queue<Integer> nums;
    double sum = 0;
    int len;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        nums = new LinkedList<>();
        len = size;
    }
    
    public double next(int val) {
        nums.offer(val);
        sum += val;
        if (nums.size() > len) {
            int delVal = nums.poll();
            sum -= delVal;
        }
        return sum / nums.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */