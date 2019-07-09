package codingTest.W0316;

public class Test7 {

    public static String solution(String cryptogram) {
        String[] answer = new String[cryptogram.length()];
        for(int i = 0; i < cryptogram.length(); ++i) {
            answer[i] = cryptogram.charAt(i) + "";
        }

        boolean check = true;

        while(check) {
            check = false;
            for (int i = 1; i < answer.length; ++i) {
                if(!answer[i].equals(" ")) {
                    if (answer[i - 1].equals(answer[i])) {
                        check = true;
                        answer[i - 1] = " ";
                        answer[i] = " ";
                    }
                }
            }
            answer = newArr(answer);
        }

        StringBuilder sb = new StringBuilder();
        for(String s : answer) {
            if(!s.equals(" ")) {
                sb.append(s);
            }
        }

        return sb.toString();
    }

    public static String[] newArr(String[] s) {
        StringBuilder sb = new StringBuilder();
        for(String str : s) {
            if(!str.equals(" ")) {
                sb.append(str);
            }
        }

        String string = sb.toString();

        String[] result = new String[string.length()];
        for(int i = 0; i < string.length(); ++i) {
            result[i] = string.charAt(i) + "";
        }

        return result;
    }

    public static void main(String[] args) {
        String cryptogram = "zyelleyz";

        System.out.println(solution(cryptogram));
    }
}
