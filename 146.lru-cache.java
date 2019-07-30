import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Hard (25.35%)
 * Likes:    3272
 * Dislikes: 118
 * Total Accepted:    324K
 * Total Submissions: 1.2M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache( 2 );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */
class LRUCache {
    Map<Integer, Node> cache;
    int cap, size = 0;
    Node head, tail;

    public LRUCache(int capacity) {
        // if (capacity < 1)
        // throw new Exception("cap should be positive value");
        cache = new HashMap<>();
        cap = capacity;

        // pseudo nodes for simplicity
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        Node node = cache.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }

        Node newNode = new Node(key, value);
        addHead(newNode);
        cache.put(key, newNode);

        size++;

        if (size > cap) {
            Node removed = removeTail();
            cache.remove(removed.key);

            size--;
        }
    }

    void addHead(Node h) {
        head.next.prev = h;
        h.next = head.next;
        h.prev = head;
        head.next = h;
    }

    void moveToHead(Node node) {
        removeNode(node);
        addHead(node);
    }

    Node removeTail() {
        Node t = tail.prev;
        removeNode(t);
        return t;
    }

    void removeNode(Node node) {
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
    }

    static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int k, int v) {
            key = k;
            val = v;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
