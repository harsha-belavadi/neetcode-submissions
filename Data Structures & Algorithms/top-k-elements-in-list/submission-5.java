class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) { 
            counter.put(n, counter.getOrDefault(n, 0) + 1); 
        }

        Map<Integer, List<Integer>> frequencies = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int n = entry.getKey();
            int count = entry.getValue();
            if (!frequencies.containsKey(count)) {
                frequencies.put(count, new ArrayList<>());
            }
            frequencies.get(count).add(n); 
        }

        List<Integer> result = new ArrayList<>();
        outer:
        for (int i=nums.length; i>=1; i--) {
            if (frequencies.containsKey(i)) {
                for (int n : frequencies.get(i)) {
                    k--;
                    result.add(n);
                    if (k == 0) { break outer; }
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
