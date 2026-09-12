class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || c != map.get(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
