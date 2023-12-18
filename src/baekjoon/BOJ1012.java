package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * bfs를 사용한다. -> queue 사용 -> linkedlist를 사용
 * add, poll
 */
public class BOJ1012 {

    // 상하좌우
    static int[][] direct = {{-1,0}, {1,0},{0, -1}, {0,1} };

    public static int[][] bfs(int[][] map, Queue<Integer> xQueue, Queue<Integer> yQueue){

        int xLen = map.length;
        int yLen = map[0].length;

        while(!xQueue.isEmpty()){
            int currentX = xQueue.poll(); // peak은 제거하지 않고 반환
            int currentY = yQueue.poll();

            for(int i=0; i<direct.length; i++){
                int nextX = currentX + direct[i][0];
                int nextY = currentY + direct[i][1];

                if((0<=nextX && nextX <xLen) && (0<= nextY && nextY < yLen)){
                    if(map[nextX][nextY] == 1 ){
                        xQueue.add(nextX);
                        yQueue.add(nextY);
                        map[nextX][nextY] = 0; //visited
                    }

                }
            }
        }


        return map;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();


        for(int i=0; i<testCase; i++){

            int answer = 0;

            int m = sc.nextInt();
            int n = sc.nextInt();
            int p = sc.nextInt();

            //배열 초기화
            int[][] map = new int[n][m];
            for(int j=0; j<p; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                map[b][a] = 1;
            }


            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    // 1일때 bfs로 탐색을 시작 -> 탐색한 것은 다시 0으로 변경
                    if(map[j][k] == 1){
                        answer+=1;
                        Queue<Integer> xQueue = new LinkedList<Integer>();
                        Queue<Integer> yQueue = new LinkedList<Integer>();
                        // in queue
                        xQueue.add(j);
                        yQueue.add(k);

                        //visited
                        map[j][k] = 0;
                        map = bfs(map,xQueue, yQueue);

                    }

                }
            }
            System.out.println(answer);

        }
    }
}
