//���ζ��еĸ��֣�2023.3.22

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        CircleArrayQueue arr=new CircleArrayQueue(3);
        boolean loop=true;
        char cc=' ';
        Scanner scanner=new Scanner(System.in);
        while(loop){
            System.out.println("�밴����ʾ����ָ�");
            System.out.println("a�����һ�����������");
            System.out.println("o:ȡ��һ����");
            System.out.println("s:չʾ��������ֵ");
            System.out.println("h:չʾͷ������");
            System.out.println("e:�˳�����");
            cc=scanner.next().charAt(0);
            switch(cc){
                case 'a':
                    System.out.println("������һ������");
                    int aa=scanner.nextInt();
                    arr.addArray(aa);
                    break;
                case 'o':
                    try {
                        System.out.println("�׳�����Ϊ��"+arr.outArray());
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 's':
                    arr.showArray();
                    break;
                case 'h':
                    try {
                        System.out.println("���е�ͷ�����ݣ�"+arr.headArray());
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
        System.out.println("�����˳�\n");
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

//    �ж϶����Ƿ�Ϊ�գ�
    public boolean isEmpty(){
        return begin==end;
    }
//    �ж϶����ǲ������ˣ�
    public boolean isFull(){
        return (end+1)%maxSize==begin;
    }
//    ����µ���������;
    public void addArray(int a){
        if(isFull()){
            System.out.println("��������");
            return;
        }
        array[end]=a;
        end=(end+1)%maxSize;
    }
//    �Ӷ�����ȡֵ
    public int outArray(){
        if(isEmpty()){
            throw new RuntimeException("�����ѿգ��޷�ȡ��");
        }
        int temp=array[begin];
        begin=(begin+1)%maxSize;
        return temp;
    }
//    չʾ����������ֵ��
    public void showArray(){
        if(isEmpty()){
            System.out.println("�����ѿգ��޷��鿴");
            return;
        }
        for (int i = begin; i < begin+useArray(); i++) {
            System.out.println("arr["+(i%maxSize)+"]��"+array[i%maxSize]);
        }
    }

//    ��������е���Ч���ݸ���
    public int useArray(){
        return (end-begin+maxSize)%maxSize;
    }
//    ���ͷ������
    public int headArray(){
        if(isEmpty()){
            throw new RuntimeException("�����ѿ�,��ͷ��");
        }
        return array[begin];
    }
}
