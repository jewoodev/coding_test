import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 사람이 옷을 입을 때 그 날의 착장에 초점을 두고, 다음 날에는 착장에 적어도 하나의 옷 종류는 바뀌어야 한다.
2. 옷의 정보가 주어질 때, 의상의 이름과 종류가 차례로 나오는데 나오는 종류는 적어도 하나를 입어야 한다.
2. 위와 같은 논리로 매일 착장을 바꿔가며 옷을 입는다면 주어지는 옷들로 만들 수 있는 조합의 개수를 출력하라.

# 풀이 논리 #
1. 옷의 종류에 따라 옷을 골라야 하기 때문에 옷의 종류를 Key 값으로 갖고, 이름의 개수를 Value 값으로 갖는 맵으로 경우를 저장한다.
2. 아래 예제에서 순서대로 조합의 개수를 연산할 때, 이전 연산의 결과에 (새로운 옷의 종류의 개수)를 곱한 것을 더하고
(새로운 옷의 종류의 개수)를 더하면 조합의 수가 나오는 규칙성을 찾을 수 있다.

예제를 살펴보자
1. (hat), (turban), (hat, sunglasses), (turban, sunglasses), (sunglasses) -> 5
2. (mask), (sunglasses), (makeup) -> 3
3. "1번 예제의 eyewear에 mask를 추가"
ㄴ(hat), (turban), (sunglasses), (mask), (hat, sunglasses), (hat, mask), (turban, sunglasses), (turban, maks) -> 8
4. "3번 예제의 eyewear에 makeup을 추가"
ㄴ(hat), (turban), (sunglasses), (mask), (makeup), (hat, sunglasses), (hat, mask), (hat, makeup),
(turban, sunglasses), (turban, maks), (turban, makeup) -> 11
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int i = 0; i < T; i++) { // 모든 테스트 케이스를 탐색
            map.clear(); // 각 케이스마다 새로운 리스트로 착장의 경우를 세기 위해 clear
            int clothCnt = Integer.parseInt(br.readLine()); // 가진 의상의 수
            int nUnion = 0; // 총 조합의 개수
            for (int j = 0; j < clothCnt; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String clothName = st.nextToken();
                String clothType = st.nextToken();
                // 맵에 옷 정보 저장하는 로직
                map.put(clothType, map.getOrDefault(clothType, 0) + 1);
            }
            for (Integer value : map.values()) {
                nUnion += value + nUnion * value;
            }
            sb.append(nUnion).append(" ");
        }
        System.out.print(sb);
    }
}