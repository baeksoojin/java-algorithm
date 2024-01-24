package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 최소힙
 * 최대힙 : (a,b) -> b-a
 *
 * //시간초과 -> scanner -> inputStream. bufferreader로 변경 & size도 변수로 변경.
 * 시간초과 해결
 */
public class BOJ1927 {

    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue priorityQueue = new PriorityQueue();

        int queueSize = 0;
        for(int i=0; i<n; i++){
            //int currentNum = sc.nextInt();
            int currentNum = Integer.parseInt(br.readLine());
            if( currentNum == 0){
                if(queueSize == 0){
                    System.out.println(0);
                }else{
                    // remove and pop -> poll()
                    System.out.println(priorityQueue.poll());
                    queueSize -= 1;
                }
            }else{
                priorityQueue.add(currentNum);
                queueSize+=1;
            }
        }


    }
}
