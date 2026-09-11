class Solution {
    private record ParsedNumber(int number, boolean valid) {};
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            ParsedNumber parsed = parse(token);
            if (parsed.valid) { stack.push(parsed.number); }
            else {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(calculate(token, v1, v2));
            }
        }
        return stack.peek();
    }

    private ParsedNumber parse(String value) {
        try {
            if (value.isBlank()) {
                return new ParsedNumber(-1, false);
            }
            return new ParsedNumber(Integer.parseInt(value), true);
        } catch (NumberFormatException ex) {
            return new ParsedNumber(-1, false);
        }
    }

    private int calculate(String op, int v1, int v2) {
        if (op.equals("+")) {
            return v1 + v2;
        } else if (op.equals("-")) {
            return v2 - v1;
        } else if (op.equals("*")) {
            return v1 * v2;
        } else {
            return v2 / v1;
        }
    }
}
