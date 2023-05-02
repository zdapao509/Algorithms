/*
ÉßĞÎ¾ØÕó
* */

public class test {
    public static void main(String[] args) {
        snakeTest(4);
    }
    public static void snakeTest(int temp){
        int i=1;
        int j=2;
        int o=1;
        int q=0;
        int p=0;
        for(int n=0;n<temp;n++){
            for(int k = 0; k < temp-n; k++) {
                if(k==0){
                    q=i;
                    p=j;
                }

                System.out.print(i+" ");
                i+=j;
                j++;

            }

            i=q+o++;
            j=p+1;
            System.out.println();
        }
    }
}

