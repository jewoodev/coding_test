import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 100번 채널에서 채널을 돌리기 위해 리모콘을 조작하는데, 숫자 버튼 M개가 고장나있다.
2. 숫자 버튼을 누르고 +, - 버튼을 눌러서 N번 채널까지 이동하는데 눌러야 하는 버튼 수의 최소값을 구하라.

# 풀이 논리 #
1.
2. 만들어진 부분 수열의 합이 S가 될 때마다 카운트한다.
3. S가 0 인 경우 공집합도 카운트되므로 정답에서 -1 해준다.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 이동하려는 채널 번호
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼 수
        boolean[] broken = new boolean[10]; // 고장난 버튼을 체크할 배열
        if (M != 0) { // 고장난게 없으면 체크할 필요 x
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int result = Math.abs(N - 100); // 초기값 설정
        // 1. 버튼 완전 탐색
        for (int i = 0; i < 999_999; i++) {
            String press = String.valueOf(i); // 이번에 누를 버튼
            int length = press.length(); // 누른 숫자의 길이

            boolean isBreak = false;
            for (int j = 0; j < length; j++) { // 1-1. press가 누를 수 없는 경우의 수인지 확인하는 로직
                if (broken[press.charAt(j) - '0']) { // 1-2. 고장난 버튼을 눌러야 하는 번호라면 다음 경우를 확인
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) { // 1-3. 아니라면
                int min = Math.abs(N - i) + length; // N까지 이동하는 횟수(N - i)만큼
                result = Math.min(result, min);
            }
        }
        System.out.println(result);
    }
}