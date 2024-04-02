import java.io.*;
import java.util.*;

public class Main {
	
	public static int N;
	public static int[][] map = new int[19][19];
	public static boolean[][] visited = new boolean[19][19];
	public static int[] dR = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static int[] dC = {1, 1, 1, 0, -1, -1, -1, 0};
	public static int result = 0;
	public static boolean over = false; // 5목을 넘어서는지 여부
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	for(int i = 0; i < 19; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 19; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	for (int row = 0; row < 19; row++) {
    		for (int col = 0; col < 19; col++) {
    			if (map[row][col] != 0) {
    				for (int dir = 0; dir < 4; dir++) {
    					over = false;
    					DFS(new Node(row, col, map[row][col]), 1, dir);
    					if (!over) { // 5목을 넘어서지 않은 경우
    						//반대방향에서도 넘어서지 않는지 확인
    			    		int nr = row + dR[dir + 4];
    			    		int nc = col + dC[dir + 4];
    			    		int color = map[row][col];
    			    		if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19) {
        			    		if(map[nr][nc] == color) {
        			    			result = 0;
        			    		}
    			    		}
    						if (result != 0) {
    							System.out.println(result);
    							System.out.println((row + 1) + " " + (col + 1));
    							return;
    						}
    					}
    				}
    			}	
    		}	
    	}
    	System.out.println(result);
    }

    //
    public static void DFS(Node start, int level, int dir) {
    	if (level == 5) {
    		int nr = start.r + dR[dir];
    		int nc = start.c + dC[dir];
    		int color = start.color;
    		
    		if (nr < 0 || nr >= 19 || nc < 0 || nc >= 19) {
    			result = start.color;
    			return;
    		}

    		if (map[nr][nc] != color) {
    			result = start.color;
    			return;
    		}

    		if (map[nr][nc] == color) { // 5목을 넘어 6목인 경우
    			over = true;
    			return;
    		}
    	}
    	
		int nr = start.r + dR[dir];
		int nc = start.c + dC[dir];
		int color = start.color;
		if (nr < 0 || nr >= 19 || nc < 0 || nc >= 19) return;
		if (map[nr][nc] != color) return;
		if (visited[nr][nc]) return;
		
		visited[nr][nc] = true;
		DFS(new Node(nr, nc, color), level + 1, dir);
		if (!over) {
			visited[nr][nc] = false;
		}
		
    }
    private static class Node {
        int r, c, color;
        public Node(int r, int c, int color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }
}