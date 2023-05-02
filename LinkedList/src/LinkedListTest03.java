import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
������ķ�ת----��Ѷ������
* */
public class LinkedListTest03 {
    public static void main(String[] args) {
        LinkedNode head=new LinkedNode(1);
        LinkedNode a=new LinkedNode(2);
        LinkedNode b=new LinkedNode(3);
        LinkedNode c=new LinkedNode(3);
        LinkedNode d=new LinkedNode(5);
        head.linked=a;
        a.linked=b;
        b.linked=c;
        c.linked=d;
        System.out.println(head);

//        System.out.println(turnaround(head));//��ת����

//        reverseOutput(head);//��β��ͷ�������

        LinkedNode head1=new LinkedNode(1);
        LinkedNode a1=new LinkedNode(1);
        LinkedNode b1=new LinkedNode(3);
        LinkedNode c1=new LinkedNode(4);
        LinkedNode d1=new LinkedNode(5);
        head1.linked=a1;
        a1.linked=b1;
        b1.linked=c1;
        c1.linked=d1;

        System.out.println(andLinkedlist(head,head1));//�ϳ�������������
    }

//    ����������ķ�ת
    public static LinkedNode turnaround(LinkedNode head){
        if(head==null){
            return null;
        }
        LinkedNode temp1=head;
        LinkedNode temp2=head.linked;
        LinkedNode temp=head;
        while(temp2!=null){
            temp1.linked=temp2.linked;//ע�������temp1����һ��ָ��temp2����һ����
            temp2.linked=temp;
            temp=temp2;
            temp2=temp1.linked;
        }
        return temp;
    }

//    �����β��ͷ���������
    public static void reverseOutput(LinkedNode head){
        if(head==null){
            return;
        }

        Stack<LinkedNode> stack=new Stack<LinkedNode>();

        LinkedNode cur=head;

        while(cur!=null){
            stack.push(cur);//ע����������룬�ǵ�ǰ�Ľڵ������
            cur=cur.linked;
        }

        while(stack.size()>0){
            System.out.println(stack.pop());
        }

    }

//    �ϲ�������������
    public static LinkedNode andLinkedlist(LinkedNode head1,LinkedNode head2){
        if(head1==null||head2==null){
            return head1==null?head1:head2;
        }
        LinkedNode res=head1.val> head2.val?head2:head1;
        LinkedNode temp=res;
        LinkedNode temp1=temp.linked;
        LinkedNode temp2=temp==head1?head2:head1;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<=temp2.val){
                temp.linked=temp1;
                temp1=temp1.linked;
                temp=temp.linked;
            }else{
                temp.linked=temp2;
                temp2=temp2.linked;
                temp=temp.linked;
            }
        }
        if(temp1==null){
            temp.linked=temp2;
        }else{
            temp.linked=temp1;
        }
        return res;
    }
}

class LinkedNode{
    int val;
    LinkedNode linked;
    public LinkedNode(){}
    public LinkedNode(int val){
        this.val=val;
    }
    public String toString(){
        return String.valueOf(this.val)+"  "+this.linked;
    }
}
