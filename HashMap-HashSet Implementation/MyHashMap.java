
class Node<K,V>
{
    int hashCode;
    K key;
    V value;
    Node<K,V> next;
    
    Node(K key, V value, int hashCode)
    {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}
class MyHashMap<K,V>
{
    int capacity = 16;
    float loadFactor = 0.75f;
    int size = 0;
    Node<K,V> [] hashTable;
    
    
    public MyHashMap() 
    {
    hashTable = new Node[capacity]; // initialize array
    }
    public MyHashMap(K key, V value)
    {
        hashTable = new Node[capacity];
    }
    public int hash(K key)
    {
        return key == null? 0: key.hashCode() ^ (key.hashCode() >>> 16);
    }
    public int indexForTable(int hash)
    {
        return hash & (capacity - 1);
    }
    
    public void put(K key, V value)
    {
        int hashcode = hash(key);
        int index = indexForTable(hashcode);
        
        Node<K,V> node = hashTable[index];
        
        for(Node<K,V> curr = node; curr != null; curr = curr.next)
        {
            if(curr.hashCode == hashcode  && ( curr.key == key || curr.key.equals(key) ))
            {
                curr.value = value;
                return;
            }
        }
        Node<K,V> newNode = new Node<>(key, value, hashcode);
        newNode.next = node;
        hashTable[index] = newNode;
        size++;
        
        if(size >= capacity * loadFactor)
        {
            resize();
        }
        
    }
    
    public V get(K key)
    {
        int hashcode = hash(key);
        int index = indexForTable(hashcode);
        Node<K,V> getNode = hashTable[index];
        for(Node<K,V> curr = getNode; curr!= null; curr = curr.next)
        {
            if(curr.hashCode == hashcode && (curr.key == key || curr.key.equals(key)))
            {
                return curr.value;
            }
        }
        return null;
    }
    
    public void remove(K key)
    {
        int hashcode = hash(key);
        int index = indexForTable(hashcode);
        Node<K,V> curr = hashTable[index];
        Node<K,V> prev = null;
        while(curr!=null)
        {
            if(curr.hashCode == hashcode && (curr.key == key || curr.key.equals(key)))
            {
                if(prev == null)
                {
                    hashTable[index] = curr.next;
                }
                else{
                    prev.next = curr.next;
                }
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    public boolean containskey(K key)
    {
        return get(key)!=null;
    }
    
    private void resize() {
    int newCapacity = capacity * 2;
    Node<K, V>[] newTable = new Node[newCapacity];

    for (int i = 0; i < hashTable.length; i++) {
        Node<K, V> node = hashTable[i];
        while (node != null) {
            Node<K, V> next = node.next;
            int index = node.hashCode & (newCapacity - 1);
            node.next = newTable[index];
            newTable[index] = node;
            node = next;
        }
    }

    capacity = newCapacity;
    hashTable = newTable;
}  
}



