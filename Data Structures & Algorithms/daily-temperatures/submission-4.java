class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] nse = nextGreaterElement(temperatures);
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            if (nse[i] == n) {
                result[i] = 0;
            } else {
                result[i] = nse[i] - i;
            }
        }
        return result;
    }

    // Next greater element
    private int[] nextGreaterElement(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int n = temperatures.length;
        int[] nse = new int[n];
        for (int i=n-1; i>=0; i--) {
            int[] pair = new int[] { temperatures[i], i };
            while (!stack.isEmpty() && stack.peek()[0] <= pair[0]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = stack.peek()[1];
            }
            stack.push(pair);
        }
        return nse;
    }
}
