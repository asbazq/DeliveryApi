//import java.util.Arrays;
//
//public class Main {
//    public int[][] solution(int[][] arr1, int[][] arr2, boolean[][] signs) {
//        int[][] answer = new int[arr1.length][arr1[0].length];
//
//
//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr1[0].length; j++) {
//                if (signs[i][j]) {
//                    answer[i][j] = arr1[i][j] + arr2[i][j];
//                } else {
//                    answer[i][j] = -arr1[i][j] - arr2[i][j];
//                }
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Main method = new Main();
//        int[][] arr1 = {{5, 7, 1}, {2, 3, 5}};
//        int[][] arr2 = {{5, 1, 6}, {7, 5, 6}};
//        boolean[][] signs = {{true, true, false}, {false, true, false}};
//        System.out.println(Arrays.deepToString(method.solution(arr1, arr2, signs)));
//    }
//}
class Solution1 {
    public class solution {
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
    }
}
