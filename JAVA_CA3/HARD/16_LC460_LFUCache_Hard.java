// LeetCode 460 - LFU Cache
// Java focus: static nested class, abstraction, constructors, final fields, composition
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LC460_LFUCache {
    private static class Node {
        int key;
        int value;
        int frequency;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> nodes;
    private final Map<Integer, LinkedHashSet<Integer>> frequencyBuckets;
    private int minFrequency;

    public LC460_LFUCache(int capacity) {
        this.capacity = capacity;
        this.nodes = new HashMap<>();
        this.frequencyBuckets = new HashMap<>();
        this.minFrequency = 0;
    }

    public int get(int key) {
        Node node = nodes.get(key);
        if (node == null) return -1;

        increaseFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (nodes.containsKey(key)) {
            Node existing = nodes.get(key);
            existing.value = value;
            increaseFrequency(existing);
            return;
        }

        if (nodes.size() == capacity) {
            LinkedHashSet<Integer> leastUsedKeys =
                    frequencyBuckets.get(minFrequency);
            int keyToRemove = leastUsedKeys.iterator().next();
            leastUsedKeys.remove(keyToRemove);
            if (leastUsedKeys.isEmpty()) {
                frequencyBuckets.remove(minFrequency);
            }
            nodes.remove(keyToRemove);
        }

        Node newNode = new Node(key, value);
        nodes.put(key, newNode);
        frequencyBuckets
                .computeIfAbsent(1, ignored -> new LinkedHashSet<>())
                .add(key);
        minFrequency = 1;
    }

    private void increaseFrequency(Node node) {
        int oldFrequency = node.frequency;
        LinkedHashSet<Integer> oldBucket = frequencyBuckets.get(oldFrequency);
        oldBucket.remove(node.key);

        if (oldBucket.isEmpty()) {
            frequencyBuckets.remove(oldFrequency);
            if (minFrequency == oldFrequency) {
                minFrequency++;
            }
        }

        node.frequency++;
        frequencyBuckets
                .computeIfAbsent(node.frequency, ignored -> new LinkedHashSet<>())
                .add(node.key);
    }

    public static void main(String[] args) {
        LC460_LFUCache cache = new LC460_LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1; key 1 becomes more frequent
        cache.put(3, 3);                  // evicts key 2
        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 3
        cache.put(4, 4);                  // evicts key 1 (least frequency)
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
