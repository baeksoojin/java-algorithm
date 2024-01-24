package baekjoon;

import java.util.Scanner;

/**
 *
 * 분할정복을 사용해서 문제 풀이를 진행
 * 4*4 -> 2*2 -> 1*1 탐색
 * 8*8 -> 4*4 -> 2*2 -> 1*1 탐색
 * 범위에 해당하는 영역을 찾고 그 영역이 현재 탐색 범위중 (4개중) 어디 영역에 해당하는지에 따라서 숫자를 더하고 시작
 *
 * -> 시간초과(다시 체크 필요)
 */
public class BOJ1074 {

    public static int X_Target = 0;
    public static int Y_Target = 0;

    public static int Answer = 0;
    public static void findTargetByConquer(int currentSize, int x, int y, int count){

        if(currentSize == 1 && x == X_Target & y == Y_Target){
            Answer = count;
            return;
        }else if (currentSize == 1){
            return ;
        }

        if( !((X_Target >= x  || X_Target < x+ currentSize)
                && (Y_Target >= y  || Y_Target < y + currentSize))){
            return;
        }
        //탐색범위 안에 존재하는지 체크
        if( (X_Target >= x  || X_Target < x+ currentSize)
                && (Y_Target >= y  || Y_Target < y + currentSize)){
            int nextSize = (int) currentSize/2;
            findTargetByConquer(nextSize, x , y , count);
            findTargetByConquer(nextSize, x, y+nextSize, count + (int)Math.pow(nextSize, 2) * 1);
            findTargetByConquer(nextSize, x + nextSize, y , count + (int)Math.pow(nextSize, 2) * 2);
            findTargetByConquer(nextSize, x + nextSize, y + nextSize, count + (int)Math.pow(nextSize, 2) * 3);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int totalSize = (int)Math.pow(2,n);

        X_Target = sc.nextInt();
        Y_Target = sc.nextInt();

        findTargetByConquer(totalSize, 0,0,0);
        System.out.println(Answer);

    }
}
