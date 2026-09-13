class Solution {
    public void sortColors(int[] nums) {
        int[] buckets = new int[3];
        for (int n : nums) { buckets[n]++; }
        int k=0;
        for (int i=0; i<3; i++) {
            while (buckets[i] > 0) {
                nums[k] = i;
                buckets[i]--;
                k++;
            }
        }
    }
}