class Solution {
    public int largestRectangleArea(int[] heights) {
        // area = nse[i] - pse[i] - 1
        // largest = max(largest, area)

        int n = heights.length;
        int[] pse = prevSmallElement(heights);
        int[] nse = nextSmallElement(heights);
        int largest = 0;
        for (int i=0; i<n; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            largest = Math.max(largest, area);
        }
        return largest;
    }

    // Use monotonic stack - either in increasing or decreasing order
    private int[] prevSmallElement(int[] heights) {
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        int[] pse = new int[n];
        for (int i=0; i<n; i++) {
            int[] pair = new int[] { heights[i], i };
            while (!stack.isEmpty() && stack.peek()[0] >= pair[0]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek()[1];
            }
            stack.push(pair);
        }
        return pse;
    }

    private int[] nextSmallElement(int[] heights) {
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        int[] nse = new int[n];
        for (int i=n-1; i>=0; i--) {
            int[] pair = new int[] { heights[i], i };
            while (!stack.isEmpty() && stack.peek()[0] >= pair[0]) {
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
