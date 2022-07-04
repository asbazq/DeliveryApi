public class Test2 {
    public String solution(int n) {
        String answer = "";
        String s = String.valueOf(n);
        int[] rn = new int[s.length()];
        int sum = 0;
        int cnt = 0;

        while (n != 0) {
            rn[cnt] = n % 10;
            n /= 10;
            cnt++;
        }

        for (int i = 0; i < rn.length; i++) {
            sum += rn[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rn.length; i++) {
            sb.append(rn[i]);
            if (i != rn.length - 1) {
                sb.append("+");
            } else {
                sb.append("=");
                sb.append(sum);
            }
        }


        answer = sb.toString();

        return answer;
    }

    public static void main(String[] args) {
        Test2 method = new Test2();

        System.out.println(method.solution(718253));
    }
}
