import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
# 요구사항 정리 #
1. 홀수 N이 주어지면 아래의 값들을 구하는 로직을 구현하라.
산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이

# 풀이 논리 #
1. 빈도수를 세어야 하므로 맵으로 구현한 후 키 값을 꺼내서 정렬하여 다른 값들도 구한다.
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