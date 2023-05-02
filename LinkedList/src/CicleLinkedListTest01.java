/*
����������Ĵ���------��ɾ�Ĳ鷽��
* */

public class CicleLinkedListTest01 {
    public static void main(String[] args) {
        ChildNodeLinkedList childNodeLinkedList=new ChildNodeLinkedList();
        childNodeLinkedList.showNode();

/*  �ýڵ����
      ChildNode child1=new ChildNode(1,"��");
        childNodeLinkedList.addNode(child1);
        childNodeLinkedList.showNode();

        ChildNode child2=new ChildNode(2,"��");
        childNodeLinkedList.addNode(child2);
        ChildNode child3=new ChildNode(3,"��");
        childNodeLinkedList.addNode(child3);
        ChildNode child4=new ChildNode(4,"��");
        childNodeLinkedList.addNode(child4);
        childNodeLinkedList.showNode();*/

        childNodeLinkedList.addNode(5);//�ýڵ��������
        childNodeLinkedList.showNode();

//        outCicleOrder(childNodeLinkedList.head,2);//Լɪ�����������ע��ִ�������������
//        ������ͷ�����next�ڵ�λ�þͻ�ı����ʱ����Ѿ����ǻ�״�ˣ��������к���һ���ǲ��ܹ���ģ��������������˳��

        System.out.println("************************************************************\n\n");

        childNodeLinkedList.outCircleLinkedList(1,2,5);//Լɪ�򻷳��������պ��ķ���д�ģ����Դ������е�ĳ��λ�ÿ�ʼ������
    }

//    Լɪ�������⣬�����û������룬�����С����Ȧ�����⣺-----�Լ�д�ģ�ֻ�ܴӵ�һ���ڵ����
    public static void outCicleOrder(ChildNode head,int num){
        ChildNode temp=head;
        ChildNode helper=new ChildNode();
        helper.next=head;
        if(head.next==null){
            System.out.println("����Ϊ��");
            return;
        }else if(num==1){
            System.out.println("��Ȧ˳��"+temp);
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
                System.out.println("���������");
                break;
            }
        }
    }
}

class ChildNodeLinkedList{
    ChildNode head=new ChildNode();

//    ���ӽڵ�
    /*public void addNode(ChildNode child){
        if(head.next==null){
            head=child;
            child.next=head;
        }
        ChildNode cur=head;//ָ�����������µĽڵ�
        while(true){
            if(cur.next==head){
                break;
            }
            cur=cur.next;
        }
        cur.next=child;
        child.next=head;
    }*/

    public void addNode(int num){//��ӽڵ�ķ��������սڵ���������---------------��˳ƽ���ݽṹ�������õĽڵ����������
        if(num<1){
            System.out.println("�ڵ���С��1��������");
            return;
        }
        ChildNode cur=head;//ָ�����������µĽڵ�
        for (int i = 1; i <= num ; i++) {
            ChildNode childNode=new ChildNode(i,"С��"+i+"��");
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

//    ������������
    public void showNode(){
        if(head.next==null){
            System.out.println("����Ϊ��");
            return;
        }
        ChildNode childNode=head;//����ָ��
        while(true){
            System.out.println(childNode);
            childNode=childNode.next;
            if(childNode==head){
                System.out.println("�������");
                break;
            }
        }
    }

//    ���������Ȧ,��Ȧ˳��,��Ȧ�ĵ�һ���ڵ�,�ڵ�������Ҫָ��:----------��˳ƽ�Լ�д��
    public void outCircleLinkedList(int nodeHead,int count,int num){
        if(nodeHead>num||nodeHead<1||num==0||count==0||this.head==null){
            System.out.println("��������");
            return;
        }
        ChildNode helper=head;//����һ���ڵ㣬�ýڵ��λ��ָ�����һ���ڵ�
        while(true){
            if(helper.next==head){
                break;
            }
            helper=helper.next;
        }

        for (int i = 0; i < nodeHead-1; i++) {//��ʼ�ƶ��ڵ㣬�ÿ�ʼ�Ľڵ��helper�������ƶ���ָ��λ��
            head=head.next;
            helper=helper.next;
        }

        while(true){
//            ��ʼ��Ȧ

            if(helper==head){
                System.out.println(helper+"\n��Ȧ���");
                break;
            }
            for (int i = 0; i < count-1; i++) {
                head=head.next;
                helper=helper.next;
            }
            System.out.println(head);
            head=head.next;//��ֻʣһ���ڵ��ʱ�򣬾�����һ�β�����headָ�������һ���ڵ㡣��helperҲָ��ýڵ�
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
        return "��ţ�"+val+"  ������"+name;
    }
}
