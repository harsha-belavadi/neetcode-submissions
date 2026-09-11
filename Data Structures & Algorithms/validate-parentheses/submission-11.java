class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>()
        {{
            put('[', ']');
            put('(', ')');
            put('{', '}');
        }};     
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
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
