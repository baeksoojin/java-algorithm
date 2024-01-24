package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1389 {
    /**
     * 케빈베이컨의 6단계 법칙
     * 플로이드 워셜을 사용해서 한 정점에서 모든 정점사이의 거리를 구하기
     */

    public static int INF = 99999999;
    public static void initGraph(int[][] graph){

        for(int i=0; i< graph.length; i++){
            for(int j=0; j<graph.length; j++){
                if(i==j){
                    graph[i][j] = 0;
                }else{
                    graph[i][j] = INF;
                }
            }
        }
    }

    public static void floydWarshall(int[][] graph){

        // 시작점. 중간점, 끝점이 존재할때 3중 포문을 돌면서 최소값으로 업데이트

        for(int middle=0; middle<graph.length; middle++){
            for(int start=0; start<graph.length; start++){
                for(int end=0; end< graph.length; end++ ){
                    // 중간지점을 거치는 것과 거치지 않는 것을 비교
                    int distanceByStopMiddle = graph[start][middle] + graph[middle][end];
                    int notStopDistance = graph[start][end];
                    graph[start][end] = ( notStopDistance > distanceByStopMiddle ) ? distanceByStopMiddle : notStopDistance;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n : 유저수, m : 친구 관계수
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] userRelation = new int[n][n];

        initGraph(userRelation);

        // 양방향 관계 초기화
        for(int i=0; i<m; i++){
            int userIndex = sc.nextInt() - 1;
            int user2Index = sc.nextInt() -1;
            userRelation[userIndex][user2Index] = 1;
            userRelation[user2Index][userIndex] = 1;
        }

        floydWarshall(userRelation);

        int min = Arrays.stream(userRelation[0]).sum();
        int minIndex= 0;
        for(int i=1; i<n; i++){
            int sumOfDistanceForI = Arrays.stream(userRelation[i]).sum();// 자기자신으로 돌아갈때는 거리가 어치파 0
            min = min > sumOfDistanceForI ? sumOfDistanceForI : min;
        }

        for(int i=0; i<n; i++){
            if(min == Arrays.stream(userRelation[i]).sum()){
                System.out.println(i+1);
                break;
            }
        }

    }
    
}
