class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = merge(nums1, nums2);
        int k = (n + m + 1) / 2;
        int l1 = k;
        int l2 = k - 1;
        if ((n + m) % 2 != 0) {
            return merged[k-1];
        } else {
            return (double) (merged[l1] + merged[l2]) / 2.0;
        }
    }

    private int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int n = left.length;
        int m = right.length;
        int[] merged = new int[n + m];
        while (i < n && j < m) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
        while (i < n) {
            merged[k++] = left[i++];
        }
        while (j < m) {
            merged[k++] = right[j++];
        }
        return merged;
    }
}
