/*
* 稀疏数组：创建二维数组，按照稀疏数组的形式进行存储------------这里还缺一部分就是将稀疏数组保存到磁盘上，留到学习了IO流那里来写。
*
* 当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。

    稀疏数组的处理方法是:
        记录数组一共有几行几列，有多少个不同的值
        把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模

* */
public class SparseArrayTest {
    public static void main(String[] args) {
        int[][] arr1=new int[11][11];
        arr1[1][2]=1;
        arr1[2][3]=2;
        arr1[10][5]=15;

        for(int[] i:arr1){//增强for循环,遍历创建的数组
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        int a=0;
        for (int i = 0; i < arr1.length; i++) {//计算数组中存的不为0的数
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != 0) {
                    a++;
                }
            }
        }

        int[][] arr2=new int[a+1][3];//创建稀疏矩阵,存储稀疏数组
        arr2[0][0]=arr1.length;//存储稀疏数组第一行
        arr2[0][1]=arr1[0].length;
        arr2[0][2]=a;

        int a2=1;
        for (int i = 0; i < arr1.length; i++) {//将原始数组中的不为0的数存在稀疏数组中
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
        for(int[] i:arr2){//增强for循环,遍历稀疏数组
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        System.out.println("\n\n从稀疏数组创建原始数组");

        int[][] arr3=new int[arr2[0][0]][arr2[0][1]];

        for (int i = 1; i < arr2.length; i++) {
            arr3[arr2[i][0]][arr2[i][1]]=arr2[i][2];
        }

        for(int[] i:arr3){//增强for循环,遍历稀疏数组
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
