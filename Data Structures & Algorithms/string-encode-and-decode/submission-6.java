/* Logic to encode */

// Take the string -> loop chars -> get ascii number of Character
// -> multiply running total by 256 (all ascii) -> add the new character
// -> form a large giant number.

/* Ex: "Hey" => [72, 101, and 121] */
// Start: runningTotal = 0
// Char 1 ('H'): 0 * 256 + 72 = 72
// Char 2 ('e'): 72 * 256 + 101 = 18533
// Char 3 ('y'): 18533 * 256 + 121 = 4744569 -> Giant Number (runningTotal)

/* Create Base62 equivalent String */
// Take Giant number: 4744569
// LOOP: Keep dividing the Giant Number until quotient turns 0
// Take the remainder as index of base62_chars
// append the char directly to encoded_string without reversing

/* Ex: 4744569 */
// 4744569 / 62 = 76525; Remainder: 19
// 76525 / 62 = 1234;  Remainder: 17
// 1234 / 62 = 19;    Remainder: 56
// 19 / 62 = 0;       Remainder: 19 -> Loop terminates

// Collected Remainders (As they appear): [19, 17, 56, 19]

// REVERSE IS MUST: Flip the remainders so they can be decoded easily left-to-right
// Reversed Order (Left-to-Right format):       [19, 56, 17, 19]

// BASE62_CHARS: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
// Index 19 -> T
// Index 56 -> 4
// Index 17 -> R
// Index 19 -> T

// Final Output Base62 Fragment -> T4RT

/* Logic to Decode (No-Reverse Pattern) */
// Rebuild Giant Number: Read "TR4T" Left-To-Right. 
// Multiply each character's Base62 index by increasing powers of 62 (starting at 62^0).
// Total Sum = (19 * 62^0) + (17 * 62^1) + (56 * 62^2) + (19 * 62^3) = 4744569
//
// Extract Original Characters: Repeatedly divide the total by 256. 
// Collect remainders from right to left to recover ASCII [72, 101, 121] -> "Hey"

/* END */

class Solution {
    String BASE62_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890";
    java.math.BigInteger ZERO = java.math.BigInteger.ZERO;
    java.math.BigInteger base62 = java.math.BigInteger.valueOf(62);
    java.math.BigInteger base256 = java.math.BigInteger.valueOf(256);

    java.math.BigInteger bint(int value) {
        return java.math.BigInteger.valueOf(value);
    }

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            var runningTotal = ZERO;
            for (char c : str.toCharArray()) {
                int ascii = c;
                runningTotal = runningTotal.multiply(base256).add(bint(ascii));
            }
            StringBuilder base62String = new StringBuilder();
            while (runningTotal.compareTo(ZERO) > 0) {
                var divAndRem = runningTotal.divideAndRemainder(base62);
                int remainder = divAndRem[1].intValue();
                runningTotal = divAndRem[0];
                base62String.append(BASE62_CHARS.charAt(remainder));
            }
            // Must reverse because remainders are calculated right-to-left
            String reversed = base62String.reverse().toString();
            encoded.append(reversed.length());
            encoded.append("#");
            encoded.append(reversed);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            StringBuilder sbLen = new StringBuilder();
            while (str.charAt(i) != '#') {
                sbLen.append(str.charAt(i));
                i++;
            }
            int length = Integer.parseInt(sbLen.toString());
            i++;
            String encoded = str.substring(i, i + length);
            i+=length;

            var runningTotal = ZERO;
            for (char c : encoded.toCharArray()) {
                int base62Index = BASE62_CHARS.indexOf(c);
                runningTotal = runningTotal.multiply(base62).add(bint(base62Index));
            }
            StringBuilder decode = new StringBuilder();
            while (runningTotal.compareTo(ZERO) > 0) {
                var divAndRem = runningTotal.divideAndRemainder(base256);
                int remainder = divAndRem[1].intValue();
                runningTotal = divAndRem[0];
                decode.append((char) remainder);
            }
            decoded.add(decode.reverse().toString());
        }
        return decoded;
    }
}
