class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] output = new int[n];
        for (int i=0; i<n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int k = stack.pop();
                output[k] = i - k;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int k = stack.pop();
            output[k] = 0;
        }

        return output;
    }
}
