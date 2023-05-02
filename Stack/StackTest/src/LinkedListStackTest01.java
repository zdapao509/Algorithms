import java.util.Scanner;

/*
����ģ��ջʵ�֣�

    ���ֵļ������⣺

        1.�쳣���׳���䣬һ���ǵô�break����Ȼ����й¶

        2.ģ��ջ������Ļ����õ���˫��������Ϊ���������ǲ��ܽ��г�ջ�����ģ�����˵����ʵ�ֳ�ջ��ָ����ǰ���ƶ���

        3.ע���������ӹ����У����ܷ������ͬһ���ڵ㣬��Ȼֱ�ӳ�����ѭ����
* */
public class LinkedListStackTest01 {
    public static void main(String[] args) {

        LinkedListStack head=new LinkedListStack(2);
        head.showNode();

        Scanner s=new Scanner(System.in);
        String key=" ";
        boolean loop=true;
        while(loop){
            System.out.println("�����룺");
            System.out.println("a: addStack");
            System.out.println("o: outStack");
            System.out.println("s: showStack");
            System.out.println("e: exit");
            key=s.next();
            switch(key){
                case "a":
                    try{
                        System.out.println("����ڵ�ţ�");
                        int num=s.nextInt();
                        LinkedListTest temp2=new LinkedListTest(num);
                        head.addNode(temp2);
                        break;
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                        break;//ע�⣺���� ��break�������ӣ�ֱ�ӳ��ַ�����й¶��Ҳ���ǣ���������Ҳ��ִ��
                    }

                case "o":
                    try{
                        System.out.println("��ջ���ǽڵ㣺"+head.outNode());
                        break;
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                        break;
                    }

                case "s":
                    head.showNode();
                    break;
                case "e":
                    s.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
    }
}

//����������
class LinkedListStack{
    private LinkedListTest head;
    private int maxSize;
    LinkedListTest temp;

    public void setLinkedListTest(LinkedListTest head){
        this.head=head;
    }

    public LinkedListStack(){}

    public LinkedListStack(int maxSize){
        this.maxSize=maxSize;
    }

//    �ж�ջ�Ƿ�Ϊ�գ�
    public boolean isEmpty(){
        if(head==null||temp==null){
            return true;
        }
        return false;
    }

//    �ж�ջ�ǲ������ˣ�
    public boolean isFull(){

        if(isEmpty()){
            return false;
        }

        LinkedListTest temp1=head;//���������ڵ㣬����������
        int count=0;
        boolean sign=false;

        while(true){//ͳ��������
            count++;
            temp1=temp1.getNext();
            if(temp1==null){
                break;
            }
        }

        if(count==this.maxSize){//�ﵽ��������ȣ���sign��Ϊtrue����ʾջ�Ѿ�����
            sign=true;
        }

        return sign;
    }

//    ���ջ�ڵ㣺
    public void addNode(LinkedListTest node){

        if(isFull()){
            throw new RuntimeException("ջ����");
        }

        if(temp==null){
            head=node;
            temp=node;
        }else{
            if(temp==node){//�ظ���ӽڵ㣬�ɻ������ǲ�����ģ�����ֱ�Ӳ�����ɻ�
                System.out.println("�ظ����");
                return;
            }
            temp.setNext(node);
            node.setPre(temp);
            temp=temp.getNext();
        }
    }

//    ɾ���ڵ㣺
    public LinkedListTest outNode(){
        if(isEmpty()){
            throw new RuntimeException("ջ�ѿ��޷�ȥ��");
        }
        LinkedListTest value=temp;
        temp=temp.getPre();
        return value;
    }

//    ����ջ
    public void showNode(){
        if(isEmpty()){
            System.out.println("ջ�ǿյģ��޷�����");
            return;
        }
        LinkedListTest res=temp;
        while(true){
            System.out.println(res);
            res=res.getPre();
            if(res==null){
                System.out.println("��������");
                break;
            }
        }
    }
}

//�����ڵ���
class LinkedListTest{
    private int val;
    private LinkedListTest next;

    private LinkedListTest pre;

    public LinkedListTest getPre(){
        return pre;
    }

    public void setPre(LinkedListTest pre) {
        this.pre = pre;
    }

    public LinkedListTest getNext(){
        return next;
    }
    public void setNext(LinkedListTest next){
        this.next=next;
    }

    public LinkedListTest(){}

    public LinkedListTest(int val){
        this.val=val;
    }

    public String toString(){
        return "�ڵ㣺"+val;
    }

}