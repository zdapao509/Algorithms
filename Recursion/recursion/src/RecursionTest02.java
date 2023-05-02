
public class RecursionTest02 {
    public static void main(String[] args) {
        //        创建迷宫：数字1 代表围墙
        int[][] MiGong=new int[10][10];

        //上下面的墙体
        for(int i=0;i<MiGong.length;i++){//注意 .length获取的是数组的行数
            for (int j = 0; j < MiGong[0].length; j++) {//注意 MiGong[0].length 获取的是数组的列数
                MiGong[0][j]=1;
                MiGong[MiGong.length-1][j]=1;
            }
        }
        //左右面的墙体
        for(int i=0;i<MiGong.length;i++){//注意 .length获取的是数组的行数
            for (int j = 0; j < MiGong[0].length; j++) {//注意 MiGong[0].length 获取的是数组的列数
                MiGong[i][0]=1;
                MiGong[i][MiGong[0].length-1]=1;
            }
        }

        //添加阻碍
        for(int i=5;i<MiGong.length;i++){//注意 .length获取的是数组的行数
            for (int j = 1; j < 5; j++) {//注意 MiGong[0].length 获取的是数组的列数
                MiGong[5][j]=1;
            }
        }

        for(int i=3;i<MiGong.length-1;i++){//注意 .length获取的是数组的行数
            MiGong[i][6]=1;
            MiGong[i-2][8]=1;
        }

//        展示迷宫：
        for(int i=0;i<MiGong.length;i++){//注意 .length获取的是数组的行数
            for (int j = 0; j < MiGong[0].length; j++) {//注意 MiGong[0].length 获取的是数组的列数
                System.out.print(MiGong[i][j]+"     ");
            }
            System.out.println("\n");
        }


//        走迷宫
//        setWay(MiGong,2,2);


//        展示走过的迷宫：
        System.out.println("**************************************");
        for(int i=0;i<MiGong.length;i++){//注意 .length获取的是数组的行数
            for (int j = 0; j < MiGong[0].length; j++) {//注意 MiGong[0].length 获取的是数组的列数
                System.out.print(MiGong[i][j]+"     ");
            }
            System.out.println("\n");
        }

    }


    /*public static boolean setWay(int[][] map, int i, int j) {
        if (map[8][8] == 2) { // 通路已经找到 ok
            return true;
        } else {
            if (map[i][j] == 0) { //如果当前这个点还没有走过
                map[i][j] = 2; // 假定该点是可以走通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { //向右走

                    return true;
                } else if (setWay(map, i - 1, j)) { //向上

                    return true;
                } else if (setWay(map, i, j - 1)) { // 向左走

                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果 map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }*/
}

