class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {            
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                int val = Math.abs(asteroid);
                if ((stack.peek() < 0 && (asteroid < 0 || asteroid > 0)) || 
                    (stack.peek() > 0 && asteroid > 0)) {
                    stack.push(asteroid);
                } else if (Math.abs(stack.peek()) == val) {
                    stack.pop();
                } else {                  
                    while (!stack.isEmpty() && 
                           stack.peek() > 0 && 
                           val > stack.peek()) {                        
                        stack.pop();
                    }

                    if (!stack.isEmpty() && stack.peek() == val) {
                        stack.pop();
                        continue;
                    }

                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(asteroid);
                    }
                }
            }            
        }

        System.out.println(stack);

        int n = stack.size();
        int[] result = new int[n];
        int i = n - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }

        return result;
    }
}