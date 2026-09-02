class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;

        while (left < word1.length() && right < word2.length()) {
            char c1 = word1.charAt(left);
            char c2 = word2.charAt(right);

            sb.append(c1);
            sb.append(c2);
            
            left++;
            right++;
        }

        while (left < word1.length()) {
            char c = word1.charAt(left);
            sb.append(c);
            left++;
        }

        while (right < word2.length()) {
            char c = word2.charAt(right);
            sb.append(c);
            right++;
        }

        return sb.toString();
    }
}