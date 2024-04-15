import java.util.*;
import java.io.*;

/*
모든 경우의 수를 탐색하면 2^50, 문제 논리의 순서로 따지는 것보다 역순으로 따져서 탐색 효율을 높인다.
맨 앞에 B가 있는 경우, 맨 끝에 A가 있는 경우를 체크해서 연산해서 S가 만들어질 수 있는지 체크한다.
 */

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String S, T;

    public static void main(String[] args) throws IOException {
        S = br.readLine();
        T = br.readLine();
        int answer = DFS(S, T);
        System.out.println(answer);
    }

    private static int DFS(String S, String T) {
        if (S.length() == T.length()) {
            if (S.equals(T)) return 1;
            else return 0;
        }

        int answer = 0;
        if (T.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(T.substring(1));
            answer += DFS(S, sb.reverse().toString());
        }

        if (T.charAt(T.length() - 1) == 'A') {
            answer += DFS(S, T.substring(0, T.length() - 1));
        }
        return answer > 0 ? 1 : 0;
    }
}
