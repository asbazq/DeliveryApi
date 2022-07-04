public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int win = 0;
        int lose = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                win += 1;
                lose += 1;
            }
            for (int j = 0; j < lottos.length; j++) {
                if (lottos[i] == win_nums[j]) win += 1;
            }
        }
        if (win == 6) {
            answer[0] = 1;
        } else if (win == 5) {
            answer[0] = 2;
        } else if (win == 4) {
            answer[0] = 3;
        } else if (win == 3) {
            answer[0] = 4;
        } else if (win == 2) {
            answer[0] = 5;
        } else {
            answer[0] = 6;
        }

        win -= lose;

        if (win == 6) {
            answer[1] = 1;
        } else if (win == 5) {
            answer[1] = 2;
        } else if (win == 4) {
            answer[1] = 3;
        } else if (win == 3) {
            answer[1] = 4;
        } else if (win == 2) {
            answer[1] = 5;
        } else {
            answer[1] = 6;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lotto method = new Lotto();
        int[] lottos = {1, 2, 3, 7, 0, 0};
        int[] win_nums = {1, 2, 3, 4, 5, 6};
        System.out.println(method.solution(lottos, win_nums));
    }
}

