class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        while (left < n && right < m) {
            char c1 = word1.charAt(left);
            char c2 = word2.charAt(right);
            sb.append(c1);
            sb.append(c2);
            left++;
            right++;
        }
        
        while (left < n) {
            sb.append(word1.charAt(left));
            left++;
        }

        while (right < m) {
            sb.append(word2.charAt(right));
            right++;
        }

        return sb.toString();
    }
}