package programmers.kakao2021;

public class 신규아이디추천 {

    public static String solution(String new_id) {
        String result = new_id;

        // 1단계
        result = result.toLowerCase()
                .replaceAll("[^-_.a-z0-9]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]|[.]$", "");

        if (result.length() == 0)
            result = "a";

        if (result.length() > 15) {
            result = result.substring(0, 15)
                    .replaceAll("^[.]|[.]$", "");
        }

        while (result.length() < 3) {
            result += result.charAt(result.length() - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";

        System.out.println("result : " + solution(new_id));
    }
}
