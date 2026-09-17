class LRUCache {
    Map<Integer, Integer> cache;
    SequencedSet<Integer> lru;
    int capacity;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        lru = new LinkedHashSet<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
// Java 21 feature: addLast moves the existing element to the end (MRU)
        lru.addLast(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
        lru.addLast(key);

        if (cache.size() > capacity) {
            int k = lru.removeFirst();
            cache.remove(k);
        }
    }
}
