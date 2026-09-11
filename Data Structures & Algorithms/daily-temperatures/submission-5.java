class Solution {
    // Next greater element pattern
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int n = temperatures.length;
        int[] nse = new int[n];
        for (int i=n-1; i>=0; i--) {
            int[] pair = new int[] { temperatures[i], i };
            while (!stack.isEmpty() && stack.peek()[0] <= pair[0]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = 0;
            } else {
                nse[i] = stack.peek()[1] - i;
            }
            stack.push(pair);
        }
        return nse;
    }
}
