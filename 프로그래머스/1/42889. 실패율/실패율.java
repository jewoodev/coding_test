import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
        //스테이지에 도달했지만 클리어하지 못한 플레이어 수
        int[] reaching = new int[N + 1];
        //스테이지에 도달한 플레이어 수
        int[] clear = new int[N + 1];

        for (int i = 0; i < stages.length; i++) {
            for (int j = 0; j < stages[i]; j++) {
                clear[j]++; //입력값 저장
            }
            reaching[stages[i] - 1]++; //입력값 저장
        }

        //스테이지 번호와 실패율을 저장할 Map
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            //해당 스테이지에 도달한 사람도 클리어한 사람도 없으면
            if (reaching[i] == 0 || clear[i] == 0) {
                map.put(i + 1, 0.0); //0퍼센트
            } else {
                map.put(i + 1, (double) reaching[i] / clear[i]);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        //실패율을 기준으로 내림차순 정렬
        list.sort(((o1, o2) -> Double.compare(map.get(o2), map.get(o1))));

        //배열로 변환
        return list.stream().mapToInt(i -> i).toArray();
    }
}