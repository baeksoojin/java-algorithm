package baekjoon;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 리모컨
 * 리모컨 버튼으로 가기(최대한 가까운 숫자로 이동) vs +, -버튼으로 이동하기 -> dp를 사용
 */
public class BOJ1107 {

    public static void main(String[] args) {

        // 전체 채널을 돌면서 min값을 찾음. 어차피 채널이 50만까지일때 999999가 최대로 나올 수 있는 숫자.
        // 채널 전체에 대해서 -> 버튼으로 이동 가능한 채널이 있다면 거기로 채널을 옮기고 그 다음으로 +,- 버튼의 횟수를 더함.

        Scanner sc = new Scanner(System.in);
        int targetChannel = sc.nextInt();

        int minChannelChangeCount = Math.abs( 100 - targetChannel);

        int wrongButtonCount = sc.nextInt();
        Set<Integer> wrongButtons;
        if(wrongButtonCount!=0){
            sc.nextLine();
            wrongButtons = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toSet());
        } else {
            wrongButtons = new HashSet<>();
        }


        if(targetChannel == 100){
            System.out.println("0");
            return;
        }else if(wrongButtonCount == 10){ // 버튼이 다 고장
            System.out.println(minChannelChangeCount);
            return;
        }else{

            // 만들 수 있는 채널 중(전체탐색) 거기서 +, -로 이동한 숫자를 계속 비교
            for(int i=0; i<1000001; i++){
                // current 채널에서 이동하는 경우
                String currentChannel = String.valueOf(i);

                boolean isPossibleForMove = !currentChannel.chars()
                        .map(it -> it-'0')
                        .anyMatch(it -> wrongButtons.contains(it));


                if(isPossibleForMove){
                    minChannelChangeCount = Math.min(minChannelChangeCount,
                            currentChannel.length() + Math.abs(targetChannel - Integer.valueOf(currentChannel)));
                }
            }

        }
        System.out.println(minChannelChangeCount);
    }
}
