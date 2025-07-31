
public class Trie{
    private Node root;
    Trie(){
        root = new Node();
    }
    public void insert(String word)
    {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            int idx = word.charAt(i) - 'a';
            if(node.child[idx] == null)
            {
                node.child[idx] = new Node();
            }
            node = node.child[idx];
        }
        node.isLast = true;
    }
    public boolean isPresent(String word)
    {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            int idx = word.charAt(i) - 'a';
            if(node.child[idx] == null)
                return false;
            node = node.child[idx];
        }
        return node.isLast;
    }
    public boolean isPrefixPresent(String word)
    {
         Node node = root;
        for(int i=0;i<word.length();i++)
        {
            int idx = word.charAt(i) - 'a';
            if(node.child[idx] == null)
                return false;
            node = node.child[idx];
        }
        return true;
    }
}