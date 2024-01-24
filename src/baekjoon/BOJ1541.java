package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 8시 31분 / 목표 : 9시
 * 괄호를 쳐서 식의 계산 결과를 최소로 만들려고한다.
 *
 * => 9시3분 solved
 */
public class BOJ1541 {

    public static void main(String[] args) {

        // ex. 1+1+1-100-10+1 -> -와 -가 나오기 전이라는거는 그 위치를 저장해야한다는 것.
        // -가 아예없을때 -> 숫자를 plusNumber에 더하기
        // 숫자와 기호를 저장한 배열에서 for -> -가 하나만 존재할때 -> -가 나오기 전까지 계속 minusNumber에 더하기
        // 최종은 plusNumber - minusNumber가 결과

        Scanner sc = new Scanner(System.in);
        String target = sc.next();

        ArrayList<String> NumberAndSign = new ArrayList<String>();

        char[] targetChars = target.toCharArray();
        String numberStringTemp = "";
        for(int i=0; i<targetChars.length; i++){
            if(targetChars[i] == '+' || targetChars[i] == '-'){ // 기호
                NumberAndSign.add(numberStringTemp);// 이전에 있던 숫자들을 넣어줌
                NumberAndSign.add(String.valueOf(targetChars[i]));// 현재의 기호를 넣어줌.
                numberStringTemp = ""; // 숫자초기화
            }else{
                numberStringTemp += targetChars[i];
            }
        }
        NumberAndSign.add(numberStringTemp);// 마지막에 나온 숫자 저장.


        int plusNumber = 0;
        int minusNumber = 0;
        boolean isPlusNumber = true;
        for(int i=0; i<NumberAndSign.size(); i++){
            String currentString = NumberAndSign.get(i);

            if(currentString.equals("-")){// switch
                isPlusNumber = false;
                continue;
            }else if(currentString.equals("+")){
                continue;
            }
            // 아래는 숫자일때만 동작
            if(isPlusNumber){
                plusNumber += Integer.valueOf(currentString);
            }else{
                minusNumber += Integer.valueOf(currentString);
            }
        }

        System.out.println(plusNumber - minusNumber);

    }
}
