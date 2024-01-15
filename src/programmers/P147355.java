package programmers;

public class P147355 {

    public static Boolean isSameOrSmall(String a, String b){
        Long aIntValue = Long.valueOf(a, 10);
        Long bIntValue = Long.valueOf(b, 10);

        if(aIntValue <= bIntValue){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        String t = "10203";
        String p = "15";

        int count = 0;

        // 1. p의 len 구하기
        int pLength = p.length();
        int tLength = t.length();

        // 2. 탐색을 진행
        for(int i=0; i<tLength-pLength+1; i++){
            String subString = t.substring(i, i+pLength);
            if(isSameOrSmall(subString, p)){
                count+= 1;
            }
        }

        // 3. answer
        System.out.println(count);

    }

}
