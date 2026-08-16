class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> counter = new HashMap<>();
        int l = 0;
        int length = 0;
        for (int r=0; r<s.length(); r++) {
            char ch = s.charAt(r);
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
            int windowSize = r - l + 1;
            while (l < r && windowSize - getMaxCount(counter) > k) {
                char ch_l = s.charAt(l);
                counter.put(ch_l, counter.get(ch_l) - 1);                
                l++;
                windowSize = r - l + 1; // This should be placed after l incremented to get correct window size
            }                     
            length = Math.max(length, windowSize);
        }
        return length;
    }

    private int getMaxCount(Map<Character, Integer> counter) {
        int maxCount = Integer.MIN_VALUE;
        for (int count : counter.values()) {
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
