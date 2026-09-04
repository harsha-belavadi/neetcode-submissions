class Solution {
    Map<Character, Integer> counter = new HashMap<>();
    public int characterReplacement(String s, int k) {        
        int left=0;
        int window = 0;
        int maxCount = 0;
        int maxWindow = 0;
        for (int right=0; right<s.length(); right++) {
            char c1 = s.charAt(right);
            counter.put(c1, counter.getOrDefault(c1, 0) + 1);
            window = right - left + 1;
            while (window - getMaxCount() > k) {
                char c2 = s.charAt(left);
                counter.put(c2, counter.get(c2) - 1);
                left++;
                window = right - left + 1;
            }
            maxWindow = Math.max(maxWindow, window);
        }
        return maxWindow;
    }

    private int getMaxCount() {
        int maxCount = 0;
        for (int v : counter.values()) {
            maxCount = Math.max(maxCount, v);
        }
        return maxCount;
    }
}
