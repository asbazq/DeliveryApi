import java.util.ArrayList;
import java.util.Arrays;


class Mock {
    public int[] solution(int[] answers) {
        int[] num1 = {1,2,3,4,5}, num2 = {2,1,2,3,2,4,2,5}, num3 = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == num1[i%num1.length]) cnt[0]++;
            if (answers[i] == num2[i%num2.length]) cnt[1]++;
            if (answers[i] == num3[i%num3.length]) cnt[2]++;
        }



        int max = Math.max(Math.max(cnt[0],cnt[1]), cnt[2]);
        ArrayList<Integer> ary = new ArrayList<>();
        if (max == cnt[0]) ary.add(1);
        if (max == cnt[1]) ary.add(2);
        if (max == cnt[2]) ary.add(3);

        int[] answer = new int[ary.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = ary.get(i);

        }

        return answer;
    }
    public static void main(String[] args) {
        Mock method = new Mock();
        int[] a = {1,3,2,4,2};
        System.out.println(Arrays.toString(method.solution(a)));
    }
}