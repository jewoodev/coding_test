import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //n은 수열의 원소 갯수
        int[] a = new int[n]; //a는 수열 배열
        int[] ans = new int[n]; //ans는 정답 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> myStack = new Stack<>();
        myStack.push(0); //연산을 위해 빈 스택에 최초 값을 세팅
        for (int i = 1; i < n; i++) {
            //현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
            while (!myStack.empty() && a[myStack.peek()] < a[i]) {
                ans[myStack.pop()] = a[i]; //정답 배열에 오큰수를 현재 수열로 저장하기
            }
            myStack.push(i); //신규 데이터 push
        }
        //반복문 수행 후인데도 스택이 비어있지 않다면
        while (!myStack.empty()) {
            ans[myStack.pop()] = -1; //스택에 쌓인 index에 -1을 넣고
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}