import java.util.Scanner;

/*
���У�----------���µķ�ʽʵ�ֵĶ��д��ڵ����⣺���������������ݱ�ȡ����ʱ��ȡ��Ԫ�غ�Ŀռ��޷����ٴ����ã�����һ��������

    ������һ�������б��������������������ʵ�֡�
    ��ѭ�����ȳ���ԭ�򡣼����ȴ�����е����ݣ�Ҫ��ȡ����������Ҫ��ȡ��

    ���б����������б���ʹ������Ľṹ���洢���е����ݣ�������������������ͼ, ���� maxSize �Ǹö��е����������

    ��Ϊ���е�����������Ƿֱ��ǰ��������������Ҫ�������� front�� rear�ֱ��¼����ǰ��˵��±꣬
    front ����������������ı䣬�� rear������������������ı�
* */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueueTest01 arr1=new ArrayQueueTest01(3);
        /*arr1.showQueue();

        arr1.addQueue(5);
        arr1.showQueue();

        arr1.addQueue(9);
        arr1.showQueue();

        arr1.headQueue();//ͷ�����ݣ�5

        System.out.println("ȡ�����ݣ�"+arr1.outQueue());
        arr1.showQueue();

        arr1.headQueue();//ͷ�����ݣ�9-------������Ϊ��Ĭ��ǰ��������Ѿ�ȡ�����ˣ����ԣ�ָ�������һλ��ָ�������µ�ͷ��

        arr1.addQueue(79);
        arr1.addQueue(951);*/


//        ʵ��ѭ������ָ�
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

class ArrayQueueTest01{
    private int maxSize;
    private int rear;
    private int front;
    private int[] arr;
    public ArrayQueueTest01(){}
    public ArrayQueueTest01(int maxSize){
        this.maxSize=maxSize;
        this.front=-1;//��ָ��Ϊ-1
        this.rear=-1;//βָ��Ϊ-1
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
        return rear==maxSize-1;
    }


//    ����в�����
    public void addQueue(int a){
        if(isFull()){
            System.out.println("�����������޷�����");
            return;
        }
        rear++;//�����ݵ�ʱ���ƶ����Ǻ��������
        arr[rear]=a;
    }

//    �����в�����
    public int outQueue(){
        if(isEmpty()){
            /*System.out.println("�����ѿգ��޷�����");
            return -1;*/
            throw new RuntimeException("���п�");//��������ʵ�ַ�ʽ��������ͨ���׳��쳣�ķ�ʽֹͣ����
        }
        front++;//ȡ����ʱ��Ĭ�ϴ�ǰ�濪ʼȡ
        return arr[front];
    }

//    ��ʾ�������ݣ��������е�����
    public void showQueue(){
        if(isEmpty()){
            System.out.println("����Ϊ��");
//            throw new RuntimeException("���п�*******************");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"]:"+arr[i]);
//            System.out.printf("arr[%d]=%d\n",i,arr[i]);//ע�������õ���printf����
        }
    }

//    ��ʾ���е�ͷ���ݣ�
    public void headQueue(){
        if(isEmpty()){
            System.out.println("����Ϊ�գ�û������");
            return;
//            throw new RuntimeException("���п�");
        }
        System.out.println("ͷ�����ݣ�"+arr[front+1]);
        //+1����Ϊ��ǰ��Ĺ����У�ֻ��outQueueʱ��ı�frontͷ��ָ�룬Ҳ����ÿȡ��һ����ʱ��ͷ��ָ��������������
        // ��ʱָ��ָ�������ȡ������ôͷ�������ͱ����  front+1  ����µ�ָ��
    }
}