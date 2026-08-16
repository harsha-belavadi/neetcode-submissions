class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int l = 0;
        int n = nums.length;
        int[] windows = new int[n - k + 1];
        for (int r=0; r<n; r++) {
            if (!deque.isEmpty() && deque.peekFirst() < r - k + 1) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && (nums[deque.peekLast()] <= nums[r])) {
                deque.removeLast();
            }
            deque.addLast(r);

            if (r - l + 1 == k) {
                windows[r - k + 1] = nums[deque.peekFirst()];
                l++;
            }
        }
        return windows;
    }
}
