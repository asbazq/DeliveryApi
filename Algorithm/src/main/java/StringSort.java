import java.util.ArrayList;
import java.util.Collections;

class StringSort {
    public String solution(String s) {
        String answer = "";
        String[] str = new String[s.length()];

        ArrayList<String> ary = new ArrayList<>();
        str = s.split("");
        for (int i =0; i < s.length(); i++) {
            ary.add(str[i]);
        }
        ary.sort(Collections.reverseOrder());

        for (int i =0; i < s.length(); i++) {
            answer += ary.get(i);
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        StringSort method = new StringSort();
        String s = "Zbcdefg";
        System.out.println(method.solution(s));
    }
}