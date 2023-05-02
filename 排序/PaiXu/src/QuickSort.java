import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
快速排序：对冒泡排序进行改进

    通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，

    然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列

    时间复杂度：O（n^2）

    空间复杂度：O（nlogn）

* */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={18,2,4,-5,6,0,-20,-61,0,5,16};
        Sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));


//        测试速度：
        Date date1=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String date1Str = format.format(date1);
        System.out.println("此时的时间是："+date1Str);

        long begin = System.currentTimeMillis();

//        生成随机数:
        int[] arr1 = new int[8000000];
        for (int i=0; i<8000000; i++) {
            arr1[i]=(int)(Math.random()*80000000);
        }

//      排序：
        Sort(arr1,0,arr1.length-1);     //验证移位法

        /*
        此时的时间是：2023-04-24  16:28:51
        此时的时间是：2023-04-24  16:28:51
        用时： 30 毫秒
        * */

//        验证时间节点

        Date date2 = new Date();

        String date2Str = format.format(date2);

        System.out.println("此时的时间是："+date2Str);

        long end = System.currentTimeMillis();

        System.out.println("用时： "+(end-begin)+" 毫秒");

    }

//    给出快速排序方法：
    public static void Sort(int[] arr, int left, int right) {
        int l=left;
        int r=right;
        int pivot=arr[(l+r)/2];
        int temp=0;//辅助交换变量
        while (l<r) {

            while (arr[l]<pivot) {//正常情况下，左边的数应该小于等于基准值
                l++;//如果满足条件，那就继续往后面找，   循环结束，找到比基准值大的或等于基准值的位于左边的值
            }

            while (arr[r]>pivot) {//同理，右边的值要比基准的值大
                r--;
            }

            if (l==r) {//此时，左右指标都指向了同一个值，没必要做交换
                break;
            }

//            能走到这里的，都是左右l r 不相等，所以可以进行交换
//            System.out.println("交换：arr["+l+"]="+arr[l]+"     arr["+r+"]="+arr[r]);
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
//            System.out.println("此时："+Arrays.toString(arr));

//            交换完了之后，判断，下标指的数是不是和基准值相等，相等就进行移位处理，避免出现死循环的现象
            if (arr[l]==pivot) r--;
            if (arr[r]==pivot) l++;
        }

//        System.out.println("**************************  结束时：l=="+l+"    r=="+r);

//        出了循环：如果下标是相等的：
        if (l==r) {
            l++;
            r--;
        }

//        对于左右两边的没有处理的数，迭代排序
        if (left<r) {
            Sort(arr,left,r);
        }
        if (right>l) {
            Sort(arr,l,right);
        }
    }
}
