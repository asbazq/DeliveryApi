//public class Main {
//    public String solution(int n) {
//        String answer = "";
//        String s = String.valueOf(n);
//        int[] rn = new int[s.length()];
//        int sum = 0;
//        int cnt = 0;
//
//        while (n != 0) {
//            rn[cnt] = n % 10;
//            n /= 10;
//            cnt++;
//        }
//
//        for (int i = 0; i < rn.length; i++) {
//            sum += rn[i];
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < rn.length; i++) {
//            sb.append(rn[i]);
//            if (i != rn.length - 1) {
//                sb.append("+");
//            } else {
//                sb.append("=");
//                sb.append(sum);
//            }
//        }
//
//
//        answer = sb.toString();
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Main method = new Main();
//
//        System.out.println(method.solution(718253));
//    }
//}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public String[] solution(String[] arr, int n) {
        String[] answer = new String[arr.length];

        ArrayList<String> ary = new ArrayList<>();
        String sameStr = "";
        for (int i = 0; i < arr.length; i++) {
            if ( sameStr == arr[i]) {
                sameStr = arr[i];
                ary.add(arr[i].charAt(n) + arr[i]);
            }
            Collections.sort(ary);
        }
        for (int i = 0; i < arr.length; i++) {
            answer[i] = ary.get(i).substring(1);
        }

            return answer;
        }

        public static void main(String[] args) {
            Main method = new Main();
            String[] arr = {"coke", "water", "glass", "dog", "dog", "yogurt", "vitamin"};
            int n = 2;
            System.out.println(Arrays.toString(method.solution(arr, n)));
        }
    }

