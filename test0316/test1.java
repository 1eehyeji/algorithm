package test0316;

public class test1 {

    public static int[] solution(int money) {
        int[] answer = new int[9];

        while(money > 0) {
            if(money < 10) {
                answer[8] = money / 1;
                money = money % 1;
            }
            else if( money < 50) {
                answer[7] = money / 10;
                money = money % 10;
            }
            else if( money < 100) {
                answer[6] = money / 50;
                money = money % 50;
            }
            else if( money < 500) {
                answer[5] = money / 100;
                money = money % 100;
            }
            else if( money < 1000) {
                answer[4] = money / 500;
                money = money % 500;
            }
            else if( money < 5000) {
                answer[3] = money / 1000;
                money = money % 1000;
            }
            else if( money < 10000) {
                answer[2] = money / 5000;
                money = money % 5000;
            }
            else if( money < 50000) {
                answer[1] = money / 10000;
                money = money % 10000;
            }
            else if(money >= 50000) {
                answer[0] = money / 50000;
                money = money % 50000;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int money1 = 50237;
        int money2 = 1;
        int money3 = 15000;
        int money4 = 1000000;

        int[] a =  solution(money4);

        for(int i : a) {
            System.out.println(i);
        }
    }
}
