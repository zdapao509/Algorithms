/*
ʹ��ջģ�������ļ�����̣�

    ʹ��ջ�ж������֣�����������������Ҫ�ȶ�������ջ���ֱ�洢��������ݺ������

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
                System.out.println("����λ��ʼ����");
                if(!oper.isEmpty()){
                    if(oper.youXianJi(experation.charAt(index))<=oper.youXianJi(oper.topChar())){
                        int num1=array.outStack();
                        int num2=array.outStack();
                        char cc=(char)oper.outStack();
                        int res=JiSuan(num1,num2,cc);
                        array.addStack(res);
                        oper.addStack(experation.charAt(index));
                    }else{
                        System.out.println("ջ�м��룺"+experation.charAt(index));
                        oper.addStack(experation.charAt(index));
                    }
                }else{
                    oper.addStack(experation.charAt(index));
                }
            }else{
                temp+=experation.charAt(index);//�������һ��С��10�����Ļ�����Ҫһֱƴ��
                if(index<experation.length()-1){//�����жϣ��������һ�����жϵ�ʱ����������±�Խ��
                    if(!isNum(experation.charAt(index+1))){//��������һ���ַ��ǲ������֣�������ǣ��ͼ���ƴ�ӣ�ֱ����һ���ַ��Ƿ��ţ��Ͳ���ƴ�Ӷ���������ջ
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
            System.out.println("ѭ��ִ��");
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

//    �ṩ�ж����ֻ����ַ��ķ���
    public static boolean isNum(char i){
        return i!='*'&&i!='/'&&i!='+'&&i!='-';
    }

//    �ṩ����������
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

//    �жϷ��ŵ����ȼ���
    public int youXianJi(char i){
        if(i=='*'||i=='/'){
            return 1;
        } else if (i=='+'||i=='-') {
            return 0;
        }else{
            return -1;
        }
    }

//   ��ʾջ������:
    public char topChar(){
        return ((char) stack[top]);
    }
}
