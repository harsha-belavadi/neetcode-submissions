class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (stack.isEmpty()) { stack.push(a); }
            else {
                if (stack.peek() > 0 && a > 0) {
                    stack.push(a);
                    continue;
                } else if (stack.peek() < 0 && a < 0) {
                    stack.push(a);
                    continue;
                } else if (stack.peek() < 0 && a > 0) {
                    stack.push(a);
                    continue;
                }

                while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                    int value = Math.abs(a);
                    int peek = stack.peek();
                    if (peek >= value) {
                        if (peek == value) { stack.pop(); }
                        break;
                    }
                    if (peek < value) {
                        stack.pop();
                    }

                    if (stack.isEmpty() || stack.peek() < 0) { 
                        stack.push(a); 
                        break;
                    }
                }
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
}