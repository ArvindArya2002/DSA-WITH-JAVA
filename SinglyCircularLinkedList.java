class LL
{
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
        }
    }
    Node head;
    Node cn;
    void addNodeAtLast(int data)
    {
        Node nn=new Node(data);
        if(head==null)
        {
            cn=head=nn;
            nn.next=head;
            return;
        }
        cn.next=nn;
        cn=nn;
        cn.next=head;
    }
    void addNodeAtBegning(int data)
    {
        Node nn=new Node(data);
        if(head==null)
        {
           cn=head=nn;
           cn.next=head;
           return;
        }
        nn.next=head;
        cn.next=nn;
        head=nn;
    }
    void traverseList()
    {
        if(head==null)
        {
            System.out.println("List is empty..");
            return;
        }
        Node cn=head;
        do
        {
            System.out.print(cn.data+" ");
            cn=cn.next;
        }while(cn!=head);
    }
}
public class SinglyCircularLinkedList 
{
 public static void main(String[] args) 
 {
        LL l=new LL();
        int nums[]={1,2,3,4,5,33,44,22,11};
        // for(int i=0;i<nums.length;i++)
        // {
        //     l.addNodeAtLast(nums[i]);
        // }
        // l.traverseList();
        for(int i=0;i<nums.length;i++)
        {
           l.addNodeAtBegning(nums[i]);
        }    
        l.traverseList();
 }   
}
