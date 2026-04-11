class LinkedList
{
    public class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
        }
    }
    Node head;
    Node tail;
    public void addNodeAtLast(int data)
    {
        Node nn=new Node(data);
        if(head==null)
        {
            head=tail=nn;
            return;
        }
        tail.next=nn;
        tail=nn;
    }
    public void addNodeBeforeBegning(int data)
    {
        Node nn=new Node(data);
        if(head==null)
        {
            head=tail=nn;
            return;
        }
        nn.next=head;
        head=nn;
    }
    public void traverseLinkedList()
    {
        if(head==null)
        {
            System.out.println("Linked List is empty...");
            return;
        }
        Node cn=head;
        while(cn!=null)
        {
            System.out.print(cn.data+" ");
            cn=cn.next;
        }
    }
}
public class SinglyLinkedList 
{
 public static void main(String[] args) 
 {
    LinkedList l=new LinkedList();
    int nums[]={1,2,3,4,5,33,44,22,11};
        // for(int i=0;i<nums.length;i++)
        // {
        //     l.addNodeAtLast(nums[i]);
        // }
    l.traverseLinkedList();
    System.out.println();
     for(int i=0;i<nums.length;i++)
    {
        l.addNodeBeforeBegning(nums[i]);
    }
    l.traverseLinkedList();
 }   
}
