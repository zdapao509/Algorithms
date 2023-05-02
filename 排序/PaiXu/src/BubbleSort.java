import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
冒泡排序 （时间复杂度：O（n^2） 空间（O（1）））

及其 优化(如果在某一次排序中没有发生过一次交换，说明不需要再排序，可以提前结束)
* */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr={9,3,-1,10,-2};
        int[] arr={2,9,3,1,10};
        Sort(arr);

//        验证时间复杂度：生成一些随机数
        int[] arr1=new int[80000];
        for (int i=0; i<80000; i++) {
            arr1[i] = (int)(Math.random()*80000000);//   Math.random()  生成随机数  范围在0-1
        }

//        设置时间标签：
        Date date1=new Date();
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr=format1.format(date1);
        System.out.println("排序前的时间是："+dateStr);

        Sort(arr1);//排序

//        设计时间标签：
        Date date2=new Date();
        String date2Str=format1.format(date2);
        System.out.println("排序之后的时间是："+date2Str);

        /*

        排序前的时间是：2023-04-20 12:19:57
        在第79651次排序已经好了，结束
        排序之后的时间是：2023-04-20 12:20:12

        * */

        System.out.println("************************\n");

//        验证时间复杂度：生成一些随机数
        int[] arr2=new int[80000];
        for (int i=0; i<80000; i++) {
            arr2[i] = (int)(Math.random()*80000000);//   Math.random()  生成随机数  范围在0-1
        }

//        也可以直接计算秒数：
        long begin =System.currentTimeMillis();

        Sort(arr2);

        long end =System.currentTimeMillis();

        System.out.println("花费： "+(end-begin)+" 毫秒");

        /*
        * 花费： 12664 毫秒
        * */
    }



    public static void Sort(int[] arr){//封装成一个方法

        int temp=0;

        for (int i=0; i<arr.length-1; i++) {//5个数的话，只要排4次，拿到4个数的位置之后，最后一个就确定了

            boolean cur=false;//标签：用于检查每一次排序中是不是有数据交换，没有一次数据交换，说明已经排序好了

            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]) {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    cur=true;
                }
            }

//            System.out.println("第"+(i+1)+"次循环的结果："+ Arrays.toString(arr));

            if (!cur) {
                System.out.println("在第" + i+ "次排序已经好了，结束\n");
                break;

                /*
                第1次循环的结果：[2, 3, 6, 9, 10]
                第2次循环的结果：[2, 3, 6, 9, 10]
                在第1次排序已经好了，结束
                * */
            }
        }
    }
}
