import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
터널 안으로 차량들이 들어간다. 그렇게 들어간 차량들 중 몇몇의 차량이 터널 안에서 추월을 한다.
1. 터널 밖으로 나오는 차량 순서를 보고 반드시 추월을 한 것으로 볼 수 있는 차량 수를 출력하라.

# 풀이 논리 #
들어간 순서대로 나오면 추월은 한 것이 아니고, 들어간 순서와 다르게 나오는 차량이 있으면 그 차량은 추월한 것이므로
차 번호를 원소로 갖는 큐를 사용해 들어가는 순서대로 차량을 저장하고, 순서가 맞지 않을 때마다 카운트해서 카운트 값을 출력한다.

카운트를 세는 논리는 아래와 같다.
1. 큐의 맨 앞 차량 번호와 터널에서 나온 차량 번호가 일치하지 않는다면,
일치할 때까지는 계속 추월한 차량이 나오는 것이므로 큐에서 remove() 해주고 카운트를 올린다.
2. 큐의 맨 앞 차량 번호와 터널에서 나온 차량 번호가 일치한다면,
들어간 순서대로 나온 것이므로 카운트를 세지 않고 poll() 해서 다음 순서의 차량을 큐의 맨 앞에 위치시킨다.
*/


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // FIFO 로 차 번호를 확인하기 위해 큐 객체 사용
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.offer(br.readLine());
        }

        int answer = 0;
        // 터널에서 나오는 차 번호가 FIFO 순서와 맞지 않을 때마다 카운트
        for (int i = 0; i < N; i++) {
            String out = br.readLine();
            if (!q.peek().equals(out)) {
                q.remove(out);
                answer++; // 풀이 논리 2번
            }
            else q.poll(); // 풀이 논리 1번
        }
        System.out.print(answer);
    }
}