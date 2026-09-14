class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        Map<Integer, List<Integer>> frequency = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (!frequency.containsKey(value)) {
                frequency.put(value, new ArrayList<>());
            }
            frequency.get(value).add(key);
        }

        int n = nums.length;
        List<Integer> output = new ArrayList<>();
        outer:
        for (int count=n; count>=1; count--) {
            List<Integer> values = frequency.getOrDefault(count, new ArrayList<>());
            for (int value : values) {
                output.add(value);
                k--;
                if (k == 0) { break outer; }
            }            
        }

        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
