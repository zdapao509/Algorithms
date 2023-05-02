import java.util.Scanner;

/*
����ģ��ջ��ʵ�֣�

* */
public class ArrayStackTest01 {
    public static void main(String[] args) {
        ArrayStack stack=new ArrayStack(5);
        String key="";
        Scanner s=new Scanner(System.in);
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
                    System.out.print("�������ݣ�");
                    int value=s.nextInt();
                    stack.addStack(value);
                    break;
                case "o":
                    try{
                        System.out.println("��ջ���ݣ�"+stack.outStack());
                        break;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        break;
                    }
                case "s":
                    stack.showStack();
                    break;
                case "e":
                    s.close();//�ļ�����Ҫ�ر�
                    loop=false;
                    break;
                default:
                    break;
            }
        }
    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    int top=-1;
    public ArrayStack(){}
    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[this.maxSize];
    }
//    �ж�ջ�յķ�����
    public boolean isEmpty(){
        return top==-1;
    }

//    �ж�ջ���˵ķ�����
    public boolean isFull(){
        return top==maxSize-1;
    }

//    ��ջ��
    public void addStack(int value){
        if(isFull()){
            System.out.println("ջ�����޷����");
            return;
        }
        top++;
        stack[top]=value;
    }

//    ��ջ��
    public int outStack(){
        if(isEmpty()){
            throw new RuntimeException("ջ�ѿ�");
        }
        int value=stack[top];
        top--;
        return value;
    }

//    ����ջ��
    public void showStack(){
        if(isEmpty()){
            System.out.println("ջ�ѿ�");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.println("stack["+i+"]:"+stack[i]);
        }
    }

}
