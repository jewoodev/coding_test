import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 기둥 높이가 N개 주어진다. 지붕의 어떤 부분도 오목한 부분이 없게 만들어야 한다.
2. 주어지는 기둥 높이로 만들 수 있는 최소 크기의 창고를 구하라

# 풀이 논리 #
한쪽 방향으로 기둥을 탐색하면서 더 큰 기둥이 나올 때까지 x 좌표를 저장해 지붕 높이를 지정하는 방법으로 구현할 수 있다.
LIFO든 FIFO든 상관없이 담아뒀던 정보를 꺼낼 수 있는 자료구조를 사용한다. 아래에서 구현 논리를 세부적으로 이야기한다.
1. 왼쪽부터 오른쪽을 탐색하면서 더 큰 기둥이 나올 때까지 지붕 높이를 지금까지의 가장 큰 기둥 높이로 지정한다.
2. 기둥들 중간에 가장 높은 기둥이 있으면 오른쪽에 1번 연산이 이루어지지 않은 기둥이 남으므로 오른쪽부터 왼쪽으로 탐색하면서 같은 연산을 한다.
3. 만들어진 지붕대로 창고 넓이를 구한다.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001]; // 기둥 x 좌표를 인덱스로, 높이를 값으로 갖는 배열
        int start = Integer.MAX_VALUE; // 창고 중 가장 왼쪽 기둥의 x 좌표
        int end = 0; // 가장 오른쪽 x 좌표
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x 좌표
            int y = Integer.parseInt(st.nextToken()); // 높이
            arr[x] = y; // arr에 저장
            start = Math.min(start, x);
            end = Math.max(end, x);
        }

        Stack<Integer> stack = new Stack<>();
        // 왼쪽부터 오른쪽으로 탐색
        int loop = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < loop) { // 더 높은 기둥이 나올 때까지 현재 기둥 높이로 지붕 높이를 지정
                stack.push(i); // 하기 위해 스택에 저장
            }
            else { // 더 높은 기둥이 나오면
                while (!stack.isEmpty()) {
                    int x = stack.pop(); // 이전에 스택에 쌓인 x 좌표들의
                    arr[x] = loop; // 지붕 높이를 지정한다
                }
                loop = arr[i]; // loop 값 최신화
            }
        }
        stack.clear();

        //오른쪽 비교
        loop = arr[end];
        for (int i = end - 1; i >= start; i--) {
            if (arr[i] < loop) stack.push(i);
            else {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    arr[x] = loop;
                }
                loop = arr[i];
            }
        }

        int answer = 0;
        for (int i = start; i <= end; i++) {
            answer += arr[i];
        }

        System.out.print(answer);
    }
}