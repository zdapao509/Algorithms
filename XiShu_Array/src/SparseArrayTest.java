/*
* ϡ�����飺������ά���飬����ϡ���������ʽ���д洢------------���ﻹȱһ���־��ǽ�ϡ�����鱣�浽�����ϣ�����ѧϰ��IO��������д��
*
* ��һ�������д󲿷�Ԫ��Ϊ��������Ϊͬһ��ֵ������ʱ������ʹ��ϡ����������������顣

    ϡ������Ĵ�������:
        ��¼����һ���м��м��У��ж��ٸ���ͬ��ֵ
        �Ѿ��в�ֵͬ��Ԫ�ص����м�ֵ��¼��һ��С��ģ�������У��Ӷ���С����Ĺ�ģ

* */
public class SparseArrayTest {
    public static void main(String[] args) {
        int[][] arr1=new int[11][11];
        arr1[1][2]=1;
        arr1[2][3]=2;
        arr1[10][5]=15;

        for(int[] i:arr1){//��ǿforѭ��,��������������
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        int a=0;
        for (int i = 0; i < arr1.length; i++) {//���������д�Ĳ�Ϊ0����
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != 0) {
                    a++;
                }
            }
        }

        int[][] arr2=new int[a+1][3];//����ϡ�����,�洢ϡ������
        arr2[0][0]=arr1.length;//�洢ϡ�������һ��
        arr2[0][1]=arr1[0].length;
        arr2[0][2]=a;

        int a2=1;
        for (int i = 0; i < arr1.length; i++) {//��ԭʼ�����еĲ�Ϊ0��������ϡ��������
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j]!= 0) {
                    arr2[a2][0]=i;
                    arr2[a2][1]=j;
                    arr2[a2][2]=arr1[i][j];
                    a2++;
                }
            }
        }

        System.out.println("***********************\n");
        for(int[] i:arr2){//��ǿforѭ��,����ϡ������
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        System.out.println("\n\n��ϡ�����鴴��ԭʼ����");

        int[][] arr3=new int[arr2[0][0]][arr2[0][1]];

        for (int i = 1; i < arr2.length; i++) {
            arr3[arr2[i][0]][arr2[i][1]]=arr2[i][2];
        }

        for(int[] i:arr3){//��ǿforѭ��,����ϡ������
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
