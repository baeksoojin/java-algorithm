package baekjoon;

import java.sql.SQLOutput;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 정점의 개수, 간선의 개수, 탐색 시작 번호. 두 정점의 번호. (양방향)
 * dfs와 bfs 수행결과를 차례대로 구하기
 * 연결 1/ 연결 안 됨 0
 */
public class BOJ1260 {

    public static int graph[][] = new int[1000][1000];
    public static int visitedForDfs[] = new int[1000];// 방문하지 않으면 0/ 방문은 1
    public static int visitedForBfs[] = new int[1000];


    // dfs -> 깊이우선탐색으로 재귀를 사용. dfs를 계속 진행
    public static void dfs(int startNode, Deque<Integer> deque){

        int currentNode = deque.pop();
        System.out.print(currentNode+1 + " ");
        for(int next=0; next<1000; next++){
            if(graph[currentNode][next] == 1 && visitedForDfs[next] != 1){
                deque.push(next);
                visitedForDfs[next] = 1; //visit
                dfs(next, deque);
            }
        }
    }

    public static void bfs(int startNode, Deque<Integer> deque){

        while(!deque.isEmpty()){

            int currentNode = deque.poll();
            System.out.print(currentNode+1 + " ");

            for(int next=0; next<1000; next++){
                if(graph[currentNode][next] == 1 && visitedForBfs[next] != 1){
                    deque.add(next);
                    visitedForBfs[next]=1; //visit
                }
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(), v = sc.nextInt()-1;

        // 인접행렬을 사용하여 정의. -> 인접리스트가 시간복잡도는 낮지만 n이 1000 -> 10^4-> 2중포문으로 1초
        // 구현이 쉬운 인접행렬 사용

        for(int i=0; i<m; i++){
            int nodeIndex1 = sc.nextInt() - 1; // 출력할때 +1
            int nodeIndex2 = sc.nextInt() - 1; // 출력할때 +1
            graph[nodeIndex1][nodeIndex2] = 1;
            graph[nodeIndex2][nodeIndex1] = 1;
        }

        // 시작점 세팅
        Deque<Integer> dequeForDfs = new LinkedList<Integer>();
        dequeForDfs.push(v);// add
        visitedForDfs[v] = 1;// visit
        dfs(v, dequeForDfs);
        System.out.println();

        // 시작점 세팅
        Deque<Integer> dequeForBfs = new LinkedList<Integer>();
        dequeForBfs.add(v);
        visitedForBfs[v] = 1;
        bfs(v, dequeForBfs);
    }




}
