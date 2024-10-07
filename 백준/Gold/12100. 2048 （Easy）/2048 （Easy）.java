import java.io.*;
import java.util.*;
public class Main {

	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int answer;
	static boolean flag = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
			
		} 

		if(n == 1) {
			System.out.println(board[0][0]);
		}else {


//			moveRight(board, n, 1, new boolean[n][n]);
//			sout(board, n, "R");
//			moveUp(board, n, 0, new boolean[n][n]);
//			sout(board, n, "U");
//			moveRight(board, n, 1, new boolean[n][n]);
//			sout(board, n, "R");
//			moveUp(board, n, 0, new boolean[n][n]);
//			sout(board, n, "U");
//			moveRight(board, n, 1, new boolean[n][n]);
//			sout(board, n, "R");
//			moveUp(board, n, 0, new boolean[n][n]);
//			sout(board, n, "U");


//			moveUp(board, n, 0, new boolean[n][n]);
//			sout(board, n, "U");
//			moveRight(board, n, 1, new boolean[n][n]);
//			sout(board, n, "R");
//			moveDown(board, n, 2, new boolean[n][n]);
//			sout(board, n, "D");
//			moveRight(board, n, 1, new boolean[n][n]);
//			sout(board, n, "R");
//			moveLeft(board, n, 3, new boolean[n][n]);
//			sout(board, n, "L");
			playGame(board, n, 0, "");
			System.out.println(answer);
			
		}

	}
	public static void sout(int[][] board, int n, String dir) {
		for(int i=0; i<n; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		
		System.out.println("=====================" + dir);
	}
	
	public static void playGame(int[][] board, int n, int count, String path) {
		if(count == 5) {
			getAnswer(board, n);
//			System.out.println(path);
//			if(answer == 64 && !flag) {
//				flag = true;
//				System.out.println(path);
//				sout(board, n, "");
//			}
			return;
		}
		for(int dir=0; dir<4; dir++) {
			int[][] newBoard = copyBoard(board, n);
			moveBoard(newBoard, n, dir);			
			
			playGame(copyBoard(newBoard, n), n, count+1, path + Integer.toString(dir));
		}
		
	}
	public static int getAnswer(int[][] board, int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				answer = Math.max(answer, board[i][j]);
			}
		}
		return answer;
	}
	public static void moveBoard(int[][] board, int n, int dir) {
		boolean[][] merged = new boolean[n][n];
		if(dir == 0) {
			moveUp(board, n, dir, merged);
		}else if(dir == 1) {
			moveRight(board, n, dir, merged);
		}else if(dir == 2) {
			moveDown(board, n, dir, merged);
		}else {
			moveLeft(board, n, dir, merged);
		}
	}
	
	
	public static void moveUp(int[][] board, int n, int dir, boolean[][] merged) {
		for(int i=1; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j] != 0) {
					Position now = new Position(i, j);
					findNextPositionAndMove(board, now, dir, n, merged);
				}
			}
		}
	}
	public static void moveRight(int[][] board, int n, int dir, boolean[][] merged) {
		for(int j=n-2; j>=0; j--) {
			for(int i=0; i<n; i++) {
//				System.out.println(i + ", " + j);
				if(board[i][j] != 0) {
					Position now = new Position(i, j);
					findNextPositionAndMove(board, now, dir, n, merged);
				}
			}
		}
	}
	
	public static void moveDown(int[][] board, int n, int dir, boolean[][] merged) {
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<n; j++) {
				if(board[i][j] != 0) {
					Position now = new Position(i, j);
					findNextPositionAndMove(board, now, dir, n, merged);
				}
			}
		}
	}
	public static void moveLeft(int[][] board, int n, int dir, boolean[][] merged) {
		for(int j=1; j<n; j++) {
			for(int i=0; i<n; i++) {
				if(board[i][j] != 0) {
					Position now = new Position(i, j);
					findNextPositionAndMove(board, now, dir, n, merged);
				}
			}
		}
	}
	
	public static void findNextPositionAndMove(int[][] board, Position now, int dir, int n, boolean[][] merged) {
		int nowValue = board[now.y][now.x];
		Position copyNow = new Position(now.y, now.x);
		
		while(true) {
			int nexty = copyNow.y + dy[dir];
			int nextx = copyNow.x + dx[dir];
			Position next = new Position(nexty, nextx);
			if(!isValidPosition(board, next, n)) {
				if(board[copyNow.y][copyNow.x] == 0) {
//					System.out.println(now + " -> " + copyNow + " 낭떠러지 이동");
					move(board, now, copyNow);
				}
				break;
			}
//			1. 다음 칸이 0인경우 -> 계속 진행
//			2. 다음 칸에 숫자가 있는 경우
//			2-1. 다음칸 숫자가 now와 동일할 경우 -> next에 now를 덧셈
//			2-2. 다음 칸 숫자가 now와 다를 경우 -> now를 copyNow로 이동
			
			if(board[next.y][next.x] == 0) {
				copyNow.y = next.y;
				copyNow.x = next.x;
				continue;
			}else if(board[next.y][next.x] != board[now.y][now.x]) {
//				System.out.println("단순 이동");
//				System.out.println(now + " -> " + copyNow);
//				System.out.println(board[now.y][now.x]+ " " + board[copyNow.y][copyNow.x]);
				move(board, now, copyNow);
				break;
			}else if(board[next.y][next.x] == board[now.y][now.x] ) {
//				System.out.println("계산 이동");
//				System.out.println(now + " -> " + next);
//				System.out.println(board[now.y][now.x]+ " " + board[next.y][next.x]);
				if(!merged[next.y][next.x]) {
					calculate(board, now, next, merged);
				}else {
					move(board, now, copyNow);
				}
				break;
			}
		}

		return;
	}
	
	public static boolean isValidPosition(int[][] board, Position next, int n) {
		if(next.y < 0 || next.y >= n || next.x < 0 || next.x >= n ) {
			return false;
		}
		return true;
	}

	
	public static void move(int[][] board, Position now, Position next) {
		board[next.y][next.x] = board[now.y][now.x];
		if(!now.equals(next)) {
			fillZero(board, now); 
		}
	}
	public static void calculate(int[][] board, Position now, Position next, boolean[][] merged) {
		board[next.y][next.x] += board[now.y][now.x]; 
		if(!now.equals(next)) {
			fillZero(board, now);
			merged[next.y][next.x]= true; 
		}
	}
	public static void fillZero(int[][] board, Position now) {
		board[now.y][now.x] = 0;
	}
	public static int[][] copyBoard(int[][] board, int n){
		int[][] retBoard = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				retBoard[i][j] = board[i][j]; 
			}
		}
		return retBoard;
	}
	static class Position{
		int y;
		int x;
		public Position(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + "]";
		}
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
			Position other = (Position) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
}