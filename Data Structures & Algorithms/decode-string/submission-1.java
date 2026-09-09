class Solution {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        int k = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                stringStack.push(sb.toString());
                numberStack.push(k);
                k = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                // Previous + (Current × Multiplier)
                String current = sb.toString();
                String previous = stringStack.pop();
                int multiplier = numberStack.pop();
                sb = new StringBuilder();
                sb.append(previous + current.repeat(multiplier));
           } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

// Previous + (Current × Multiplier) 