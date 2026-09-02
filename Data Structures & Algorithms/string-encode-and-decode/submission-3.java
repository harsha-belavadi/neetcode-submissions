class Solution {
    String BASE62_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    static java.math.BigInteger ZERO = java.math.BigInteger.ZERO;
    static java.math.BigInteger base256 = java.math.BigInteger.valueOf(256);
    static java.math.BigInteger base62 = java.math.BigInteger.valueOf(62);

    // Helper shortcut method to make valueOf shorter
    static java.math.BigInteger bint(int val) {
        return java.math.BigInteger.valueOf(val);
    }
    
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            var runningTotal = ZERO;
            for (char c : str.toCharArray()) {
                int ascii = c;
                runningTotal = runningTotal.multiply(base256).add(bint(ascii));
            }

            StringBuilder base62encoded = new StringBuilder();
            while (runningTotal.compareTo(ZERO) > 0) {
                var divAndRem = runningTotal.divideAndRemainder(base62);
                int remainder = divAndRem[1].intValue();
                base62encoded.append(BASE62_CHARS.charAt(remainder));
                runningTotal = divAndRem[0];
            }

            // Must reverse because remainders are calculated right-to-left
            String encodedString = base62encoded.reverse().toString();

            encoded.append(encodedString.length());
            encoded.append("#");
            encoded.append(encodedString);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            int length = 0;
            StringBuilder number = new StringBuilder();
            while (str.charAt(index) != '#') {
                number.append(str.charAt(index));
                index++;
            }
            length = Integer.parseInt(number.toString());
            index++;
            String s = str.substring(index, index + length);

            // Decode the string
            var runningTotal = ZERO;
            for (char c : s.toCharArray()) {
                int base62Value = BASE62_CHARS.indexOf(c);
                runningTotal = runningTotal.multiply(base62).add(bint(base62Value));
            }

            StringBuilder decoded = new StringBuilder();
            while (runningTotal.compareTo(ZERO) > 0) {
                var divAndRem = runningTotal.divideAndRemainder(base256);
                int remainder = divAndRem[1].intValue();
                decoded.append((char)remainder);
                runningTotal = runningTotal.divide(base256);
            }

            index = index + length;
            result.add(decoded.reverse().toString());
        }
        return result;
    }
}
