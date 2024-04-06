import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 게임 횟수 X와 이긴 게임 수 Y가 주어졌을 때의 승률 Z가 게임을 몇 번 더 해야 변동되는지 구하라.

# 풀이 논리 #
1. 승률 Z를 계산할 때 소수점은 버리므로 총 게임의 1% 되는 게임 수를 구하면 된다고 착각하기 쉬운데
게임을 추가로 할 때 X와 Y 둘 다 증가한다는 걸 파악하자.
2. 구해야 하는 해가 a 라고 하면 a가 1% 증가하기 위해서는
$ (Y + a) * 100 / (X + a) = Z + 1 $
위의 식을 풀면 된다.
3. 100Y + 100a = (Z + 1)X + a(Z + 1)
4. a = - (Z + 1)X + 100Y / Z - 99
5. 다음으로 Z가 절대 변하지 않는 조건을 처리해야 한다. 예제의 경우 100%이면 변하지 않고,
6. Z가 99일때 위 방정식에서 분모가 0이 되므로 이 또한 처리해주자.
7. 그리고 a가 연산된 결과는 소수점을 가질 수 있으므로 올림 처리해주자.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        int Z = (int) (Y * 100 / X);
        if (Z >= 99) answer = -1;
        else {
            answer = (int) Math.ceil(((100 * Y) - (Z + 1) * X) /(double) (Z - 99));
        }
        System.out.print(answer);
    }
}