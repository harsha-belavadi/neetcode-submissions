class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(sb.toString());
                numbers.push(k);
                sb = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // previous + (current * multiplier)
                String previous = stack.pop();
                String current = sb.toString();
                int multiplier = numbers.pop();
                sb = new StringBuilder(previous + current.repeat(multiplier));
                k = 0;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}