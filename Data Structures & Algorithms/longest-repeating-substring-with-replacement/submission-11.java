class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int longest = 0;
        while (right < n) {
            char c1 = s.charAt(right);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            int window = right - left + 1;
            while (left < right && window - getMax() > k) {
                char c2 = s.charAt(left);                
                map.put(c2, map.get(c2) - 1);
                if (map.get(c2) == 0) {
                    map.remove(c2);
                }
                left++;
                window = right - left + 1;
            }
            longest = Math.max(longest, window);
            right++;
        }
        return longest;
    }

    private int getMax() {
        int max = 0;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }
        return max;
    }
}
