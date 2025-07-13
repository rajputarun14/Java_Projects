import java.util.HashMap;

public class LRUCache{
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    public void put(int key, int value)
    {
        Node node;
        if(cache.containsKey(key))
        {
            node = cache.get(key);
            node.value = value;
            remove(node);
            insertAtHead(node);
            return;
        }
        if(cache.size() == capacity)
        {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
            ;
        }
        node = new Node(key, value);
        cache.put(key, node);
        insertAtHead(node);
    }
    public void remove(Node node){
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }
    public void remove(int key)
    {
        Node node;
        if(cache.containsKey(key))
        {
            node = cache.get(key);
            remove(node);
            cache.remove(key);
        }
    }
    public void insertAtHead(Node node)
    {
        Node tmp = head.next;
        head.next = node;
        node.prev = head;
        node.next = tmp;
        tmp.prev = node;
    }
    public int get(int key)
    {
        Node node;
        if(cache.containsKey(key))
        {
            node = cache.get(key);
            remove(node);
            insertAtHead(node);
            return node.value;
        }
        return -1;
    }
}