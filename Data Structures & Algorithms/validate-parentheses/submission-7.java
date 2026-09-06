class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>() {{
            put(']', '[');
            put('}', '{');
            put(')', '(');
        }};
        
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (isOpening(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpening(char c) {
        return c == '[' || c == '{' || c == '('; 
    }
}
