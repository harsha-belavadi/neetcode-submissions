class Solution {
    private record ParseNumber(int number, boolean valid) {};
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String op : operations) {
            ParseNumber parsed = parse(op);
            if (parsed.valid) { stack.push(parsed.number); }
            else if (op.equals("+")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2);
                stack.push(v1);
                stack.push(v1 + v2); 
            } else if (op.equals("D")) {
                int v = stack.peek();
                stack.push(2 * v);
            } else if (op.equals("C")) {
                stack.pop();
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private ParseNumber parse(String value) {
        try {
            if (value.isBlank()) { return new ParseNumber(-1, false); }
            return new ParseNumber(Integer.parseInt(value), true);
        } catch (NumberFormatException ex) {
            return new ParseNumber(-1, false);
        }
    }
}