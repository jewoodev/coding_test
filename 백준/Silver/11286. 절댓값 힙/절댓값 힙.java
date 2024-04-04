import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. N번 만큼 정수가 입력된다. 입력값이 0이 아니라면 배열에 추가하고 0이라면 배열의 가장 작은 값을 출력하고 제거하라.

# 풀이 논리 #
1. 요구사항 1번을 구현하기 위해 우선순위 큐를 사용한다.
*/

public class Main implements Comparable<Main> {
    int val;

    public Main(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(Main o) {
        if (Math.abs(this.val) == Math.abs(o.val)) return this.val - o.val;
        return Math.abs(this.val) - Math.abs(o.val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //n은 연산의 개수
        PriorityQueue<Main> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int nextInput = Integer.parseInt(br.readLine());
            if (nextInput == 0) {
                if (q.isEmpty()) sb.append("0").append("\n");
                else sb.append(q.poll().val).append("\n");
            }
            else q.offer(new Main(nextInput));
        }
        br.close();
        System.out.println(sb);
    }
}