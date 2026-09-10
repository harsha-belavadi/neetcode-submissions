class Solution {
    private record Parsed(int number, boolean valid) {};
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String op : operations) {
            Parsed parsed = parseNumber(op);
            if (parsed.valid) {
                stack.push(parsed.number);
            } else if (op.equals("+")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2);
                stack.push(v1);
                stack.push(v1 + v2);
            } else if (op.equals("D")) {
                int value = stack.peek();
                stack.push(value * 2);
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

    private Parsed parseNumber(String s) {
        try {
            if (s.isBlank()) { return new Parsed(-1, false); }
            return new Parsed(Integer.parseInt(s), true);
        } catch (Exception ex) {
            return new Parsed(-1, false);
        }
    }
}