class BinaryTree
{
   public class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
        }
    }
    int idx=-1;
    // ADD NODES OF TREE ACCORDING TO PREORDER..
    public Node addData(int nodes[])
    {
        idx++;
        if(nodes[idx]==-1)
        {
            return null;
        }
        Node nn=new Node(nodes[idx]);
        nn.left=addData(nodes);
        nn.right=addData(nodes);
        return nn;
    }
    // Pre-Order Traversal
    void preOrder(Node root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
public class Tree
{
    public static void main(String[] args) 
    {
       int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1}; 
       BinaryTree tree=new BinaryTree();
       BinaryTree.Node root=tree.addData(nodes);
       tree.preOrder(root);
    }
}