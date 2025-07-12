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
    private static int capacity;
    HashMap<Integer, Node> cache;
    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        Node head = new Node(0,0);
        Node tail = new Node(0,0);

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
        }
    }
    public void remove(Node node){
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }
}