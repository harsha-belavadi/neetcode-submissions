class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String s : strs) {
            int[] buckets = new int[256];
            for (char c : s.toCharArray()) {
                buckets[c]++;
            }
            String key = Arrays.toString(buckets);
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            anagrams.get(key).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }
}
