package programmers.sorting;

import java.util.ArrayList;

public class P42746 {

    public static String maxResult ="";
    public static ArrayList<String> valueResult = new ArrayList<>();
    public static void permutation(int[] array, int[] visited, int dep, int n, int m, int[] original){

        if(dep == m){// 마지막 순열 조합이 들어간 다음 재귀.
            // 배열은 참조타입이기에 copy해서 저장
            //int[] temp = Arrays.copyOf(array,m);
            //permutationResult.add(temp);
            String valueStringTemp = "";
            for(int i=0; i<m; i++){
                valueStringTemp += original[array[i]];
            }
            if(maxResult.compareTo(valueStringTemp) < 0 ){
                maxResult = valueStringTemp;
            }
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i] == 0){// visited 하지 않은 것
                visited[i] = 1;// visited 처리 진행
                array[dep] = i;
                permutation(array, visited, dep+1, n,m, original);
                visited[i]=0; // 같은 level에서는 visited처리 풀기
            }
        }
    }
    public static void main(String[] args) {

        int[] numbers = new int[]{6,10,2};

        // permutation -> index를 순열을 구해서 나올 수 있는 경우를 모두 구한다.
        // n&m PS algorithm을 사용한다.
        int m = numbers.length;// 3개를 뽑음
        int n = numbers.length; // 3개중에서

        int[] visited = new int[m];

        permutation(new int[m],visited,  0, n, m,  numbers);
        System.out.println(maxResult);
    }
}
