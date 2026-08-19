class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Deque<int[]> queue = new ArrayDeque<>();

        Map<Character, Integer> counter = new HashMap<>();
        for (char task : tasks) { counter.put(task, counter.getOrDefault(task, 0) + 1 ); }

        for (int count : counter.values()) { maxHeap.add(count); }

        int t = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            int updatedTaskCnt = 0;
            if (!maxHeap.isEmpty()) {
                int taskCnt = maxHeap.poll();
                updatedTaskCnt = taskCnt - 1;
            }

            t++;

            if (updatedTaskCnt > 0) {
                queue.add(new int[] { updatedTaskCnt, t + n });
            }

            if (!queue.isEmpty()) {
                int[] first = queue.peekFirst();
                if (first[1] == t) {
                    queue.pollFirst();
                    maxHeap.add(first[0]);
                }
            }
        }
        return t;
    }
}
