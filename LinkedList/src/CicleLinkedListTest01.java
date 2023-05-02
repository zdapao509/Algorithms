/*
单向环形链表的创建------增删改查方法
* */

public class CicleLinkedListTest01 {
    public static void main(String[] args) {
        ChildNodeLinkedList childNodeLinkedList=new ChildNodeLinkedList();
        childNodeLinkedList.showNode();

/*  用节点添加
      ChildNode child1=new ChildNode(1,"张");
        childNodeLinkedList.addNode(child1);
        childNodeLinkedList.showNode();

        ChildNode child2=new ChildNode(2,"汪");
        childNodeLinkedList.addNode(child2);
        ChildNode child3=new ChildNode(3,"李");
        childNodeLinkedList.addNode(child3);
        ChildNode child4=new ChildNode(4,"赵");
        childNodeLinkedList.addNode(child4);
        childNodeLinkedList.showNode();*/

        childNodeLinkedList.addNode(5);//用节点数量添加
        childNodeLinkedList.showNode();

//        outCicleOrder(childNodeLinkedList.head,2);//约瑟夫出环形链表；注意执行完这个操作，
//        链表中头结点存的next节点位置就会改变这个时候就已经不是环状了，所以这行和下一行是不能共存的，他打乱了链表的顺序

        System.out.println("************************************************************\n\n");

        childNodeLinkedList.outCircleLinkedList(1,2,5);//约瑟夫环出链表，按照韩的方法写的，可以从链表中的某个位置开始出链表
    }

//    约瑟夫环形问题，根据用户的输入，计算出小孩出圈的问题：-----自己写的：只能从第一个节点输出
    public static void outCicleOrder(ChildNode head,int num){
        ChildNode temp=head;
        ChildNode helper=new ChildNode();
        helper.next=head;
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }else if(num==1){
            System.out.println("出圈顺序："+temp);
            return;
        }

        while(true){
            for(int i=0;i<num-1;i++){
                temp=temp.next;
                helper=helper.next;
                helper.next=temp;
            }
            System.out.println(temp);
            temp=temp.next;
            helper.next=temp;
            if(helper.next==helper){
                System.out.println(helper);
                System.out.println("出链表完毕");
                break;
            }
        }
    }
}

class ChildNodeLinkedList{
    ChildNode head=new ChildNode();

//    增加节点
    /*public void addNode(ChildNode child){
        if(head.next==null){
            head=child;
            child.next=head;
        }
        ChildNode cur=head;//指向链表中最新的节点
        while(true){
            if(cur.next==head){
                break;
            }
            cur=cur.next;
        }
        cur.next=child;
        child.next=head;
    }*/

    public void addNode(int num){//添加节点的方法，按照节点的数量添加---------------韩顺平数据结构课里面用的节点数量定义的
        if(num<1){
            System.out.println("节点数小于1，不存在");
            return;
        }
        ChildNode cur=head;//指向链表中最新的节点
        for (int i = 1; i <= num ; i++) {
            ChildNode childNode=new ChildNode(i,"小孩"+i+"号");
            if(i==1){
                head=childNode;
                childNode.next=head;
                cur=childNode;
            }else{
                cur.next=childNode;
                childNode.next=head;
                cur=cur.next;
            }
        }
    }

//    遍历环形链表
    public void showNode(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        ChildNode childNode=head;//辅助指针
        while(true){
            System.out.println(childNode);
            childNode=childNode.next;
            if(childNode==head){
                System.out.println("遍历完成");
                break;
            }
        }
    }

//    环形链表出圈,出圈顺序,出圈的第一个节点,节点数量都要指定:----------韩顺平自己写的
    public void outCircleLinkedList(int nodeHead,int count,int num){
        if(nodeHead>num||nodeHead<1||num==0||count==0||this.head==null){
            System.out.println("输入有误");
            return;
        }
        ChildNode helper=head;//创建一个节点，让节点的位置指向最后一个节点
        while(true){
            if(helper.next==head){
                break;
            }
            helper=helper.next;
        }

        for (int i = 0; i < nodeHead-1; i++) {//开始移动节点，让开始的节点和helper辅助点移动至指定位置
            head=head.next;
            helper=helper.next;
        }

        while(true){
//            开始出圈

            if(helper==head){
                System.out.println(helper+"\n出圈完成");
                break;
            }
            for (int i = 0; i < count-1; i++) {
                head=head.next;
                helper=helper.next;
            }
            System.out.println(head);
            head=head.next;//当只剩一个节点的时候，经过这一次操作，head指向了最后一个节点。而helper也指向该节点
            helper.next=head;
        }
    }
}
class ChildNode{
    private int val;
    private String name;
    ChildNode next;
    public ChildNode(){}
    public ChildNode(int val,String name){
        this.val=val;
        this.name=name;
    }
    public String toString(){
        return "序号："+val+"  姓名："+name;
    }
}
