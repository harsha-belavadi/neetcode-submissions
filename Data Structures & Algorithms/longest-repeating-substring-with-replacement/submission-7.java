class Solution {
    Map<Character, Integer> counter = new HashMap<>();
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int window = 0;
        int maxWindow = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            counter.put(c1, counter.getOrDefault(c1, 0) + 1);
            window = right - left + 1;
            while (window - getMax() > k) {
                char c2 = s.charAt(left);
                counter.put(c2, counter.get(c2) - 1);                
                left++;
                window = right - left + 1;
            }
            maxWindow = Math.max(maxWindow, window);
            right++;
        }
        return maxWindow;
    }

    private int getMax() {
        int max = 0;
        for (int value : counter.values()) {
            max = Math.max(max, value);
        }
        return max;
    }
}
