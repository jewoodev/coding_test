import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
# 요구사항 정리 #
홀수 N이 주어지면 아래의 값들을 구하는 로직을 구현하라.
1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값, 최빈값이 여러 개이면 두번째로 작은값 
4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이

# 풀이 논리 #
1. 산술평균 : N개의 수를 입력받으면서 int 변수에 누적합한 후 N으로 나눈다.
2. 중앙값 : N개의 수를 배열에 저장해 정렬하여 중앙 위치의 요소를 꺼낸다.
3. 최빈값 : 맵의 Key에 입력되는 수, Value에 빈도수를 저장하여 요구사항 3번에 맞게 정렬하여 값을 구한다.
4. 범위 : 2번에서 정렬한 배열의 처음과 끝값의 차이를 구한다.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0; // N개 수의 합
        int[] arr = new int[N]; // 중앙값을 꺼내는데 쓰일 배열
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);
            arr[i] = key;
            sum += key;
        }
        sb.append((int) Math.round(sum /(double) N)).append("\n"); // 산술 평균 연산

        Arrays.sort(arr);
        sb.append(arr[(arr.length - 1) / 2]).append("\n"); // 중앙값

        // 최빈값, 여러 개면 두 번째로 작은 값
        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted((m1, m2) -> {
                    if (m1.getValue() != m2.getValue()) return m2.getValue() - m1.getValue();
                    else return m1.getKey() - m2.getKey();
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
        Integer[] valueSorted = sortedMap.values().stream().toArray(Integer[]::new);
        Integer[] keySorted = sortedMap.keySet().stream().toArray(Integer[]::new);
        if (valueSorted.length != 1) { // 서로 다른 크기의 수가 둘 이상이고
            if (valueSorted[0] == valueSorted[1]) { // 최빈값이 여러 개면
                sb.append(keySorted[1]).append("\n"); // 두 번째로 작은 값
            } else sb.append(keySorted[0]).append("\n"); // 아니면 그대로 출력
        } else sb.append(keySorted[0]).append("\n"); // 같은 수만 입력되었으면 그 수가 최빈값

        // 범위
        sb.append(arr[arr.length - 1] - arr[0]);
        System.out.println(sb);
    }
}
