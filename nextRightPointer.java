import java.util.*;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class nextRightPointer {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        nextRightPointer obj = new nextRightPointer();
        obj.connect(root);

        // Print the next pointers
        System.out.println(root.left.next.val); // Should print 3
        System.out.println(root.left.left.next.val); // Should print 5
    }       
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();

            for(int i=0;i<n;i++){
                 Node curr=q.poll();
                 if(curr.left!=null)q.add(curr.left);
                 if(curr.right!=null)q.add(curr.right);
                 if(i+1<n){
                    curr.next=q.peek();
                 }else{
                    curr.next=null;
                 }
            }
        }
        return root;
    }
}
