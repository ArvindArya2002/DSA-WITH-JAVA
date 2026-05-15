import java.util.LinkedList;
import java.util.Queue;
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
    void Inorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }
    void postorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    void levelOrderTraversal(Node root)
    {
        if(root==null)
        {
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            Node cn=q.remove();
            if(cn==null)
            {
                System.out.println();
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    q.add(null);
                }
            }
            else
            {
                System.out.print(cn.data+" ");
                if(cn.left!=null)
                {
                    q.add(cn.left);
                }
                if(cn.right!=null)
                {
                    q.add(cn.right);
                }
            }
        }
    }
    // Counting No. of Nodes..
    int countNodes(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int LeftNodes=countNodes(root.left);
        int RightNodes=countNodes(root.right);
        return LeftNodes+RightNodes+1;
    }
    // Counting Sum of Nodes..
    int SumNodes(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int LeftNodesSum=SumNodes(root.left);
        int RightNodeSum=SumNodes(root.right);
        return LeftNodesSum+RightNodeSum+root.data;
    }
    // Height of tree
    int TreeHeigth(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int LeftHeight=TreeHeigth(root.left);
        int RightHeight=TreeHeigth(root.right);
        int max=Math.max(LeftHeight, RightHeight);
        return max+1;
    }
    // Diameter of Tree through O(N sq)
    int Diam1(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftSubTreeDiam=Diam1(root.left);
        int RightSubTreeDiam=Diam1(root.right);
        int rootDiam=TreeHeigth(root.left)+TreeHeigth(root.right)+1;
        return Math.max(rootDiam, Math.max(leftSubTreeDiam,RightSubTreeDiam));
    }
    // Diameter of Tree through O(N)
    class treeInfo
    {
        int leftHeight=0;
        int rightHeight=0;

        public treeInfo(int leftHeight,int rightHeight) 
        {
            this.leftHeight=leftHeight;
            this.rightHeight=rightHeight;
        }
        
    }
    treeInfo Diam2(Node root)
    {
        if(root==null)
        {
            return new treeInfo(0,0);
        }
       treeInfo leftT1=Diam2(root.left);
       treeInfo rightT1=Diam2(root.right);
       int myHeight=Math.max(leftT1.TreeHeigth + rightT1.TreeHeigth + 1);

    }
}
public class Tree
{
    public static void main(String[] args) 
    {
       int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1}; 
       BinaryTree tree=new BinaryTree();
       BinaryTree.Node root=tree.addData(nodes);
       System.out.println(tree.Diam1(root));
    }
}