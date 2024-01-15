package programmers;

import java.util.HashMap;

public class P172928 {

    public static Boolean isStartPoint(char point){
        if(point == 'S'){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String[] park = new String[]{ "SOO", "OOO", "OOO"};
        String[] routes = new String[]{"E 2","S 2","W 1"};

        int xCurrent = 0;
        int yCurrent = 0;

        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(isStartPoint(park[i].charAt(j))){
                    xCurrent = i;
                    yCurrent = j;
                    System.out.println( "x : " + xCurrent + "y : " +  yCurrent);
                    break;
                }
            }
        }

        // 방향 이동 세팅
        HashMap<Character, Integer[]> direction = new HashMap<>();

        direction.put('N', new  Integer[]{-1, 0});//위로 이동
        direction.put('S', new  Integer[]{1, 0});//아래로 이동
        direction.put('W', new  Integer[]{0, -1});//왼쪽으로 이동
        direction.put('E', new  Integer[]{0, 1});//오른쪽으로 이동

        // routes 탐색

        for(int r=0; r<routes.length; r++){

            Boolean breakFlag = false;
            Boolean outFlag = false;

            char currentDir = routes[r].charAt(0);
            int changeCount = routes[r].charAt(2) - '0';

            int xDiff = direction.get(currentDir)[0];
            int yDiff = direction.get(currentDir)[1];

            int xCurrentTemp = xCurrent;
            int yCurrentTemp = yCurrent;

            System.out.println(xCurrentTemp + " " + yCurrentTemp);

            //이동시키기

            for(int i=0; i<changeCount; i++){
                xCurrentTemp += xDiff;
                yCurrentTemp += yDiff;

                System.out.println(xCurrentTemp + " / " +yCurrentTemp);
                // 이동하는 사이에 장애물 여부 체크
                if(park[xCurrentTemp].charAt(yCurrentTemp) == 'X'){
                    breakFlag = true;
                    break;
                }

                // 이동하는 사이에 범위 초과 체크
                if(xCurrentTemp >= park.length || xCurrentTemp <0 || yCurrentTemp <0 || yCurrentTemp >= park[0].length()){

                    outFlag = true;
                    break;
                }
            }

            // 정상일때만
            if (breakFlag == false && outFlag == false){
                xCurrent = xCurrentTemp;
                yCurrent = yCurrentTemp;
            }
        }

        int[] answer = new int[]{xCurrent, yCurrent};
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }


}
