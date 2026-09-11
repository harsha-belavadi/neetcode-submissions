class StockSpanner {
    // Previous smaller element
    Stack<int[]> stack;
    int index;
    public StockSpanner() {
        stack = new Stack<>();
        index = 0;
    }
    
    public int next(int price) {
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }
        int value;
        if (stack.isEmpty()) {
            value = index + 1;
        } else {
            value = index - stack.peek()[1];
        }
        stack.push(new int[] { price, index });
        index++;
        return value;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */