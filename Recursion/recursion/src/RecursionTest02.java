
public class RecursionTest02 {
    public static void main(String[] args) {
        //        �����Թ�������1 ����Χǽ
        int[][] MiGong=new int[10][10];

        //�������ǽ��
        for(int i=0;i<MiGong.length;i++){//ע�� .length��ȡ�������������
            for (int j = 0; j < MiGong[0].length; j++) {//ע�� MiGong[0].length ��ȡ�������������
                MiGong[0][j]=1;
                MiGong[MiGong.length-1][j]=1;
            }
        }
        //�������ǽ��
        for(int i=0;i<MiGong.length;i++){//ע�� .length��ȡ�������������
            for (int j = 0; j < MiGong[0].length; j++) {//ע�� MiGong[0].length ��ȡ�������������
                MiGong[i][0]=1;
                MiGong[i][MiGong[0].length-1]=1;
            }
        }

        //����谭
        for(int i=5;i<MiGong.length;i++){//ע�� .length��ȡ�������������
            for (int j = 1; j < 5; j++) {//ע�� MiGong[0].length ��ȡ�������������
                MiGong[5][j]=1;
            }
        }

        for(int i=3;i<MiGong.length-1;i++){//ע�� .length��ȡ�������������
            MiGong[i][6]=1;
            MiGong[i-2][8]=1;
        }

//        չʾ�Թ���
        for(int i=0;i<MiGong.length;i++){//ע�� .length��ȡ�������������
            for (int j = 0; j < MiGong[0].length; j++) {//ע�� MiGong[0].length ��ȡ�������������
                System.out.print(MiGong[i][j]+"     ");
            }
            System.out.println("\n");
        }


//        ���Թ�
//        setWay(MiGong,2,2);


//        չʾ�߹����Թ���
        System.out.println("**************************************");
        for(int i=0;i<MiGong.length;i++){//ע�� .length��ȡ�������������
            for (int j = 0; j < MiGong[0].length; j++) {//ע�� MiGong[0].length ��ȡ�������������
                System.out.print(MiGong[i][j]+"     ");
            }
            System.out.println("\n");
        }

    }


    /*public static boolean setWay(int[][] map, int i, int j) {
        if (map[8][8] == 2) { // ͨ·�Ѿ��ҵ� ok
            return true;
        } else {
            if (map[i][j] == 0) { //�����ǰ����㻹û���߹�
                map[i][j] = 2; // �ٶ��õ��ǿ�����ͨ
                if (setWay(map, i + 1, j)) {//������
                    return true;
                } else if (setWay(map, i, j + 1)) { //������

                    return true;
                } else if (setWay(map, i - 1, j)) { //����

                    return true;
                } else if (setWay(map, i, j - 1)) { // ������

                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else { // ��� map[i][j] != 0 , ������ 1�� 2�� 3
                return false;
            }
        }
    }*/
}

