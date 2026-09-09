class FreqStack {
    Map<Integer, Integer> counter;
    Map<Integer, Stack<Integer>> stacks;
    int maxCnt;
    public FreqStack() {
        counter = new HashMap<>();
        stacks = new HashMap<>();
        maxCnt = 0;
    }
    
    public void push(int val) {
        counter.put(val, counter.getOrDefault(val, 0) + 1);
        int count = counter.get(val);
        if (count >= maxCnt) {
            maxCnt = count;
        }
        if (!stacks.containsKey(count)) {
            stacks.put(count, new Stack<>());
        }
        stacks.get(count).push(val);
    }
    
    public int pop() {
        int value = stacks.get(maxCnt).pop();
        counter.put(value, counter.get(value) - 1);
        if (counter.get(value) == 0) {
            counter.remove(value);
        }
        if (stacks.get(maxCnt).isEmpty()) {
            stacks.remove(maxCnt);
            maxCnt--;
        }
        return value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */