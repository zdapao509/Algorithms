import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/*
�������򣺴��������ݵĵڶ�������ʼ��ǰ������Ƚϣ����򡣵��ڵڶ����Ժ������Ҫ�ŵ� ��ǰ���������һ�£����ĸ�λ�÷�����

    ʱ�临�Ӷȣ� O��n^2��

    �ռ临�Ӷȣ�O��1��
* */
public class InsetSort {
    public static void main(String[] args) {

        int[] arr={9,4,1,2,35,4,2,47,71};
        Sort(arr);
        System.out.println("��������"+ Arrays.toString(arr));

//        ��֤ʱ�临�Ӷȣ�
        Date date1=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String date1Str = format.format(date1);
        System.out.println("��ʱ��ʱ���ǣ�"+date1Str);

        long begin = System.currentTimeMillis();

//        ���������:
        int[] arr1 = new int[80000];
        for (int i=0; i<80000; i++) {
            arr1[i]=(int)(Math.random()*80000000);
        }

//        ����
        Sort(arr1);

//        ��֤ʱ��ڵ�

        Date date2 = new Date();

        String date2Str = format.format(date2);

        System.out.println("��ʱ��ʱ���ǣ�"+date2Str);

        long end = System.currentTimeMillis();

        System.out.println("��ʱ�� "+(end-begin)+" ����");

        /*
        ��������[1, 2, 2, 4, 4, 9, 35, 47, 71]
        ��ʱ��ʱ���ǣ�2023-04-20  17:37:33
        ��ʱ��ʱ���ǣ�2023-04-20  17:37:34
        ��ʱ�� 894 ����
        * */
    }

    public static void Sort(int[] arr) {//������������ķ���

        int needToInsert=0;

        int index = 0;

        int count = 0;

        for (int i=1; i<arr.length; i++) {//ѭ����������ǰ���

            needToInsert=arr[i];

            index = i - 1;//��ǰ��������бȽϣ����Դ�ǰ��ĵ�һ������ʼ��Ҫ�Ƚ�

            while (index >= 0 && needToInsert < arr[index]) {//��ǰ����� һ�αȽϣ�ֱ���ҵ����ʵ�λ��

                arr[index+1] = arr[index];//������λ���Ѵ�������ں���һλ

                index--;

                count++;
            }

            if (index != (i-1)) arr[index+1] = needToInsert;//ֻ��indexλ�ñ��ˣ���֤������Ҫ��˳�򣬷���ֱ�Ӳ��û�λ�ã� indexʼ����Ҫ�ŵ�λ�õ�ǰ��
        }

        System.out.println("����������  "+count);
    }
}
