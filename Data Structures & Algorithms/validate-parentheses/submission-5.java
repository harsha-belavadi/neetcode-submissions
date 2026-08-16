class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        for (char c : s.toCharArray()) {            
            if (closeToOpen.containsKey(c)) {
                if (stack.isEmpty()) { return false; }
                char open = stack.pop();
                if (!isMatchingBracket(open, c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatchingBracket(char c1, char c2) {
        return (c1 == '[' && c2 == ']') || 
        (c1 == '{' && c2 == '}') || 
        (c1 == '(' && c2 == ')');
    }
}
