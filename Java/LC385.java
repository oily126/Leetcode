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
    public NestedInteger deserialize(String s) {
        int i, len = s.length(), cur = 0, op = 1;
        Stack<NestedInteger> ans = new Stack<>();
        NestedInteger nest = null;
        boolean hasNum = false;
        if (len == 0) return new NestedInteger();
        for (i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '-') {
                op = -op;
                hasNum = true;
            } else if (ch >= '0' && ch <= '9') {
                cur = cur * 10 + ch - '0';
                hasNum = true;
            } else if (ch == ',') {
                if (hasNum) {
                    ans.peek().add(new NestedInteger(cur * op));
                    op = 1;
                    cur = 0;
                    hasNum = false;
                }
            } else if (ch == '[') {
                nest = new NestedInteger();
                if (!ans.empty()) {
                    ans.peek().add(nest);
                }
                ans.add(nest);
            } else if (ch == ']') {
                if (hasNum) {
                    ans.peek().add(new NestedInteger(cur * op));
                    op = 1;
                    cur = 0;
                    hasNum = false;
                }
                nest = ans.pop();
            }
        }
        if (hasNum) {
            ans.add(new NestedInteger(cur * op));
        }
        while (!ans.empty()) {
            nest = ans.pop();
        }
        return nest;
    }
}