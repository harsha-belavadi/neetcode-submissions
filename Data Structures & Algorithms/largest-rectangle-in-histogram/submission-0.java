class Solution {
    public int largestRectangleArea(int[] heights) {
        // area = (nse[i] - pse[i] - 1) * heights[i]
        // largest = max(largest, area)

        int[] pse = prevSmallerElement(heights);
        int[] nse = nextSmallerElement(heights);
        
        int largest = -1;
        for (int i=0; i<heights.length; i++) {
            int area = (nse[i] - pse[i] - 1) * heights[i];
            largest = Math.max(largest, area);
        }
        
        return largest;
    }

    // Use monotonic stack - either in increasing or decreasing order
    private int[] nextSmallerElement(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int n = heights.length;
        int[] nse = new int[heights.length];
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

    private int[] prevSmallerElement(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int[] pse = new int[heights.length];
        for (int i=0; i<heights.length; i++) {
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
}
