class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> target = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            char key = t.charAt(i);
            target.put(key, target.getOrDefault(key, 0) + 1);
        }

        int l = 0;
        int r = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int startIdx = -1;

        int n = s.length();
        int k = t.length();

        while(r < n) {
            char c = s.charAt(r);
            if (target.containsKey(c)) {
                if (target.get(c) > 0) count++;
                target.put(c, target.get(c) - 1);
            }

            while (count == k) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    startIdx = l;
                }
                c = s.charAt(l);
                if (target.containsKey(c)) {
                    target.put(c, target.get(c) + 1);
                    if (target.get(c) > 0) count--;
                }
                l++;
            }

            r++;
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLength);
    }
}
