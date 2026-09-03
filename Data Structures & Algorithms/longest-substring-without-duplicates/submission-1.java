class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> tracker = new HashSet<>();        
        int left = 0;
        int right = 0;
        int window = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            while (left <= right && tracker.contains(c1)) {
                char c2 = s.charAt(left);
                tracker.remove(c2);
                left++;
            }
            tracker.add(c1);
            window = Math.max(window, right - left + 1);
            right++;         
        }
        return window;
    }
}
