import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
�鲢����

    ʱ�临�Ӷȣ�O��nlogn��

    �ռ临�Ӷȣ�O��1��
* */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2};
        int[] temp=new int[arr.length];
        Merge(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));



//        �����ٶȣ�
        Date date1=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String date1Str = format.format(date1);
        System.out.println("��ʱ��ʱ���ǣ�"+date1Str);

        long begin = System.currentTimeMillis();

//        ���������:
        int[] arr1 = new int[8000000];
        for (int i=0; i<8000000; i++) {
            arr1[i]=(int)(Math.random()*80000000);
        }

//      ����
        int[] temp1=new int[arr1.length];
        Merge(arr1,0,arr1.length-1,temp1);     //��֤��λ��

        /*
        ��ʱ��ʱ���ǣ�2023-04-24  20:48:51
        ��ʱ��ʱ���ǣ�2023-04-24  20:48:53
        ��ʱ�� 1935 ����
        * */

//        ��֤ʱ��ڵ�

        Date date2 = new Date();

        String date2Str = format.format(date2);

        System.out.println("��ʱ��ʱ���ǣ�"+date2Str);

        long end = System.currentTimeMillis();

        System.out.println("��ʱ�� "+(end-begin)+" ����");
    }



//    �ṩ�鲢����ģ���+�ϵķ���

    public static void Merge(int[] arr, int left, int right, int[] temp) {

        if (left < right) {

            int mid=(left+right)/2;

//            ����߽��еݹ�ֽ�
            Merge(arr,left,mid,temp);

//            System.out.println("��ߣ��ֽ���ϣ�  left="+left+"   mid="+mid+"    right="+right);

//            ���ұ߽��еݹ�ֽ�
            Merge(arr,mid+1,right,temp);

//            System.out.println("�ұߣ��ֽ���ϣ�  left="+left+"   mid="+mid+"    right="+right);

//            �ֽ����˾��ٽ��кϲ�
            Sort(arr,left,mid,right,temp);

        }
    }



//    �ṩ�鲢���򷽷����ϲ��ķ�����

    /**
     *
     * @param arr
     * @param left ���ǩ
     * @param mid  �����ǩ
     * @param right �ұ�ǩ
     * @param temp �������飬������
     */
    public static void Sort (int[] arr, int left, int mid, int right, int[] temp) {
        int i=left;
        int j=mid+1;
        int t=0;//�����������渨�������е��±�

//        (1)
//        �Ȱ��������ߵ����ݰ��չ������뵽temp������
//        ֱ���������ߵ��������У���һ�ߴ�����Ϊֹ
        while (i<=mid && j<=right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

//        (2)
//        ������ʣ�����ݵ�һ�ߵ���������ȫ������temp
        while (j<=right) {
            temp[t++] = arr[j++];
        }

        while (i<=mid) {
            temp[t++] = arr[i++];
        }

//        (3)
//        ��temp�����Ԫ�ؿ�����arr
//        ע�⣺����ÿ�ζ���Ҫ�������е��������ݶ�������ȥ
        t=0;
        int tempLeft=left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }

//        System.out.println("�ݹ�һ�Σ� left="+left+"   right="+right+"       arr: "+Arrays.toString(arr)+"\n");

    }
}
