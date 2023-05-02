import java.util.Scanner;

/*
����ģ����е�ʱ�򣬳���ȡ��������ĳλ�õ�Ԫ��֮�󣬸ÿ�ȱλ�ò����ٴδ������ݣ�Ϊ���������⣬�������뻷�ζ��С�

    ��ָ��front��������frontָ����еĵ�һ��Ԫ�أ���arr[front]���Ƕ��еĵ�һ��Ԫ��    front�ĳ�ʼֵ��0

    rearָ����е����һ��Ԫ�صĺ�һ��λ�ã��ճ�һ���ռ���Լ��   rear��ʼֵ��0

    ������ʱ����rear+1��%maxSize==front;

    ����Ϊ������ʱ��rear==front;

    �����е���Ч���ݸ�������rear+maxSize-front��%maxSize

ע�⣺����Ļ��ζ���ִ��ʱ�������Ҷ���maxSize��3������Ч���ݾ���2��Ҳ�����������ֻ��ͬʱ��2������
    ����
        arr[0]:1
        arr[1]:2---------����Ѿ��ﵽ�����ݵ����ޣ������ٴ��ˡ���ʱ��front��0 rear��2

     ��ʱ����ȡ��һ������front���1��

     (rear+1)%maxSize==0������front��---------֤����Ч���������㣬�����������һ������

     �������ʱ�������±��ǣ�rear Ҳ����arr[rear=2]    ע�⣺���ﲻ�����±�Ϊ0�ĵط�������������±�Ϊ2�ĵط����������Ч����Ϊ2�������±���Ե���maxSize-1

     ���Գ�������������
            arr[2]:3
            arr[0]:4--------������Ϊͷ��ָ���±�Ϊ2


* */
public class CircleArrayQueueTest {
    public static void main(String[] args) {
        CircleArrayQueueTest01 arr1=new CircleArrayQueueTest01(5);
        boolean loop=true;
        char key=' ';//�����û�����
        Scanner scanner=new Scanner(System.in);
        while(loop){
            System.out.println("\n\n������ָ�");
            System.out.println("s(show):��ʾ����");
            System.out.println("e(exit):�˳�����");
            System.out.println("a(add):���Ӷ���");
            System.out.println("o(out):ȡ����");
            System.out.println("h(head):�鿴����ͷ������");
            key=scanner.next().charAt(0);//����һ���ַ�
            switch(key){
                case 's':
                    arr1.showQueue();
                    break;
                case 'a':
                    System.out.println("����Ҫ��ӵ�����");
                    int value =scanner.nextInt();//�����Scanner�Ѿ���new���ˣ����Բ���Ҫ��new��ֵ
                    arr1.addQueue(value);
                    break;
                case 'o':
//                    arr1.outQueue();
//                    ͨ���׳��쳣�ķ�ʽʵ�ַ��ʣ�
                    try{
                        int a=arr1.outQueue();
                        System.out.println("�׳�����Ϊ��"+a);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    arr1.headQueue();
                    break;
                case 'e':
                    scanner.close();//ע��scannerҪ�ر�
                    loop=false;//ѭ����ֹ����
                    break;
                default:
                    break;
            }
        }
        System.out.println("�����˳�\n");
    }
}


class CircleArrayQueueTest01{
    private int maxSize;
    private int rear;
    private int front;
    private int[] arr;
    public CircleArrayQueueTest01(){}
    public CircleArrayQueueTest01(int maxSize){
        this.maxSize=maxSize;
        arr=new int[this.maxSize];
    }

    //    �ṩsetter��getter����
    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    //    �ж��Ƿ�Ϊ�յķ���
    public boolean isEmpty(){
        return front==rear;
    }

    //    �ж��Ƿ�����
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }


    //    ����в�����
    public void addQueue(int a){
        if(isFull()){
            System.out.println("�����������޷�����");
            return;
        }
        arr[rear]=a;
        rear=(rear+1)%maxSize;//�������˼���ǣ�rearָ���Ҹ�ֵ��������һ�����������Ҹ�arr[0]��ֵ֮���±�rear��Ϊ1��ͨ�������ķ�ʽȡ��ʵ���±��ѭ����
        //���maxSizeΪ3����ô��arr[2]����ֵ֮��rearС����Ҫ����Ϊ0���µ�һ�ֿ�ʼ��
        System.out.println("rear:"+rear);
    }

    //    �����в�����
    public int outQueue(){
        if(isEmpty()){
            /*System.out.println("�����ѿգ��޷�����");
            return -1;*/
            throw new RuntimeException("���п�");//��������ʵ�ַ�ʽ��������ͨ���׳��쳣�ķ�ʽֹͣ����
        }
        int a=arr[front];//�ȰѶ�Ӧλ�õ���ȡ������Ȼ���front(��Զָ����еĵ�һ����) ���£���Ҳ��Ҫ���ӵ����λ�õ�ʱ��ѭ��������һ�׶Σ�
        // maxSizeΪ3��ʱ��front����2֮�󣬾�Ҫ���µ���һ�ֵ�0��
        front=(front+1)%maxSize;
        return a;

    }

    //    ��ʾ�������ݣ��������е�����
    public void showQueue(){
        if(isEmpty()){
            System.out.println("����Ϊ��");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.println("arr["+(i%maxSize)+"]:"+arr[(i%maxSize)]);
        }
    }

//  ͳ�ƶ����е���Ч���ݵĸ������������Ĳ��֣�û�д�Ĳ���
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //    ��ʾ���е�ͷ���ݣ�
    public void headQueue(){
        if(isEmpty()){
            System.out.println("����Ϊ�գ�û������");
            return;
        }
        System.out.println("ͷ�����ݣ�"+arr[front]);
    }
}