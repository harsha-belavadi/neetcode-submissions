class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            int[] bucket = new int[128]; // All 128 ASCII
            for (char c : s.toCharArray()) {
                bucket[c]++;
            }
            String key = Arrays.toString(bucket);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
