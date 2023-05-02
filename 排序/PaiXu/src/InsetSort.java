import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/*
插入排序：从输入数据的第二个数开始和前面的数比较，排序。等于第二个以后的数都要放到 他前面的数组排一下，看哪个位置符合他

    时间复杂度： O（n^2）

    空间复杂度：O（1）
* */
public class InsetSort {
    public static void main(String[] args) {

        int[] arr={9,4,1,2,35,4,2,47,71};
        Sort(arr);
        System.out.println("排序结果："+ Arrays.toString(arr));

//        验证时间复杂度：
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
        Sort(arr1);

//        验证时间节点

        Date date2 = new Date();

        String date2Str = format.format(date2);

        System.out.println("此时的时间是："+date2Str);

        long end = System.currentTimeMillis();

        System.out.println("用时： "+(end-begin)+" 毫秒");

        /*
        排序结果：[1, 2, 2, 4, 4, 9, 35, 47, 71]
        此时的时间是：2023-04-20  17:37:33
        此时的时间是：2023-04-20  17:37:34
        用时： 894 毫秒
        * */
    }

    public static void Sort(int[] arr) {//给出插入排序的方法

        int needToInsert=0;

        int index = 0;

        int count = 0;

        for (int i=1; i<arr.length; i++) {//循环，挨个往前面放

            needToInsert=arr[i];

            index = i - 1;//和前面的数进行比较，所以从前面的第一个数开始都要比较

            while (index >= 0 && needToInsert < arr[index]) {//和前面的数 一次比较，直到找到合适的位置

                arr[index+1] = arr[index];//依次移位，把大的数放在后面一位

                index--;

                count++;
            }

            if (index != (i-1)) arr[index+1] = needToInsert;//只有index位置变了，才证明我需要换顺序，否则直接不用换位置； index始终在要放的位置的前面
        }

        System.out.println("交换次数：  "+count);
    }
}
