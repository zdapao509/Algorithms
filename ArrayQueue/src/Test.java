//环形队列的复现：2023.3.22

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        CircleArrayQueue arr=new CircleArrayQueue(3);
        boolean loop=true;
        char cc=' ';
        Scanner scanner=new Scanner(System.in);
        while(loop){
            System.out.println("请按照提示输入指令：");
            System.out.println("a：添加一个数进入队列");
            System.out.println("o:取出一个数");
            System.out.println("s:展示队列所有值");
            System.out.println("h:展示头部数据");
            System.out.println("e:退出代码");
            cc=scanner.next().charAt(0);
            switch(cc){
                case 'a':
                    System.out.println("请输入一个数“");
                    int aa=scanner.nextInt();
                    arr.addArray(aa);
                    break;
                case 'o':
                    try {
                        System.out.println("抛出数据为："+arr.outArray());
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 's':
                    arr.showArray();
                    break;
                case 'h':
                    try {
                        System.out.println("队列的头部数据："+arr.headArray());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'e':
                    loop=false;
                    scanner.close();
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出\n");
    }
}

class CircleArrayQueue{
    private int[] array;
    private int begin;
    private int end;
    private int maxSize;

    public CircleArrayQueue(){}
    public CircleArrayQueue(int maxSize){
        this.maxSize=maxSize;
        this.array=new int[this.maxSize];
    }

    public void setArray(int[] array){
        this.array=array;
    }
    public int[] getArray(){
        return array;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

//    判断队列是否为空：
    public boolean isEmpty(){
        return begin==end;
    }
//    判断队列是不是满了：
    public boolean isFull(){
        return (end+1)%maxSize==begin;
    }
//    添加新的数进队列;
    public void addArray(int a){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        array[end]=a;
        end=(end+1)%maxSize;
    }
//    从队列中取值
    public int outArray(){
        if(isEmpty()){
            throw new RuntimeException("队列已空，无法取数");
        }
        int temp=array[begin];
        begin=(begin+1)%maxSize;
        return temp;
    }
//    展示队列中所有值：
    public void showArray(){
        if(isEmpty()){
            System.out.println("队列已空，无法查看");
            return;
        }
        for (int i = begin; i < begin+useArray(); i++) {
            System.out.println("arr["+(i%maxSize)+"]："+array[i%maxSize]);
        }
    }

//    计算队列中的有效数据个数
    public int useArray(){
        return (end-begin+maxSize)%maxSize;
    }
//    输出头部数据
    public int headArray(){
        if(isEmpty()){
            throw new RuntimeException("队列已空,无头部");
        }
        return array[begin];
    }
}
