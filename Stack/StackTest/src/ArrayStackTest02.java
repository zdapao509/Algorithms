/*
使用栈模拟计算机的计算过程：

    使用栈判断是数字，还是运算符；因此需要先定义两个栈，分别存储计算的数据和运算符

* */

public class ArrayStackTest02 {
    public static void main(String[] args) {
        ArrayStack1 array=new ArrayStack1(10);
        ArrayStack1 oper=new ArrayStack1(10);

        String experation="70*9+9*50-10*70/2";

        int index=0;

        String temp="";

        while(true){
            if(index==experation.length()){
                break;
            }
            System.out.println(!isNum('+'));
            if(!isNum(experation.charAt(index))){
                System.out.println("符号位开始加入");
                if(!oper.isEmpty()){
                    if(oper.youXianJi(experation.charAt(index))<=oper.youXianJi(oper.topChar())){
                        int num1=array.outStack();
                        int num2=array.outStack();
                        char cc=(char)oper.outStack();
                        int res=JiSuan(num1,num2,cc);
                        array.addStack(res);
                        oper.addStack(experation.charAt(index));
                    }else{
                        System.out.println("栈中加入："+experation.charAt(index));
                        oper.addStack(experation.charAt(index));
                    }
                }else{
                    oper.addStack(experation.charAt(index));
                }
            }else{
                temp+=experation.charAt(index);//如果不是一个小于10的数的话，就要一直拼接
                if(index<experation.length()-1){//加入判断，避免最后一个数判断的时候出现数组下标越界
                    if(!isNum(experation.charAt(index+1))){//看他的下一个字符是不是数字，如果还是，就继续拼接，直到下一个字符是符号，就不再拼接而是入数字栈
                        int temp1=Integer.valueOf(temp);
                        array.addStack(temp1);
                        temp="";
                    }
                }else{
                    int temp1=Integer.valueOf(temp);
                    array.addStack(temp1);
                    temp="";
                }

            }

            index++;
        }

        array.showStack();
        System.out.println("*********************");
        oper.showStack();
        int res=0;
        while(true){
            System.out.println("循环执行");
            if(oper.isEmpty()){
                break;
            }
            int num1=array.outStack();
            int num2=array.outStack();
            char cc=(char)oper.outStack();
            System.out.println(cc);
            res=JiSuan(num1,num2,cc);
            array.addStack(res);
        }

        System.out.println(experation+"="+res);
    }

//    提供判断数字还是字符的方法
    public static boolean isNum(char i){
        return i!='*'&&i!='/'&&i!='+'&&i!='-';
    }

//    提供算数方法：
    public static int JiSuan(int num1,int num2,char cc){
        switch(cc){
            case '+':
                return num2+num1;
            case '-':
                return num2-num1;
            case '*':
                return num2*num1;
            case '/':
                return num2/num1;
            default:
                return -1;
        }
    }
}


class ArrayStack1{
    private int maxSize;
    private int[] stack;
    int top=-1;
    public ArrayStack1(){}
    public ArrayStack1(int maxSize){
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

//    判断符号的优先级：
    public int youXianJi(char i){
        if(i=='*'||i=='/'){
            return 1;
        } else if (i=='+'||i=='-') {
            return 0;
        }else{
            return -1;
        }
    }

//   显示栈顶数据:
    public char topChar(){
        return ((char) stack[top]);
    }
}
