class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        int n = nums.length;
        int[] maxWindows = new int[n - k + 1];
        int midx = 0;
        for (int right=0; right<n; right++) {
            // 1. Add the current element to the heap
            queue.add(nums[right]);

            // 2. Once the window size hits k, record the maximum and slide the left side
            if (right >= k - 1) {
                maxWindows[midx++] = queue.peek();
                 // Calculate the left index that needs to leave the window
                int left = right - k + 1;
                queue.remove(nums[left]);
            }
        }
        return maxWindows;
    }
}
