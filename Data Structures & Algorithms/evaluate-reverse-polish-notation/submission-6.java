class Solution {
    Stack<Integer> stack = new Stack<>();
    public int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if (!isOp(token)) {
                int number = convert(token);
                stack.push(number);
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();                
                int result = calculate(token, num1, num2);
                stack.push(result);
            }
        }
        return stack.peek();
    }

    private boolean isOp(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"); 
    }

    private int convert(String s) {
        return Integer.parseInt(s);
    }

    private int calculate(String op, int num1, int num2) {
        if (op.equals("+")) {
            return num1 + num2;
        } else if (op.equals("-")) {
            return num2 - num1;
        } else if (op.equals("*")) {
            return num1 * num2;
        } else {
            return num2/num1;
        }
    }
}
