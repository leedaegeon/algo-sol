import java.io.*;
import java.util.*;
public class Main {
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, m;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		char[][] field = new char[n][m];
		Ball red = null;
		Ball blue = null;
		Ball goal = null;
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			char[] row = input.toCharArray();
			
			for(int j=0; j<m; j++) {
				if(row[j] == 'R') {
					red = new Ball('r', i, j, -1);
					field[i][j] = '.';
				}else if(row[j] == 'B') {
					blue = new Ball('b', i, j, -1);
					field[i][j] = '.';
				}else if(row[j] == 'O') {
					goal = new Ball('g', i, j, -1);
					field[i][j] = '.';
				}else {
					field[i][j] = row[j];
				}
			}
		}
		List<Ball> balls = new ArrayList<>();
		balls.add(red);
		balls.add(blue);

		playGame(balls, n, m, field, goal, 1);
		
		if(answer != Integer.MAX_VALUE) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}
	}
	public static void playGame(List<Ball> balls, int n, int m, char[][] field, Ball goal, int depth) {

		
		if(depth > 10) {
			return;
		}
		for(int i=0; i<4; i++) {
			List<Ball> ballParam = copyBall(balls, i);
			boolean possible = moveBalls(ballParam, n, m, field, goal);
			if(possible) {
				playGame(ballParam, n, m, field, goal, depth+1);
			}else if(isBlueGoal(ballParam, goal)){	
				answer = Math.min(answer, depth);
			}
		}
		
	}
	public static List<Ball> copyBall(List<Ball> balls, int dir){
		List<Ball> retBalls = new ArrayList<>();
		Ball first = new Ball(balls.get(0), dir);
		Ball second = new Ball(balls.get(1), dir);
		retBalls.add(first);
		retBalls.add(second);
		return retBalls;
		
	}
	public static boolean isBlueGoal(List<Ball> balls, Ball goal) {
		int blueIdx = getIdx(balls, 'b');
		Ball blue = balls.get(blueIdx);
		if(blue.equals(goal)) {
			return false;
		}else {

			return true;
		}
	}
	public static int getIdx(List<Ball> balls, char color) {
		for(int i=0; i<balls.size(); i++) {
			if(balls.get(i).color == color) {
				return i;
			}
		}
		return 0;
	}
	public static boolean moveBalls(List<Ball> balls, int n, int m, char[][] field, Ball goal) {
		Collections.sort(balls);

		boolean first = moveBall(balls.get(0), balls.get(1), n, m, field, goal);
		boolean second = moveBall(balls.get(1), balls.get(0), n, m, field, goal);

		return check(first, second, balls);
	}
	public static boolean check(boolean first, boolean second, List<Ball> balls) {
//		완료상태, 진행 가능 상태
		if(!first && !second) {
			return true;
		}
		return false;
	}
	public static boolean moveBall(Ball ball, Ball ball2, int n, int m, char[][] field, Ball goal) {
		int dir = ball.dir;
		
		while(true) {
			int nexty = ball.y + dy[dir];
			int nextx = ball.x + dx[dir];
			if(nexty < 0 || nexty >= n || nextx < 0 || nextx >= m 
					|| field[nexty][nextx] == '#' 
					|| (nexty == ball2.y && nextx == ball2.x) 
					|| (nexty == goal.y && nextx == goal.x)) {
				if(nexty == goal.y && nextx == goal.x) {
					ball.y += dy[dir];
					ball.x += dx[dir];
					return true;
				}
				else {
					return false;	
				}
			}
			ball.y += dy[dir];
			ball.x += dx[dir];
		}
		
		
	}
	
	static class Ball implements Comparable<Ball>{
		char color;
		int y;
		int x;
		int dir;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Ball other = (Ball) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public int compareTo(Ball o) {
			if(dir == 0) {
				return this.y - o.y;
			}else if(dir == 1) {
				return o.x - this.x;
			}else if(dir == 2) {
				return o.y - this.y;
			}else {
				return this.x - o.x;
			}
		}

		public Ball() {
	
		}
		
		public Ball(char color, int y, int x, int dir) {
			super();
			this.color = color;
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
		public Ball(Ball ball, int dir) {
			this.color = ball.color;
			this.y = ball.y;
			this.x = ball.x;
			this.dir = dir;
			
		}
		@Override
		public String toString() {
			return "Ball [color=" + color + ", y=" + y + ", x=" + x + ", dir=" + dir + "]";
		}
		
		
	}

}