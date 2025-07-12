public class MyHashSet<T>
{
    private MyHashMap<T,Object> map;
    
    public MyHashSet()
    {
        map = new MyHashMap<T, Object>(); 
    }
    public void add(T key)
    {
        map.put(key,1);
    }
    public boolean contains(T key)
    {
        return map.containskey(key);
    }
    public void remove(T key)
    {
        map.remove(key);
    }
}