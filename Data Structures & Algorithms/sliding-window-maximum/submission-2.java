class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); // Acts like Monotonic Stack For this Problem
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            while (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
            if (i >= k - 1) {
                result.add(nums[deque.getFirst()]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
