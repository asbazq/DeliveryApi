import java.util.ArrayList;
import java.util.Collections;

public class num2 {
    class Solution {
        public int[] solution(int[] numbers) {


            ArrayList<Integer> ary = new ArrayList<>();
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    int sum = numbers[i] + numbers[j];
                    if (!ary.contains(sum)) ary.add(sum);
                }
            }
            Collections.sort(ary);
            int[] answer = new int[ary.size()];
            for (int i = 0; i < ary.size(); i++) {
                answer[i] = ary.get(i);
            }
            return answer;
        }
    }
}
