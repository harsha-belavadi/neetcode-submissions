class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) {
            maxHeap.add(s);
        }

        while (maxHeap.size() > 1) {
            int v2 = maxHeap.poll();
            int v1 = maxHeap.poll();
            maxHeap.add(v2 - v1);
        }

        return maxHeap.peek();
    }
}
