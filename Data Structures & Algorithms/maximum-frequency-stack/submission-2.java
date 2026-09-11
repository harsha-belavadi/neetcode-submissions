class FreqStack {
    Map<Integer, Integer> counter;
    Map<Integer, Stack<Integer>> frequency;
    int maxCount;
    public FreqStack() {
        counter = new HashMap<>();
        frequency = new HashMap<>();
        maxCount = 0;
    }
    
    public void push(int val) {
        counter.put(val, counter.getOrDefault(val, 0) + 1);
        int count = counter.get(val);
        maxCount = Math.max(maxCount, count);        
        if (!frequency.containsKey(count)) {
            frequency.put(count, new Stack<>());
        }
        frequency.get(count).push(val);
    }
    
    public int pop() {
        int value = frequency.get(maxCount).pop();
        counter.put(value, counter.get(value) - 1);
        if (frequency.get(maxCount).size() == 0) {
            frequency.remove(maxCount);
            maxCount--;
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