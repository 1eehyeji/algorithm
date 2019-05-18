package codingTest.W0316;

public class test4 {

    public static int solution(int[] pobi, int[] crong) {
        int answer = 0;

       if(check(pobi) || check(crong)) {
           return -1;
       }

        int pobiHigh = Math.max( Math.max(sum(pobi[0]), multiply(pobi[0])),
                Math.max(sum(pobi[1]), multiply(pobi[1])));

        int crongHigh = Math.max( Math.max(sum(crong[0]), multiply(crong[0])),
                Math.max(sum(crong[1]), multiply(crong[1])));

        if(pobiHigh > crongHigh) {
            answer = 1;
        }
        else if(pobiHigh < crongHigh) {
            answer = 2;
        }
        else {
            answer = 0;
        }

       return answer;
    }

    public static int sum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }

        return sum;
    }

    public static int multiply(int num) {
        int multiply = 1;

        while (num > 0) {
            multiply *= num % 10;
            num = num / 10;
        }

        return multiply;
    }

    public static boolean check(int[] a) {
        if(a[0] < 1 || a[1] > 400) {
            return true;
        }
        if(a[1] - a[0] > 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] pobi = { 131, 132 };
        int[] crong = { 99, 102 };

        System.out.println(solution(pobi, crong));
    }
}
