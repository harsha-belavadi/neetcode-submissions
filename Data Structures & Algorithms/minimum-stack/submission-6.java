class MinStack {
    List<Integer> stack;
    List<Integer> minstack;
    public MinStack() {
        stack = new ArrayList<>();
        minstack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if (minstack.isEmpty() || val <= minstack.get(minstack.size() - 1)) {
            minstack.add(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) { return; }
        int popped = stack.remove(stack.size()-1);
        if (popped == minstack.get(minstack.size()-1)) {
            minstack.remove(minstack.size()-1);
        }
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return minstack.get(minstack.size()-1);
    }
}
