import java.util.Scanner;

/*
数组模拟队列的时候，出现取出数组中某位置的元素之后，该空缺位置不能再次存入数据，为解决这个问题，这里引入环形队列。

    对指针front做调整：front指向队列的第一个元素，即arr[front]就是队列的第一个元素    front的初始值：0

    rear指向队列的最后一个元素的后一个位置，空出一个空间做约定   rear初始值：0

    队列满时：（rear+1）%maxSize==front;

    队列为空条件时：rear==front;

    队列中的有效数据个数：（rear+maxSize-front）%maxSize

注意：这里的环形队列执行时，比如我定义maxSize是3，那有效数据就是2，也就是这个队列只能同时存2个数。
    比如
        arr[0]:1
        arr[1]:2---------这就已经达到存数据的上限，不能再存了。此时：front：0 rear：2

     这时，我取出一个数，front变成1；

     (rear+1)%maxSize==0不等于front；---------证明有效数据量不足，还可以再添加一个数，

     再添加数时，数的下标是：rear 也就是arr[rear=2]    注意：这里不是往下标为0的地方添加数，是往下标为2的地方添加数，有效数据为2，但是下标可以到达maxSize-1

     可以出现这样的现象：
            arr[2]:3
            arr[0]:4--------这是因为头部指向下标为2


* */
public class CircleArrayQueueTest {
    public static void main(String[] args) {
        CircleArrayQueueTest01 arr1=new CircleArrayQueueTest01(5);
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
        return (rear+1)%maxSize==front;
    }


    //    入队列操作：
    public void addQueue(int a){
        if(isFull()){
            System.out.println("队列已满，无法存入");
            return;
        }
        arr[rear]=a;
        rear=(rear+1)%maxSize;//这里的意思就是：rear指向我赋值的数的下一个数，比如我给arr[0]赋值之后，下标rear就为1；通过这样的方式取余实现下标的循环；
        //如果maxSize为3，那么当arr[2]赋完值之后，rear小标需要更新为0，新的一轮开始。
        System.out.println("rear:"+rear);
    }

    //    出队列操作：
    public int outQueue(){
        if(isEmpty()){
            /*System.out.println("队列已空，无法出列");
            return -1;*/
            throw new RuntimeException("队列空");//除了上述实现方式，还可以通过抛出异常的方式停止程序
        }
        int a=arr[front];//先把对应位置的数取出来，然后把front(永远指向队列的第一个数) 更新，他也是要增加到最大位置的时候，循环进入下一阶段，
        // maxSize为3的时候，front到了2之后，就要更新到下一轮的0，
        front=(front+1)%maxSize;
        return a;

    }

    //    显示所有数据，遍历所有的数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.println("arr["+(i%maxSize)+"]:"+arr[(i%maxSize)]);
        }
    }

//  统计队列中的有效数据的个数，存了数的部分，没有存的不算
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //    显示队列的头数据：
    public void headQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        System.out.println("头部数据："+arr[front]);
    }
}