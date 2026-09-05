class Solution {
    Map<Character, Integer> counter = new HashMap<>();
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < n) {
            char c1 = s.charAt(right);
            counter.put(c1, counter.getOrDefault(c1, 0) + 1);
            int window = right - left + 1;
            while (window - getMax() > k) {
                char c2 = s.charAt(left);
                counter.put(c2, counter.get(c2) - 1);                
                left++;
                window = right - left + 1;
            }
            maxLength = Math.max(maxLength, window);
            right++;            
        }
        return maxLength;
    }

    private int getMax() {
        int max = 0;
        for (int value : counter.values()) {
            max = Math.max(max, value);
        }
        return max;
    }
}
