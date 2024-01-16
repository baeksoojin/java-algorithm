package programmers.heap;

import java.util.PriorityQueue;

/**
 * 스코빌 지수지수가 k이상이 되도록
 * 최소 섞은 횟수
 * 백만 개의 scoville
 * peek -> get : 수정하지 않고 가져옴. (굳이 ..?)
 * poll -> remove & get
 */
public class P42626 {
    public static void main(String[] args) {

        int[] scoville = new int[]{2, 3};
        int k = 7;

        // 우선순위가 낮은 순서대로 먼저나옴
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            priorityQueue.add(scoville[i]);
        }
        int count = 0;
        while(true){

            // 모든 값이 k를 넘을때 stop -> 가장 작은 값이 k보다 크거나 같으면 됨
            int scovilleSize = priorityQueue.size();
            int smallestScoville = priorityQueue.poll();
            if(smallestScoville >= k){
                break;
            } else if (smallestScoville < k && scovilleSize ==1){
                count = -1;
                break;
            }

            // 가장 작은 것과 그 다음을 뽑아서 다시 priorityQueue에 넣음.
            int secondSmallestScoville = priorityQueue.poll();
            priorityQueue.add(smallestScoville + secondSmallestScoville * 2 );
            // 횟수 증가
            count++;

        }
        System.out.println(count);
    }
}
