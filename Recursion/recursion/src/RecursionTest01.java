/*
递归：

    用递归实现迷宫问题
* */
public class RecursionTest01 {
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
        setWay(MiGong,3,2);


//        展示走过的迷宫：
        System.out.println("**************************************");
        for(int i=0;i<MiGong.length;i++){//注意 .length获取的是数组的行数
            for (int j = 0; j < MiGong[0].length; j++) {//注意 MiGong[0].length 获取的是数组的列数
                System.out.print(MiGong[i][j]+"     ");
            }
            System.out.println("\n");
        }

    }

//    提供方法走迷宫：
    public static boolean setWay(int[][] map,int i,int j) {

        System.out.println("此时： x=" + i + "     y=" + j);

        if(map[8][8]==2){
            return true;
        }else{
            if(map[i][j]==0){

                map[i][j]=2;

                if(setWay(map,i+1,j)){//先向下走
                    System.out.println("向下走一步,此时： x="+(i+1)+"  y="+j);
                    return true;
                }else if(setWay(map,i,j+1)){
                    System.out.println("向右边走一步,此时： x="+i+"  y="+(j+1));
                    return true;
                }else if(setWay(map,i-1,j)){
                    System.out.println("向上边走一步,此时： x="+(i-1)+"  y="+j);
                    return true;
                }else if(setWay(map,i,j-1)){
                    System.out.println("向左边走一步,此时： x="+i+"  y="+(j-1));
                    return true;
                }else{//走不通：
                    System.out.println("走到：x="+i+"  y="+j+"的时候走不通！！");
                    map[i][j]=3;
                    return false;
                }
            }else{//如果map[i][j]不等于0，说明是墙体1，或者已经走过的2，或者死路3
                return false;
            }
        }
    }
}
