class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(String.format("%d#%s", s.length(), s));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> decoded = new ArrayList<>();
        while (i < str.length()) {
            // Find the delimiter separating length and content
            int delimiterIdx = str.indexOf("#", i);

            // Extract and parse the length
            int length = Integer.parseInt(str.substring(i, delimiterIdx));

            // Move pointer past the '#' delimiter
            i = delimiterIdx + 1;

            // Extract the original string and advance the pointer
            decoded.add(str.substring(i, i + length));
            i += length;
        }

        return decoded;
    }
}
