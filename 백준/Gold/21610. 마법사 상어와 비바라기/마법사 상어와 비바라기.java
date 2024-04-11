import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. N * N 크기의 격자에서 비바라기를 시전하면 (N, 1), (N, 2), (N - 1, 1), (N - 1, 2)에 비구름이 생긴다.

순차적으로 이뤄지는 이동 명령
1. 이동을 명령하면 d 방향으로 s 칸 만큼 이동한다. 그리고 각 구름에서 비가 내려 구름이 있는 칸의 물 양이 1 증가하고 구름이 사라진다.
2. 2에서 물이 증가한 칸에 물복사버그 마법을 시전한다. 그러면 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니 수만큼
해당 바구니의 물의 양이 증가한다. (대각선 방향에 있는거 말고 본인(바구니)가 증가)
3. 이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
4. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
5. M번의 이동이 끝난 후 바구니에 들어있는 물의 총량을 구하자.

# 풀이 논리 #
1.

*/

class Main {
    private static int N, M;
    private static int[][] map;
//    private static boolean[][] cloud;
    private static boolean[][] check; // 구름이 사라진 곳을 체크할 배열
    private static List<Cloud> cloud = new ArrayList<>(); // 구름 위치 저장할 배열
    private static int[] dR = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dC = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 격자의 한 변의 길이
        M = Integer.parseInt(st.nextToken()); // 이동 횟수
        map = new int[N][N]; // 맵 정보 저장할 배열
        check = new boolean[N][N];
//        cloud = new boolean[N][N]; // 구름 위치 저장할 배열

        // 구름 위치 초기값 저장
        cloud.add(new Cloud(N - 1, 0));
        cloud.add(new Cloud(N - 1, 1));
        cloud.add(new Cloud(N - 2, 0));
        cloud.add(new Cloud(N - 2, 1));

        // 맵 정보 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 비바라기 시전
//        cloud[N][1] = cloud[N][2] = cloud[N - 1][1] = cloud[N - 1][2] = true;

        /* 이동 로직 시작 */
        // 주어지는 이동 명령 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1; // 방향
            int s = Integer.parseInt(st.nextToken()); // 이동 칸 수
            // 구름 이동 후 구름에서 비가 내려 구름이 사라지고, 해당 위치의 물의 양이 1 늘어난다.
            for (Cloud c : cloud) {
                /* # 이동 구현 #
                  1. (s % N) -> 이동 횟수 : 이동 횟수 s가 N보다 크면 이를 N로 나눈 나머지만큼 이동한 것과 같아진다.
                  2. (N +... )) % N -> 끝 인덱스 잇기 : 인덱스 0과 N - 1을 이어줘야할 필요가 있다.
                                이를 이동 연산을 할 때 N을 더해주고 N으로 나머지 연산을 해서 이어준다.
                 */
                c.r = (N + c.r + dR[d] * (s % N)) % N;
                c.c = (N + c.c + dC[d] * (s % N)) % N;
                map[c.r][c.c]++;
                check[c.r][c.c] = true;
            }
            // 1. 비가 내린 위치에서 물복사버그 마법을 사용한다.
            for (int j = 1; j < 8; j+=2) { // 1-1. 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니 수만큼
                for (Cloud c : cloud) {
                    int nR = c.r + dR[j]; // 대각선 위치
                    int nC = c.c + dC[j];
                    if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue; // 맵 밖으로 벗어나면 continue
                    if (map[nR][nC] != 0) map[c.r][c.c]++; // 1-2. 물의 양이 늘어난다.
                }
            }
            cloud.clear();

            // 이전에 구름이 사라진 위치를 제외한 곳에서 물의 양이 2 이상인 곳에서 구름이 생겨나고 물의 양이 2 줄어든다.
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!check[j][k] && map[j][k] >= 2) {
                        map[j][k] -= 2;
                        cloud.add(new Cloud(j, k));
                        check[j][k] = true;
                    }
                }
            }
            check = new boolean[N][N];
        }

        // M번의 이동이 끝난 후 바구니에 남은 물의 총량을 구하라
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    private static class Cloud {
        int r, c;
        private Cloud(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}