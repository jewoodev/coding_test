import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 정점과 간선의 개수, 그리고 시작 정점이 주어지면 깊이 우선 탐색으로 노드를 오름차순으로 방문할 경우 방문 순서를 출력하라.

# 풀이 논리 #
1. DFS를 요구사항에 맞게 구현한다.
*/

class Main {
    private static StringBuilder sb = new StringBuilder();
    private static List<Integer>[] listArr;
    private static int[] check;
    private static int visitOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken()); // 정점의 개수
        int edgeCnt = Integer.parseInt(st.nextToken()); // 간선의 개수
        int startNode = Integer.parseInt(st.nextToken()); // 시작 정점

        // 인접 리스트 생성
        listArr = new List[nodeCnt + 1];
        for (int i = 1; i < nodeCnt + 1; i++) {
            listArr[i] = new ArrayList<>();
        }
        // 방문 순서 정보를 저장할 배열
        check = new int[nodeCnt + 1];
        // 그래프 정보 저장
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            listArr[start].add(end); // 무방향 그래프 구현
            listArr[end].add(start);
        }
        // 인접 정점을 오름차순으로 방문하기 위해 정렬
        for (int i = 1; i <= nodeCnt; i++) {
            Collections.sort(listArr[i]);
        }

        visitOrder = 1; // 방문 순서
        // DFS
        DFS(startNode);

        // 방문 순서 출력
        for (int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void DFS(int node) {
        check[node] = visitOrder; // 방문 순서를 저장
        // 1.탐색 로직 시작
        for (int i = 0; i < listArr[node].size(); i++) { // 1-1. 해당 노드에서 
            int newNode = listArr[node].get(i); // 1-2. 방문 가능한 노드가
            if (check[newNode] == 0) { // 1-3. 방문했던 게 아니라면
                visitOrder++; // 1-4. 다음으로 방문한다.
                DFS(newNode); // 1-5. 다음으로 방문한 노드에서 DFS
            }
        }
    }
}
