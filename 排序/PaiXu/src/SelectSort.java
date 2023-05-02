import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
ѡ������ÿһ��ѭ������Сֵ���ŵ������--------------ʱ�临�Ӷȣ�O��n^2��  �ռ临�Ӷȣ� O��1��


* */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr={60,-5,6,89,15,40};

        Sort(arr);

        System.out.println("ע�⣺����ѡ������ķ���֮��ԭ�����Ѿ������˱仯��Ҳ���Ǻ������õ�ʱ��Ҫע�⣬�Ǿ��������"+Arrays.toString(arr));

//        ��֤�ٶ�
        int[] arr1=new int[80000];
        for (int i=0; i<80000; i++) {
            arr1[i]=(int)(Math.random()*8000000);
        }

//        ���ʱ���ǩ��
        Date date1=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        String date1Str=format.format(date1);
        System.out.println("\n��ʱ��ʱ�䣺"+date1Str);

//        ����
        Sort(arr1);

//        ʱ���ǩ
        Date date2 = new Date();
        String date2Str = format.format(date2);
        System.out.println("������ɵ�ʱ�䣺"+date2Str);
        /*
        ��ʱ��ʱ�䣺2023-04-20 16:49:00
        ������ɵ�ʱ�䣺2023-04-20 16:49:04
        * */

//        ����ֱ�Ӽ�������
        long begin = System.currentTimeMillis();

//        �����������ݣ�
        int[] arr2=new int[80000];
        for (int i=0; i<80000; i++) {
            arr2[i]=(int)(Math.random()*8000000);
        }

//    ����
        Sort(arr2);

//        ��������
        long end = System.currentTimeMillis();

        System.out.println("\n���������ʱ�� "+(end-begin)+" ����");
        /*
        ���������ʱ�� 1142 ����
        * */

    }

    public static void Sort(int[] arr) {//�ṩѡ������ķ���

        for (int i=0; i<arr.length-1; i++) {

            int minIndex=i;//һ��ʼ�ٶ�������ֵ����С��

            int min=arr[i];//�����жϱȽ�

            for (int j=i+1; j<arr.length; j++) {

                if (min>arr[j]) {//����ٶ�����Сֵ�Ⱥ����ֵ�����Ǿͻ��ɺ����ֵ

                    min=arr[j];

                    minIndex=j;
                }
            }

            if (min!=arr[i]) {//ֻ�е��ٶ�����Сֵ���������ѭ��֮����ԭ���ٶ�����Сֵ������ˣ���˵����С�Ĳ��ǵ�ǰֵ����Ҫ����

                arr[minIndex]=arr[i];

                arr[i] = min;
            }
        }

//        System.out.println(Arrays.toString(arr));

    }
}
