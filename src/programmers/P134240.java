package programmers;

public class P134240 {

    public static void main(String[] args) {
        int[] food = new int[]{1,3,4,6};
        String foodsForCompetition = "";

        for(int i=1; i<food.length; i++){
            // 2로 나눈 몫 -> i가 몫만큼 배열에 저장
            int count = food[i]/2; // 몫
            System.out.println(count);
            for(int j=0; j<count; j++){
                foodsForCompetition += String.valueOf(i);
            }
        }

        // 문자열 뒤집기
        StringBuilder reversedStr = new StringBuilder(foodsForCompetition);
        reversedStr.reverse();
        System.out.println(reversedStr);

        System.out.println(foodsForCompetition + "0" + reversedStr);
    }
}
