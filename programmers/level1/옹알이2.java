package programmers.level1;

public class 옹알이2 {

    public int solution(String[] babbling) {
        int answer = 0;

        String[] arr = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; ++i) {
            String tmp = babbling[i];

            for (int j = 0; j < arr.length; ++j) {
                tmp = tmp.replaceAll(arr[j], j + "");
            }

            int pre = -1;
            boolean check = true;
            for (char c : tmp.toCharArray()) {
                if (!Character.isDigit(c) || pre == (c - '0')) {
                    check = false;
                    break;
                }

                pre = c - '0';
            }

            if (check) ++answer;
        }

        return answer;
    }
}
