class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        boolean destroyed = false;
        for (int asteroid : asteroids) {
            destroyed = false;
            int absval = Math.abs(asteroid);
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (stack.peek() >= absval) {
                    destroyed = true;
                    if (stack.peek() == absval) { stack.pop(); }
                    break;
                } else if (stack.peek() < absval) {
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