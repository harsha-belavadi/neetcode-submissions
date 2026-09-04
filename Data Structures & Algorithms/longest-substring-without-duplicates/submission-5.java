class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> unique = new HashSet<>();
        int left = 0;
        int right = 0;
        int window = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            while (unique.contains(c)) {
                unique.remove(s.charAt(left));
                left++;
            }
            window = Math.max(window, right - left + 1);
            unique.add(c);
            right++;
        }
        return window;        
    }
}
