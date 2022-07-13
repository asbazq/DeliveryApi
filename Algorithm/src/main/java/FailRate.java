import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FailRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] cnt = new int[N]; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
        Map<Integer,Double> map = new HashMap<>(); // HashMap을 이용하여 key에는 스테이지 value에는 실패율
        int total = stages.length; // 스테이지에 도달한 플레이어 수

        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i]; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            if (stage == N + 1) continue; // 마지막 스테이지는 제외
            cnt[stage - 1]++; // 배열은 0부터 시작이므로 -1
        }
        for (int i = 0; i < cnt.length; i++) { // 스테이지에 도달한 플레이어 수
            if (total == 0) { // 플레이어가 0일 때
                map.put(i,0d); // 0을 삽입
                continue;
            }
            map.put(i, (double) cnt[i] / total); // 실패율
            total -= cnt[i]; // 이전 층을 뺀 플레이어 수
        }
        for (int i = 0; i < N; i++) {
            double max = -1; // value값이 0일 수도 있으니까 -1 대입
            int maxkey = 0;

            for (int key : map.keySet()) { // map의 키값
                if (max < map.get(key)) {
                    max = map.get(key); // 최대 값 구함
                    maxkey = key;
                }
            }
            answer[i] = maxkey + 1; // 실패율이 높은 순으로 , 배열은 0부터니까 +1
            map.remove(maxkey); // maxkey를 지우고 다시 반복
        }
            return answer;
    }
    public static void main(String[] args) {
        FailRate method = new FailRate();
        int a = 5;
        int[] b = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(method.solution(a, b)));
    }
}
