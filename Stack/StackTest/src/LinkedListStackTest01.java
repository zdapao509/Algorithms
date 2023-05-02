import java.util.Scanner;

/*
链表模拟栈实现：

    出现的几个问题：

        1.异常的抛出语句，一定记得带break，不然方法泄露

        2.模拟栈用链表的话，用的是双向链表，因为单向链表是不能进行出栈操作的（或者说很难实现出栈后指针往前面移动）

        3.注意链表的添加过程中，不能反复添加同一个节点，不然直接成了死循环。
* */
public class LinkedListStackTest01 {
    public static void main(String[] args) {

        LinkedListStack head=new LinkedListStack(2);
        head.showNode();

        Scanner s=new Scanner(System.in);
        String key=" ";
        boolean loop=true;
        while(loop){
            System.out.println("请输入：");
            System.out.println("a: addStack");
            System.out.println("o: outStack");
            System.out.println("s: showStack");
            System.out.println("e: exit");
            key=s.next();
            switch(key){
                case "a":
                    try{
                        System.out.println("输入节点号：");
                        int num=s.nextInt();
                        LinkedListTest temp2=new LinkedListTest(num);
                        head.addNode(temp2);
                        break;
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                        break;//注意：这里 的break如果不添加，直接出现方法的泄露。也就是，下面的语句也会执行
                    }

                case "o":
                    try{
                        System.out.println("出栈的是节点："+head.outNode());
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

//创建链表类
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

//    判断栈是否为空：
    public boolean isEmpty(){
        if(head==null||temp==null){
            return true;
        }
        return false;
    }

//    判断栈是不是满了：
    public boolean isFull(){

        if(isEmpty()){
            return false;
        }

        LinkedListTest temp1=head;//建立辅助节点，遍历链表长度
        int count=0;
        boolean sign=false;

        while(true){//统计链表长度
            count++;
            temp1=temp1.getNext();
            if(temp1==null){
                break;
            }
        }

        if(count==this.maxSize){//达到最大链表长度，将sign置为true，表示栈已经满了
            sign=true;
        }

        return sign;
    }

//    添加栈节点：
    public void addNode(LinkedListTest node){

        if(isFull()){
            throw new RuntimeException("栈已满");
        }

        if(temp==null){
            head=node;
            temp=node;
        }else{
            if(temp==node){//重复添加节点，成环，这是不允许的，所以直接不允许成环
                System.out.println("重复添加");
                return;
            }
            temp.setNext(node);
            node.setPre(temp);
            temp=temp.getNext();
        }
    }

//    删除节点：
    public LinkedListTest outNode(){
        if(isEmpty()){
            throw new RuntimeException("栈已空无法去除");
        }
        LinkedListTest value=temp;
        temp=temp.getPre();
        return value;
    }

//    遍历栈
    public void showNode(){
        if(isEmpty()){
            System.out.println("栈是空的，无法遍历");
            return;
        }
        LinkedListTest res=temp;
        while(true){
            System.out.println(res);
            res=res.getPre();
            if(res==null){
                System.out.println("遍历到底");
                break;
            }
        }
    }
}

//创建节点类
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
        return "节点："+val;
    }

}