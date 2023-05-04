package programmers.level1;
import java.util.Arrays;

/*
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환해주는 gcdlcm 함수를 완성해 보세요.
 * 배열의 맨 앞에 최대공약수, 그 다음 최소공배수를 넣어 반환하면 됩니다. 
 * 예를 들어 gcdlcm(3,12) 가 입력되면, [3, 12]를 반환해주면 됩니다.
 */

class GCDandLCM {
    public int[] gcdlcm(int a, int b) {
        int[] answer = new int[2];
        int num1 = Math.max(a, b);
        int num2 = Math.min(a, b);

        while(num2 != 0) {
            int r = (num1 % num2);
            num1 = num2;
            num2 = r;
        }
        
        answer[0] = num1;
        answer[1] = (a * b) / num1;
        
        return answer;
    }

    public static void main(String[] args) {

    }
}