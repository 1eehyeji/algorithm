package codingTest.W0316;

public class test3 {

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        String[] reverse = new String[123];

        int j = 90;
        for(int i = 65; i < 91; ++i) {
            reverse[j] = Character.toString((char ) i);
            --j;
        }

        j = 122;
        for(int i = 97; i < 123; ++i) {
            reverse[j] = Character.toString((char ) i);
            --j;
        }

        for(int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if(c >= 65 && c <= 90) {
                sb.append(reverse[(int) c]);
            }
            else if(c >= 97 && c <= 122) {
                sb.append(reverse[(int) c]);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String word = "\"I love you\"";

        String word2 = "\"i love\"";

        String word3 = "\"YOU\"";

        System.out.println(solution(word3));
    }
}
