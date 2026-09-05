class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        int window = right - left + 1;
        while (left < right && window > k) {            
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                right--;
            } else {
                left++;
            }
            window = right - left + 1;      
        }
        List<Integer> result = new ArrayList<>();
        for (int i=left; i<=right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}