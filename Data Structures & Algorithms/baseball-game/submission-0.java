class Solution {
    private record Parsed(boolean isNumber, int number) {}
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<operations.length; i++) {
            String op = operations[i];
            Parsed parsed = parseNumber(op);
            if (parsed.isNumber()) {                
                stack.push(parsed.number);
            } else {
                if (op.equals("C")) {
                    stack.pop();
                } else if (op.equals("D")) {
                    int value = stack.peek();
                    stack.push(value * 2);
                } else {
                    int v1 = stack.pop();
                    int v2 = stack.pop();
                    stack.push(v2);
                    stack.push(v1);             
                    stack.push(v1 + v2);
                }
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private Parsed parseNumber(String num) {
        try {
            if (num == null || num.isEmpty()) { return new Parsed(false, -1); }
            return new Parsed(true, Integer.parseInt(num));
        } catch (NumberFormatException ex) {
            return new Parsed(false, -1);
        }
    }
}