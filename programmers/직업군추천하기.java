package programmers;

import java.util.HashMap;
import java.util.Map;

public class 직업군추천하기 {

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int maxScore = 0;

        String[] jobs = new String[table.length];
        Map<String, Integer>[] langPoint = new HashMap[table.length];

        for (int i = 0; i < table.length; ++i) {
            String[] tokens = table[i].split(" ");
            jobs[i] = tokens[0];
            langPoint[i] = new HashMap<String, Integer>();
            for (int j = 1; j < tokens.length; ++j) {
                langPoint[i].put(tokens[j], (6 - j));
            }
        }

        for (int i = 0; i < langPoint.length; ++i) {
            int score = 0;
            for (int j = 0; j < languages.length; ++j) {
                score += langPoint[i].getOrDefault(languages[j], 0) * preference[j];
            }

            if (maxScore <= score) {
                answer = (maxScore == score && answer.compareTo(jobs[i]) < 0) ? answer : jobs[i];
                maxScore = score;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] table = {
                "SI JAVA JAVASCRIPT SQL PYTHON C#",
                "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA"
        };

        String[] languages = {"PYTHON", "C++", "SQL"};

        int[] preference = {7, 5, 5};

        System.out.println(solution(table, languages, preference));
    }
}
