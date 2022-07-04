import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test {
    public String[] solution(String[] arr, int n) {
        String[] answer = new String[arr.length];

        ArrayList<String> ary = new ArrayList<>();
        String sameStr = "";
        for (int i = 0; i < arr.length; i++) {
            if ( sameStr != arr[i]) {
                sameStr = arr[i];
                ary.add(arr[i].charAt(n) + arr[i]);
            }
            Collections.sort(ary);
        }
        for (int i = 0; i < ary.size(); i++) {
            answer[i] = ary.get(i).substring(1);
        }

            return answer;
        }

        public static void main(String[] args) {
            test method = new test();
            String[] arr = {"coke", "water", "glass", "dog", "dog", "yogurt", "vitamin"};
            int n = 2;
            System.out.println(Arrays.toString(method.solution(arr, n)));
        }
    }


