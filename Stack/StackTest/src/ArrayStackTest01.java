import java.util.Scanner;

/*
数组模拟栈的实现：

* */
public class ArrayStackTest01 {
    public static void main(String[] args) {
        ArrayStack stack=new ArrayStack(5);
        String key="";
        Scanner s=new Scanner(System.in);
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
                    System.out.print("输入数据：");
                    int value=s.nextInt();
                    stack.addStack(value);
                    break;
                case "o":
                    try{
                        System.out.println("出栈数据："+stack.outStack());
                        break;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        break;
                    }
                case "s":
                    stack.showStack();
                    break;
                case "e":
                    s.close();//文件流，要关闭
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
//    判断栈空的方法：
    public boolean isEmpty(){
        return top==-1;
    }

//    判断栈满了的方法：
    public boolean isFull(){
        return top==maxSize-1;
    }

//    入栈：
    public void addStack(int value){
        if(isFull()){
            System.out.println("栈满，无法添加");
            return;
        }
        top++;
        stack[top]=value;
    }

//    出栈：
    public int outStack(){
        if(isEmpty()){
            throw new RuntimeException("栈已空");
        }
        int value=stack[top];
        top--;
        return value;
    }

//    遍历栈：
    public void showStack(){
        if(isEmpty()){
            System.out.println("栈已空");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.println("stack["+i+"]:"+stack[i]);
        }
    }

}
