class Solution {
    Stack<Integer> stack = new Stack<>();
    public int[] asteroidCollision(int[] asteroids) {        
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) { stack.push(asteroid); }
            else {
                performOperations(asteroid);
            }
        }

        int n = stack.size();
        int[] result = new int[n];
        int i = n-1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }

        return result;
    }

    private void performOperations(int asteroid) {
        if ((stack.peek() > 0 && asteroid > 0) || (stack.peek() < 0)) {
            stack.push(asteroid);
            return;
        }
        
        while (stack.peek() > 0) {
            int value = Math.abs(asteroid);
            if (stack.peek() >= value) {
                if (stack.peek() == value) { stack.pop(); }
                break;
            } else {
                stack.pop();
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
        }
    }
}