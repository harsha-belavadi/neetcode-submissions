class StockSpanner {
    // previous greater element pattern
    Stack<int[]> stack;
    int index = 0;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int n = 0;
        if (stack.isEmpty()) {
            n = 1;
            stack.push(new int[] { price, index });   
        } else {
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                n = index + 1;
            } else {
                n = index - stack.peek()[1];
            }
            stack.push(new int[] { price, index });
        }
        index++;
        return n;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/* previous greater element tracing 

[60, 2] 2-1 = 1
[80, 1] 1-0(stack.peek before push) = 1
[100, 0]
----------
[60, 4] 4-3 = 1
[70, 3] 3 - 1 = 2
[80, 1]
[100, 0]
---------
[75, 5] 5-1 = 4
[80, 1]
[100, 0]
---------
[85, 6] 6-0 = 6
[100, 0]
*/