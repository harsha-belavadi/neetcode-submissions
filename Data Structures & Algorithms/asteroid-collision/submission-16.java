class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean destroyed = false;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int absvalue = Math.abs(asteroid);
                if (absvalue <= stack.peek()) {
                    destroyed = true;
                    if (absvalue == stack.peek()) { stack.pop(); }
                    break;
                } else {
                    stack.pop();
                }
            }
            if (!destroyed) {
                stack.push(asteroid);
            }
        }
        int n = stack.size();
        int[] result = new int[n];
        for (int i=n-1; i>=0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}