import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
일직선 상에 놓이는 탑의 정상에 레이저 송신기가 각각 놓이고, 송신기는 왼쪽으로 레이저 신호를 보낸다.
수신 측의 탑 높이가 더 높거나 같지 않으면 신호를 수신할 수 없다. 신호를 수신한 탑들의 번호를 출력하라.

# 풀이 논리 #
탑 높이가 같거나 큰 것이 왼쪽에 있는지 탐색을 해야하는데, 이를 DFS로 구현하면 500,000 * 500,000 으로 시간 초과가 걸린다.
그렇기 때문에 Monotonic Stack(단조 스택)을 이용해 풀이해야 한다.
스택에 새로운 탑의 길이 값을 넣을 때 스택 안에 길이가 더 작은 탑이 있으면 그걸 모두 삭제하고 넣는 구조로 구현하면 된다.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 탑의 수.
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>(); // 단조 스택.
        // 단조 스택 구현 로직 시작.
        for (int i = 1; i <= N; i++) {
            int newHeight = Integer.parseInt(st.nextToken()); // 처음 탑을 순서대로 주어지는 탑의 높이.
            if (stack.isEmpty()) { // 스택이 비어있으면
                sb.append("0 "); // 해당 위치의 탑의 신호를 수신할 수 있는 탑이 없으므로 0 처리.
                stack.push(new Tower(i, newHeight)); // 탑 삽입.
            }
            else { // 스택에 탑이 있으면
                while (true) {
                    if (stack.isEmpty()) { // 아래에서 stack에서 pop()하다가 비워지면
                        sb.append("0 "); // 새로운 탑보다 큰게 없다는 것, 수신 가능한 탑이 없는 것이다. 0으로 기록한다.
                        stack.push(new Tower(i, newHeight)); // 현재 탑을 스택에 push한다.
                        break;
                    }
                    if (stack.peek().height > newHeight) { // 스택의 LI 탑의 높이가 새 탑의 높이보다 크면
                        sb.append(stack.peek().seq).append(" "); // 그 탑이 수신 가능한 탑이다. 정답 값에 추가한다.
                        stack.push(new Tower(i, newHeight)); // 현재 탑을 스택에 push한다.
                        break;
                    } else { // 스택의 LI 탑의 높이가
                        stack.pop(); // 새 탑의 높이보다 큰 탑이 아니면 모두 삭제한다.
                    }
                }
            }
        }
        System.out.print(sb);
    }

    private static class Tower {
        int seq; // 왼쪽부터의 순서
        int height; // 높이
        private Tower(int seq, int height) {
            this.seq = seq;
            this.height = height;
        }
    }
}
