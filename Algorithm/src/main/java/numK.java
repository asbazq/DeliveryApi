import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class numK {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        ArrayList<Integer> ary = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0]; j <= commands[i][1]; j++) {
                ary.add(array[j-1]);
                Collections.sort(ary);
            }
            answer[i] = ary.get(commands[i][2] - 1);
            ary.clear();
        }

        return answer;
    }
    public static void main(String[] args) {
        numK method = new numK();
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(method.solution(a,b)));
    }
}
