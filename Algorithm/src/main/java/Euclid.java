import java.util.Arrays;

public class Euclid {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int big = Math.max(n, m);
        int small = Math.min(n, m);

        answer[0] = gcd(big, small);
        answer[1] = big * small / answer[0];

        return answer;
    }

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        int r = a % b;
        return gcd(b, r);
    }
    public static void main(String[] args) {
        Euclid method = new Euclid();
        System.out.println(Arrays.toString(method.solution(2,5)));
    }
}