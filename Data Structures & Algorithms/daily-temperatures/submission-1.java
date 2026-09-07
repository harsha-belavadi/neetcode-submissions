class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index]
        int[] result = new int[n];
        
        for (int i=0; i<n; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[1]) {
                int[] pair = stack.pop();
                result[pair[0]] = i - pair[0];
            }
            stack.push(new int[] { i, t });
        }
        return result;
    }
}
