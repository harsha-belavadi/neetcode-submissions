class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);        
        int[] result = new int[n - k + 1];
        int i = 0;
        int left = 0;
        for (int right=0; right<n; right++) {
            queue.add(nums[right]);
            if (right >= k-1) { 
                result[i++] = queue.peek();
                queue.remove(nums[left]);
                left++;
            }            
        }
        return result;       
    }
}
