class MyQueue {
    Stack<Integer> left = new Stack<>();
    Stack<Integer> right = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        while (!right.empty()) left.push(right.pop());
        left.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (!left.empty()) right.push(left.pop());
        right.pop();
    }

    // Get the front element.
    public int peek() {
        while (!left.empty()) right.push(left.pop());
        return right.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return left.empty() && right.empty();
    }
}