class TimeStore {
    String value;
    int time;
    TimeStore(String value, int time) {
        this.value = value;
        this.time = time;
    }

    public String getValue() {
        return this.value;
    }

    public int getTime() {
        return this.time;
    }
}

class TimeMap {
    Map<String, List<TimeStore>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        TimeStore timestore = new TimeStore(value, timestamp);
        map.get(key).add(timestore);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) { return ""; }
        List<TimeStore> store = map.get(key);
        int[] time = new int[store.size()];
        String[] values = new String[store.size()];
        int i = 0;
        for (TimeStore timestore : store) {
            String value = timestore.getValue();
            int n = timestore.getTime();
            values[i] = value;
            time[i] = n;
            i++;
        }
        int index = binarysearch(time, timestamp);
        if (index == -1) { return ""; }
        return values[index];
    }

    private int binarysearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int upperbound = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                upperbound = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return upperbound;
    }
}
