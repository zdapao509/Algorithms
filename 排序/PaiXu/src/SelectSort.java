import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
选择排序：每一次循环找最小值，放到最左边--------------时间复杂度：O（n^2）  空间复杂度： O（1）


* */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr={60,-5,6,89,15,40};

        Sort(arr);

        System.out.println("注意：经过选择排序的方法之后，原数组已经发生了变化，也就是后面引用的时候，要注意，是经过排序的"+Arrays.toString(arr));

//        验证速度
        int[] arr1=new int[80000];
        for (int i=0; i<80000; i++) {
            arr1[i]=(int)(Math.random()*8000000);
        }

//        设计时间标签：
        Date date1=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        String date1Str=format.format(date1);
        System.out.println("\n此时的时间："+date1Str);

//        排序
        Sort(arr1);

//        时间标签
        Date date2 = new Date();
        String date2Str = format.format(date2);
        System.out.println("排序完成的时间："+date2Str);
        /*
        此时的时间：2023-04-20 16:49:00
        排序完成的时间：2023-04-20 16:49:04
        * */

//        采用直接计秒数：
        long begin = System.currentTimeMillis();

//        生成排序数据：
        int[] arr2=new int[80000];
        for (int i=0; i<80000; i++) {
            arr2[i]=(int)(Math.random()*8000000);
        }

//    排序：
        Sort(arr2);

//        计秒数：
        long end = System.currentTimeMillis();

        System.out.println("\n排序完成用时： "+(end-begin)+" 毫秒");
        /*
        排序完成用时： 1142 毫秒
        * */

    }

    public static void Sort(int[] arr) {//提供选择排序的方法

        for (int i=0; i<arr.length-1; i++) {

            int minIndex=i;//一开始假定索引的值是最小的

            int min=arr[i];//用于判断比较

            for (int j=i+1; j<arr.length; j++) {

                if (min>arr[j]) {//如果假定的最小值比后面的值还大，那就换成后面的值

                    min=arr[j];

                    minIndex=j;
                }
            }

            if (min!=arr[i]) {//只有当假定的最小值经过上面的循环之后，与原来假定的最小值不相等了，才说明最小的不是当前值，需要交换

                arr[minIndex]=arr[i];

                arr[i] = min;
            }
        }

//        System.out.println(Arrays.toString(arr));

    }
}
