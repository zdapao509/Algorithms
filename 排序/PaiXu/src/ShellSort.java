import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
希尔排序（缩小增量排序）：插入排序的改进算法(当最小的数在最后的时候，采用插入排序的方法效率低（因为每一个比他大的数都要移动）)

    原理相当于进行分类组成子序列，对每个子序列进行排序，采用的是插入排序的方法

    时间复杂度：O（n^s） (其中 1<s<2)----最差时间复杂度     平均时间复杂度： O（nlogn）

    空间复杂度：O（1）
* */
public class ShellSort {
    public static void main(String[] args) {

        int[] arr={8,9,1,7,2,3,5,4,6,0};

//        Sort(arr);

//        shellSort1(arr);

        shellSort2(arr);

        System.out.println(Arrays.toString(arr));

        System.out.println("****************************\n");

//        测试速度：
        Date date1=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String date1Str = format.format(date1);
        System.out.println("此时的时间是："+date1Str);

        long begin = System.currentTimeMillis();

//        生成随机数:
        int[] arr1 = new int[80000];
        for (int i=0; i<80000; i++) {
            arr1[i]=(int)(Math.random()*80000000);
        }

//        排序：
//        Sort(arr1);        //验证交换式的
        /*
        此时的时间是：2023-04-20  23:04:57
        交换次数： 2169598
        此时的时间是：2023-04-20  23:05:05
        用时： 8741 毫秒
        * */


        shellSort1(arr1);     //验证移位法
        /*
        此时的时间是：2023-04-20  23:13:58
        交换次数： 2241611
        此时的时间是：2023-04-20  23:13:58
        用时： 25 毫秒
        * */

//        shellSort2(arr1);      //验证自己的优化改进移位法
        /*
        此时的时间是：2023-04-20  23:13:28
        交换次数： 2262570
        此时的时间是：2023-04-20  23:13:28
        用时： 26 毫秒
        * */


//        验证时间节点

        Date date2 = new Date();

        String date2Str = format.format(date2);

        System.out.println("此时的时间是："+date2Str);

        long end = System.currentTimeMillis();

        System.out.println("用时： "+(end-begin)+" 毫秒");

    }

//    提供交换式的希尔排序方法：
    public static void Sort(int[] arr){
        int temp = 0;
        int count = 0;

        for (int gap=arr.length/2; gap>0; gap /= 2) {//先计算要进行多少轮次

//            System.out.println("\ngap="+gap+"   ,arr="+Arrays.toString(arr));

            for (int i=gap; i<arr.length; i++) {

//                System.out.println("\n        i="+i+"   ,arr="+Arrays.toString(arr));

                for (int j=i-gap; j>=0; j-=gap) {
                    if (arr[j] > arr[j+gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j+gap] = temp;
                        count++;
                    }
//                    System.out.println("\n                 j="+j+"   ,arr="+Arrays.toString(arr));
                }
            }
        }

        System.out.println("交换次数： "+count);
    }

//    提供交换式的希尔方式的改进方法：移位法

    public static void shellSort1 (int[] arr) {

        int needToInsert=0;

        int index=0;

        int count=0;

        for (int gap = arr.length/2; gap > 0; gap /= 2) {

            for (int i =gap; i < arr.length; i++) {

                needToInsert=arr[i];

                index=i;//代表的是要寻找位置的数的下标，不是要寻找位置的数的下标的前一个

                if (arr[index]<arr[index-gap]) {//这里的if语句是用来进行优化的，就是先判断成不成立再进行下面的计算

                    while (index-gap >= 0 && needToInsert<arr[index-gap]) {

                        arr[index]=arr[index-gap];

                        index-=gap;

                        count++;
                    }
//                    退出while循环之后就代表找到这个放数据的位置，直接放进去
                    arr[index] = needToInsert;//这里是因为index就代表当前要插入的数的位置，所以这里的index不减gap
                }
            }
        }

        System.out.println("交换次数： "+count);
    }


//    我自己的改进，不采用上面的for循环，和插入排序的方式很接近

    public static void shellSort2(int[] arr) {

        int needToInsert = 0;

        int index = 0;

        int count=0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) { //先计算需要分组的数量  10个元素，步长为5；  再分成步长为2；  最后分成步长为 1

            for (int i = gap; i < arr.length; i++) {  //再将每一个分组进行排序------对于每一个分组，都采用插入排序的方法

                needToInsert = arr[i];

                index = i - gap;//代表的是要寻找位置的数的下标，不是要寻找位置的数的下标的前一个

                while (index >= 0 && needToInsert < arr[index]) {  //注意：index>=0判断必须放前面，不然超出下标索引
                    // ArrayIndexOutOfBoundsException: Index -5 out of bounds for length 10

                    arr[index + gap] = arr[index];

                    index -= gap;

                    count++;
                }
//                    退出while循环之后就代表找到这个放数据的位置，直接放进去
                arr[index+gap] = needToInsert;

            }
        }

        System.out.println("交换次数： "+count);
    }
}
