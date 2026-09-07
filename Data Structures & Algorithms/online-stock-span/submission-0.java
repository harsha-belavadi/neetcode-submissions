class StockSpanner {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public StockSpanner() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public int next(int price) {
        boolean keepCounting = true;
        int count = 0;

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(price);

        while (!s2.isEmpty()) {
            int value = s2.pop();
            if (keepCounting && price >= value) {
                count++;
            } else {
                keepCounting = false;
            }
            s1.push(value);
        }

        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
