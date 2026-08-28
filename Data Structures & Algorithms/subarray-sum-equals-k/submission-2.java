class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer, Integer> prefix = new HashMap<>()
       {{
        put(0, 1);
       }};
       int count = 0;
       int prefixSum = 0;
       for (int n : nums) {
            prefixSum += n;
            int diff = prefixSum - k;
            if (prefix.containsKey(diff)) {
                count += prefix.get(diff);
            }
            prefix.put(prefixSum, prefix.getOrDefault(prefixSum, 0) + 1);
       }
       return count;
    }
}
/*
Input: nums = [2,-1,1,2], k = 2
Output: 4

prefix_counter
0 1
2 2
1 1
4 1

count 0 -> 1 -> 1 -> 2 -> 4

Tracing:
--------
count = 0
when i=0: count + prefix(2 - k) => prefix(0) = 1 ===> 0 + 1 = 1 
count = 1

count = 1
when i=1: count + prefix(1-2) => prefix(-1) not found - pass

count = 1
when i=2: count + prefix(2-2) => prefix(0) = 1 ===> 1 + 1 = 2
count = 2

count = 2
when i=3: count + prefix(4-2) => prefix(2) = 2 ===> 2 + 2 = 4
count = 4

return count;

*/