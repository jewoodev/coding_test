import java.io.*;
import java.util.*;

/*
입력값 정수 N 이 주어지고 N개의 숫자가 주어지는데, 각각이 풍선이며 순서대로 1번 ~ N번 풍선이라는 설정이다.
각 풍선 안에 주어진 숫자가 들어가 있다.
1번 풍선과 N번 풍선은 이어져 있다. 즉, 원형으로 세워져 있다.
1번을 터트리고 나온 번호만큼 이동해서 터트리는 것을 반복한다. 터진 순서대로 풍선의 번호를 나열하라.
=======================================================
1. 원형으로 구현된 리스트 써본 적이 없어서 그냥 ArrayList랑 while로 구현하려고 했는데 문제에서 이동한 다음 터트려서 이걸 구현하려면 재귀를 써야 하나 싶다.
2. 재귀로 풀어보려 했는데 이 방식도 구현할 길이 바로 보이지 않는다. 구현 방식을 좀 비틀어야 할 것 같다. 좀 지금과는 다르게 해야 한다.

다시 정리해보자.
예제가 연산되는 순서를 봐보자.
1. 3(1) 2(2) 1(3) -3(4) -1(5) -> 1번 풍선(3)을 list에서 삭제하기 전의 list에서 3을 이동해야 한다. 그래서 -3이 다음 풍선이 된다. 4번 풍선을 찾고 나서 삭제한다.
2. 2(2) 1(3) -3(4) -1(5) -> 이제 4번 풍선을 터트려야 하는데 터트리기 전의 list에서 -3을 이동해야 한다. 그래서 5번 풍선이 된다.
3. 2(2) 1(3) -1(5)
4. 2(2) 1(3)
5.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<int[]> q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
        int in = arr[0];

        for(int i=1; i<n; i++){
            q.add(new int[] {(i+1), arr[i]}); // {풍선 idx, 내용}
        }

        while(!q.isEmpty()) {
            // 양수인 경우
            if(in > 0) {
                // 순서 뒤로 돌리기
                for(int i=1; i<in; i++) {
                    q.add(q.poll());
                }

                int[] nxt = q.poll();
                in = nxt[1];
                sb.append(nxt[0]+" ");
            }
            // 음수인 경우
            else {
                for(int i=1; i < - in; i++	) {
                    q.addFirst(q.pollLast());
                }

                int[] nxt = q.pollLast();
                in = nxt[1];
                sb.append(nxt[0]+" ");
            }
        }

        System.out.println(sb.toString());

    }
}
