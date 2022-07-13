public class sumDisvisor {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) answer += i;
        }
        return answer;
    }
    public static void main(String[] args) {
        sumDisvisor method = new sumDisvisor();
        System.out.println(method.solution(12));
    }
}