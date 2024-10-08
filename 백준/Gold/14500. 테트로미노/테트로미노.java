import java.io.*;
import java.util.*;
public class Main {
	static final int dy[] = {-1, 0, 1, 0};
	static final int dx[] = {0, 1, 0, -1};
	static Set<Set<Point>> visitPaths = new HashSet<>();
	static int[][] field;
	static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, m;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		field = new int[n][m];
		Queue<Point> q = new ArrayDeque<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		boolean[][] visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				Point start = new Point(i, j);
				visited[i][j] = true;
				makeTetro(start, visited, field[i][j], n, m, 0);
				visited[i][j] = false;
			}
		}
		System.out.println(answer);

	}
	public static void makeTetro(Point now, boolean[][] visited, int sum, int n, int m, int count) {
		
		if(count == 3) {
			answer = Math.max(sum, answer);
			return;
		}
		for(int i=0; i<4; i++) {
			int nexty = now.y + dy[i];
			int nextx = now.x + dx[i];
			Point next = new Point(nexty, nextx);

			if(nexty < 0 || nexty >= n || nextx < 0 || nextx >= m || visited[nexty][nextx]) {
				continue;
			}
			if(count == 1) {
				visited[nexty][nextx] = true;
				makeTetro(now, visited, sum + field[next.y][next.x], n, m, count+1);
				visited[nexty][nextx] = false;
			}
			visited[nexty][nextx] = true;
			makeTetro(next, visited, sum + field[next.y][next.x], n, m, count+1);
			visited[nexty][nextx] = false;
		}
	}
	

	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + "]";
		}

		
		
	}
}