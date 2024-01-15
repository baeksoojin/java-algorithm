package programmers.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P42748Ver2 {

    /**
     * 두 수를 합쳤을 때 큰 수 -> 더 커야함
     * Comparator -> compareTo를 구현 (override) -> lambda 표현식으로 가능
     * => 해당 과정을 반복
     */
    public static void main(String[] args) {

        int[] numbers = new int[]{3, 30, 34, 5, 9};

        String[] stringNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

//        Arrays.sort(stringNumbers, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return (s2+s1).compareTo(s1+s2);
//            }
//        });
        Arrays.sort(stringNumbers, (s1, s2) ->
            (s2+s1).compareTo(s1+s2)
        );

        if(stringNumbers[0].equals("0")) {
            System.out.println("0");
            return;
        }

        //최종연산
        System.out.println(Arrays.stream(stringNumbers).collect(Collectors.joining()));

    }
}
