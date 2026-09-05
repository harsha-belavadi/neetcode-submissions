class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int n = nums.length;
        int left = 0;
        int[] maxWindows = new int[n - k + 1];
        int i = 0;
        for (int right=0; right<nums.length; right++) {
            queue.add(nums[right]);
            if (right >= k-1) {
                maxWindows[i++] = queue.peek();
                queue.remove(nums[left]);
                left++;
            }
        }
        return maxWindows;
    }
}
