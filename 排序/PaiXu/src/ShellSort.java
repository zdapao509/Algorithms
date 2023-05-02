import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
ϣ��������С�������򣩣���������ĸĽ��㷨(����С����������ʱ�򣬲��ò�������ķ���Ч�ʵͣ���Ϊÿһ�������������Ҫ�ƶ���)

    ԭ���൱�ڽ��з�����������У���ÿ�������н������򣬲��õ��ǲ�������ķ���

    ʱ�临�Ӷȣ�O��n^s�� (���� 1<s<2)----���ʱ�临�Ӷ�     ƽ��ʱ�临�Ӷȣ� O��nlogn��

    �ռ临�Ӷȣ�O��1��
* */
public class ShellSort {
    public static void main(String[] args) {

        int[] arr={8,9,1,7,2,3,5,4,6,0};

//        Sort(arr);

//        shellSort1(arr);

        shellSort2(arr);

        System.out.println(Arrays.toString(arr));

        System.out.println("****************************\n");

//        �����ٶȣ�
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
//        Sort(arr1);        //��֤����ʽ��
        /*
        ��ʱ��ʱ���ǣ�2023-04-20  23:04:57
        ���������� 2169598
        ��ʱ��ʱ���ǣ�2023-04-20  23:05:05
        ��ʱ�� 8741 ����
        * */


        shellSort1(arr1);     //��֤��λ��
        /*
        ��ʱ��ʱ���ǣ�2023-04-20  23:13:58
        ���������� 2241611
        ��ʱ��ʱ���ǣ�2023-04-20  23:13:58
        ��ʱ�� 25 ����
        * */

//        shellSort2(arr1);      //��֤�Լ����Ż��Ľ���λ��
        /*
        ��ʱ��ʱ���ǣ�2023-04-20  23:13:28
        ���������� 2262570
        ��ʱ��ʱ���ǣ�2023-04-20  23:13:28
        ��ʱ�� 26 ����
        * */


//        ��֤ʱ��ڵ�

        Date date2 = new Date();

        String date2Str = format.format(date2);

        System.out.println("��ʱ��ʱ���ǣ�"+date2Str);

        long end = System.currentTimeMillis();

        System.out.println("��ʱ�� "+(end-begin)+" ����");

    }

//    �ṩ����ʽ��ϣ�����򷽷���
    public static void Sort(int[] arr){
        int temp = 0;
        int count = 0;

        for (int gap=arr.length/2; gap>0; gap /= 2) {//�ȼ���Ҫ���ж����ִ�

//            System.out.println("\ngap="+gap+"   ,arr="+Arrays.toString(arr));

            for (int i=gap; i<arr.length; i++) {

//                System.out.println("\n        i="+i+"   ,arr="+Arrays.toString(arr));

                for (int j=i-gap; j>=0; j-=gap) {
                    if (arr[j] > arr[j+gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j+gap] = temp;
                        count++;
                    }
//                    System.out.println("\n                 j="+j+"   ,arr="+Arrays.toString(arr));
                }
            }
        }

        System.out.println("���������� "+count);
    }

//    �ṩ����ʽ��ϣ����ʽ�ĸĽ���������λ��

    public static void shellSort1 (int[] arr) {

        int needToInsert=0;

        int index=0;

        int count=0;

        for (int gap = arr.length/2; gap > 0; gap /= 2) {

            for (int i =gap; i < arr.length; i++) {

                needToInsert=arr[i];

                index=i;//�������ҪѰ��λ�õ������±꣬����ҪѰ��λ�õ������±��ǰһ��

                if (arr[index]<arr[index-gap]) {//�����if��������������Ż��ģ��������жϳɲ������ٽ�������ļ���

                    while (index-gap >= 0 && needToInsert<arr[index-gap]) {

                        arr[index]=arr[index-gap];

                        index-=gap;

                        count++;
                    }
//                    �˳�whileѭ��֮��ʹ����ҵ���������ݵ�λ�ã�ֱ�ӷŽ�ȥ
                    arr[index] = needToInsert;//��������Ϊindex�ʹ���ǰҪ���������λ�ã����������index����gap
                }
            }
        }

        System.out.println("���������� "+count);
    }


//    ���Լ��ĸĽ��������������forѭ�����Ͳ�������ķ�ʽ�ܽӽ�

    public static void shellSort2(int[] arr) {

        int needToInsert = 0;

        int index = 0;

        int count=0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) { //�ȼ�����Ҫ���������  10��Ԫ�أ�����Ϊ5��  �ٷֳɲ���Ϊ2��  ���ֳɲ���Ϊ 1

            for (int i = gap; i < arr.length; i++) {  //�ٽ�ÿһ�������������------����ÿһ�����飬�����ò�������ķ���

                needToInsert = arr[i];

                index = i - gap;//�������ҪѰ��λ�õ������±꣬����ҪѰ��λ�õ������±��ǰһ��

                while (index >= 0 && needToInsert < arr[index]) {  //ע�⣺index>=0�жϱ����ǰ�棬��Ȼ�����±�����
                    // ArrayIndexOutOfBoundsException: Index -5 out of bounds for length 10

                    arr[index + gap] = arr[index];

                    index -= gap;

                    count++;
                }
//                    �˳�whileѭ��֮��ʹ����ҵ���������ݵ�λ�ã�ֱ�ӷŽ�ȥ
                arr[index+gap] = needToInsert;

            }
        }

        System.out.println("���������� "+count);
    }
}
