public class Main {
    public static void main(String args[])
    {
        Trie tryDS = new Trie();
        tryDS.insert("arun");
        tryDS.insert("varun");
        tryDS.insert("kumar");
        tryDS.insert("bat");
        tryDS.insert("ba");

        System.out.println(tryDS.isPrefixPresent("va"));

        System.out.println(tryDS.isPresent("arunss"));
        
    }
}
