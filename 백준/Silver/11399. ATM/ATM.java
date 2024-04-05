import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. ATM 앞에 1번부터 N번까지의 사람이 줄을 서있다. 그리고 각 사람이 돈을 인출하는데 걸리는 시간이 Pi로 주어진다.
2. 사람들이 줄을 서는 순서에 따라 모든 사람이 돈을 인출하는데 걸리는 총 시간이 달라진다.
3. 그 시간이 최소가 되도록 구현하라

# 풀이 논리 #
1. 누적합이 최소가 되도록 해야 하므로 우선순위 큐를 사용해 구현한다.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }
        int sum = 0;
        int[] sumArr = new int[N]; // 각 사람이 인출하는데 걸리는 시간을 저장하는 배열
        int idx = 0;
        while (!q.isEmpty()) { // 아래와 같은 논리로 sumArr 값들을 채워나간다.
            sum += q.poll();
            sumArr[idx] = sum;
            idx++;
        }
        // 문제에서 요구하는 총 시간을 연산해 출력한다.
        System.out.print(Arrays.stream(sumArr).sum());
    }
}