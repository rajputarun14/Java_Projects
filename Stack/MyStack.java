class Node<T>{
    T data;
    Node<T> next;
    Node(){};
    Node(T data)
    {
        this.data = data;
    }
}
public class MyStack<T> {
    int capacity;
    Node<T> node;
    int size = 0;
    Node<T> top;
    MyStack(int capacity)
    {
        this.capacity = capacity;
        this.node = null;
    }

    public void push(T data) throws Exception
    {
        Node<T> newNode = new Node<>(data);
        if(size == capacity)
        {
            throw new Exception("Size full");
        }
        newNode.next = node;
        node = newNode;
        size++;

    }
    public T pop() throws Exception
    {
        if(size == 0)
        {
            throw new Exception("Null stack");
        }
        Node<T> tmp = node;
        node = node.next;
        size--;
        return tmp.data;
    }
    public T peek() throws Exception{
        if(size == 0)
        {
            throw new Exception("Null stack");
        }
        return node.data;

    }
    public int size()
    {
        return this.size;
    }
}
class Main{
    public static void main(String[] args) throws Exception
    {
        MyStack<Integer> st = new MyStack<>(3);
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
