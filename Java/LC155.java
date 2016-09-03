public class MinStack {
    Stack<Integer> s;
    Stack<Integer> minS;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        minS = new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
        if (minS.empty() || x <= minS.peek()) {
            minS.push(x);
        }
    }
    
    public void pop() {
        if (s.peek().equals(minS.peek())) {
            minS.pop();
        }
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */