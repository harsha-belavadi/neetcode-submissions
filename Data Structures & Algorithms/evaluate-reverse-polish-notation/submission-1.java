class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int r = 0;
            int n1 = 0;
            int n2 = 0;
            switch(token) {
                case "+":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    r = n1 + n2;
                    stack.push(r);
                    break;
                case "-":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    r = n2 - n1;
                    stack.push(r);
                    break;
                case "*":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    r = n1 * n2;
                    stack.push(r);
                    break;
                case "/":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    r = n2 / n1;
                    stack.push(r);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.peek();
    }
}
