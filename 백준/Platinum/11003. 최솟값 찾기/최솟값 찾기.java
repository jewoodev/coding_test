import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //n은 주어지는 수의 갯수
        int width = Integer.parseInt(st.nextToken()); //width는 슬라이딩 윈도우의 폭
        Deque<Node> dq = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            //새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
            while (!dq.isEmpty() && dq.getLast().val > now) {
                dq.removeLast();
            }
            dq.addLast(new Node(now, i));
            if (dq.getFirst().idx <= i - width) { //범위에서 벗어난 값은 덱에서 제거
                dq.removeFirst();
            }
            bw.write(dq.getFirst().val + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static class Node {
        private int val;
        private int idx;

        public Node(int val, int index) {
            this.val = val;
            this.idx = index;
        }
    }
}