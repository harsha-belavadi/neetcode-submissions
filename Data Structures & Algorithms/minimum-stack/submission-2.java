class MinStack {
    private List<Integer> stack;
    private List<Integer> minStack;
    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty() || val <= minStack.getLast()) {
            minStack.add(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) { return; }
        int popped = stack.remove(stack.size() - 1);
        if (popped == minStack.getLast()) {
            minStack.remove(minStack.size() - 1);
        }
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minStack.getLast();
    }
}
