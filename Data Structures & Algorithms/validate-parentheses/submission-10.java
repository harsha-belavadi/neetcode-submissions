class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closing = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                char opening = stack.pop();
                if (closing.get(opening) != c) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
