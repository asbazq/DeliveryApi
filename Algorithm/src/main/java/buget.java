import java.util.Arrays;

public class buget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            budget -= d[i];
            if (budget < 0) break;
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        buget method = new buget();
        int[] a = {1,3,2,5,4};
        int b = 9;
        System.out.println(method.solution(a,b));
    }
}