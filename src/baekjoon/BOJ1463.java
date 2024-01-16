package baekjoon;

import java.util.Scanner;

/**
 * 3가지 경우에서 어떤거를 써야 최소가 될 지 모르니 전부 탐색.
 * dp를 써서 기록.
 * 연산을 사용하는 횟수의 최소횟수를 출력
 */
public class BOJ1463 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] dp = new int[(int)Math.pow(10,6)+1];

        int n = sc.nextInt();

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        if(n==1){
            System.out.println("0");
        }else if(n==2 || n==3){
            System.out.println("1");
        }else{
            for(int i=4; i<n+1; i++){
                dp[i] = dp[i-1] + 1;

                if(i%2 == 0){
                    dp[i] = dp[i/2] + 1 <= dp[i] ? dp[i/2]+1 : dp[i];
                }
                if(i%3 == 0){
                    dp[i] = dp[i/3] + 1 <=  dp[i] ? dp[i/3]+1 : dp[i];
                }
            }
            System.out.println(dp[n]);
        }



    }
}
