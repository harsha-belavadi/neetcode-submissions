class Solution {
    private record Parsed(int number, boolean valid) {};
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            Parsed parsed = parseString(token);
            if (parsed.valid) {
                int num = parsed.number;
                stack.push(num);
            } else if (token.equals("+")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v1 + v2);
            } else if (token.equals("-")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2 - v1);
            } else if (token.equals("*")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v1 * v2);
            } else {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2/v1);
            }
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }

    private Parsed parseString(String s) {
        try {
            if (s.isBlank()) { return new Parsed(-1, false); }
            return new Parsed(Integer.parseInt(s), true);
        } catch (Exception ex) {
            return new Parsed(-1, false);
        }
    }
}
