import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
�������򣺶�ð��������иĽ�

    ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ��������ݶ�������һ���ֵ��������ݶ�ҪС��

    Ȼ���ٰ��˷����������������ݷֱ���п�����������������̿��Եݹ���У��Դ˴ﵽ�������ݱ����������

    ʱ�临�Ӷȣ�O��n^2��

    �ռ临�Ӷȣ�O��nlogn��

* */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={18,2,4,-5,6,0,-20,-61,0,5,16};
        Sort(arr,0,arr.length-1);
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
        Sort(arr1,0,arr1.length-1);     //��֤��λ��

        /*
        ��ʱ��ʱ���ǣ�2023-04-24  16:28:51
        ��ʱ��ʱ���ǣ�2023-04-24  16:28:51
        ��ʱ�� 30 ����
        * */

//        ��֤ʱ��ڵ�

        Date date2 = new Date();

        String date2Str = format.format(date2);

        System.out.println("��ʱ��ʱ���ǣ�"+date2Str);

        long end = System.currentTimeMillis();

        System.out.println("��ʱ�� "+(end-begin)+" ����");

    }

//    �����������򷽷���
    public static void Sort(int[] arr, int left, int right) {
        int l=left;
        int r=right;
        int pivot=arr[(l+r)/2];
        int temp=0;//������������
        while (l<r) {

            while (arr[l]<pivot) {//��������£���ߵ���Ӧ��С�ڵ��ڻ�׼ֵ
                l++;//��������������Ǿͼ����������ң�   ѭ���������ҵ��Ȼ�׼ֵ��Ļ���ڻ�׼ֵ��λ����ߵ�ֵ
            }

            while (arr[r]>pivot) {//ͬ���ұߵ�ֵҪ�Ȼ�׼��ֵ��
                r--;
            }

            if (l==r) {//��ʱ������ָ�궼ָ����ͬһ��ֵ��û��Ҫ������
                break;
            }

//            ���ߵ�����ģ���������l r ����ȣ����Կ��Խ��н���
//            System.out.println("������arr["+l+"]="+arr[l]+"     arr["+r+"]="+arr[r]);
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
//            System.out.println("��ʱ��"+Arrays.toString(arr));

//            ��������֮���жϣ��±�ָ�����ǲ��Ǻͻ�׼ֵ��ȣ���Ⱦͽ�����λ�������������ѭ��������
            if (arr[l]==pivot) r--;
            if (arr[r]==pivot) l++;
        }

//        System.out.println("**************************  ����ʱ��l=="+l+"    r=="+r);

//        ����ѭ��������±�����ȵģ�
        if (l==r) {
            l++;
            r--;
        }

//        �����������ߵ�û�д����������������
        if (left<r) {
            Sort(arr,left,r);
        }
        if (right>l) {
            Sort(arr,l,right);
        }
    }
}
