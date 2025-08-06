import java.util.LinkedList;
import java.util.Queue;

public class CreateBinaryTree {
    public static Node createTree(int[] nums, int i)
    {
        Node head;
        Node root = new Node(nums[i]);
        head = root;
        i++;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(i<nums.length && !q.isEmpty())
        {
            Node tmp = q.poll();
            if(nums[i]!=-1 && i<nums.length)
            {
                tmp.left = new Node(nums[i]);
                q.add(tmp.left);
            }
            i++;

            if(nums[i]!=-1 && i<nums.length)
            {
                tmp.right = new Node(nums[i]);
                q.add(tmp.right);
            }
            i++;
        }
        return head;
    }

    public static void levelOrderTraversal(Node head)
    {
        Queue<Node> qq = new LinkedList<>();
        qq.add(head);
        while(!qq.isEmpty())
        {
            Node tmp =  qq.poll();
            System.out.print(tmp.data);
            System.out.print(" ");
            if(tmp.left != null)qq.add(tmp.left);
            if(tmp.right != null)qq.add(tmp.right);
        }
    }
    public static void main(String args[])
    {
        int[] nums = new int[]{10, 20, 30, 40, 50, 60, 70};
        Node head = createTree(nums, 0);
        levelOrderTraversal(head);
    }
}
