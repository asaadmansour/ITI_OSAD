public class Main {
    public static void main(String[] args) {
        LruCache cache = new LruImpl();
        cache.setCapacity(2);  // Cache can hold 2 items

        System.out.println("=== LRU Cache Tests ===\n");

        // Test 1: Basic put and get
        System.out.println("Test 1: Basic put and get");
        cache.put(1, 100);
        cache.put(2, 200);
        System.out.println("get(1) = " + cache.get(1) + " (expected: 100)");
        System.out.println("get(2) = " + cache.get(2) + " (expected: 200)");

        // Test 2: Get non-existent key
        System.out.println("\nTest 2: Get non-existent key");
        System.out.println("get(3) = " + cache.get(3) + " (expected: -1)");

        // Test 3: LRU eviction
        System.out.println("\nTest 3: LRU eviction");
        cache.put(1, 100);
        cache.put(2, 200);
        cache.get(1);        // Access key 1, so key 2 becomes LRU
        cache.put(3, 300);   // Should evict key 2 (LRU)
        System.out.println("get(2) = " + cache.get(2) + " (expected: -1, evicted)");
        System.out.println("get(1) = " + cache.get(1) + " (expected: 100)");
        System.out.println("get(3) = " + cache.get(3) + " (expected: 300)");

        // Test 4: Update existing key
        System.out.println("\nTest 4: Update existing key");
        cache.put(1, 999);   // Update key 1
        System.out.println("get(1) = " + cache.get(1) + " (expected: 999)");

        System.out.println("\n=== Tests Complete ===");
    }
}
