class DynamicArray {

    Integer[] nums;
    Integer top = 0;
    public DynamicArray(int capacity) {
        nums = new Integer[capacity];
    }

    public int get(int i) {
        return nums[i];
    }

    public void set(int i, int n) {
        nums[i] = n;
    }

    public void pushback(int n) {
        if (top == nums.length) {
            resize();
            nums[top] = n;
            top++;
            return;
        }
        nums[top] = n;
        top++;
    }

    public int popback() {
        int pop = nums[top-1];
        nums[top-1] = null;
        top--;
        return pop;
    }

    private void resize() {
        int length = 2 * nums.length;
        Integer[] copy = new Integer[length];
        for (int i=0; i<nums.length; i++) {
            copy[i] = nums[i];
        }
        nums = copy;
    }

    public int getSize() {
        return top;
    }

    public int getCapacity() {
        return nums.length;
    }
}
