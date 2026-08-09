class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') { stack.push(c); }

            if (stack.isEmpty()) { return false; }

            if (c == ']' || c == ')' || c == '}') { 
                char popped = stack.pop();
                if ((c == ']' && popped != '[') ||
                    (c == '}' && popped != '{') ||
                    (c == ')' && popped != '(')) {
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
