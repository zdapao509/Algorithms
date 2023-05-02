import java.util.Scanner;

/*
队列：----------以下的方式实现的队列存在的问题：当数组中所有数据被取出的时候，取出元素后的空间无法被再次利用，属于一次性数组

    队列是一个有序列表，可以用数组或是链表来实现。
    遵循先入先出的原则。即：先存入队列的数据，要先取出。后存入的要后取出

    队列本身是有序列表，若使用数组的结构来存储队列的数据，则队列数组的声明如下图, 其中 maxSize 是该队列的最大容量。

    因为队列的输出、输入是分别从前后端来处理，因此需要两个变量 front及 rear分别记录队列前后端的下标，
    front 会随着数据输出而改变，而 rear则是随着数据输入而改变
* */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueueTest01 arr1=new ArrayQueueTest01(3);
        /*arr1.showQueue();

        arr1.addQueue(5);
        arr1.showQueue();

        arr1.addQueue(9);
        arr1.showQueue();

        arr1.headQueue();//头部数据：5

        System.out.println("取出数据："+arr1.outQueue());
        arr1.showQueue();

        arr1.headQueue();//头部数据：9-------这是因为，默认前面的数据已经取出来了，所以，指针后移了一位，指向了最新的头部

        arr1.addQueue(79);
        arr1.addQueue(951);*/


//        实现循环接收指令：
        boolean loop=true;
        char key=' ';//接收用户输入
        Scanner scanner=new Scanner(System.in);
        while(loop){
            System.out.println("\n\n请输入指令：");
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):增加队列");
            System.out.println("o(out):取数据");
            System.out.println("h(head):查看队列头部数据");
            key=scanner.next().charAt(0);//接收一个字符
            switch(key){
                case 's':
                    arr1.showQueue();
                    break;
                case 'a':
                    System.out.println("输入要添加的数：");
                    int value =scanner.nextInt();//这里的Scanner已经被new好了，所以不需要再new新值
                    arr1.addQueue(value);
                    break;
                case 'o':
//                    arr1.outQueue();
//                    通过抛出异常的方式实现访问：
                    try{
                        int a=arr1.outQueue();
                        System.out.println("抛出数据为："+a);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    arr1.headQueue();
                    break;
                case 'e':
                    scanner.close();//注意scanner要关闭
                    loop=false;//循环终止条件
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出\n");
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
        this.front=-1;//首指针为-1
        this.rear=-1;//尾指针为-1
        arr=new int[this.maxSize];
    }

//    提供setter和getter方法
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

//    判断是否为空的方法
    public boolean isEmpty(){
        return front==rear;
    }

//    判断是否满了
    public boolean isFull(){
        return rear==maxSize-1;
    }


//    入队列操作：
    public void addQueue(int a){
        if(isFull()){
            System.out.println("队列已满，无法存入");
            return;
        }
        rear++;//存数据的时候，移动的是后面的索引
        arr[rear]=a;
    }

//    出队列操作：
    public int outQueue(){
        if(isEmpty()){
            /*System.out.println("队列已空，无法出列");
            return -1;*/
            throw new RuntimeException("队列空");//除了上述实现方式，还可以通过抛出异常的方式停止程序
        }
        front++;//取数的时候默认从前面开始取
        return arr[front];
    }

//    显示所有数据，遍历所有的数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
//            throw new RuntimeException("队列空*******************");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"]:"+arr[i]);
//            System.out.printf("arr[%d]=%d\n",i,arr[i]);//注意这里用的是printf函数
        }
    }

//    显示队列的头数据：
    public void headQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
//            throw new RuntimeException("队列空");
        }
        System.out.println("头部数据："+arr[front+1]);
        //+1是因为，前面的过程中，只有outQueue时会改变front头部指针，也就是每取出一个数时，头部指针对齐了这个数，
        // 此时指针指向的数被取出，那么头部的数就变成了  front+1  这个新的指针
    }
}