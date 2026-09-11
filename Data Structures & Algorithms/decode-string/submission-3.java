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
                k = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                // previous + current * count
                String previous = stack.pop();
                String current = sb.toString();
                int count = numbers.pop();
                sb = new StringBuilder();               
                k = 0;
                sb.append(previous + current.repeat(count));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}