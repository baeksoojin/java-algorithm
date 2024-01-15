package programmers.sorting;

import java.util.Arrays;

/**
 * 부분 array -> copyOfRange(array, from, to); to는 포함 X
 */
public class P42748 {

    /**
     * N과 M은 재귀를 사용하기 때문에 시간복잡도는 O(n!) -> m이 9정도일때만 사용하도록 하자.
     * 무조건 시간초과
     */

    public static void main(String[] args) {

        int[] array = new int[]{1,5,2, 6, 3, 7, 4};
        int[][] commands = new int[][]{
                {2, 5, 3}, {4, 4, 1}, {1, 7, 3}
        };

        int[] answer = new int[commands.length];

        for(int i=0; i< commands.length; i++){

            int[] command = commands[i];
            int startIdx = command[0]-1;
            int endIdx = command[1];
            int answerIdx = command[2]-1;

            // 부분 array -> copyOfRange(array, s, e); : e는 포함하지 않음
            int[] cutArray = Arrays.copyOfRange(array, startIdx, endIdx);
            // sorting
            int[] sortCutArray = Arrays.stream(cutArray).sorted().toArray();
            System.out.println(sortCutArray[answerIdx]);
            answer[i] = sortCutArray[answerIdx];


        }
    }
}
