import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 주어지는 N개의 좌표를 압축해서 출력하라.

# 풀이 논리 #

*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 좌표 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] origin = new int[N]; // 원본 데이터를 저장하는 배열
        int[] sorted = new int[N]; // 정렬을 수행할 배열
        for (int i = 0; i < N; i++) // 좌표 값 저장
            sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i : sorted) {
            if (!map.containsKey(i)) {
                map.put(i, rank);
                rank++;
            }
        }
        for (int key : origin) {
            sb.append(map.get(key)).append(" ");
        }
        System.out.print(sb);
    }
}