import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
ð������ ��ʱ�临�Ӷȣ�O��n^2�� �ռ䣨O��1������

���� �Ż�(�����ĳһ��������û�з�����һ�ν�����˵������Ҫ�����򣬿�����ǰ����)
* */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr={9,3,-1,10,-2};
        int[] arr={2,9,3,1,10};
        Sort(arr);

//        ��֤ʱ�临�Ӷȣ�����һЩ�����
        int[] arr1=new int[80000];
        for (int i=0; i<80000; i++) {
            arr1[i] = (int)(Math.random()*80000000);//   Math.random()  ���������  ��Χ��0-1
        }

//        ����ʱ���ǩ��
        Date date1=new Date();
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr=format1.format(date1);
        System.out.println("����ǰ��ʱ���ǣ�"+dateStr);

        Sort(arr1);//����

//        ���ʱ���ǩ��
        Date date2=new Date();
        String date2Str=format1.format(date2);
        System.out.println("����֮���ʱ���ǣ�"+date2Str);

        /*

        ����ǰ��ʱ���ǣ�2023-04-20 12:19:57
        �ڵ�79651�������Ѿ����ˣ�����
        ����֮���ʱ���ǣ�2023-04-20 12:20:12

        * */

        System.out.println("************************\n");

//        ��֤ʱ�临�Ӷȣ�����һЩ�����
        int[] arr2=new int[80000];
        for (int i=0; i<80000; i++) {
            arr2[i] = (int)(Math.random()*80000000);//   Math.random()  ���������  ��Χ��0-1
        }

//        Ҳ����ֱ�Ӽ���������
        long begin =System.currentTimeMillis();

        Sort(arr2);

        long end =System.currentTimeMillis();

        System.out.println("���ѣ� "+(end-begin)+" ����");

        /*
        * ���ѣ� 12664 ����
        * */
    }



    public static void Sort(int[] arr){//��װ��һ������

        int temp=0;

        for (int i=0; i<arr.length-1; i++) {//5�����Ļ���ֻҪ��4�Σ��õ�4������λ��֮�����һ����ȷ����

            boolean cur=false;//��ǩ�����ڼ��ÿһ���������ǲ��������ݽ�����û��һ�����ݽ�����˵���Ѿ��������

            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]) {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    cur=true;
                }
            }

//            System.out.println("��"+(i+1)+"��ѭ���Ľ����"+ Arrays.toString(arr));

            if (!cur) {
                System.out.println("�ڵ�" + i+ "�������Ѿ����ˣ�����\n");
                break;

                /*
                ��1��ѭ���Ľ����[2, 3, 6, 9, 10]
                ��2��ѭ���Ľ����[2, 3, 6, 9, 10]
                �ڵ�1�������Ѿ����ˣ�����
                * */
            }
        }
    }
}
