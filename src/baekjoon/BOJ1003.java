package baekjoon;

import java.util.*;
public class BOJ1003 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        int[] fiboPrint0 = new int[41];
        int[] fiboPrint1 = new int[41];

        fiboPrint0[0] = 1;
        fiboPrint0[1] = 0;
        fiboPrint1[0] = 0;
        fiboPrint1[1] = 1;

        for(int idx=0; idx<n; idx++){

            int m = sc.nextInt();

            if(m==0){
                System.out.println(fiboPrint0[m] + " " + fiboPrint1[m]);
                continue;
            }
            else if(m==1){
                System.out.println(fiboPrint0[m] + " " + fiboPrint1[m]);
                continue;
            }

            for(int i=2; i<m+1; i++){
                fiboPrint0[i] = fiboPrint0[i-2] + fiboPrint0[i-1];
                fiboPrint1[i] = fiboPrint1[i-2] + fiboPrint1[i-1];
            }
            System.out.println(fiboPrint0[m] + " " + fiboPrint1[m]);
        }


    }
}
