/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> sums = new ArrayList<>();
        Queue<NestedInteger> waitNum = new LinkedList<>();
        int size = 0, lv = 0;
        for (NestedInteger num : nestedList) {
            waitNum.offer(num);
        }
        while (waitNum.size() > 0) {
            size = waitNum.size();
            if (sums.size() <= lv) {
                sums.add(0);
            }
            for (int i = 0; i < size; i++) {
                NestedInteger num = waitNum.poll();
                
                if (num.isInteger()) {
                    sums.set(lv, sums.get(lv) + num.getInteger());
                } else {
                    for (NestedInteger tmpNum : num.getList()) {
                        waitNum.offer(tmpNum);
                    }
                }
            }
            lv++;
        }
        int sum = 0;
        for (int i = 0; i < sums.size(); i++) {
            sum += sums.get(i) * (sums.size() - i);
        }
        return sum;
    }
}