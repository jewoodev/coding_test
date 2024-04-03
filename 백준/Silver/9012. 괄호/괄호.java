import java.io.*;
import java.util.*;

/* "()" 처럼 완전히 쌍을 이루는 괄호들로 이루어졌는지 아닌지 출력하는 문제 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int left = 0;
            boolean isBroken = false;
            // 입력값 인덱싱 탐색
            for (int j = 0; j < input.length(); j++) {
                // 처음에 ( 로 시작하지 않으면 VPS가 될 수 없다.
                if (j == 0 && input.charAt(j) != '(') {
                    sb.append("NO").append("\n");
                    isBroken = true;
                    break;
                }
                else {
                    // 한번이라도 ) 갯수가 많아지는 순간 VPS가 아니게 된다.
                    if (left < 0) {
                        sb.append("NO").append("\n");
                        isBroken = true;
                        break;
                    }
                    // ( 갯수를 세어주고
                    else if (input.charAt(j) == '(') {
                        left++;
                    }
                    // ) 가 나오면 지금까지 ( 로 열렸던 괄호를 닫아줘야 한다
                    else if (input.charAt(j) == ')') {
                        left--; // ( 개수를 줄이는 것으로 괄호 닫기 로직을 구현
                    }
                }
            }
            if (!isBroken) { // VPS가 될 수 없다고 판단되어진 게 아니라면 left 값을 확인해서 결과를 만든다
                if (left == 0) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
