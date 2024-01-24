package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * 9시 20분 시작.-> 목표 9시50분
 * 연속된 부분 수열의 합
 * 오름차순으로 정렬된 수열. 두 인덱스의 원소와 그 사이의 원소를 모두 포함 : 부분 수열
 * 부분수열의 합 k. 합이 동일하다면 길이가 짧은 수열이 부분수열 -> 길이가 동일하다면 가장 먼저 앞쪽에 나오는 수열
 * 부분수열의 합 k를 만드는 인덱스 2개를 출력
 *
 * 시행1.) 10^7이 N이기에 무조건 시간초과. -> 41.2점( 9시45분 제출)
 * 시행2.) 투포인터를 사용해서 누적합을 구해줘야한다.
 *
 */
public class P178870 {
    public static void main(String[] args) {

        // 시간복잡도가 존재하지 앟음.
        int[] sequence = new int[]{1, 2, 3, 4, 5};
        int k = 7;
        int[] answer = {};

        // 10^7 -> N 시간복잡도를 고려한다면 이중포문은 안됨.

        // list -> 부분수열을 만들 수 있는 인덱스 두개를 저장. 길이 list-> 길이를 저장.
        // list 결과에서 인덱스 길이가 가장 짧은 것을 길이 list로 구하고 그때의 index중에서 가장 적은 것을 찾기
        // 가장 작은 index의 list에 담긴 배열이 정답

        ArrayList<int[]> indexsForK = new ArrayList<>();
        ArrayList<Integer> lengthForK = new ArrayList<>();

        for(int i=0; i<sequence.length; i++){
            for(int j=i; j<sequence.length; j++){
                int[] tempArray = Arrays.copyOfRange(sequence, i, j+1);
                if(Arrays.stream(tempArray).sum() == k){
                    indexsForK.add(new int[]{i,j});
                    lengthForK.add(j-i);
                }
            }
        }
        Optional<Integer> minlength = lengthForK.stream().min((a, b)-> (a-b));
        int min = minlength.get();

        for(int i=0; i<lengthForK.size(); i++){
            if(lengthForK.get(i)== min){
                int[] minLenIndexsForK =  indexsForK.get(i);
                System.out.println(Arrays.toString(minLenIndexsForK));
                answer = minLenIndexsForK;
                break;
            }
        }

        System.out.println(answer);
    }
}
