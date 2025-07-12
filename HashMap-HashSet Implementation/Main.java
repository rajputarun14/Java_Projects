public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		MyHashMap<String, String> myMap = new MyHashMap<String, String>();
        System.out.println("HashMap Operations");
		myMap.put("arun", "kumar");
		System.out.println(myMap.get("arun"));
		myMap.remove("arun");
		System.out.println(myMap.containskey("arun"));




        System.out.println("HashSet Operations");
        MyHashSet<String> set = new MyHashSet<String>();
        set.add("apple");
        set.add("banana");

        System.out.println(set.contains("apple"));  // true
        System.out.println(set.contains("grape"));  // false

        set.remove("banana");
        System.out.println(set.contains("banana"));
	}
}