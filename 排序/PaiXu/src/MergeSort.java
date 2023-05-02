import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
归并排序：

    时间复杂度：O（nlogn）

    空间复杂度：O（1）
* */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2};
        int[] temp=new int[arr.length];
        Merge(arr,0,arr.length-1,temp);
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
        int[] temp1=new int[arr1.length];
        Merge(arr1,0,arr1.length-1,temp1);     //验证移位法

        /*
        此时的时间是：2023-04-24  20:48:51
        此时的时间是：2023-04-24  20:48:53
        用时： 1935 毫秒
        * */

//        验证时间节点

        Date date2 = new Date();

        String date2Str = format.format(date2);

        System.out.println("此时的时间是："+date2Str);

        long end = System.currentTimeMillis();

        System.out.println("用时： "+(end-begin)+" 毫秒");
    }



//    提供归并排序的：分+合的方法

    public static void Merge(int[] arr, int left, int right, int[] temp) {

        if (left < right) {

            int mid=(left+right)/2;

//            向左边进行递归分解
            Merge(arr,left,mid,temp);

//            System.out.println("左边：分解完毕：  left="+left+"   mid="+mid+"    right="+right);

//            向右边进行递归分解
            Merge(arr,mid+1,right,temp);

//            System.out.println("右边：分解完毕：  left="+left+"   mid="+mid+"    right="+right);

//            分解完了就再进行合并
            Sort(arr,left,mid,right,temp);

        }
    }



//    提供归并排序方法：合并的方法：

    /**
     *
     * @param arr
     * @param left 左标签
     * @param mid  中央标签
     * @param right 右标签
     * @param temp 辅助数组，存数据
     */
    public static void Sort (int[] arr, int left, int mid, int right, int[] temp) {
        int i=left;
        int j=mid+1;
        int t=0;//辅助变量，存辅助数组中的下标

//        (1)
//        先把左右两边的数据按照规则填入到temp数组中
//        直到左右两边的有序序列，又一边处理完为止
        while (i<=mid && j<=right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

//        (2)
//        把所有剩余数据的一边的数据依次全部填入temp
        while (j<=right) {
            temp[t++] = arr[j++];
        }

        while (i<=mid) {
            temp[t++] = arr[i++];
        }

//        (3)
//        将temp数组的元素拷贝到arr
//        注意：不是每次都需要将数组中的所有数据都拷贝进去
        t=0;
        int tempLeft=left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }

//        System.out.println("递归一次： left="+left+"   right="+right+"       arr: "+Arrays.toString(arr)+"\n");

    }
}
